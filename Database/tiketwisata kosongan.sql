-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 29, 2021 at 11:55 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiketwisata`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbfeedback`
--

CREATE TABLE `tbfeedback` (
  `username` varchar(20) NOT NULL,
  `Nama_Lengkap` varchar(150) DEFAULT NULL,
  `Kritik_Saran` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tblogin`
--

CREATE TABLE `tblogin` (
  `nama` varchar(150) COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(40) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(16) COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(5) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `tblogin`
--

INSERT INTO `tblogin` (`nama`, `username`, `password`, `status`) VALUES
('Admin', 'admin', 'admin', 'false'),
('user', 'user', 'user', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `tbpengaturan`
--

CREATE TABLE `tbpengaturan` (
  `username` varchar(20) NOT NULL,
  `Nama_Lengkap` varchar(150) DEFAULT NULL,
  `Tanggal_Lahir` varchar(20) DEFAULT NULL,
  `Jenis_Kelamin` varchar(10) DEFAULT NULL,
  `Nomor_Telepon` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbtiket`
--

CREATE TABLE `tbtiket` (
  `id_tiket` varchar(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  `tanggal_tiket` date NOT NULL,
  `jenis_tiket` varchar(40) NOT NULL,
  `lokasi_tiket` varchar(100) NOT NULL,
  `jumlah_tiket` int(11) NOT NULL,
  `jenis_pembayaran` varchar(100) NOT NULL,
  `total_harga` bigint(20) NOT NULL,
  `status_pembayaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbwisata`
--

CREATE TABLE `tbwisata` (
  `No` int(11) NOT NULL,
  `jenisWisata` varchar(50) NOT NULL,
  `namaWisata` varchar(150) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbwisata`
--

INSERT INTO `tbwisata` (`No`, `jenisWisata`, `namaWisata`, `harga`) VALUES
(1, 'Wisata Religi', 'Pura Besakih (Karangasem)', 40000),
(2, 'Wisata Religi', 'Klenteng Ling Li Miao (Denpasar)', 40000),
(3, 'Wisata Religi', 'Pura Paluang (Nusa Penida)', 40000),
(4, 'Wisata Religi', 'Pura Rambut Siwi (Jembrana)', 40000),
(5, 'Wisata Religi', 'Pura Dalem Balingkang (Bangli)', 40000),
(6, 'Wisata Religi', 'Pura Mekah (Buleleng)', 40000),
(7, 'Wisata Religi', 'Pura Catur Lokapala (Karangasem)', 40000),
(8, 'Wisata Religi', 'Pura Ulun Mumbul (Badung)', 40000),
(9, 'Wisata Religi', 'Pura Saraswati (Ubud)', 40000),
(10, 'Wisata Religi', 'Pura Tanah Lot (Tabanan)', 40000),
(11, 'Wisata Pendidikan', 'Bali Zoo Park (Gianyar)', 35000),
(12, 'Wisata Pendidikan', 'Monkey Forest (Ubud)', 35000),
(13, 'Wisata Pendidikan', 'Konservasi Penyu (Denpasar)', 35000),
(14, 'Wisata Pendidikan', 'Garuda Wisnu Kencana (Bali)', 35000),
(15, 'Wisata Pendidikan', 'Bali Treetop Bedugul (Tabanan)', 35000),
(16, 'Wisata Pendidikan', 'Charly’s Chocolate Factory (Karangasem)', 35000),
(17, 'Wisata Pendidikan', 'Bali Safari & Marine Park (Gianyar)', 35000),
(18, 'Wisata Pendidikan', 'Monumen Bajra Sandhi (Denpasar)', 35000),
(19, 'Wisata Pendidikan', 'Dream Museum Zone (Badung)', 35000),
(20, 'Wisata Pendidikan', 'House Of Alaia Studio (Badung)', 35000),
(21, 'Wisata Alam', 'Pantai Pandawa (Badung)', 30000),
(22, 'Wisata Alam', 'Pantai Sanur (Denpasar)', 30000),
(23, 'Wisata Alam', 'Pantai Jimbaran (Badung)', 30000),
(24, 'Wisata Alam', 'Pantai Crystal bay (Nusa Penida)', 30000),
(25, 'Wisata Alam', 'Pantai Soka (Tabanan)', 30000),
(26, 'Wisata Alam', 'Air terjun Leke-leke (Tabanan)', 30000),
(27, 'Wisata Alam', 'Air Terjun Kembar Banyumala(Buleleng)', 30000),
(28, 'Wisata Alam', 'Danau Beratan (Tabanan)', 30000),
(29, 'Wisata Alam', 'Danau Buyan (Buleleng)', 30000),
(30, 'Wisata Alam', 'Danau Batur (Bangli)', 30000),
(31, 'Wisata Alam', 'Baturraden', 30000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbfeedback`
--
ALTER TABLE `tbfeedback`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tblogin`
--
ALTER TABLE `tblogin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbpengaturan`
--
ALTER TABLE `tbpengaturan`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbtiket`
--
ALTER TABLE `tbtiket`
  ADD PRIMARY KEY (`id_tiket`);

--
-- Indexes for table `tbwisata`
--
ALTER TABLE `tbwisata`
  ADD PRIMARY KEY (`No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbwisata`
--
ALTER TABLE `tbwisata`
  MODIFY `No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
