-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2013 at 01:10 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bpr_averos`
--

--
-- Dumping data for table `bpa_user_group`
--

INSERT INTO `bpa_user_group` (`ID`, `GROUP_NAME`) VALUES
('111', 'Super Admin'),
('222', 'Teller');


--
-- Dumping data for table `bpa_user`
--

INSERT INTO `bpa_user` (`USERNAME`, `PASSWORD`, `GROUP_ID`) VALUES
('superadmin', '17c4520f6cfd1ab53d8745e84681eb49', '111'),
('teller', '8482dfb1bca15b503101eb438f52deed', '222');



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
