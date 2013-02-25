-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 04, 2012 at 10:20 PM
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
-- Table structure for table `jenis_transaksi`
--

CREATE TABLE IF NOT EXISTS `jenis_transaksi` (
  `kode_transaksi` varchar(3) NOT NULL,
  `nama_transaksi` varchar(50) NOT NULL,
  PRIMARY KEY (`kode_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE IF NOT EXISTS `nasabah` (
  `no_rekening` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `nis` varchar(10) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `tanggal_daftar` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `nama_orangtua` varchar(100) NOT NULL,
  `no_kontak` varchar(100) NOT NULL,
  `saldo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`no_rekening`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `kode_transaksi` varchar(3) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `no_rekening` varchar(10) NOT NULL,
  `nominal` decimal(10,2) NOT NULL,
  `tipe` enum('D','K') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kode_transaksi` (`kode_transaksi`),
  KEY `fk_no_rekening` (`no_rekening`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_no_rekening` FOREIGN KEY (`no_rekening`) REFERENCES `nasabah` (`no_rekening`),
  ADD CONSTRAINT `fk_kode_transaksi` FOREIGN KEY (`kode_transaksi`) REFERENCES `jenis_transaksi` (`kode_transaksi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
