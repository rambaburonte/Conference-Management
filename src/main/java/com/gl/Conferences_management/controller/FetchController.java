package com.gl.Conferences_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.gl.Conferences_management.entity.*;
import com.gl.Conferences_management.repository.*;

@RestController
@RequestMapping("/api/fetch")
public class FetchController {

    @Autowired
    private AbstractsRepository abstractsRepository;

    @Autowired
    private AbstractSubmissionRepository abstractSubmissionRepository;

    @Autowired
    private AcadBusinessRepository acadBusinessRepository;

    @Autowired
    private AdvisaryCommitteeRepository advisaryCommitteeRepository;

    @Autowired
    private AttendeesFromRepository attendeesFromRepository;

    @Autowired
    private BannersRepository bannersRepository;

    @Autowired
    private BrochureRepository brochureRepository;

    @Autowired
    private CallforabstractsRepository callforabstractsRepository;

    @Autowired
    private CfaCategoriesRepository cfaCategoriesRepository;

    @Autowired
    private CfaSubCategoriesRepository cfaSubCategoriesRepository;

    @Autowired
    private CityAttractionsRepository cityAttractionsRepository;

    @Autowired
    private CityguideRepository cityguideRepository;

    @Autowired
    private CityGuideImagesRepository cityGuideImagesRepository;

    @Autowired
    private CommitteeRepository committeeRepository;

    @Autowired
    private CommitteeProgramRepository committeeProgramRepository;

    @Autowired
    private ConfRepository confRepository;

    @Autowired
    private ConferencesRepository conferencesRepository;

    @Autowired
    private ConfKeynoteRepository confKeynoteRepository;

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private DailyTasksRepository dailyTasksRepository;

    @Autowired
    private DeadlinesRepository deadlinesRepository;

    @Autowired
    private EditConferenceRepository editConferenceRepository;

    @Autowired
    private EditSymposiaRepository editSymposiaRepository;

    @Autowired
    private FeaturedSpeakersRepository featuredSpeakersRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private HomeInfoRepository homeInfoRepository;

    @Autowired
    private HomepageRepository homepageRepository;

    @Autowired
    private HotelExpensesRepository hotelExpensesRepository;

    @Autowired
    private ImportantDetailsRepository importantDetailsRepository;

    @Autowired
    private IndianRegReqRepository indianRegReqRepository;

    @Autowired
    private InvitecolleagueRepository invitecolleagueRepository;

    @Autowired
    private InvitedSpeakersRepository invitedSpeakersRepository;

    @Autowired
    private KeynotesRepository keynotesRepository;

    @Autowired
    private KeynoteSpeakersRepository keynoteSpeakersRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Autowired
    private MailSendingRepository mailSendingRepository;

    @Autowired
    private MediaPartnersRepository mediaPartnersRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private MetaTagsRepository metaTagsRepository;

    @Autowired
    private MorespeakersRepository morespeakersRepository;

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private PagesRepository pagesRepository;

    @Autowired
    private PastContentRepository pastContentRepository;

    @Autowired
    private PastSpeakersRepository pastSpeakersRepository;

    @Autowired
    private PdfEnqueryRepository pdfEnqueryRepository;

    @Autowired
    private PdfsRepository pdfsRepository;

    @Autowired
    private PendingWorksRepository pendingWorksRepository;

    @Autowired
    private PlenarySpeakersRepository plenarySpeakersRepository;

    @Autowired
    private PositivesRepository positivesRepository;

    @Autowired
    private PostersRepository postersRepository;

    @Autowired
    private PreconfRepository preconfRepository;

    @Autowired
    private RefundsRepository refundsRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationsRepository registrationsRepository;

    @Autowired
    private RegistrationPricesRepository registrationPricesRepository;

    @Autowired
    private RelatedConferencesRepository relatedConferencesRepository;

    @Autowired
    private RenewedSpeakersRepository renewedSpeakersRepository;

    @Autowired
    private RenownedspeakersRepository renownedspeakersRepository;

    @Autowired
    private ScientificProgrammeRepository scientificProgrammeRepository;

    @Autowired
    private SenderSettingsRepository senderSettingsRepository;

    @Autowired
    private SendingDomainsRepository sendingDomainsRepository;

    @Autowired
    private SpeakerInfoRepository speakerInfoRepository;

    @Autowired
    private SponsorCatalogueRepository sponsorCatalogueRepository;

