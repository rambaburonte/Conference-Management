   
package com.gl.Conferences_management.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Conferences_management.dto.PaymentRequest;
import com.gl.Conferences_management.service.MailService;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/payment")
@Slf4j
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

    @Value("${paypal.mode}")
    private String paypalMode;

    // Create Stripe Checkout Session - returns payment URL
    @PostMapping("/stripe/register")
    public ResponseEntity<?> createStripePaymentIntent(@RequestBody PaymentRequest req) {
        log.info("Received Stripe payment request for user: {}, amount: {}, currency: {}", req.getUser(), req.getAmount(), req.getCurrency());
        try {
            Stripe.apiKey = stripeSecretKey;

            // Convert amount (double dollars) to cents (long)
            long amountCents = Math.round(req.getAmount() * 100);
            String currency = req.getCurrency() == null ? "usd" : req.getCurrency().toLowerCase();
            String successUrl = req.getSuccessUrl() == null ? "/payment/success" : req.getSuccessUrl();
            String cancelUrl = req.getCancelUrl() == null ? "/payment/cancel" : req.getCancelUrl();
            // Append Stripe session ID placeholder to URLs
            String successUrlWithSession = successUrl + (successUrl.contains("?") ? "&" : "?") + "session_id={CHECKOUT_SESSION_ID}&provider=stripe";
            String cancelUrlWithSession = cancelUrl + (cancelUrl.contains("?") ? "&" : "?") + "session_id={CHECKOUT_SESSION_ID}&provider=stripe";
            log.debug("Stripe payment details - amountCents: {}, currency: {}", amountCents, currency);

            // Create Checkout Session instead of PaymentIntent
                SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(successUrlWithSession)
                    .setCancelUrl(cancelUrlWithSession)
                    .addLineItem(
                        SessionCreateParams.LineItem.builder()
                            .setQuantity(1L)
                            .setPriceData(
                                SessionCreateParams.LineItem.PriceData.builder()
                                    .setCurrency(currency)
                                    .setUnitAmount(amountCents)
                                    .setProductData(
                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                            .setName(req.getDescription() != null ? req.getDescription() : "Conference Registration")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .putMetadata("email", req.getEmail() == null ? "" : req.getEmail())
                    .putMetadata("name", req.getName() == null ? "" : req.getName())
                    .build();

            Session session = Session.create(params);
            log.info("Stripe Checkout Session created with ID: {}", session.getId());

                // Generate invoice number (e.g., INV20251121-<random 5 digits>)
                String invoiceNumber = "INV" + java.time.LocalDate.now().toString().replaceAll("-", "") + "-" + (int)(Math.random()*90000+10000);
                // Insert into DB with invoice_number
                jdbcTemplate.update("INSERT INTO registrations (title, name, email, phone, country, address, org, price, conf, category, description, payment_type, status, token, t_id, date, invoice_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'stripe', 0, ?, null, ?, ?)",
                    req.getTitle(), req.getName(), req.getEmail(), req.getPhone(), req.getCountry(), req.getAddress(), req.getOrg(), req.getAmount(), req.getConf(), req.getCategory(), req.getDescription(), session.getId(), LocalDate.now(), invoiceNumber);
                log.info("Registration inserted into database with token: {} and invoice_number: {}", session.getId(), invoiceNumber);
            
            // Send email
            try {
                String toEmail = req.getEmail(); // default to submitted email
                if (req.getUser() != null) {    
                    try {
                        String loginEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, req.getUser());
                        if (loginEmail != null) {
                            toEmail = loginEmail;
                            log.info("Using login email for Stripe registration: {}", loginEmail);
                        } else {
                            log.warn("No login email found for user: {}, using submitted email: {}", req.getUser(), req.getEmail());
                        }
                    } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
                        log.warn("No login email found for user: {}, using submitted email: {}", req.getUser(), req.getEmail());
                    }
                }
                mailService.sendEmail(toEmail, "Registration Confirmation", "Thank you for registering for the conference. Your payment is being processed.");
                log.info("Stripe registration confirmation email sent to: {}", toEmail);
            } catch (Exception e) {
                log.error("Error sending Stripe registration email for user: {}", req.getUser(), e);
            }

            Map<String, Object> resp = new HashMap<>();
            resp.put("sessionId", session.getId());
            resp.put("url", session.getUrl());  // This is the payment URL from Stripe
            resp.put("successUrl", successUrl);
            resp.put("cancelUrl", cancelUrl);
            log.info("Stripe checkout session response prepared for ID: {}", session.getId());
            return ResponseEntity.ok(resp);

        } catch (StripeException | NumberFormatException e) {
            log.error("Error creating Stripe checkout session for user: {}", req.getUser(), e);
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

    // Create PayPal payment (redirect flow) - returns approval URL
    @PostMapping("/paypal/register")
    public ResponseEntity<?> createPaypalPayment(@RequestBody PaymentRequest req) {
        log.info("Received PayPal payment request for user: {}, amount: {}, currency: {}", req.getUser(), req.getAmount(), req.getCurrency());
        String total = String.format("%.2f", req.getAmount()); // PayPal expects string format like "10.00"
        String currency = req.getCurrency() == null ? "USD" : req.getCurrency();
        String successUrl = req.getSuccessUrl() == null ? "/payment/success" : req.getSuccessUrl();
        String cancelUrl = req.getCancelUrl() == null ? "/payment/cancel" : req.getCancelUrl();
        String successUrlWithSession = successUrl + "?provider=paypal";
        String cancelUrlWithSession = cancelUrl + "?provider=paypal";
        log.debug("PayPal payment details - total: {}, currency: {}", total, currency);

        APIContext apiContext = new APIContext(paypalClientId, paypalClientSecret, paypalMode);

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
        // Temporarily set without session_id, will update after payment creation
        redirectUrls.setCancelUrl(cancelUrlWithSession);
        redirectUrls.setReturnUrl(successUrlWithSession);
        payment.setRedirectUrls(redirectUrls);

        try {
            Payment createdPayment = payment.create(apiContext);
            String approvalUrl = createdPayment.getLinks().stream()
                    .filter(link -> "approval_url".equalsIgnoreCase(link.getRel()))
                    .findFirst()
                    .map(link -> link.getHref())
                    .orElse(null);
            log.info("PayPal payment created with ID: {}", createdPayment.getId());

                // Generate invoice number (e.g., INV20251121-<random 5 digits>)
                String invoiceNumber = "INV" + java.time.LocalDate.now().toString().replaceAll("-", "") + "-" + (int)(Math.random()*90000+10000);
                // Insert into DB with invoice_number
                jdbcTemplate.update("INSERT INTO registrations (title, name, email, phone, country, address, org, price, conf, category, description, payment_type, status, token, t_id, date, invoice_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'paypal', 0, ?, null, ?, ?)",
                    req.getTitle(), req.getName(), req.getEmail(), req.getPhone(), req.getCountry(), req.getAddress(), req.getOrg(), req.getAmount(), req.getConf(), req.getCategory(), req.getDescription(), createdPayment.getId(), LocalDate.now(), invoiceNumber);
                log.info("PayPal registration inserted into database with token: {} and invoice_number: {}", createdPayment.getId(), invoiceNumber);
            
            // Send email
            try {
                String toEmail = req.getEmail(); // default to submitted email
                if (req.getUser() != null) {
                    String loginEmail = jdbcTemplate.queryForObject("SELECT email FROM login_details WHERE username = ?", String.class, req.getUser());
                    if (loginEmail != null) {
                        toEmail = loginEmail;
                        log.info("Using login email for PayPal registration: {}", loginEmail);
                    } else {
                        log.warn("No login email found for user: {}, using submitted email: {}", req.getUser(), req.getEmail());
                    }
                }
                mailService.sendEmail(toEmail, "Registration Confirmation", "Thank you for registering for the conference. Your payment is being processed.");
                log.info("PayPal registration confirmation email sent to: {}", toEmail);
            } catch (Exception e) {
                log.error("Error sending PayPal registration email for user: {}", req.getUser(), e);
            }

            Map<String, Object> resp = new HashMap<>();
            resp.put("orderId", createdPayment.getId()); // PayPal order id
            resp.put("sessionId", createdPayment.getId()); // Also send as sessionId for FE consistency
            resp.put("approvalUrl", approvalUrl);
            resp.put("successUrl", successUrl);
            resp.put("cancelUrl", cancelUrl);
            log.info("PayPal payment response prepared for ID: {}", createdPayment.getId());
            return ResponseEntity.ok(resp);
        } catch (PayPalRESTException e) {
            log.error("Error creating PayPal payment for user: {}", req.getUser(), e);
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

   

    // Confirm Stripe payment success
    @PostMapping("/stripe/success")
    public ResponseEntity<?> confirmStripePayment(@RequestBody Map<String, String> body) {
        String sessionId = body.get("token");
        log.info("Received Stripe payment confirmation for sessionId: {}", sessionId);

        if (sessionId == null) {
            log.warn("Session ID is required for Stripe payment confirmation");
            return ResponseEntity.badRequest().body(Map.of("error", "session_id is required"));
        }

        try {
            // Always check payment status from Stripe using sessionId
            Session session = Session.retrieve(sessionId);
            log.debug("Retrieved Stripe Checkout Session: {}, payment_status: {}", session.getId(), session.getPaymentStatus());
            String t_id = session.getPaymentIntent();
            if ("paid".equals(session.getPaymentStatus())) {
                log.info("Attempting to update registration: token={}, t_id={}, payment_type=stripe", sessionId, t_id);
                int updated = jdbcTemplate.update("UPDATE registrations SET status = 1, t_id = ? WHERE token = ? AND payment_type = 'stripe'",
                        t_id, sessionId);
                log.info("Stripe payment confirmed. Update count: {} for sessionId: {}", updated, sessionId);
                if (updated > 0) {
                    return ResponseEntity.ok(Map.of("status", "success"));
                } else {
                    log.warn("No registration row updated for token={}, payment_type=stripe", sessionId);
                    return ResponseEntity.status(404).body(Map.of("error", "No registration found to update"));
                }
            } else {
                log.warn("Stripe payment not completed for sessionId: {}, payment_status: {}", sessionId, session.getPaymentStatus());
                return ResponseEntity.badRequest().body(Map.of("error", "Payment not completed"));
            }
        } catch (StripeException e) {
            log.error("Error confirming Stripe payment for sessionId: {}", sessionId, e);
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

    // Confirm PayPal payment success
    @PostMapping("/paypal/success")
    public ResponseEntity<?> confirmPaypalPayment(@RequestBody Map<String, String> body) {
        String paymentId = body.get("token");
        log.info("Received PayPal payment confirmation for paymentId: {}", paymentId);

        if (paymentId == null) {
            log.warn("paymentId is required for PayPal payment confirmation");
            return ResponseEntity.badRequest().body(Map.of("error", "paymentId is required"));
        }

        try {
            APIContext apiContext = new APIContext(paypalClientId, paypalClientSecret, paypalMode);
            Payment payment = Payment.get(apiContext, paymentId);
            log.debug("Retrieved PayPal payment: {}, state: {}", payment.getId(), payment.getState());
            String t_id = payment.getId();
            if ("approved".equals(payment.getState())) {
                log.info("Attempting to update registration: token={}, t_id={}, payment_type=paypal", paymentId, t_id);
                int updated = jdbcTemplate.update("UPDATE registrations SET status = 1, t_id = ? WHERE token = ? AND payment_type = 'paypal'",
                        t_id, paymentId);
                log.info("PayPal payment confirmed. Update count: {} for paymentId: {}", updated, paymentId);
                if (updated > 0) {
                    return ResponseEntity.ok(Map.of("status", "success"));
                } else {
                    log.warn("No registration row updated for token={}, payment_type=paypal", paymentId);
                    return ResponseEntity.status(404).body(Map.of("error", "No registration found to update"));
                }
            } else {
                log.warn("PayPal payment not approved for paymentId: {}, state: {}", paymentId, payment.getState());
                return ResponseEntity.badRequest().body(Map.of("error", "Payment not approved"));
            }
        } catch (PayPalRESTException e) {
            log.error("Error confirming PayPal payment for paymentId: {}", paymentId, e);
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(500).body(err);
        }
    }

     // Fallback: Update registration status by token
    @PostMapping("/update-status-by-token")
    public ResponseEntity<?> updateStatusByToken(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        log.info("Received fallback status update for token: {}", token);
        if (token == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "token is required"));
        }
        int updated = jdbcTemplate.update("UPDATE registrations SET status = 1 WHERE token = ?", token);
        if (updated > 0) {
            log.info("Registration status updated for token: {}", token);
            return ResponseEntity.ok(Map.of("status", "updated"));
        } else {
            log.warn("No registration found for token: {}", token);
            return ResponseEntity.status(404).body(Map.of("error", "Registration not found"));
        }
    }
}
