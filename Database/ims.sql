-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2019 at 08:01 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productId` int(11) NOT NULL,
  `productName` varchar(30) NOT NULL,
  `productPrice` int(11) NOT NULL,
  `salePrice` decimal(8,2) NOT NULL,
  `productQty` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `productPrice`, `salePrice`, `productQty`) VALUES
(102, 'DEO Men', 200, '300.00', 30),
(103, 'Coca Cola', 25, '30.00', 58),
(104, 'Books', 50, '75.00', 40),
(105, 'Pen', 6, '10.00', 70),
(106, 'Bag', 1000, '2000.00', 20),
(107, 'Bottle', 150, '250.00', 90);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `productId1` int(11) NOT NULL,
  `SaleId` int(11) NOT NULL,
  `SaleQty` double NOT NULL,
  `Price` decimal(8,2) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`productId1`, `SaleId`, `SaleQty`, `Price`, `date`) VALUES
(101, 1, 10, '25.00', '2019-07-05'),
(102, 2, 20, '500.00', '2019-07-04'),
(103, 1, 20, '10.00', '2019-07-04'),
(104, 4, 60, '200.00', '2019-07-04'),
(105, 5, 50, '2500.00', '2019-07-05'),
(106, 6, 30, '3000.00', '2019-07-04'),
(107, 7, 10, '250.00', '2019-07-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD KEY `fk_productId1` (`productId1`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
