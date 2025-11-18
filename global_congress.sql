-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: mysql-196993-0.cloudclusters.net:10001
-- Generation Time: Nov 13, 2025 at 04:11 AM
-- Server version: 8.0.26
-- PHP Version: 8.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `global_congress`
--

-- --------------------------------------------------------

--
-- Table structure for table `abstracts`
--

CREATE TABLE `abstracts` (
  `sno` int NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Country` varchar(20) NOT NULL,
  `Authors_Email` varchar(50) NOT NULL,
  `Alternative_Email` varchar(50) NOT NULL,
  `Abstract_Category` varchar(80) NOT NULL,
  `Abstract` varchar(80) NOT NULL,
  `Full_Postal_Address` varchar(200) NOT NULL,
  `Attach_your_file` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `abstract_submission`
--

CREATE TABLE `abstract_submission` (
  `id` int NOT NULL,
  `user` varchar(500) NOT NULL,
  `title` varchar(500) NOT NULL,
  `fname` varchar(500) NOT NULL,
  `country` varchar(500) NOT NULL,
  `org` text,
  `email` varchar(500) NOT NULL,
  `phno` varchar(500) NOT NULL,
  `category` varchar(500) DEFAULT NULL,
  `sent_from` varchar(500) DEFAULT NULL,
  `track_name` varchar(500) DEFAULT NULL,
  `address` text,
  `date` date DEFAULT NULL,
  `ipaddress` varchar(500) NOT NULL,
  `attachment` varchar(500) DEFAULT NULL,
  `presentation_title` varchar(2000) DEFAULT NULL,
  `entity` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `AcadBusiness`
--

CREATE TABLE `AcadBusiness` (
  `content` text,
  `category` varchar(50) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `EID` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `login` datetime DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `advisary_committee`
--

CREATE TABLE `advisary_committee` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `affiliation` text NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `pub1` text NOT NULL,
  `pub2` text NOT NULL,
  `pub3` text NOT NULL,
  `pub4` text NOT NULL,
  `network` text NOT NULL,
  `date` date NOT NULL,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendees_from`
--

CREATE TABLE `attendees_from` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  `heading` varchar(500) NOT NULL,
  `para` text NOT NULL,
  `recordListingID` int DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `banners`
--

CREATE TABLE `banners` (
  `id` int NOT NULL,
  `user` varchar(500) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `recordListingID` int DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `brochure`
--

CREATE TABLE `brochure` (
  `id` int NOT NULL,
  `prof` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `alternate_email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `organization` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `message` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `callforabstracts`
--

CREATE TABLE `callforabstracts` (
  `recordListingID` int DEFAULT NULL,
  `TrackName` text,
  `Category` varchar(50) DEFAULT NULL,
  `user` int DEFAULT NULL,
  `id` int NOT NULL,
  `SubTof` varchar(200) DEFAULT NULL,
  `TrackIdentity` varchar(40) DEFAULT NULL,
  `description` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `cfa_categories`
--

CREATE TABLE `cfa_categories` (
  `rec_id` int NOT NULL,
  `conference_name` varchar(100) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `order_sequence_no` tinyint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `cfa_sub_categories`
--

CREATE TABLE `cfa_sub_categories` (
  `rec_id` int NOT NULL,
  `category_id` int NOT NULL,
  `sub_category_name` varchar(50) NOT NULL,
  `order_sequence_no` tinyint NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `CityAttractions`
--

CREATE TABLE `CityAttractions` (
  `Attraction` varchar(200) DEFAULT NULL,
  `AttractionLink` varchar(200) DEFAULT NULL,
  `user` int DEFAULT NULL,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `cityguide`
--

CREATE TABLE `cityguide` (
  `conference` varchar(50) DEFAULT NULL,
  `content` text,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `CityGuideImages`
--

CREATE TABLE `CityGuideImages` (
  `imgContent` varchar(40) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `sid` int NOT NULL,
  `tdate` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `committee`
--

CREATE TABLE `committee` (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `affiliation` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `pub1` text,
  `pub2` text,
  `pub3` text,
  `pub4` text,
  `network` text,
  `user` int NOT NULL DEFAULT '0',
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `committee_program`
--

CREATE TABLE `committee_program` (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `affiliation` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `conf`
--

CREATE TABLE `conf` (
  `sno` int NOT NULL,
  `confname` varchar(50) NOT NULL,
  `link` varchar(100) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `location` varchar(200) NOT NULL,
  `confimage` varchar(60) NOT NULL,
  `up` int NOT NULL DEFAULT '1',
  `recordListingID` int NOT NULL DEFAULT '0',
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `conferences`
--

CREATE TABLE `conferences` (
  `id` int NOT NULL,
  `name` varchar(250) COLLATE latin1_general_ci NOT NULL,
  `theme` text COLLATE latin1_general_ci NOT NULL,
  `conference_date` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `website` text COLLATE latin1_general_ci,
  `website1` text COLLATE latin1_general_ci,
  `abstract` text COLLATE latin1_general_ci,
  `abstract1` text COLLATE latin1_general_ci,
  `email` text COLLATE latin1_general_ci,
  `email1` text COLLATE latin1_general_ci,
  `email2` text COLLATE latin1_general_ci,
  `short_desc` text COLLATE latin1_general_ci,
  `ceremony_time` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `ceremony_place` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `venue` varchar(250) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `conf_keynote`
--

CREATE TABLE `conf_keynote` (
  `kid` int NOT NULL,
  `conference` int NOT NULL,
  `time` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `place` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `user` int NOT NULL,
  `break1` text COLLATE latin1_general_ci,
  `break2` text COLLATE latin1_general_ci
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `contact_us`
--

CREATE TABLE `contact_us` (
  `id` int NOT NULL,
  `name` varchar(500) NOT NULL,
  `email` varchar(500) NOT NULL,
  `subject` varchar(500) DEFAULT NULL,
  `message` text NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `daily_tasks`
--

CREATE TABLE `daily_tasks` (
  `tid` int NOT NULL,
  `user` int NOT NULL,
  `assigned_by` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `date` date NOT NULL,
  `sec1` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec2` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec3` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec4` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec5` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec6` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec7` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec8` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec9` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `remarks` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec1_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec2_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec3_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec4_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec5_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec6_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec7_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec8_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `sec9_reply` text CHARACTER SET latin1 COLLATE latin1_general_ci
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deadlines`
--

CREATE TABLE `deadlines` (
  `did` int NOT NULL,
  `user` int NOT NULL,
  `deadlines` text NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `editConference`
--

CREATE TABLE `editConference` (
  `ShortName` varchar(50) DEFAULT NULL,
  `up` int NOT NULL,
  `Title` varchar(150) DEFAULT NULL,
  `venue` varchar(65) DEFAULT NULL,
  `hvenue` varchar(50) NOT NULL,
  `Dates` varchar(40) DEFAULT NULL,
  `Theme` varchar(150) DEFAULT NULL,
  `f_Theme` varchar(200) NOT NULL,
  `EmailId1` varchar(60) NOT NULL,
  `EmailId2` varchar(50) NOT NULL,
  `EmailId3` varchar(50) NOT NULL,
  `id` int NOT NULL,
  `JournalName1` varchar(100) NOT NULL,
  `JournalName2` varchar(100) NOT NULL,
  `JournalName3` varchar(100) NOT NULL,
  `JournalShortName1` varchar(100) NOT NULL,
  `JournalShortName2` varchar(100) NOT NULL,
  `JournalShortName3` varchar(100) NOT NULL,
  `JournalURL1` varchar(150) NOT NULL,
  `JournalURL2` varchar(150) NOT NULL,
  `JournalURL3` varchar(150) NOT NULL,
  `WebUrl` varchar(200) NOT NULL,
  `EarlyBird` varchar(40) NOT NULL,
  `RegCloses` varchar(40) NOT NULL,
  `FinalDate` varchar(40) NOT NULL,
  `TracksCount` int NOT NULL,
  `SubTracksCount` int NOT NULL,
  `confvenue` varchar(60) NOT NULL,
  `CancellationDate` varchar(60) NOT NULL,
  `ResearchField` varchar(150) NOT NULL,
  `AbstractSub` text NOT NULL,
  `ConfUrl` text NOT NULL,
  `description` varchar(1000) NOT NULL,
  `field` char(100) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `edit_symposia`
--

CREATE TABLE `edit_symposia` (
  `sno` int NOT NULL,
  `sym_early` varchar(10) NOT NULL,
  `sym_late` varchar(10) NOT NULL,
  `symposia` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `featured_speakers`
--

CREATE TABLE `featured_speakers` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `affiliation` text NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `gallery`
--

CREATE TABLE `gallery` (
  `id` int NOT NULL,
  `user` varchar(500) NOT NULL,
  `image` varchar(500) NOT NULL,
  `recordListingID` int NOT NULL,
  `link` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `homepage`
--

CREATE TABLE `homepage` (
  `conference` varchar(30) DEFAULT NULL,
  `home` text,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `home_info`
--

CREATE TABLE `home_info` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `data` text,
  `image` text,
  `aimage` varchar(100) DEFAULT NULL,
  `pdf` varchar(100) DEFAULT NULL,
  `info3` text,
  `info4` text,
  `status` int DEFAULT '1',
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hotel_expenses`
--

CREATE TABLE `hotel_expenses` (
  `id` int NOT NULL,
  `no_days_event` int NOT NULL,
  `h_name` varchar(500) NOT NULL,
  `accommodation_per_night` varchar(200) NOT NULL,
  `no_of_rooms` varchar(255) DEFAULT NULL,
  `accommodation_price` varchar(255) NOT NULL,
  `lunch_buffet` varchar(255) NOT NULL,
  `t_expenses` varchar(255) NOT NULL,
  `conf_room_price` int NOT NULL,
  `total_price` varchar(200) NOT NULL,
  `imp_id` varchar(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `important_details`
--

CREATE TABLE `important_details` (
  `sno` int NOT NULL,
  `id` int DEFAULT NULL,
  `ShortName` varchar(500) DEFAULT NULL,
  `ConfUrl` varchar(500) DEFAULT NULL,
  `Theme` varchar(500) DEFAULT NULL,
  `EmailId1` varchar(500) DEFAULT NULL,
  `EmailId2` varchar(500) DEFAULT NULL,
  `EmailId3` varchar(500) DEFAULT NULL,
  `abstract_submission_deadline` varchar(500) DEFAULT NULL,
  `registration_opens` varchar(500) DEFAULT NULL,
  `EarlyBird` varchar(500) DEFAULT NULL,
  `mid_term` varchar(500) DEFAULT NULL,
  `Late_registration` varchar(200) DEFAULT NULL,
  `OnSpot` varchar(500) DEFAULT NULL,
  `ConferenceTitle` varchar(500) DEFAULT NULL,
  `ConferenceVenue` varchar(500) DEFAULT NULL,
  `ConferenceDates` varchar(500) DEFAULT NULL,
  `facebook_link` varchar(500) DEFAULT NULL,
  `linkedin_link` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `instagram_link` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `twitter_link` varchar(500) DEFAULT NULL,
  `twitter_tweets` mediumtext,
  `date` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `pc_name` varchar(500) DEFAULT NULL,
  `entity_logo` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `indian_reg_req`
--

CREATE TABLE `indian_reg_req` (
  `id` int NOT NULL,
  `USD` int NOT NULL,
  `INR` int NOT NULL,
  `USER` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `invitecolleague`
--

CREATE TABLE `invitecolleague` (
  `confTitle1` varchar(100) DEFAULT NULL,
  `confTitle2` varchar(100) DEFAULT NULL,
  `cfaurl` varchar(150) DEFAULT NULL,
  `ImpSessions` text,
  `WithRegards` varchar(100) DEFAULT NULL,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `invited_speakers`
--

CREATE TABLE `invited_speakers` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `affiliation` text,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int DEFAULT '0',
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `keynotes`
--

CREATE TABLE `keynotes` (
  `id` int NOT NULL,
  `day` varchar(10) NOT NULL,
  `keynote` int NOT NULL,
  `speaker_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `speaker_photo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_logo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `key_pdf` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `break` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `time` varchar(50) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `user` int NOT NULL,
  `sid` int DEFAULT '0',
  `recordListingID` int DEFAULT NULL,
  `tittle` varchar(500) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `biography` text NOT NULL,
  `abstract` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `keynote_speakers`
--

CREATE TABLE `keynote_speakers` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `affiliation` text,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int DEFAULT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `likes`
--

CREATE TABLE `likes` (
  `id` int NOT NULL,
  `facebook` varchar(120) NOT NULL,
  `linkedin` varchar(120) NOT NULL,
  `twitter` varchar(120) NOT NULL,
  `blog` varchar(180) NOT NULL,
  `youtube` varchar(200) NOT NULL,
  `flickr` varchar(200) NOT NULL,
  `googleplus` varchar(200) NOT NULL,
  `pinterest` varchar(200) NOT NULL,
  `rss` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `Links`
--

CREATE TABLE `Links` (
  `RSS` varchar(50) NOT NULL,
  `facebook` varchar(50) NOT NULL,
  `LinkedIn` varchar(50) NOT NULL,
  `Twitter` varchar(50) NOT NULL,
  `Blog` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `id` int NOT NULL,
  `first_name` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `last_name` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `password` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `email` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `contact_no` varchar(15) COLLATE latin1_general_ci DEFAULT NULL,
  `gender` varchar(8) COLLATE latin1_general_ci DEFAULT NULL,
  `address` tinytext COLLATE latin1_general_ci,
  `status` varchar(20) COLLATE latin1_general_ci DEFAULT 'true',
  `role` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `conference` int DEFAULT NULL,
  `member` int DEFAULT '0',
  `username` varchar(50) COLLATE latin1_general_ci DEFAULT NULL,
  `ConfName` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `confvenue` varchar(60) COLLATE latin1_general_ci DEFAULT NULL,
  `assigned_to` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `assigned_date` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `conference_url` varchar(500) COLLATE latin1_general_ci DEFAULT NULL,
  `event_name` varchar(500) COLLATE latin1_general_ci DEFAULT NULL,
  `url` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `entity_name` varchar(500) COLLATE latin1_general_ci DEFAULT NULL,
  `hostinger_domain` varchar(500) COLLATE latin1_general_ci DEFAULT NULL,
  `hostinger_domain_1` varchar(500) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `otp_time` datetime DEFAULT NULL,
  `otp` varchar(11) COLLATE latin1_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login_info`
--

CREATE TABLE `login_info` (
  `id` int NOT NULL,
  `login_date` date NOT NULL,
  `logout_date` date DEFAULT NULL,
  `user` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mail_sending`
--

CREATE TABLE `mail_sending` (
  `id` int NOT NULL,
  `campaign_type` varchar(200) COLLATE latin1_general_ci NOT NULL,
  `invitation_type` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `emails_sent` int DEFAULT '0',
  `emails_recivied` int DEFAULT '0',
  `unsubscribed` int DEFAULT '0',
  `unique_views` int DEFAULT '0',
  `user` int NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `media_partners`
--

CREATE TABLE `media_partners` (
  `id` int NOT NULL,
  `mediapartner_name` varchar(500) DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL,
  `description` text,
  `user` varchar(500) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `id` int NOT NULL,
  `name` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `affiliation` text,
  `email` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `speaker_category` varchar(500) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `category` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT 'Plenary',
  `user` int DEFAULT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int NOT NULL,
  `Organizing_Committee` varchar(100) NOT NULL,
  `b2b` text NOT NULL,
  `scientific_partnering` varchar(100) NOT NULL,
  `additional_menu` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `msg_id` int NOT NULL,
  `user` int NOT NULL,
  `speaker_name` varchar(150) COLLATE latin1_general_ci NOT NULL,
  `affiliation` text COLLATE latin1_general_ci NOT NULL,
  `reply_given` text COLLATE latin1_general_ci NOT NULL,
  `reply_date` date NOT NULL,
  `reply_attachment` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `reply_sent` text COLLATE latin1_general_ci NOT NULL,
  `sent_date` date NOT NULL,
  `sent_attachment` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `abstract_title` varchar(250) COLLATE latin1_general_ci NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `meta_tags`
--

CREATE TABLE `meta_tags` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `main_title` varchar(500) DEFAULT NULL,
  `description` text,
  `keywords` text,
  `abs_title` varchar(500) DEFAULT NULL,
  `abs_description` text,
  `abs_keywords` text,
  `reg_title` varchar(500) DEFAULT NULL,
  `reg_description` text,
  `reg_keywords` text,
  `guidelines_title` varchar(500) DEFAULT NULL,
  `guidelines_description` text,
  `guidelines_keywords` text,
  `policies_title` varchar(500) DEFAULT NULL,
  `policies_description` text,
  `policies_keywords` text,
  `contact_title` varchar(500) DEFAULT NULL,
  `contact_description` text,
  `contact_keywords` text,
  `speaker_title` varchar(500) DEFAULT NULL,
  `speaker_description` text,
  `speaker_keywords` text,
  `committee_title` varchar(500) DEFAULT NULL,
  `committee_description` text,
  `committee_keywords` text,
  `callforpapers_title` varchar(500) DEFAULT NULL,
  `callforpapers_description` text,
  `callforpapers_keywords` text,
  `topics_title` varchar(500) DEFAULT NULL,
  `topics_description` text,
  `topics_keywords` text,
  `venue_title` varchar(500) DEFAULT NULL,
  `venue_description` text,
  `venue_keywords` text,
  `visa_title` varchar(500) DEFAULT NULL,
  `visa_description` text,
  `visa_keywords` text,
  `invitation_title` varchar(500) DEFAULT NULL,
  `invitation_description` text,
  `invitation_keywords` text,
  `terms_title` varchar(500) DEFAULT NULL,
  `terms_description` text,
  `terms_keywords` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `morespeakers`
--

CREATE TABLE `morespeakers` (
  `id` int NOT NULL,
  `name` varchar(60) NOT NULL,
  `affiliation` varchar(150) NOT NULL,
  `photo` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `id` int NOT NULL,
  `notification_name` varchar(200) NOT NULL,
  `notification_link` varchar(200) NOT NULL,
  `user` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pages`
--

CREATE TABLE `pages` (
  `id` int NOT NULL,
  `faqs` text,
  `policies` text,
  `guidelines` text,
  `visa_information` text,
  `invitation_letter` text NOT NULL,
  `terms_conditions` text,
  `user` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `past_content`
--

CREATE TABLE `past_content` (
  `home` text NOT NULL,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `past_speakers`
--

CREATE TABLE `past_speakers` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `affiliation` varchar(200) NOT NULL,
  `country` varchar(50) NOT NULL,
  `photo` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `pdfs`
--

CREATE TABLE `pdfs` (
  `sno` int NOT NULL,
  `tentative_program` varchar(100) DEFAULT NULL,
  `Conferenceguide` varchar(100) DEFAULT NULL,
  `Brochure` varchar(100) DEFAULT NULL,
  `abstract_book` varchar(500) DEFAULT NULL,
  `eform_usa` varchar(50) DEFAULT NULL,
  `Sponsorship` varchar(60) DEFAULT NULL,
  `eform` varchar(40) DEFAULT NULL,
  `id` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `pdf_enquery`
--

CREATE TABLE `pdf_enquery` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `submitted_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `pending_works`
--

CREATE TABLE `pending_works` (
  `id` int NOT NULL,
  `pending_work` longtext COLLATE latin1_general_ci NOT NULL,
  `user` int NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `plenary_speakers`
--

CREATE TABLE `plenary_speakers` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `affiliation` text,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int DEFAULT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `positives`
--

CREATE TABLE `positives` (
  `id` int NOT NULL,
  `positive_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `photo` varchar(100) DEFAULT NULL,
  `user` int NOT NULL DEFAULT '0',
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `posters`
--

CREATE TABLE `posters` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `name` varchar(120) NOT NULL,
  `affiliation` text,
  `pdf` varchar(120) DEFAULT NULL,
  `photo` varchar(120) DEFAULT NULL,
  `logo` varchar(120) DEFAULT NULL,
  `recordListingID` int DEFAULT NULL,
  `biography` text NOT NULL,
  `abstract` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `preconf`
--

CREATE TABLE `preconf` (
  `sno` int NOT NULL,
  `confname` varchar(200) NOT NULL,
  `link` varchar(250) NOT NULL,
  `recordListingID` int NOT NULL DEFAULT '0',
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `refunds`
--

CREATE TABLE `refunds` (
  `id` int NOT NULL,
  `invoice_number` varchar(200) NOT NULL,
  `amount` varchar(11) NOT NULL,
  `reason` varchar(200) NOT NULL,
  `status` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `reg_id` int NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `middlename` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `activation_status` varchar(15) NOT NULL DEFAULT 'deactive',
  `login_status` varchar(5) NOT NULL DEFAULT 'no',
  `reg_date` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registrations`
--

CREATE TABLE `registrations` (
  `id` int NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `country` varchar(500) DEFAULT NULL,
  `address` text,
  `org` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `price` double DEFAULT NULL,
  `checkin_date` varchar(500) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `conf` varchar(500) DEFAULT NULL,
  `token` text,
  `confirm_no` varchar(500) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `description` text,
  `payment_type` varchar(255) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `entity_assigned` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `invoice_number` varchar(500) DEFAULT NULL,
  `t_id` varchar(200) DEFAULT NULL,
  `entity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `registration_prices`
--

CREATE TABLE `registration_prices` (
  `id` int NOT NULL,
  `speaker_reg_e` varchar(500) DEFAULT NULL,
  `delegate_reg_e` varchar(500) DEFAULT NULL,
  `student_reg_e` varchar(500) DEFAULT NULL,
  `poster_reg_e` varchar(500) DEFAULT NULL,
  `speaker_reg_s` varchar(500) DEFAULT NULL,
  `delegate_reg_s` varchar(500) DEFAULT NULL,
  `student_reg_s` varchar(500) DEFAULT NULL,
  `poster_reg_s` varchar(500) DEFAULT NULL,
  `speaker_reg_o` varchar(500) DEFAULT NULL,
  `delegate_reg_o` varchar(500) DEFAULT NULL,
  `student_reg_o` varchar(500) DEFAULT NULL,
  `poster_reg_o` varchar(500) DEFAULT NULL,
  `one_night_single_occupancy` varchar(500) DEFAULT NULL,
  `one_night_double_occupancy` varchar(500) DEFAULT NULL,
  `two_night_single_occupancy` varchar(500) DEFAULT NULL,
  `two_night_double_occupancy` varchar(500) DEFAULT NULL,
  `three_night_single_occupancy` varchar(500) DEFAULT NULL,
  `three_night_double_occupancy` varchar(500) DEFAULT NULL,
  `four_night_single_occupancy` varchar(500) DEFAULT NULL,
  `four_night_double_occupancy` varchar(500) DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `related_conferences`
--

CREATE TABLE `related_conferences` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `conference_date` varchar(500) NOT NULL,
  `website` text NOT NULL,
  `user` int NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `renewed_speakers`
--

CREATE TABLE `renewed_speakers` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `photo` varchar(200) NOT NULL,
  `name` varchar(250) NOT NULL,
  `affiliation` text NOT NULL,
  `country` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `renownedspeakers`
--

CREATE TABLE `renownedspeakers` (
  `user` int DEFAULT NULL,
  `name1` varchar(40) DEFAULT NULL,
  `photo1` varchar(200) DEFAULT NULL,
  `affiliation1` text,
  `country1` varchar(40) DEFAULT NULL,
  `name2` varchar(40) DEFAULT NULL,
  `photo2` varchar(200) DEFAULT NULL,
  `affiliation2` text,
  `country2` varchar(40) DEFAULT NULL,
  `tdate` varchar(40) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `id` int NOT NULL,
  `Biography1` text NOT NULL,
  `Biography2` text NOT NULL,
  `recordListingID` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `scientific_programme`
--

CREATE TABLE `scientific_programme` (
  `sid` int NOT NULL,
  `conference` int NOT NULL,
  `day` int NOT NULL,
  `date` date NOT NULL,
  `user` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sender_settings`
--

CREATE TABLE `sender_settings` (
  `id` int NOT NULL,
  `domain_name` varchar(255) NOT NULL,
  `email` varchar(500) NOT NULL,
  `outgoing` varchar(255) DEFAULT NULL,
  `smtp_username` varchar(500) NOT NULL,
  `smtp_password` varchar(500) NOT NULL,
  `encryption` varchar(255) NOT NULL,
  `port` int NOT NULL,
  `mail_service` varchar(500) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sending_domains`
--

CREATE TABLE `sending_domains` (
  `id` int NOT NULL,
  `email` varchar(500) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `shortname` varchar(500) DEFAULT NULL,
  `user` int DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `speakerscrolling`
--

CREATE TABLE `speakerscrolling` (
  `name` varchar(40) DEFAULT NULL,
  `country` varchar(40) DEFAULT NULL,
  `Affiliation` varchar(60) DEFAULT NULL,
  `image` varchar(40) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `speaker_info`
--

CREATE TABLE `speaker_info` (
  `id` int NOT NULL,
  `sub_track` int NOT NULL,
  `time` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `speaker_title` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `speaker_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `speaker_photo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_logo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `spk_pdf` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `plenary_title` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `time_1` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `plenary_name` varchar(150) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `plenary_photo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_logo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_pdf` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `break` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT NULL,
  `display` int NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `sponsors`
--

CREATE TABLE `sponsors` (
  `id` int NOT NULL,
  `sponsor_name` varchar(200) DEFAULT NULL,
  `link` varchar(200) DEFAULT NULL,
  `description` text,
  `user` varchar(200) DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sponsors_mobileapp`
--

CREATE TABLE `sponsors_mobileapp` (
  `content` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `sponsor_catalogue`
--

CREATE TABLE `sponsor_catalogue` (
  `id` int NOT NULL,
  `prof` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `alternate_email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `organization` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `status_report`
--

CREATE TABLE `status_report` (
  `id` int NOT NULL,
  `abstract_received` int DEFAULT '0',
  `regs_received` int DEFAULT '0',
  `abstracts_updated` int DEFAULT '0',
  `local_name` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `local_affiliation` text COLLATE latin1_general_ci,
  `local_email` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `nonlocal_name` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `nonlocal_affiliation` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  `nonlocal_email` varchar(150) COLLATE latin1_general_ci DEFAULT NULL,
  `user` int NOT NULL,
  `status_date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subscribes`
--

CREATE TABLE `subscribes` (
  `id` int NOT NULL,
  `email` varchar(500) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `category` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sub_tracks`
--

CREATE TABLE `sub_tracks` (
  `id` int NOT NULL,
  `track_id` int NOT NULL,
  `session_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `session_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `session_photo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `session_logo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `cosession_photo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_logo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `strack_name` text CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `strack_place` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `strack_date` date NOT NULL,
  `strack_time` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Suggest_Speaker`
--

CREATE TABLE `Suggest_Speaker` (
  `id` int NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MailId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SpeakerName` varchar(100) NOT NULL,
  `SpeakerMailId` varchar(100) NOT NULL,
  `Message` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `time_management`
--

CREATE TABLE `time_management` (
  `id` int NOT NULL,
  `work_done` text COLLATE latin1_general_ci NOT NULL,
  `target_date` date NOT NULL,
  `finished_date` date DEFAULT NULL,
  `user` int NOT NULL,
  `date` date NOT NULL,
  `assigned_by` varchar(150) COLLATE latin1_general_ci NOT NULL,
  `work_status` text COLLATE latin1_general_ci
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `topics`
--

CREATE TABLE `topics` (
  `id` int NOT NULL,
  `topic` text NOT NULL,
  `conference` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tracks`
--

CREATE TABLE `tracks` (
  `id` int NOT NULL,
  `track_name` text CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `session_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `session_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `session_photo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `session_logo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `cosession_photo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `cosession_logo` varchar(120) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `sa_name` varchar(100) NOT NULL,
  `sa_affiliation` text NOT NULL,
  `sa_photo` varchar(80) NOT NULL,
  `sa_logo` varchar(80) NOT NULL,
  `sid` int NOT NULL,
  `track_time` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `track_place` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `track_date` date DEFAULT NULL,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `track_description`
--

CREATE TABLE `track_description` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `description` text NOT NULL,
  `TrackIdentity` int NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `track_speakers`
--

CREATE TABLE `track_speakers` (
  `id` int NOT NULL,
  `track` int NOT NULL,
  `time` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `speaker_title` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `speaker_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `speaker_photo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_logo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `spk_pdf` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `speaker_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `plenary_title` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `time_1` varchar(40) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `plenary_name` varchar(150) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_affiliation` text CHARACTER SET latin1 COLLATE latin1_general_ci,
  `plenary_photo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_logo` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `plenary_pdf` varchar(100) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `break` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `user` int NOT NULL,
  `recordListingID` int DEFAULT NULL,
  `biography` text NOT NULL,
  `abstract` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `tz_members`
--

CREATE TABLE `tz_members` (
  `id` int NOT NULL,
  `usr` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `pass` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `regIP` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `dt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `unsubscribes`
--

CREATE TABLE `unsubscribes` (
  `id` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `cnfid` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `venue_accommodation`
--

CREATE TABLE `venue_accommodation` (
  `id` int NOT NULL,
  `acc_content` text NOT NULL,
  `acc_image1` varchar(500) NOT NULL,
  `image_title1` text NOT NULL,
  `acc_image2` varchar(500) NOT NULL,
  `image_title2` text NOT NULL,
  `acc_image3` varchar(500) NOT NULL,
  `image_title3` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `venue_helpdesk`
--

CREATE TABLE `venue_helpdesk` (
  `id` int NOT NULL,
  `address` varchar(200) NOT NULL,
  `state` varchar(40) NOT NULL,
  `city` varchar(40) NOT NULL,
  `Airport` varchar(70) NOT NULL,
  `Distance` varchar(15) NOT NULL,
  `language` varchar(30) NOT NULL,
  `helpdesk_image` varchar(50) NOT NULL,
  `venue_image` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `venue_hospitality`
--

CREATE TABLE `venue_hospitality` (
  `id` int NOT NULL,
  `map` text,
  `venue_content` text,
  `venue_image1` varchar(500) DEFAULT NULL,
  `image_title1` text,
  `venue_image2` varchar(500) DEFAULT NULL,
  `image_title2` text,
  `venue_image3` varchar(500) DEFAULT NULL,
  `image_title3` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `workshop`
--

CREATE TABLE `workshop` (
  `id` int NOT NULL,
  `user` int NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  `heading` varchar(500) NOT NULL,
  `para` text NOT NULL,
  `recordListingID` int DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `work_sheet`
--

CREATE TABLE `work_sheet` (
  `id` int NOT NULL,
  `uploaded_at` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user` int DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `work_update`
--

CREATE TABLE `work_update` (
  `id` int NOT NULL,
  `individual_sent` int NOT NULL DEFAULT '0',
  `merge_sent` int NOT NULL DEFAULT '0',
  `collection` int NOT NULL DEFAULT '0',
  `positives` int NOT NULL DEFAULT '0',
  `virtual_res` int NOT NULL DEFAULT '0',
  `abstracts` int NOT NULL DEFAULT '0',
  `registrations` int NOT NULL DEFAULT '0',
  `revenue` int NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `user` varchar(500) NOT NULL,
  `update_file` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `yrf`
--

CREATE TABLE `yrf` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `affiliation` text,
  `photo` varchar(100) DEFAULT NULL,
  `biography` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `research` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `user` int DEFAULT NULL,
  `recordListingID` int DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `abstract_submission`
--
ALTER TABLE `abstract_submission`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `AcadBusiness`
--
ALTER TABLE `AcadBusiness`
  ADD PRIMARY KEY (`EID`);

--
-- Indexes for table `advisary_committee`
--
ALTER TABLE `advisary_committee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendees_from`
--
ALTER TABLE `attendees_from`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `brochure`
--
ALTER TABLE `brochure`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `callforabstracts`
--
ALTER TABLE `callforabstracts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cfa_categories`
--
ALTER TABLE `cfa_categories`
  ADD PRIMARY KEY (`rec_id`),
  ADD KEY `order_sequence_no` (`order_sequence_no`),
  ADD KEY `conference_name` (`conference_name`);

--
-- Indexes for table `cfa_sub_categories`
--
ALTER TABLE `cfa_sub_categories`
  ADD PRIMARY KEY (`rec_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `order_sequence_no` (`order_sequence_no`);

--
-- Indexes for table `CityAttractions`
--
ALTER TABLE `CityAttractions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `CityGuideImages`
--
ALTER TABLE `CityGuideImages`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `committee`
--
ALTER TABLE `committee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `committee_program`
--
ALTER TABLE `committee_program`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `conf`
--
ALTER TABLE `conf`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `conferences`
--
ALTER TABLE `conferences`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `conf_keynote`
--
ALTER TABLE `conf_keynote`
  ADD PRIMARY KEY (`kid`);

--
-- Indexes for table `contact_us`
--
ALTER TABLE `contact_us`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `daily_tasks`
--
ALTER TABLE `daily_tasks`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `deadlines`
--
ALTER TABLE `deadlines`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `edit_symposia`
--
ALTER TABLE `edit_symposia`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `featured_speakers`
--
ALTER TABLE `featured_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gallery`
--
ALTER TABLE `gallery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `home_info`
--
ALTER TABLE `home_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel_expenses`
--
ALTER TABLE `hotel_expenses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `important_details`
--
ALTER TABLE `important_details`
  ADD PRIMARY KEY (`sno`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `invited_speakers`
--
ALTER TABLE `invited_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keynotes`
--
ALTER TABLE `keynotes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keynote_speakers`
--
ALTER TABLE `keynote_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login_details`
--
ALTER TABLE `login_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`conference`),
  ADD KEY `role` (`role`);

--
-- Indexes for table `mail_sending`
--
ALTER TABLE `mail_sending`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `media_partners`
--
ALTER TABLE `media_partners`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `meta_tags`
--
ALTER TABLE `meta_tags`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pages`
--
ALTER TABLE `pages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `past_content`
--
ALTER TABLE `past_content`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `past_speakers`
--
ALTER TABLE `past_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pdfs`
--
ALTER TABLE `pdfs`
  ADD PRIMARY KEY (`sno`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pdf_enquery`
--
ALTER TABLE `pdf_enquery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pending_works`
--
ALTER TABLE `pending_works`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `plenary_speakers`
--
ALTER TABLE `plenary_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `positives`
--
ALTER TABLE `positives`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `posters`
--
ALTER TABLE `posters`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `preconf`
--
ALTER TABLE `preconf`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`reg_id`);

--
-- Indexes for table `registrations`
--
ALTER TABLE `registrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registration_prices`
--
ALTER TABLE `registration_prices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `related_conferences`
--
ALTER TABLE `related_conferences`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `renewed_speakers`
--
ALTER TABLE `renewed_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `renownedspeakers`
--
ALTER TABLE `renownedspeakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `scientific_programme`
--
ALTER TABLE `scientific_programme`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `sender_settings`
--
ALTER TABLE `sender_settings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sending_domains`
--
ALTER TABLE `sending_domains`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `speaker_info`
--
ALTER TABLE `speaker_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sponsors`
--
ALTER TABLE `sponsors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sponsor_catalogue`
--
ALTER TABLE `sponsor_catalogue`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status_report`
--
ALTER TABLE `status_report`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_tracks`
--
ALTER TABLE `sub_tracks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Suggest_Speaker`
--
ALTER TABLE `Suggest_Speaker`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `YourMailId` (`MailId`),
  ADD UNIQUE KEY `SpeakerMailId` (`SpeakerMailId`),
  ADD UNIQUE KEY `MailId` (`MailId`);

--
-- Indexes for table `time_management`
--
ALTER TABLE `time_management`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `topics`
--
ALTER TABLE `topics`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tracks`
--
ALTER TABLE `tracks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `track_description`
--
ALTER TABLE `track_description`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `track_speakers`
--
ALTER TABLE `track_speakers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tz_members`
--
ALTER TABLE `tz_members`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usr` (`usr`);

--
-- Indexes for table `unsubscribes`
--
ALTER TABLE `unsubscribes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venue_accommodation`
--
ALTER TABLE `venue_accommodation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venue_helpdesk`
--
ALTER TABLE `venue_helpdesk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venue_hospitality`
--
ALTER TABLE `venue_hospitality`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `workshop`
--
ALTER TABLE `workshop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `work_sheet`
--
ALTER TABLE `work_sheet`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `work_update`
--
ALTER TABLE `work_update`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `yrf`
--
ALTER TABLE `yrf`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `abstract_submission`
--
ALTER TABLE `abstract_submission`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `AcadBusiness`
--
ALTER TABLE `AcadBusiness`
  MODIFY `EID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `advisary_committee`
--
ALTER TABLE `advisary_committee`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `attendees_from`
--
ALTER TABLE `attendees_from`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `banners`
--
ALTER TABLE `banners`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `brochure`
--
ALTER TABLE `brochure`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `callforabstracts`
--
ALTER TABLE `callforabstracts`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cfa_categories`
--
ALTER TABLE `cfa_categories`
  MODIFY `rec_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cfa_sub_categories`
--
ALTER TABLE `cfa_sub_categories`
  MODIFY `rec_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CityAttractions`
--
ALTER TABLE `CityAttractions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CityGuideImages`
--
ALTER TABLE `CityGuideImages`
  MODIFY `sid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `committee`
--
ALTER TABLE `committee`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `committee_program`
--
ALTER TABLE `committee_program`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conf`
--
ALTER TABLE `conf`
  MODIFY `sno` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conferences`
--
ALTER TABLE `conferences`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conf_keynote`
--
ALTER TABLE `conf_keynote`
  MODIFY `kid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contact_us`
--
ALTER TABLE `contact_us`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `daily_tasks`
--
ALTER TABLE `daily_tasks`
  MODIFY `tid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `deadlines`
--
ALTER TABLE `deadlines`
  MODIFY `did` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `edit_symposia`
--
ALTER TABLE `edit_symposia`
  MODIFY `sno` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `featured_speakers`
--
ALTER TABLE `featured_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `gallery`
--
ALTER TABLE `gallery`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `home_info`
--
ALTER TABLE `home_info`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hotel_expenses`
--
ALTER TABLE `hotel_expenses`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `important_details`
--
ALTER TABLE `important_details`
  MODIFY `sno` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invited_speakers`
--
ALTER TABLE `invited_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `keynotes`
--
ALTER TABLE `keynotes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `keynote_speakers`
--
ALTER TABLE `keynote_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login_details`
--
ALTER TABLE `login_details`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mail_sending`
--
ALTER TABLE `mail_sending`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `media_partners`
--
ALTER TABLE `media_partners`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `msg_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `meta_tags`
--
ALTER TABLE `meta_tags`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pages`
--
ALTER TABLE `pages`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `past_speakers`
--
ALTER TABLE `past_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pdfs`
--
ALTER TABLE `pdfs`
  MODIFY `sno` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pdf_enquery`
--
ALTER TABLE `pdf_enquery`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pending_works`
--
ALTER TABLE `pending_works`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `plenary_speakers`
--
ALTER TABLE `plenary_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `positives`
--
ALTER TABLE `positives`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `posters`
--
ALTER TABLE `posters`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `preconf`
--
ALTER TABLE `preconf`
  MODIFY `sno` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `reg_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `registrations`
--
ALTER TABLE `registrations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `registration_prices`
--
ALTER TABLE `registration_prices`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `related_conferences`
--
ALTER TABLE `related_conferences`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `renewed_speakers`
--
ALTER TABLE `renewed_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `renownedspeakers`
--
ALTER TABLE `renownedspeakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `scientific_programme`
--
ALTER TABLE `scientific_programme`
  MODIFY `sid` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sender_settings`
--
ALTER TABLE `sender_settings`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sending_domains`
--
ALTER TABLE `sending_domains`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `speaker_info`
--
ALTER TABLE `speaker_info`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sponsors`
--
ALTER TABLE `sponsors`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sponsor_catalogue`
--
ALTER TABLE `sponsor_catalogue`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `status_report`
--
ALTER TABLE `status_report`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sub_tracks`
--
ALTER TABLE `sub_tracks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Suggest_Speaker`
--
ALTER TABLE `Suggest_Speaker`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `time_management`
--
ALTER TABLE `time_management`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `topics`
--
ALTER TABLE `topics`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tracks`
--
ALTER TABLE `tracks`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `track_description`
--
ALTER TABLE `track_description`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `track_speakers`
--
ALTER TABLE `track_speakers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tz_members`
--
ALTER TABLE `tz_members`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `unsubscribes`
--
ALTER TABLE `unsubscribes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workshop`
--
ALTER TABLE `workshop`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `work_sheet`
--
ALTER TABLE `work_sheet`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `work_update`
--
ALTER TABLE `work_update`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `yrf`
--
ALTER TABLE `yrf`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