    @Autowired
    private SponsorsRepository sponsorsRepository;

    @Autowired
    private StatusReportRepository statusReportRepository;

    @Autowired
    private SubscribesRepository subscribesRepository;

    @Autowired
    private SubTracksRepository subTracksRepository;

    @Autowired
    private SuggestSpeakerRepository suggestSpeakerRepository;

    @Autowired
    private TimeManagementRepository timeManagementRepository;

    @Autowired
    private TopicsRepository topicsRepository;

    @Autowired
    private TrackDescriptionRepository trackDescriptionRepository;

    @Autowired
    private TracksRepository tracksRepository;

    @Autowired
    private TrackSpeakersRepository trackSpeakersRepository;

    @Autowired
    private TzMembersRepository tzMembersRepository;

    @Autowired
    private UnsubscribesRepository unsubscribesRepository;

    @Autowired
    private VenueAccommodationRepository venueAccommodationRepository;

    @Autowired
    private VenueHelpdeskRepository venueHelpdeskRepository;

    @Autowired
    private VenueHospitalityRepository venueHospitalityRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private WorkSheetRepository workSheetRepository;

    @Autowired
    private WorkUpdateRepository workUpdateRepository;

    @Autowired
    private YrfRepository yrfRepository;

    @GetMapping("/abstracts")
    public List<Abstracts> getAbstracts() {
        return abstractsRepository.findAll();
    }

    @GetMapping("/abstract-submissions")
    public List<AbstractSubmission> getAbstractSubmissions() {
        return abstractSubmissionRepository.findAll();
    }

    @GetMapping("/acad-business")
    public List<AcadBusiness> getAcadBusiness() {
        return acadBusinessRepository.findAll();
    }

    @GetMapping("/advisary-committee")
    public List<AdvisaryCommittee> getAdvisaryCommittee() {
        return advisaryCommitteeRepository.findAll();
    }

    @GetMapping("/attendees-from")
    public List<AttendeesFrom> getAttendeesFrom() {
        return attendeesFromRepository.findAll();
    }

    @GetMapping("/banners")
    public List<Banners> getBanners() {
        return bannersRepository.findAll();
    }

    @GetMapping("/brochure")
    public List<Brochure> getBrochure() {
        return brochureRepository.findAll();
    }

    @GetMapping("/call-for-abstracts")
    public List<Callforabstracts> getCallforabstracts() {
        return callforabstractsRepository.findAll();
    }

    @GetMapping("/cfa-categories")
    public List<CfaCategories> getCfaCategories() {
        return cfaCategoriesRepository.findAll();
    }

    @GetMapping("/cfa-sub-categories")
    public List<CfaSubCategories> getCfaSubCategories() {
        return cfaSubCategoriesRepository.findAll();
    }

    @GetMapping("/city-attractions")
    public List<CityAttractions> getCityAttractions() {
        return cityAttractionsRepository.findAll();
    }

    @GetMapping("/city-guide")
    public List<Cityguide> getCityguide() {
        return cityguideRepository.findAll();
    }

    @GetMapping("/city-guide-images")
    public List<CityGuideImages> getCityGuideImages() {
        return cityGuideImagesRepository.findAll();
    }

    @GetMapping("/committee")
    public List<Committee> getCommittee() {
        return committeeRepository.findAll();
    }

    @GetMapping("/committee-program")
    public List<CommitteeProgram> getCommitteeProgram() {
        return committeeProgramRepository.findAll();
    }

    @GetMapping("/conf")
    public List<Conf> getConf() {
        return confRepository.findAll();
    }

    @GetMapping("/conferences")
    public List<Conferences> getConferences() {
        return conferencesRepository.findAll();
    }

    @GetMapping("/conf-keynote")
    public List<ConfKeynote> getConfKeynote() {
        return confKeynoteRepository.findAll();
    }

    @GetMapping("/contact-us")
    public List<ContactUs> getContactUs() {
        return contactUsRepository.findAll();
    }

    @GetMapping("/daily-tasks")
    public List<DailyTasks> getDailyTasks() {
        return dailyTasksRepository.findAll();
    }

    @GetMapping("/deadlines")
    public List<Deadlines> getDeadlines() {
        return deadlinesRepository.findAll();
    }

    @GetMapping("/edit-conference")
    public List<EditConference> getEditConference() {
        return editConferenceRepository.findAll();
    }

