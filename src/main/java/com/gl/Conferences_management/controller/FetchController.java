package com.gl.Conferences_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Conferences_management.service.DatabaseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/fetch")
@Slf4j
public class FetchController {

    @Autowired
    private DatabaseService databaseService;

    private String camelToSnake(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    @GetMapping("/abstracts")
    public List<Map<String, Object>> getAbstracts() {
        log.info("Fetching abstracts");
        String tableName = camelToSnake("getAbstracts".substring(3));
        List<Map<String, Object>> result = databaseService.executeQuery("SELECT * FROM " + tableName);
        log.info("Fetched {} abstracts", result.size());
        return result;
    }

    @GetMapping("/abstract-submissions")
    public List<Map<String, Object>> getAbstractSubmissions() {
        String tableName = camelToSnake("getAbstractSubmissions".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/acad-business")
    public List<Map<String, Object>> getAcadBusiness() {
        String tableName = camelToSnake("getAcadBusiness".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/advisary-committee")
    public List<Map<String, Object>> getAdvisaryCommittee() {
        String tableName = camelToSnake("getAdvisaryCommittee".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/attendees-from")
    public List<Map<String, Object>> getAttendeesFrom() {
        String tableName = camelToSnake("getAttendeesFrom".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/banners")
    public List<Map<String, Object>> getBanners() {
        String tableName = camelToSnake("getBanners".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/brochure")
    public List<Map<String, Object>> getBrochure() {
        String tableName = camelToSnake("getBrochure".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/call-for-abstracts")
    public List<Map<String, Object>> getCallforabstracts() {
        String tableName = camelToSnake("getCallforabstracts".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/cfa-categories")
    public List<Map<String, Object>> getCfaCategories() {
        String tableName = camelToSnake("getCfaCategories".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/cfa-sub-categories")
    public List<Map<String, Object>> getCfaSubCategories() {
        String tableName = camelToSnake("getCfaSubCategories".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-attractions")
    public List<Map<String, Object>> getCityAttractions() {
        String tableName = camelToSnake("getCityAttractions".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-guide")
    public List<Map<String, Object>> getCityguide() {
        String tableName = camelToSnake("getCityguide".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-guide-images")
    public List<Map<String, Object>> getCityGuideImages() {
        String tableName = camelToSnake("getCityGuideImages".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/committee")
    public List<Map<String, Object>> getCommittee() {
        String tableName = camelToSnake("getCommittee".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/committee-program")
    public List<Map<String, Object>> getCommitteeProgram() {
        String tableName = camelToSnake("getCommitteeProgram".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/conf")
    public List<Map<String, Object>> getConf() {
        String tableName = camelToSnake("getConf".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/conferences")
    public List<Map<String, Object>> getConferences() {
        String tableName = camelToSnake("getConferences".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/conf-keynote")
    public List<Map<String, Object>> getConfKeynote() {
        String tableName = camelToSnake("getConfKeynote".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/contact-us")
    public List<Map<String, Object>> getContactUs() {
        String tableName = camelToSnake("getContactUs".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/daily-tasks")
    public List<Map<String, Object>> getDailyTasks() {
        String tableName = camelToSnake("getDailyTasks".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/deadlines")
    public List<Map<String, Object>> getDeadlines() {
        String tableName = camelToSnake("getDeadlines".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/edit-conference")
    public List<Map<String, Object>> getEditConference() {
        String tableName = camelToSnake("getEditConference".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/edit-symposia")
    public List<Map<String, Object>> getEditSymposia() {
        String tableName = camelToSnake("getEditSymposia".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/featured-speakers")
    public List<Map<String, Object>> getFeaturedSpeakers() {
        String tableName = camelToSnake("getFeaturedSpeakers".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/gallery")
    public List<Map<String, Object>> getGallery() {
        String tableName = camelToSnake("getGallery".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/home-info")
    public List<Map<String, Object>> getHomeInfo() {
        String tableName = camelToSnake("getHomeInfo".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/homepage")
    public List<Map<String, Object>> getHomepage() {
        String tableName = camelToSnake("getHomepage".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/hotel-expenses")
    public List<Map<String, Object>> getHotelExpenses() {
        String tableName = camelToSnake("getHotelExpenses".substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/important-details")
    public List<Map<String, Object>> getImportantDetails() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    // Get important details by domain (parameterized to avoid SQL injection)
    @GetMapping("/important-details/domain/{domain}")
    public List<Map<String, Object>> getImportantDetailsByDomain(@PathVariable("domain") String domain) {
        String sql = "SELECT * FROM important_details WHERE domain = ?";
        return databaseService.executeQuery(sql, domain);
    }

    @GetMapping("/important-details/shortname/{shortname}")
    public List<Map<String, Object>> getImportantDetailsByShortName(@PathVariable("shortname") String shortname) {
        log.info("Fetching important details for shortname: {}", shortname);
        String sql = "SELECT * FROM important_details WHERE ShortName = ?";
        List<Map<String, Object>> result = databaseService.executeQuery(sql, shortname);
        log.info("Fetched {} important details for shortname: {}", result.size(), shortname);
        return result;
    }

    @GetMapping("/important-details/id/{id}")
    public List<Map<String, Object>> getImportantDetailsById(@PathVariable("id") int id) {
        String sql = "SELECT * FROM important_details WHERE id = ?";
        return databaseService.executeQuery(sql, id);
    }

    @GetMapping("/indian-reg-req")
    public List<Map<String, Object>> getIndianRegReq() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/invite-colleague")
    public List<Map<String, Object>> getInvitecolleague() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/invited-speakers")
    public List<Map<String, Object>> getInvitedSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/keynotes")
    public List<Map<String, Object>> getKeynotes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/keynote-speakers")
    public List<Map<String, Object>> getKeynoteSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/likes")
    public List<Map<String, Object>> getLikes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/login-details")
    public List<Map<String, Object>> getLoginDetails() {
        log.info("Fetching login details");
        String tableName = camelToSnake("getLoginDetails".substring(3));
        List<Map<String, Object>> result = databaseService.executeQuery("SELECT * FROM " + tableName);
        log.info("Fetched {} login details", result.size());
        return result;
    }

    @GetMapping("/login-details/username/{username}")
    public List<Map<String, Object>> getLoginDetailsByUsername(@PathVariable("username") String username) {
        log.info("Fetching login details for username: {}", username);
        String sql = "SELECT * FROM login_details WHERE username = ?";
        List<Map<String, Object>> result = databaseService.executeQuery(sql, username);
        log.info("Fetched {} login details for username: {}", result.size(), username);
        return result;
    }

    @GetMapping("/login-details/conference-url/{conferenceUrl}")
    public List<Map<String, Object>> getLoginDetailsByConferenceUrl(@PathVariable("conferenceUrl") String conferenceUrl) {
        log.info("Fetching login details for conference URL: {}", conferenceUrl);
        String sql = "SELECT * FROM login_details WHERE conference_url = ? OR url = ?";
        List<Map<String, Object>> result = databaseService.executeQuery(sql, conferenceUrl, conferenceUrl);
        log.info("Fetched {} login details for conference URL: {}", result.size(), conferenceUrl);
        return result;
    }

    @GetMapping("/login-info")
    public List<Map<String, Object>> getLoginInfo() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/mail-sending")
    public List<Map<String, Object>> getMailSending() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/media-partners")
    public List<Map<String, Object>> getMediaPartners() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/members")
    public List<Map<String, Object>> getMembers() {
        String tableName = camelToSnake("getMembers".substring(3));
        String sql = "SELECT * FROM " + tableName + " ORDER BY " +
            "CASE " +
            "WHEN category = 'Plenary' THEN 1 " +
            "WHEN category = 'Keynote' THEN 2 " +
            "WHEN category = 'Invited' THEN 3 " +
            "WHEN category = 'Yrf' THEN 4 " +
            "WHEN category = 'Poster' THEN 5 " +
            "ELSE 6 " +
            "END ASC, " +
            "recordListingID ASC";
        return databaseService.executeQuery(sql);
    }

    @GetMapping("/members/user/{user}")
    public List<Map<String, Object>> getMembersByUser(@PathVariable("user") String user) {
        log.info("Fetching members for username: {}", user);
        try {
            Integer userId = databaseService.queryForObject("SELECT id FROM login_details WHERE username = ?", Integer.class, user);
            if (userId == null) {
                log.warn("No login details found for username: {}", user);
                return List.of();
            }
            log.debug("Found user id: {} for username: {}", userId, user);
            String sql = "SELECT * FROM members WHERE user = ? ORDER BY recordListingID ASC";
            List<Map<String, Object>> result = databaseService.executeQuery(sql, userId);
            // Add base URL to photo field
            for (Map<String, Object> member : result) {
                Object photo = member.get("photo");
                if (photo != null && !photo.toString().isEmpty()) {
                    member.put("photo", "https://ccai2026.com/cms/photos/" + photo.toString());
                }
            }
            log.info("Fetched {} members for username: {}", result.size(), user);
            return result;
        } catch (Exception e) {
            log.error("Error fetching members for username: {}", user, e);
            return List.of();
        }
    }

    @GetMapping("/menu")
    public List<Map<String, Object>> getMenu() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/messages")
    public List<Map<String, Object>> getMessages() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/meta-tags")
    public List<Map<String, Object>> getMetaTags() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/meta-tags/user/{user}")
    public List<Map<String, Object>> getMetaTagsByUser(@PathVariable("user") Integer user) {
        String sql = "SELECT * FROM meta_tags WHERE user = ?";
        return databaseService.executeQuery(sql, user);
    }

    @GetMapping("/more-speakers")
    public List<Map<String, Object>> getMorespeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/notifications")
    public List<Map<String, Object>> getNotifications() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/pages")
    public List<Map<String, Object>> getPages() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/past-content")
    public List<Map<String, Object>> getPastContent() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/past-speakers")
    public List<Map<String, Object>> getPastSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/pdf-enquery")
    public List<Map<String, Object>> getPdfEnquery() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/pdfs")
    public List<Map<String, Object>> getPdfs() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/pending-works")
    public List<Map<String, Object>> getPendingWorks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/plenary-speakers")
    public List<Map<String, Object>> getPlenarySpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/positives")
    public List<Map<String, Object>> getPositives() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/posters")
    public List<Map<String, Object>> getPosters() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/preconf")
    public List<Map<String, Object>> getPreconf() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/refunds")
    public List<Map<String, Object>> getRefunds() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/registration")
    public List<Map<String, Object>> getRegistration() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/registrations")
    public List<Map<String, Object>> getRegistrations() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/registration-prices")
    public List<Map<String, Object>> getRegistrationPrices() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/related-conferences")
    public List<Map<String, Object>> getRelatedConferences() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/renewed-speakers")
    public List<Map<String, Object>> getRenewedSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/renowned-speakers")
    public List<Map<String, Object>> getRenownedspeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/scientific-programme")
    public List<Map<String, Object>> getScientificProgramme() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/sender-settings")
    public List<Map<String, Object>> getSenderSettings() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/sending-domains")
    public List<Map<String, Object>> getSendingDomains() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/speaker-info")
    public List<Map<String, Object>> getSpeakerInfo() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/sponsor-catalogue")
    public List<Map<String, Object>> getSponsorCatalogue() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/sponsors")
    public List<Map<String, Object>> getSponsors() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/status-report")
    public List<Map<String, Object>> getStatusReport() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/subscribes")
    public List<Map<String, Object>> getSubscribes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/sub-tracks")
    public List<Map<String, Object>> getSubTracks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/suggest-speaker")
    public List<Map<String, Object>> getSuggestSpeaker() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/time-management")
    public List<Map<String, Object>> getTimeManagement() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/topics")
    public List<Map<String, Object>> getTopics() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/track-description")
    public List<Map<String, Object>> getTrackDescription() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/tracks")
    public List<Map<String, Object>> getTracks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/track-speakers")
    public List<Map<String, Object>> getTrackSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/tz-members")
    public List<Map<String, Object>> getTzMembers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/unsubscribes")
    public List<Map<String, Object>> getUnsubscribes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-accommodation")
    public List<Map<String, Object>> getVenueAccommodation() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-helpdesk")
    public List<Map<String, Object>> getVenueHelpdesk() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-hospitality")
    public List<Map<String, Object>> getVenueHospitality() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/workshop")
    public List<Map<String, Object>> getWorkshop() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/work-sheet")
    public List<Map<String, Object>> getWorkSheet() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/work-update")
    public List<Map<String, Object>> getWorkUpdate() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }

    @GetMapping("/yrf")
    public List<Map<String, Object>> getYrf() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return databaseService.executeQuery("SELECT * FROM " + tableName);
    }
}
