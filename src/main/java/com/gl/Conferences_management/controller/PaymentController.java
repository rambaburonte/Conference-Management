package com.gl.Conferences_management.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.gl.Conferences_management.dto.PaymentRequest;
import com.gl.Conferences_management.service.MailService;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private MailService mailService;

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Value("${paypal.client.id}")
    private String paypalClientId;

    @Value("${paypal.client.secret}")
    private String paypalClientSecret;

    // Create Stripe PaymentIntent
    @PostMapping("/stripe/register")
    public ResponseEntity<?> createStripePaymentIntent(@RequestBody PaymentRequest req) {
        try {
            Stripe.apiKey = stripeSecretKey;

            // Convert amount (double dollars) to cents (long)
            long amountCents = Math.round(req.getAmount() * 100);
            String currency = req.getCurrency() == null ? "usd" : req.getCurrency().toLowerCase();
            String successUrl = req.getSuccessUrl() == null ? "/paymentsuccess" : req.getSuccessUrl();
            String cancelUrl = req.getCancelUrl() == null ? "/paymentcancel" : req.getCancelUrl();

            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(amountCents)
                    .setCurrency(currency)
                    .putMetadata("email", req.getEmail() == null ? "" : req.getEmail())
                    .putMetadata("name", req.getName() == null ? "" : req.getName())
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);

            // Insert into DB
            jdbcTemplate.update("INSERT INTO registrations (title, name, email, phone, country, address, org, price, conf, category, description, payment_type, status, token, t_id, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'stripe', 0, ?, null, ?)",
                    req.getTitle(), req.getName(), req.getEmail(), req.getPhone(), req.getCountry(), req.getAddress(), req.getOrg(), req.getAmount(), req.getConf(), req.getCategory(), req.getDescription(), intent.getId(), LocalDate.now());
            
            // Send email
            try {
                String toEmail = req.getEmail(); // default to submitted email
                if (req.getUser() != null) {
                    String loginEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, req.getUser());
                    if (loginEmail != null) {
                        toEmail = loginEmail;
                    }
                }
                mailService.sendEmail(toEmail, "Registration Confirmation", "Thank you for registering for the conference. Your payment is being processed.");
            } catch (Exception e) {
                // Log email error if needed
            }

            Map<String, Object> resp = new HashMap<>();
            resp.put("clientSecret", intent.getClientSecret());
            resp.put("id", intent.getId());
            resp.put("status", intent.getStatus());
            resp.put("successUrl", successUrl);
            resp.put("cancelUrl", cancelUrl);
            return ResponseEntity.ok(resp);

        } catch (StripeException | NumberFormatException e) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

    // Create PayPal payment (redirect flow) - returns approval URL
    @PostMapping("/paypal/register")
    public ResponseEntity<?> createPaypalPayment(@RequestBody PaymentRequest req) {
        String total = String.format("%.2f", req.getAmount()); // PayPal expects string format like "10.00"
        String currency = req.getCurrency() == null ? "USD" : req.getCurrency();
        String successUrl = req.getSuccessUrl() == null ? "/paymentsuccess" : req.getSuccessUrl();
        String cancelUrl = req.getCancelUrl() == null ? "/paymentcancel" : req.getCancelUrl();

        APIContext apiContext = new APIContext(paypalClientId, paypalClientSecret, "sandbox");

        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(total);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(req.getDescription() == null ? "Conference registration payment" : req.getDescription());

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(List.of(transaction));

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        try {
            Payment createdPayment = payment.create(apiContext);
            String approvalUrl = createdPayment.getLinks().stream()
                    .filter(link -> "approval_url".equalsIgnoreCase(link.getRel()))
                    .findFirst()
                    .map(link -> link.getHref())
                    .orElse(null);

            // Insert into DB
            jdbcTemplate.update("INSERT INTO registrations (title, name, email, phone, country, address, org, price, conf, category, description, payment_type, status, token, t_id, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'paypal', 0, ?, null, ?)",
                    req.getTitle(), req.getName(), req.getEmail(), req.getPhone(), req.getCountry(), req.getAddress(), req.getOrg(), req.getAmount(), req.getConf(), req.getCategory(), req.getDescription(), createdPayment.getId(), LocalDate.now());
            
            // Send email
            try {
                String toEmail = req.getEmail(); // default to submitted email
                if (req.getUser() != null) {
                    String loginEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, req.getUser());
                    if (loginEmail != null) {
                        toEmail = loginEmail;
                    }
                }
                mailService.sendEmail(toEmail, "Registration Confirmation", "Thank you for registering for the conference. Your payment is being processed.");
            } catch (Exception e) {
                // Log email error if needed
            }

            Map<String, Object> resp = new HashMap<>();
            resp.put("paymentId", createdPayment.getId());
            resp.put("approvalUrl", approvalUrl);
            resp.put("successUrl", successUrl);
            resp.put("cancelUrl", cancelUrl);
            return ResponseEntity.ok(resp);
        } catch (PayPalRESTException e) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

   

    // Confirm Stripe payment success
    @PostMapping("/stripe/success")
    public ResponseEntity<?> confirmStripePayment(@RequestBody Map<String, String> body) {
        String token = body.get("token");
      

        if (token == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "token is required"));
        }

        try {
            PaymentIntent intent = PaymentIntent.retrieve(token);
           String t_id  =   intent.getId();
            if ("succeeded".equals(intent.getStatus())) {
                jdbcTemplate.update("UPDATE registrations SET status = 1, t_id = ? WHERE token = ? AND payment_type = 'stripe'",
                        t_id, token);
                return ResponseEntity.ok(Map.of("status", "success"));
            } else {
                return ResponseEntity.badRequest().body(Map.of("error", "Payment not succeeded"));
            }
        } catch (StripeException e) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

    // Confirm PayPal payment success
    @PostMapping("/paypal/success")
    public ResponseEntity<?> confirmPaypalPayment(@RequestBody Map<String, String> body) {
        String token = body.get("token");

        if (token == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "token is required"));
        }

        try {
            APIContext apiContext = new APIContext(paypalClientId, paypalClientSecret, "sandbox");
            Payment payment = Payment.get(apiContext, token);
            String t_id = payment.getId();
            if ("approved".equals(payment.getState())) {
                jdbcTemplate.update("UPDATE registrations SET status = 1, t_id = ? WHERE token = ? AND payment_type = 'paypal'",
                        t_id, token);
                return ResponseEntity.ok(Map.of("status", "success"));
            } else {
                return ResponseEntity.badRequest().body(Map.of("error", "Payment not approved"));
            }
        } catch (PayPalRESTException e) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }
}
