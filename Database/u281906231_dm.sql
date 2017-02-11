-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2017 at 11:11 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u281906231_dm`
--

-- --------------------------------------------------------

--
-- Table structure for table `alert`
--

CREATE TABLE `alert` (
  `_id` int(10) NOT NULL,
  `username` text COLLATE utf8_unicode_ci NOT NULL,
  `text` text COLLATE utf8_unicode_ci NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `alert`
--

INSERT INTO `alert` (`_id`, `username`, `text`, `latitude`, `longitude`) VALUES
(1, '', 'Suddenly A small EarTHquake came and Our Building Collapsed,Save Us we are Under the Building,i somehow Came out of the Chunks,Bt many people Still Inside,Come ASAP.', 20.9374, 77.7796),
(11, '', 'Help Me!', 19.1074526, 72.8368237),
(13, '', '', 19.1075019, 72.8368699),
(12, '', 'help me!', 19.1074526, 72.8368237),
(8, '', 'help me', 19.0213, 72.8424),
(14, '', 'need help', 19.1075019, 72.8368699),
(15, '', '', 19.1072393, 72.8355313),
(16, '', '', 19.1067694, 72.837193),
(17, '', 'need help', 19.1067694, 72.837193),
(18, '', 'need help', 19.1067694, 72.837193),
(19, '', 'need help', 19.1067694, 72.837193),
(20, '', 'need help', 19.1067694, 72.837193),
(21, '', 'need help', 19.1067694, 72.837193),
(22, '', 'need help', 19.1067694, 72.837193),
(23, '', 'need help', 19.1067694, 72.837193),
(24, '', 'need help', 19.1067694, 72.837193),
(25, '', 'need help', 19.1067694, 72.837193),
(26, '', 'please help me bro', 0, 0),
(27, '', 'pisal ke gir gaya bro', 0, 0),
(28, '', '', 0, 0),
(29, '', '', 19.1074526, 72.8368237),
(30, '', 'Need Help', 19.1074526, 72.8368237),
(31, '', 'pleSss help', 19.1071463, 72.8373776),
(32, '', 'pleSss help', 19.1071463, 72.8373776),
(33, '', 'pleSss help', 19.1071463, 72.8373776),
(34, '', 'pleSss help', 19.1071463, 72.8373776),
(35, '', 'pleSss help', 19.1071463, 72.8373776),
(36, '', 'remind', 19.1071463, 72.8373776),
(37, '', 'remind', 19.1071463, 72.8373776),
(38, '', '', 19.1072393, 72.8355313),
(39, '', 'need help', 19.1072393, 72.8355313),
(40, '', '', 19.1074526, 72.8368237),
(41, '', 'bhai bachao meko', 19.1074526, 72.8368237),
(42, '', 'bhai bachao meko', 19.1074526, 72.8368237),
(43, '', 'bachooooo Bhaijaan', 19.1074526, 72.8368237),
(44, 'Aditya', '', 19.1074526, 72.8368237),
(45, 'Aditya', 'Hyde h fggfg', 19.1074526, 72.8368237),
(46, 'Aditya', 'Hyde h fggfg', 19.1074526, 72.8368237),
(47, 'Aditya', 'cg yet Rd', 19.1074526, 72.8368237),
(48, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1070564, 72.8373776),
(49, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(50, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(51, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(52, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(53, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(54, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(55, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(56, '', 'Naved: Fatt ke haath meh aa gayi bhai', 19.1074526, 72.8368237),
(57, 'Maaz Khan', 'help me', 19.1074526, 72.8368237),
(58, 'Maaz Khan', 'Rohit: mai gay hu', 19.1074526, 72.8368237),
(59, 'Maaz Khan', 'bachao saalo', 19.1074526, 72.8368237),
(60, 'Maaz Khan', 'jungle meh aag lagi bhaago baccho bhaago', 19.1074526, 72.8368237),
(61, 'Jawad Shaikh', 'Need Help!', 19.1074526, 72.8368237),
(62, 'Maaz Khan', 'Urgent help needed', 19.1072393, 72.8355313),
(63, 'Maaz Khan', 'hola como estas', 19.1070564, 72.8373776),
(64, 'Maaz Khan', 'qwrtyidjsjshfjsiksjdjkdidkcjndjishabjdkfiannskcofojsnsnncbcj', 19.1070564, 72.8373776),
(65, 'Aditya', 'GG DDG', 19.1075019, 72.8368699),
(66, 'Maaz Khan', 'Help me Superman', 19.1070564, 72.8373776),
(67, 'Maaz Khan', 'Somebody help me', 19.1070564, 72.8373776),
(68, 'Maaz Khan', 'Somebody 911', 19.1070564, 72.8373776),
(69, 'Maaz Khan', 'Somebody  shawtyfire burning on the dance floor', 19.1070564, 72.8373776),
(70, 'Maaz Khan', 'Somebody  911 fire burning on the dance floor', 19.1070564, 72.8373776),
(71, 'Maaz Khan', 'Somebody  911 fire burning on the dance floor', 19.1070564, 72.8373776),
(72, 'Danish Shah', 'Help me!', 19.1071463, 72.8373776),
(73, 'Danish Shah', 'Maaz gandu', 19.0733224, 72.8999606),
(74, 'Maaz khan', 'Help', 0, 0),
(75, 'Jawad Shaikh', 'need help', 19.1066796, 72.837193),
(76, 'Jawad Shaikh', 'need help', 19.1066796, 72.837193),
(77, 'Jawad Shaikh', 'need help', 19.1066796, 72.837193),
(78, 'Jawad Shaikh', 'need help', 19.1066796, 72.837193),
(79, 'Danish Shah', '', 19.1070564, 72.8373776),
(80, 'Danish Shah', 'Need Help!', 19.1071463, 72.8373776);

-- --------------------------------------------------------

--
-- Table structure for table `alert_count`
--

CREATE TABLE `alert_count` (
  `_id` int(10) NOT NULL,
  `alert_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alert_count`
--

INSERT INTO `alert_count` (`_id`, `alert_id`) VALUES
(47, 1),
(53, 2),
(54, 3),
(55, 4),
(56, 5),
(57, 6),
(58, 7),
(59, 8),
(60, 9),
(61, 10),
(62, 11),
(63, 12),
(64, 13),
(65, 14),
(66, 15),
(67, 16),
(68, 17),
(69, 18),
(70, 19),
(71, 20),
(72, 21),
(73, 22),
(74, 23),
(75, 24),
(76, 25),
(77, 26),
(78, 27),
(79, 28),
(80, 29),
(81, 30),
(82, 31),
(83, 32),
(84, 33),
(85, 34),
(86, 35),
(87, 36),
(88, 37),
(89, 38),
(90, 39),
(91, 40),
(92, 41),
(93, 42),
(94, 43),
(95, 44),
(96, 45),
(97, 46),
(98, 47),
(99, 48),
(100, 49),
(101, 50),
(102, 51),
(103, 52),
(104, 53),
(105, 54),
(106, 55),
(107, 56),
(108, 57),
(109, 58),
(110, 59),
(111, 60),
(112, 61),
(113, 62),
(114, 63),
(115, 64),
(116, 65),
(117, 66),
(118, 67),
(119, 68),
(120, 69),
(121, 70),
(122, 71),
(123, 72);

-- --------------------------------------------------------

--
-- Table structure for table `co_ordinator`
--

CREATE TABLE `co_ordinator` (
  `_id` int(10) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `phone_no` text COLLATE utf8_unicode_ci NOT NULL,
  `speciality` text COLLATE utf8_unicode_ci NOT NULL,
  `availability` text COLLATE utf8_unicode_ci NOT NULL,
  `camp_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `co_ordinator`
