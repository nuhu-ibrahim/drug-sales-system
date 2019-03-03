-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2017 at 02:42 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `drugs_sales_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `productID` char(6) NOT NULL,
  `Qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`productID`, `Qty`) VALUES
('PARA12', 0),
('PARA13', 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventorytrack`
--

CREATE TABLE `inventorytrack` (
  `productID` char(6) NOT NULL,
  `Qty` int(11) NOT NULL,
  `QtyIn` int(11) NOT NULL,
  `QtyOut` int(11) NOT NULL,
  `choice` varchar(15) NOT NULL,
  `Reason` varchar(200) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventorytrack`
--

INSERT INTO `inventorytrack` (`productID`, `Qty`, `QtyIn`, `QtyOut`, `choice`, `Reason`, `date`) VALUES
('Para12', 2, 2, 0, 'IN', 'STOCK', '2017-06-08'),
('Para12', 7, 5, 0, 'IN', 'STOCK', '2017-06-08'),
('Para12', 9, 2, 0, 'OUT', 'Spoiled', '2017-06-09'),
('Para12', 7, 2, 0, 'OUT', 'Spoilt', '2017-06-09'),
('Para12', 1, 6, 0, 'OUT', 'Spoilt', '2017-06-09'),
('Para12', 0, 0, 1, 'OUT', 'Spoiled', '2017-06-15'),
('Para12', 12, 12, 0, 'IN', 'STOCK', '2017-06-15'),
('Para12', 10, 0, 2, 'OUT', 'Spoiled', '2017-06-15'),
('Para13', 10, 10, 0, 'IN', 'STOCK', '2017-06-18'),
('PARA12', 9, 0, 1, 'OUT', 'SOLD', '2017-06-18'),
('PARA13', 8, 0, 2, 'OUT', 'SOLD', '2017-06-18'),
('PARA12', 8, 0, 1, 'OUT', 'SOLD', '2017-06-18'),
('PARA12', 7, 0, 1, 'OUT', 'SOLD', '2017-06-18'),
('PARA12', 6, 0, 1, 'OUT', 'SOLD', '2017-06-18'),
('PARA12', 5, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA12', 4, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA12', 3, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA13', 7, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA12', 2, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA13', 6, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA12', 1, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA13', 2, 0, 4, 'OUT', 'SOLD', '2017-06-19'),
('Para12', 0, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA13', 1, 0, 1, 'OUT', 'SOLD', '2017-06-19'),
('PARA13', 0, 0, 1, 'OUT', 'SOLD', '2017-06-19');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` char(6) NOT NULL,
  `productName` varchar(30) NOT NULL,
  `charge` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `productName`, `charge`) VALUES
('PARA12', 'Paracetamol', '120.00'),
('PARA13', 'Panadol', '20.00');

-- --------------------------------------------------------

--
-- Table structure for table `salestbl`
--

CREATE TABLE `salestbl` (
  `ID` char(6) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `quantity` varchar(6) DEFAULT NULL,
  `amount` varchar(30) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `custname` varchar(50) NOT NULL,
  `custNumber` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salestbl`
--

INSERT INTO `salestbl` (`ID`, `name`, `quantity`, `amount`, `date`, `type`, `custname`, `custNumber`) VALUES
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-18', 'PRODUCT', 'MUSTAPHA IBRAHIM', '0898989898'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-18', 'SERVICE', 'MUSTAPHA IBRAHIM', '0898989898'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-18', 'PRODUCT', 'NUHU', '2222'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-18', 'PRODUCT', 'NUHU', '224324'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-18', 'SERVICE', 'NUHU', '224324'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-18', 'SERVICE', 'EWSFD', '243'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ABDULLAHI LAWAL', '090909090'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU', '383838'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'FORCAS', '33333'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'NUHU', '222'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'NUHU IBRAHIM', '07061151982'),
('PARA13', 'Panadol', '1', '20.0', '2017-06-19', 'PRODUCT', 'NUHU IBRAHIM', '07061151982'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '07061151982'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'NUHU IB', '080999'),
('PARA13', 'Panadol', '1', '20.0', '2017-06-19', 'PRODUCT', 'NUHU IB', '080999'),
('PARA12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'NUHU ADELODUN', '090898989'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU ADELODUN', '090898989'),
('PARA13', 'Panadol', '4', '80.0', '2017-06-19', 'PRODUCT', 'NUHU ADELODUN', '090898989'),
('Para12', 'Paracetamol', '1', '120.0', '2017-06-19', 'PRODUCT', 'NUHU', '88'),
('PARA13', 'Panadol', '1', '20.0', '2017-06-19', 'PRODUCT', 'NUHU', '88'),
('PARA13', 'Panadol', '1', '20.0', '2017-06-19', 'PRODUCT', 'NUHU IBRAHIM', '08066353'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '08066353'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '08072626262'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '08072626262'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '08072626262'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADELODUN IBRAHIM', '0807777777'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'ADELODUN IBRAHIM', '0807777777'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADELODUN IBRAHIM', '0807777777'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADRJDFNDJ JNFSJDNFJK', '30434333'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'ADRJDFNDJ JNFSJDNFJK', '30434333'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADRJDFNDJ JNFSJDNFJK', '30434333'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'SDFQEDFJWDF KDJSFNDS', '333333'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'SDFQEDFJWDF KDJSFNDS', '333333'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'SDFQEDFJWDF KDJSFNDS', '333333'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'DSKJAFD', '33'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'KKKK', '999'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'KKKKK', '0000'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'DF GFJGYHJ', '3456'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'DF GFJGYHJ', '3456'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HHHHH HHHH', '666'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'GHDYTD YFRY7UR', '6789080'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'GHDYTD YFRY7UR', '6789080'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HJFJF', '660970'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'HJFJF', '660970'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HJJGJH', '989988'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IB', '0908998988'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'NUHU IB', '0908998988'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IB', '0908998988'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'NHJFYTD MJFUV', '6585'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NHJFYTD MJFUV', '6585'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'NHJFYTD MJFUV', '6585'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'GHD BHCFHGDF', '56666'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'GHD BHCFHGDF', '56666'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'GHD BHCFHGDF', '56666'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HJFJ', '66'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'RTDGFG', '333'),
('head12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'FDFCXGDF', '33'),
('head12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'KJJKK', '88'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'KJJKK', '88'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'EWKJRF EWJDFK', '2333'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'EWKJRF EWJDFK', '2333'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU IBRAHIM', '08098787878'),
('head12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NYUH HF', '4860'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NUHU ADELODUN', '07061151982'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'FGJGHJBN FGJGHJ', '35457789'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NBFJERG ASIJBFS', '890909990'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'NBFJERG ASIJBFS', '890909990'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'NBFJERG ASIJBFS', '890909990'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'DHDSBF WEDBFWI', '2923342'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'DHDSBF WEDBFWI', '2923342'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HBDSLFBDWS HHBDFSA', '3827823732'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'HBDSLFBDWS HHBDFSA', '3827823732'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'HBDSLFBDWS HHBDFSA', '3827823732'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'BADSHF HBHBC', '94358532'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'BADSHF HBHBC', '94358532'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'BADSHF HBHBC', '94358532'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADF SBFJCHBDSF', '25743235'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'ADF SBFJCHBDSF', '25743235'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'ADF SBFJCHBDSF', '25743235'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'G DS FDSF', '22432324'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'G DS FDSF', '22432324'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'G DS FDSF', '22432324'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'SWFBWJDSF WJDBSFDWH', '334329234'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'SWFBWJDSF WJDBSFDWH', '334329234'),
('HEAD12', 'Head dressing', '1', '300.0', '2017-06-19', 'SERVICE', 'SWFBWJDSF WJDBSFDWH', '334329234'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'HSBC NJKJDF', '833333'),
('HEAD12', 'Head dressing', '1', '120.0', '2017-06-19', 'SERVICE', 'HSBC NJKJDF', '833333');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `serviceID` char(6) NOT NULL,
  `serviceName` varchar(30) NOT NULL,
  `chargeRegular` decimal(10,2) NOT NULL,
  `chargeHome` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`serviceID`, `serviceName`, `chargeRegular`, `chargeHome`) VALUES
('BETE12', 'Beterment tream', '120.00', '190.00'),
('HEAD12', 'Head dressing', '120.00', '300.00');

-- --------------------------------------------------------

--
-- Table structure for table `tempinventorytbl`
--

CREATE TABLE `tempinventorytbl` (
  `productID` char(6) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tempinventorytbl`
--

INSERT INTO `tempinventorytbl` (`productID`, `qty`) VALUES
('PARA12', 0),
('PARA13', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tempsalestbl`
--

CREATE TABLE `tempsalestbl` (
  `SNo` int(10) UNSIGNED NOT NULL,
  `ID` char(6) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `quantity` varchar(6) DEFAULT NULL,
  `amount` varchar(30) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tempsalestbl`
--

INSERT INTO `tempsalestbl` (`SNo`, `ID`, `name`, `quantity`, `amount`, `date`, `type`) VALUES
(1, 'head12', 'Head dressing', '1', '300.0', '2017-07-30', 'SERVICE');

-- --------------------------------------------------------

--
-- Table structure for table `usertbl`
--

CREATE TABLE `usertbl` (
  `uname` varchar(20) NOT NULL,
  `pword` varchar(20) DEFAULT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `mname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertbl`
--

INSERT INTO `usertbl` (`uname`, `pword`, `fname`, `mname`, `lname`) VALUES
('n', 'n', 'Nuhu', NULL, 'Ibrahim');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD KEY `productID` (`productID`);

--
-- Indexes for table `inventorytrack`
--
ALTER TABLE `inventorytrack`
  ADD KEY `product(productID)` (`productID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`serviceID`);

--
-- Indexes for table `tempsalestbl`
--
ALTER TABLE `tempsalestbl`
  ADD PRIMARY KEY (`SNo`);

--
-- Indexes for table `usertbl`
--
ALTER TABLE `usertbl`
  ADD PRIMARY KEY (`uname`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tempsalestbl`
--
ALTER TABLE `tempsalestbl`
  MODIFY `SNo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
