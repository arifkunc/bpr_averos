-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 20, 2013 at 01:09 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `bpa_aktivitas_user`
--

CREATE TABLE IF NOT EXISTS `bpa_aktivitas_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `waktu` datetime NOT NULL,
  `username` varchar(20) NOT NULL,
  `aktivitas` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_username2` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bpa_jenis_transaksi`
--

CREATE TABLE IF NOT EXISTS `bpa_jenis_transaksi` (
  `kode_transaksi` varchar(3) NOT NULL,
  `nama_transaksi` varchar(50) NOT NULL,
  `debit_kredit` enum('D','K') NOT NULL,
  PRIMARY KEY (`kode_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bpa_nasabah`
--

CREATE TABLE IF NOT EXISTS `bpa_nasabah` (
  `no_rekening` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `gender` enum('L','P') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nama_orangtua` varchar(100) NOT NULL,
  `telepon` varchar(100) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `tgl_daftar` date NOT NULL,
  `ket` text,
  PRIMARY KEY (`no_rekening`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bpa_transaksi`
--

CREATE TABLE IF NOT EXISTS `bpa_transaksi` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `kode_transaksi` varchar(3) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `no_rekening` varchar(10) NOT NULL,
  `nominal` decimal(10,2) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kode_transaksi` (`kode_transaksi`),
  KEY `fk_no_rekening` (`no_rekening`),
  KEY `fk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bpa_user`
--

CREATE TABLE IF NOT EXISTS `bpa_user` (
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `GROUP_ID` varchar(3) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  KEY `fk_group` (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bpa_user_group`
--

CREATE TABLE IF NOT EXISTS `bpa_user_group` (
  `ID` varchar(3) NOT NULL,
  `GROUP_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bpa_aktivitas_user`
--
ALTER TABLE `bpa_aktivitas_user`
  ADD CONSTRAINT `fk_username2` FOREIGN KEY (`username`) REFERENCES `bpa_user` (`username`);

--
-- Constraints for table `bpa_transaksi`
--
ALTER TABLE `bpa_transaksi`
  ADD CONSTRAINT `fk_kode_transaksi` FOREIGN KEY (`kode_transaksi`) REFERENCES `bpa_jenis_transaksi` (`kode_transaksi`),
  ADD CONSTRAINT `fk_no_rekening` FOREIGN KEY (`no_rekening`) REFERENCES `bpa_nasabah` (`no_rekening`),
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `bpa_user` (`username`);

--
-- Constraints for table `bpa_user`
--
ALTER TABLE `bpa_user`
  ADD CONSTRAINT `fk_group` FOREIGN KEY (`group_id`) REFERENCES `bpa_user_group` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
