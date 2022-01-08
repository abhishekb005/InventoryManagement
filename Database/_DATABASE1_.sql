-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2019 at 08:06 PM
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
  `purchasePrice` int(11) NOT NULL,
  `salePrice` decimal(8,2) NOT NULL,
  `productQty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `purchasePrice`, `salePrice`, `productQty`) VALUES
(101, 'Maggie', 15, '25.00', 80),
(102, 'DEO Men', 200, '300.00', 50),
(103, 'Coca Cola', 25, '30.00', 58),
(104, 'Books', 50, '75.00', 100),
(105, 'Pen', 6, '10.00', 78),
(106, 'Bag', 1000, '2000.00', 50),
(107, 'shoes', 1500, '4000.00', 28),
(108, 'Laptop', 25000, '35000.00', 60),
(109, 'Pencil', 3, '5.00', 100),
(110, 'Chocolate', 10, '20.00', 55),
(111, 'Fevicol', 5, '10.00', 150),
(112, 'Sheet', 7, '15.00', 30),
(113, 'Copy', 25, '35.00', 200),
(114, 'Water Bottle', 100, '150.00', 45),
(115, 'Speaker', 500, '550.00', 30);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `productId1` int(11) NOT NULL,
  `saleId` int(11) NOT NULL,
  `saleQty` double DEFAULT NULL,
  `Price` decimal(8,2) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`productId1`, `saleId`, `saleQty`, `Price`, `date`) VALUES
(101, 1, 20, '25.00', '2019-07-04'),
(102, 2, 10, '300.00', '2019-07-04'),
(104, 3, 10, '75.00', '2019-07-04'),
(106, 6, 20, '2200.00', '2019-07-04'),
(105, 5, 122, '10.00', '2019-07-04'),
(108, 8, -50, '50000.00', '2019-07-07'),
(107, 7, 22, '4000.00', '2019-07-04'),
(109, 9, 50, '5.00', '2019-07-06'),
(110, 10, 5, '20.00', '2019-07-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`),
  ADD KEY `productId` (`productId`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD KEY `sale_ibfk_1` (`productId1`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `fk_productId1` FOREIGN KEY (`productId1`) REFERENCES `product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`productId1`) REFERENCES `product` (`productId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
