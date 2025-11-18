package com.gl.Conferences_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fetch")
public class FetchController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String camelToSnake(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    @GetMapping("/abstracts")
    public List<Map<String, Object>> getAbstracts() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/abstract-submissions")
    public List<Map<String, Object>> getAbstractSubmissions() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/acad-business")
    public List<Map<String, Object>> getAcadBusiness() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/advisary-committee")
    public List<Map<String, Object>> getAdvisaryCommittee() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/attendees-from")
    public List<Map<String, Object>> getAttendeesFrom() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/banners")
    public List<Map<String, Object>> getBanners() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/brochure")
    public List<Map<String, Object>> getBrochure() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/call-for-abstracts")
    public List<Map<String, Object>> getCallforabstracts() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/cfa-categories")
    public List<Map<String, Object>> getCfaCategories() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/cfa-sub-categories")
    public List<Map<String, Object>> getCfaSubCategories() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-attractions")
    public List<Map<String, Object>> getCityAttractions() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-guide")
    public List<Map<String, Object>> getCityguide() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/city-guide-images")
    public List<Map<String, Object>> getCityGuideImages() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/committee")
    public List<Map<String, Object>> getCommittee() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/committee-program")
    public List<Map<String, Object>> getCommitteeProgram() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/conf")
    public List<Map<String, Object>> getConf() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/conferences")
    public List<Map<String, Object>> getConferences() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/conf-keynote")
    public List<Map<String, Object>> getConfKeynote() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/contact-us")
    public List<Map<String, Object>> getContactUs() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/daily-tasks")
    public List<Map<String, Object>> getDailyTasks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/deadlines")
    public List<Map<String, Object>> getDeadlines() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/edit-conference")
    public List<Map<String, Object>> getEditConference() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/edit-symposia")
    public List<Map<String, Object>> getEditSymposia() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/featured-speakers")
    public List<Map<String, Object>> getFeaturedSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/gallery")
    public List<Map<String, Object>> getGallery() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/home-info")
    public List<Map<String, Object>> getHomeInfo() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/homepage")
    public List<Map<String, Object>> getHomepage() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/hotel-expenses")
    public List<Map<String, Object>> getHotelExpenses() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/important-details")
    public List<Map<String, Object>> getImportantDetails() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    // Get important details by domain (parameterized to avoid SQL injection)
    @GetMapping("/important-details/domain/{domain}")
    public List<Map<String, Object>> getImportantDetailsByDomain(@PathVariable("domain") String domain) {
        String sql = "SELECT * FROM important_details WHERE domain = ?";
        return jdbcTemplate.queryForList(sql, domain);
    }

    @GetMapping("/indian-reg-req")
    public List<Map<String, Object>> getIndianRegReq() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/invite-colleague")
    public List<Map<String, Object>> getInvitecolleague() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/invited-speakers")
    public List<Map<String, Object>> getInvitedSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/keynotes")
    public List<Map<String, Object>> getKeynotes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/keynote-speakers")
    public List<Map<String, Object>> getKeynoteSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/likes")
    public List<Map<String, Object>> getLikes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/login-details")
    public List<Map<String, Object>> getLoginDetails() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/login-info")
    public List<Map<String, Object>> getLoginInfo() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/mail-sending")
    public List<Map<String, Object>> getMailSending() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/media-partners")
    public List<Map<String, Object>> getMediaPartners() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/members")
    public List<Map<String, Object>> getMembers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/menu")
    public List<Map<String, Object>> getMenu() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/messages")
    public List<Map<String, Object>> getMessages() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/meta-tags")
    public List<Map<String, Object>> getMetaTags() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/more-speakers")
    public List<Map<String, Object>> getMorespeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/notifications")
    public List<Map<String, Object>> getNotifications() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/pages")
    public List<Map<String, Object>> getPages() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/past-content")
    public List<Map<String, Object>> getPastContent() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/past-speakers")
    public List<Map<String, Object>> getPastSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/pdf-enquery")
    public List<Map<String, Object>> getPdfEnquery() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/pdfs")
    public List<Map<String, Object>> getPdfs() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/pending-works")
    public List<Map<String, Object>> getPendingWorks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/plenary-speakers")
    public List<Map<String, Object>> getPlenarySpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/positives")
    public List<Map<String, Object>> getPositives() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/posters")
    public List<Map<String, Object>> getPosters() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/preconf")
    public List<Map<String, Object>> getPreconf() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/refunds")
    public List<Map<String, Object>> getRefunds() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/registration")
    public List<Map<String, Object>> getRegistration() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/registrations")
    public List<Map<String, Object>> getRegistrations() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/registration-prices")
    public List<Map<String, Object>> getRegistrationPrices() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/related-conferences")
    public List<Map<String, Object>> getRelatedConferences() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/renewed-speakers")
    public List<Map<String, Object>> getRenewedSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/renowned-speakers")
    public List<Map<String, Object>> getRenownedspeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/scientific-programme")
    public List<Map<String, Object>> getScientificProgramme() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/sender-settings")
    public List<Map<String, Object>> getSenderSettings() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/sending-domains")
    public List<Map<String, Object>> getSendingDomains() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/speaker-info")
    public List<Map<String, Object>> getSpeakerInfo() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/sponsor-catalogue")
    public List<Map<String, Object>> getSponsorCatalogue() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/sponsors")
    public List<Map<String, Object>> getSponsors() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/status-report")
    public List<Map<String, Object>> getStatusReport() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/subscribes")
    public List<Map<String, Object>> getSubscribes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/sub-tracks")
    public List<Map<String, Object>> getSubTracks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/suggest-speaker")
    public List<Map<String, Object>> getSuggestSpeaker() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/time-management")
    public List<Map<String, Object>> getTimeManagement() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/topics")
    public List<Map<String, Object>> getTopics() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/track-description")
    public List<Map<String, Object>> getTrackDescription() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/tracks")
    public List<Map<String, Object>> getTracks() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/track-speakers")
    public List<Map<String, Object>> getTrackSpeakers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/tz-members")
    public List<Map<String, Object>> getTzMembers() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/unsubscribes")
    public List<Map<String, Object>> getUnsubscribes() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-accommodation")
    public List<Map<String, Object>> getVenueAccommodation() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-helpdesk")
    public List<Map<String, Object>> getVenueHelpdesk() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/venue-hospitality")
    public List<Map<String, Object>> getVenueHospitality() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/workshop")
    public List<Map<String, Object>> getWorkshop() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/work-sheet")
    public List<Map<String, Object>> getWorkSheet() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/work-update")
    public List<Map<String, Object>> getWorkUpdate() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }

    @GetMapping("/yrf")
    public List<Map<String, Object>> getYrf() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String tableName = camelToSnake(methodName.substring(3));
        return jdbcTemplate.queryForList("SELECT * FROM " + tableName);
    }
}