    @GetMapping("/edit-symposia")
    public List<EditSymposia> getEditSymposia() {
        return editSymposiaRepository.findAll();
    }

    @GetMapping("/featured-speakers")
    public List<FeaturedSpeakers> getFeaturedSpeakers() {
        return featuredSpeakersRepository.findAll();
    }

    @GetMapping("/gallery")
    public List<Gallery> getGallery() {
        return galleryRepository.findAll();
    }

    @GetMapping("/home-info")
    public List<HomeInfo> getHomeInfo() {
        return homeInfoRepository.findAll();
    }

    @GetMapping("/homepage")
    public List<Homepage> getHomepage() {
        return homepageRepository.findAll();
    }

    @GetMapping("/hotel-expenses")
    public List<HotelExpenses> getHotelExpenses() {
        return hotelExpensesRepository.findAll();
    }

    @GetMapping("/important-details")
    public List<ImportantDetails> getImportantDetails() {
        return importantDetailsRepository.findAll();
    }

    @GetMapping("/indian-reg-req")
    public List<IndianRegReq> getIndianRegReq() {
        return indianRegReqRepository.findAll();
    }

    @GetMapping("/invite-colleague")
    public List<Invitecolleague> getInvitecolleague() {
        return invitecolleagueRepository.findAll();
    }

    @GetMapping("/invited-speakers")
    public List<InvitedSpeakers> getInvitedSpeakers() {
        return invitedSpeakersRepository.findAll();
    }

    @GetMapping("/keynotes")
    public List<Keynotes> getKeynotes() {
        return keynotesRepository.findAll();
    }

    @GetMapping("/keynote-speakers")
    public List<KeynoteSpeakers> getKeynoteSpeakers() {
        return keynoteSpeakersRepository.findAll();
    }

    @GetMapping("/likes")
    public List<Likes> getLikes() {
        return likesRepository.findAll();
    }

    @GetMapping("/login-details")
    public List<LoginDetails> getLoginDetails() {
        return loginDetailsRepository.findAll();
    }

    @GetMapping("/login-info")
    public List<LoginInfo> getLoginInfo() {
        return loginInfoRepository.findAll();
    }

    @GetMapping("/mail-sending")
    public List<MailSending> getMailSending() {
        return mailSendingRepository.findAll();
    }

    @GetMapping("/media-partners")
    public List<MediaPartners> getMediaPartners() {
        return mediaPartnersRepository.findAll();
    }

    @GetMapping("/members")
    public List<Members> getMembers() {
        return membersRepository.findAll();
    }

    @GetMapping("/menu")
    public List<Menu> getMenu() {
        return menuRepository.findAll();
    }

    @GetMapping("/messages")
    public List<Messages> getMessages() {
        return messagesRepository.findAll();
    }

    @GetMapping("/meta-tags")
    public List<MetaTags> getMetaTags() {
        return metaTagsRepository.findAll();
    }

    @GetMapping("/more-speakers")
    public List<Morespeakers> getMorespeakers() {
        return morespeakersRepository.findAll();
    }

    @GetMapping("/notifications")
    public List<Notifications> getNotifications() {
        return notificationsRepository.findAll();
    }

    @GetMapping("/pages")
    public List<Pages> getPages() {
        return pagesRepository.findAll();
    }

    @GetMapping("/past-content")
    public List<PastContent> getPastContent() {
        return pastContentRepository.findAll();
    }

    @GetMapping("/past-speakers")
    public List<PastSpeakers> getPastSpeakers() {
        return pastSpeakersRepository.findAll();
    }

    @GetMapping("/pdf-enquery")
    public List<PdfEnquery> getPdfEnquery() {
        return pdfEnqueryRepository.findAll();
    }

    @GetMapping("/pdfs")
    public List<Pdfs> getPdfs() {
        return pdfsRepository.findAll();
    }

    @GetMapping("/pending-works")
    public List<PendingWorks> getPendingWorks() {
        return pendingWorksRepository.findAll();
    }

    @GetMapping("/plenary-speakers")
    public List<PlenarySpeakers> getPlenarySpeakers() {
        return plenarySpeakersRepository.findAll();
    }

    @GetMapping("/positives")
    public List<Positives> getPositives() {
        return positivesRepository.findAll();
    }

    @GetMapping("/posters")
    public List<Posters> getPosters() {
        return postersRepository.findAll();
    }

    @GetMapping("/preconf")
    public List<Preconf> getPreconf() {
        return preconfRepository.findAll();
    }

