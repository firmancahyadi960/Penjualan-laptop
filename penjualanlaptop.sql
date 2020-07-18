-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2017 at 03:01 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualanlaptop`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `namabarang` varchar(45) DEFAULT NULL,
  `jenisbarang` varchar(45) DEFAULT NULL,
  `hargabeli` double DEFAULT NULL,
  `hargajual` double DEFAULT NULL,
  `stok` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `namabarang`, `jenisbarang`, `hargabeli`, `hargajual`, `stok`) VALUES
(2, 'LENOVO THINKPAD', 'LENOVO', 5000, 10000, '95'),
(3, 'ACER PREDATOR 211', 'ACER', 5000, 10000, '6'),
(4, 'ASUS ROG 211', 'ASUS', 5000, 6000, '7'),
(5, 'asus dtx', 'asus', 5000, 7000, '5'),
(6, 'TOSHIBA GYTX', 'TOSHIBA', 45000000, 50000000, '108');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `id` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `bayar` double DEFAULT NULL,
  `kembalian` double DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id`, `tanggal`, `total`, `bayar`, `kembalian`, `user_id`, `supplier_id`) VALUES
(3, '2017-07-07', 10000, 15000, 15000, 1, 1),
(4, '2017-07-07', 100000, 200000, 200000, 1, 2),
(5, '2017-07-10', 50000, 100000, 100000, 1, 2),
(6, '2017-07-12', 50000, 100000, 100000, 1, 1),
(7, '2017-07-12', 60000, 100000, 100000, 1, 2),
(8, '2017-07-12', 25000, 50000, 50000, 1, 2),
(9, '2017-07-12', 500000, 1000000, 1000000, 1, 1),
(10, '2017-07-12', 4500000000, 10000000000, 10000000000, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `pembelian_item`
--

CREATE TABLE `pembelian_item` (
  `id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pembelian_id` int(11) NOT NULL,
  `barang_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pembelian_item`
--

INSERT INTO `pembelian_item` (`id`, `qty`, `subtotal`, `pembelian_id`, `barang_id`) VALUES
(1, 1, 10000, 3, 2),
(2, 10, 100000, 4, 2),
(3, 5, 50000, 5, 3),
(4, 5, 50000, 6, 2),
(5, 6, 60000, 7, 2),
(6, 5, 25000, 8, 4),
(7, 100, 500000, 9, 2),
(8, 100, 4500000000, 10, 6);

--
-- Triggers `pembelian_item`
--
DELIMITER $$
CREATE TRIGGER `pembelian_item_AFTER_INSERT` AFTER INSERT ON `pembelian_item` FOR EACH ROW BEGIN
 update barang set stok = stok + new.qty 
	where id = new.barang_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `bayar` double DEFAULT NULL,
  `kembalian` double DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `tanggal`, `total`, `bayar`, `kembalian`, `user_id`, `sales_id`) VALUES
(1, '2017-06-20', 10000, 12000, 1800, 1, 1),
(2, '2017-07-02', 10000, 15000, 4800, 1, 1),
(3, '2017-07-02', 40000, 50000, 9200, 1, 1),
(4, '2017-07-02', 50000, 60000, 9000, 1, 1),
(5, '2017-07-02', 10000, 11000, 800, 1, 1),
(6, '2017-07-07', 10000, 15000, 5000, 1, 1),
(7, '2017-07-10', 100000, 2000000, 1900000, 1, 1),
(8, '2017-07-11', 10000, 15000, 5000, 1, 1),
(9, '2017-07-11', 10000, 15000, 5000, 1, 1),
(10, '2017-07-12', 50000, 100000, 50000, 1, 1),
(11, '2017-07-12', 40000, 60000, 20000, 1, 1),
(12, '2017-07-12', 60000, 61000, 1000, 1, 1),
(14, '2017-07-12', 16000, 18000, 2000, 1, 1),
(15, '2017-07-12', 16000, 17000, 1000, 1, 1),
(16, '2017-07-12', 50000000, 100000000, 50000000, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan_item`
--

CREATE TABLE `penjualan_item` (
  `id` int(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `penjualan_id` int(11) NOT NULL,
  `barang_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `penjualan_item`
--

INSERT INTO `penjualan_item` (`id`, `qty`, `subtotal`, `penjualan_id`, `barang_id`) VALUES
(1, 1, 10000, 1, 2),
(2, 1, 10000, 2, 2),
(3, 4, 40000, 3, 2),
(4, 5, 50000, 4, 3),
(5, 1, 10000, 5, 3),
(6, 1, 10000, 6, 2),
(7, 10, 100000, 7, 2),
(8, 1, 10000, 8, 3),
(9, 1, 10000, 9, 3),
(10, 5, 50000, 10, 2),
(11, 4, 40000, 11, 2),
(12, 4, 40000, 12, 2),
(13, 2, 20000, 12, 2),
(14, 1, 10000, 14, 3),
(15, 1, 6000, 14, 4),
(16, 1, 10000, 15, 2),
(17, 1, 6000, 15, 4),
(18, 1, 50000000, 16, 6);

--
-- Triggers `penjualan_item`
--
DELIMITER $$
CREATE TRIGGER `penjualan_item_AFTER_INSERT` AFTER INSERT ON `penjualan_item` FOR EACH ROW BEGIN
    update barang set stok = stok - new.qty 
	where id = new.barang_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `telpon` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `nama`, `alamat`, `telpon`) VALUES
(1, 'RIAN PANGESTU', 'PIJOT', '0000888');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `alamat` text,
  `no_telepon` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `nama`, `alamat`, `no_telepon`) VALUES
(1, ' PT SIDO ', ' AMPENAN', '15017'),
(2, 'PT ABADI', 'SWETA', '08881');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `username`, `password`) VALUES
(1, 'admin', 'admin', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pembelian_supplier1_idx` (`supplier_id`),
  ADD KEY `fk_pembelian_user1_idx` (`user_id`);

--
-- Indexes for table `pembelian_item`
--
ALTER TABLE `pembelian_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pembelian_item_pembelian1_idx` (`pembelian_id`),
  ADD KEY `fk_pembelian_item_barang1_idx` (`barang_id`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_penjualan_user1_idx` (`user_id`),
  ADD KEY `fk_penjualan_sales1_idx` (`sales_id`);

--
-- Indexes for table `penjualan_item`
--
ALTER TABLE `penjualan_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_penjualan_item_penjualan1_idx` (`penjualan_id`),
  ADD KEY `fk_penjualan_item_barang1_idx` (`barang_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `pembelian_item`
--
ALTER TABLE `pembelian_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `penjualan_item`
--
ALTER TABLE `penjualan_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `fk_pembelian_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pembelian_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pembelian_item`
--
ALTER TABLE `pembelian_item`
  ADD CONSTRAINT `fk_pembelian_item_barang1` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pembelian_item_pembelian1` FOREIGN KEY (`pembelian_id`) REFERENCES `pembelian` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `fk_penjualan_sales1` FOREIGN KEY (`sales_id`) REFERENCES `sales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_penjualan_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `penjualan_item`
--
ALTER TABLE `penjualan_item`
  ADD CONSTRAINT `fk_penjualan_item_barang1` FOREIGN KEY (`barang_id`) REFERENCES `barang` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_penjualan_item_penjualan1` FOREIGN KEY (`penjualan_id`) REFERENCES `penjualan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