--

INSERT INTO `co_ordinator` (`_id`, `name`, `phone_no`, `speciality`, `availability`, `camp_id`) VALUES
(3, 'Shreyas Angchekar', '996562525', 'Air Force Commander', 'Available', 1),
(4, 'Maaz Khan', '5862345789', 'Naval Commander', 'Unavailable', 1),
(5, 'Danish Shah', '7894561235', 'Road Combat Sargent', 'Available', 1),
(6, 'Rohit Gowda', '5468791325', 'Naval Sargent', 'Available', 1),
(7, 'jawad Shaikh', '4718529653', 'Ship Sailor', 'Available', 1),
(8, 'Risabh Masani', '8527419632', 'ParaGlding Expert', 'Available', 1);

-- --------------------------------------------------------

--
-- Table structure for table `people`
--

CREATE TABLE `people` (
  `_id` int(11) NOT NULL,
  `username` text NOT NULL,
  `phone_no` text NOT NULL,
  `camp_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `people`
--

INSERT INTO `people` (`_id`, `username`, `phone_no`, `camp_id`) VALUES
(1, 'Danish Shah', '8879456127', 1),
(2, 'Maaz Khan', '1825794623', 1),
(3, 'Aditya Mishra', '9029030880', 1),
(4, 'jawad shaikh', '9769876942', 1),
(5, 'Rohit Gowda', '8546971235', 1),
(6, 'Shreyas Angchekar', '88745963214', 1),
(7, 'Drouiand Hyeirn', '85469715236', 1),
(8, 'Aswert Jhets', '965841237', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rescue_camp`
--

CREATE TABLE `rescue_camp` (
  `_id` int(10) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `capacity` text COLLATE utf8_unicode_ci NOT NULL,
  `occupied` text COLLATE utf8_unicode_ci NOT NULL,
  `latitude` double NOT NULL,
  `Longitude` double NOT NULL,
  `services` text COLLATE utf8_unicode_ci NOT NULL,
  `head_name` text COLLATE utf8_unicode_ci NOT NULL,
  `head_phone_no` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rescue_camp`
--

INSERT INTO `rescue_camp` (`_id`, `name`, `capacity`, `occupied`, `latitude`, `Longitude`, `services`, `head_name`, `head_phone_no`, `password`) VALUES
(1, 'Kashmir', '250000', '10000', 33.7782, 76.5762, 'Medical Help,Providing Food PAckets,health Camps,Night Emergency Services,Providing River Boats,Survileance Technology,Snow Clearance,Para-rafting.', 'Yousuf Juned Amre', '9969554856', '123456'),
(2, 'Gangtok', '42500', '28400', 27.3389, 88.6065, 'Providing River Boats,Survileance Technology,Snow Clearance,Para-rafting,Providing Safety,assistance.', 'Aditya Mishra', '9658743215', '123456'),
(3, 'Himachal', '35600', '14200', 31.1048, 77.1734, 'Medical Help,Providing Food PAckets,health Camps,Night Emergency Services,Providing River Boats,Survileance Technology,Snow Clearance,Para-rafting.', 'Shiv Shukla', '9969554889', '123456'),
(4, 'Meghalaya', '36521', '14785', 25.467, 91.3662, 'Providing River Boats,Survileance Technology,Snow Clearance,Para-rafting,Providing Safety,assistance.', 'Aditya Tomar', '9658743245', '123456'),
(5, 'Kerela', '58479', '26400', 10.8505, 76.2711, 'Night Assistance,Air Survileance,Medical Assistance,Providing Food Packets,Rescuing Tenants,Proving Clothing.', 'Afzal Sayyed', '9654781253', '123456'),
(6, 'Amravati', '457890', '25490', 20.9374, 77.7796, 'Night Assistance,Air Survileance,Medical Assistance,Providing Food Packets,Rescuing Children as Priority,Proving Clothing,Helping Through Helcopters.', 'rana navroji Jadhav', '8546793215', '123456'),
(7, 'Nashik', '8520', '2450', 19.9975, 73.7898, 'Medical Help,Safety Assistance,Night Assistance,Night Survilleance,Cops Pertolling,Providing Drinking Water.', 'Nishikant yadav', '854796542', '123456'),
(8, 'Delhi', '254500', '125600', 28.7041, 77.1025, 'Medical Help,Safety Assistance,Night Assistance,Night Survilleance,Cops Pertolling,Providing Drinking Water,Shifting People.', 'narayan Murthi', '8547965847', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `resources`
--

CREATE TABLE `resources` (
  `_id` int(11) NOT NULL,
  `cars` text COLLATE utf8_unicode_ci NOT NULL,
  `ambulance` text COLLATE utf8_unicode_ci NOT NULL,
  `bus` text COLLATE utf8_unicode_ci NOT NULL,
  `airplanes` text COLLATE utf8_unicode_ci NOT NULL,
  `rescuing_capacity` text COLLATE utf8_unicode_ci NOT NULL,
  `camp_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `resources`
--

INSERT INTO `resources` (`_id`, `cars`, `ambulance`, `bus`, `airplanes`, `rescuing_capacity`, `camp_id`) VALUES
(1, '22', '14', '8', '4', '25000', 4),
(2, '54', '25', '15', '12', '58400', 8),
(3, '29', '13', '8', '2', '17000', 3),
(4, '32', '12', '3', '5', '18900', 1),
(5, '45', '16', '20', '14', '58900', 6),
(6, '27', '18', '12', '8', '32800', 7),
(7, '36', '12', '15', '10', '45200', 2),
(8, '34', '14', '12', '9', '458700', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `_id` int(10) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `phone_no` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`_id`, `name`, `phone_no`, `password`) VALUES
(1, 'Ramesh Suresh mane', '4578632165', 'Ramesh'),
(27, 'Maaz khan', '9870740978', 'qwerty'),
(26, 'Danish Shah', '8828496830', '12345'),
(25, 'Jawad Shaikh', '8898616326', 'qwerty'),
(24, 'Maaz Khan', '9870740978', 'qwertty'),
(22, '', '', ''),
(20, 'nikant rana', '89734526', '23456'),
(23, 'Aditya', '93817481751', '13579'),
(18, 'Danish Shah', '8828496830', '12345'),
(17, 'Danish Shah', '8828496830', '12345'),
(16, 'Danish Shah', '8828496830', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alert`
--
ALTER TABLE `alert`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `alert_count`
--
ALTER TABLE `alert_count`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `co_ordinator`
--
ALTER TABLE `co_ordinator`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `rescue_camp`
--
ALTER TABLE `rescue_camp`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `resources`
--
ALTER TABLE `resources`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alert`
--
ALTER TABLE `alert`
  MODIFY `_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
--
-- AUTO_INCREMENT for table `alert_count`
--
ALTER TABLE `alert_count`
  MODIFY `_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;
--
-- AUTO_INCREMENT for table `co_ordinator`
--
ALTER TABLE `co_ordinator`
  MODIFY `_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `people`
--
ALTER TABLE `people`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `rescue_camp`
--
ALTER TABLE `rescue_camp`
  MODIFY `_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `resources`
--
ALTER TABLE `resources`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