    @GetMapping("/refunds")
    public List<Refunds> getRefunds() {
        return refundsRepository.findAll();
    }

    @GetMapping("/registration")
    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }

    @GetMapping("/registrations")
    public List<Registrations> getRegistrations() {
        return registrationsRepository.findAll();
    }

    @GetMapping("/registration-prices")
    public List<RegistrationPrices> getRegistrationPrices() {
        return registrationPricesRepository.findAll();
    }

    @GetMapping("/related-conferences")
    public List<RelatedConferences> getRelatedConferences() {
        return relatedConferencesRepository.findAll();
    }

    @GetMapping("/renewed-speakers")
    public List<RenewedSpeakers> getRenewedSpeakers() {
        return renewedSpeakersRepository.findAll();
    }

    @GetMapping("/renowned-speakers")
    public List<Renownedspeakers> getRenownedspeakers() {
        return renownedspeakersRepository.findAll();
    }

    @GetMapping("/scientific-programme")
    public List<ScientificProgramme> getScientificProgramme() {
        return scientificProgrammeRepository.findAll();
    }

    @GetMapping("/sender-settings")
    public List<SenderSettings> getSenderSettings() {
        return senderSettingsRepository.findAll();
    }

    @GetMapping("/sending-domains")
    public List<SendingDomains> getSendingDomains() {
        return sendingDomainsRepository.findAll();
    }

    @GetMapping("/speaker-info")
    public List<SpeakerInfo> getSpeakerInfo() {
        return speakerInfoRepository.findAll();
    }

    @GetMapping("/sponsor-catalogue")
    public List<SponsorCatalogue> getSponsorCatalogue() {
        return sponsorCatalogueRepository.findAll();
    }

    @GetMapping("/sponsors")
    public List<Sponsors> getSponsors() {
        return sponsorsRepository.findAll();
    }

    @GetMapping("/status-report")
    public List<StatusReport> getStatusReport() {
        return statusReportRepository.findAll();
    }

    @GetMapping("/subscribes")
    public List<Subscribes> getSubscribes() {
        return subscribesRepository.findAll();
    }

    @GetMapping("/sub-tracks")
    public List<SubTracks> getSubTracks() {
        return subTracksRepository.findAll();
    }

    @GetMapping("/suggest-speaker")
    public List<SuggestSpeaker> getSuggestSpeaker() {
        return suggestSpeakerRepository.findAll();
    }

    @GetMapping("/time-management")
    public List<TimeManagement> getTimeManagement() {
        return timeManagementRepository.findAll();
    }

    @GetMapping("/topics")
    public List<Topics> getTopics() {
        return topicsRepository.findAll();
    }

    @GetMapping("/track-description")
    public List<TrackDescription> getTrackDescription() {
        return trackDescriptionRepository.findAll();
    }

    @GetMapping("/tracks")
    public List<Tracks> getTracks() {
        return tracksRepository.findAll();
    }

    @GetMapping("/track-speakers")
    public List<TrackSpeakers> getTrackSpeakers() {
        return trackSpeakersRepository.findAll();
    }

    @GetMapping("/tz-members")
    public List<TzMembers> getTzMembers() {
        return tzMembersRepository.findAll();
    }

    @GetMapping("/unsubscribes")
    public List<Unsubscribes> getUnsubscribes() {
        return unsubscribesRepository.findAll();
    }

    @GetMapping("/venue-accommodation")
    public List<VenueAccommodation> getVenueAccommodation() {
        return venueAccommodationRepository.findAll();
    }

    @GetMapping("/venue-helpdesk")
    public List<VenueHelpdesk> getVenueHelpdesk() {
        return venueHelpdeskRepository.findAll();
    }

    @GetMapping("/venue-hospitality")
    public List<VenueHospitality> getVenueHospitality() {
        return venueHospitalityRepository.findAll();
    }

    @GetMapping("/workshop")
    public List<Workshop> getWorkshop() {
        return workshopRepository.findAll();
    }

    @GetMapping("/work-sheet")
    public List<WorkSheet> getWorkSheet() {
        return workSheetRepository.findAll();
    }

    @GetMapping("/work-update")
    public List<WorkUpdate> getWorkUpdate() {
        return workUpdateRepository.findAll();
    }

    @GetMapping("/yrf")
    public List<Yrf> getYrf() {
        return yrfRepository.findAll();
    }
}
