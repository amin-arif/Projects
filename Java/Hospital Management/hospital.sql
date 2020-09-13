-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 01:36 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitalmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospitalstaff`
--

CREATE TABLE `hospitalstaff` (
  `StaffId` varchar(8) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Designation` varchar(15) NOT NULL,
  `Salary` double(8,2) NOT NULL,
  `Phone` int(15) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Department` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospitalstaff`
--

INSERT INTO `hospitalstaff` (`StaffId`, `Name`, `Designation`, `Salary`, `Phone`, `Address`, `Department`) VALUES
('a001', 'faruq', 'Admin', 0.00, 0, 'dhaka', ''),
('a004', 'Safiq', 'Admin', 15400.00, 1854692415, 'Rangpur', ''),
('d001', 'Tamim', 'doctor', 14255.00, 14558, 'Dhaka', 'medicine'),
('d002', 'Sakib', 'doctor', 15000.00, 1855, 'Barishal', 'eye'),
('d003', 'farhan', 'doctor', 15000.00, 18558, 'uttara', 'skin'),
('d004', 'mamun', 'doctor', 1500.00, 1855, 'noakhali', 'psychology'),
('d005', 'roky', 'doctor', 14552.00, 1584, 'dhaka', 'dhaka'),
('r001', 'tamanna', 'Receptionist', 0.00, 0, '', ''),
('r002', 'Shohag', 'Receptionist', 14566.00, 158474, 'manikdi', ''),
('r003', 'salman', 'receptionist', 145500.00, 154, 'badda', '');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PId` varchar(6) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Disease` varchar(15) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Age` int(3) NOT NULL,
  `Phone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`PId`, `Name`, `Address`, `Disease`, `Gender`, `Age`, `Phone`) VALUES
('p001', 'Robin', 'Tal tola', 'jondis', 'male', 25, 15899),
('p002', 'hamim', 'rampura', 'cancer', 'male', 13, 1455),
('p003', 'asfaq', 'mirpur', 'fever', 'male', 15, 15),
('p004', 'sadik', 'sonargaon', 'heart attack', 'male', 40, 125),
('p005', 'sobnom', 'kuakata', 'eye problem', 'female', 25, 125);

-- --------------------------------------------------------

--
-- Table structure for table `patientlist`
--

CREATE TABLE `patientlist` (
  `Date` varchar(15) NOT NULL,
  `PId` varchar(11) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Disease` varchar(30) NOT NULL,
  `Appointed_With` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientlist`
--

INSERT INTO `patientlist` (`Date`, `PId`, `Name`, `Disease`, `Appointed_With`) VALUES
('14.12.19', 'p001', 'Robin', 'jondis', ''),
('12.15.17', 'p002', 'hamim', 'cancer', ''),
('12.12.19', 'p003', 'asfaq', 'fever', ''),
('11.04.19', 'p004', 'sadik', 'heart attack', ''),
('11.12.19', 'p005', 'sobnom', 'fever', '');

-- --------------------------------------------------------

--
-- Table structure for table `patientlist1`
--

CREATE TABLE `patientlist1` (
  `Date` varchar(11) NOT NULL,
  `PId` varchar(8) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Disease` varchar(20) NOT NULL,
  `Appointed_With` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientlist1`
--

INSERT INTO `patientlist1` (`Date`, `PId`, `Name`, `Disease`, `Appointed_With`) VALUES
('11.25.19', 'p005', 'sobnom', 'eye problem', 'Sakib');

-- --------------------------------------------------------

--
-- Table structure for table `patientlist2`
--

CREATE TABLE `patientlist2` (
  `Date` varchar(11) NOT NULL,
  `PId` varchar(8) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Disease` varchar(30) NOT NULL,
  `Appointed_With` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientlist2`
--

INSERT INTO `patientlist2` (`Date`, `PId`, `Name`, `Disease`, `Appointed_With`) VALUES
('14.06.19', 'p002', 'hamim', 'cancer', '');

-- --------------------------------------------------------

--
-- Table structure for table `patientlist3`
--

CREATE TABLE `patientlist3` (
  `Date` varchar(11) NOT NULL,
  `PId` varchar(8) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Disease` varchar(30) NOT NULL,
  `Appointed_With` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientlist3`
--

INSERT INTO `patientlist3` (`Date`, `PId`, `Name`, `Disease`, `Appointed_With`) VALUES
('12.14.19', 'p004', 'sadik', 'heart attack', 'Mamun');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` varchar(8) NOT NULL,
  `password` int(10) NOT NULL,
  `status` int(1) NOT NULL,
  `department` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `password`, `status`, `department`) VALUES
('a001', 1234, 0, ''),
('a002', 16164600, 1, ''),
('a003', 16331260, 0, ''),
('a004', 17756921, 0, ''),
('d001', 17996919, 1, 'medicine'),
('d002', 10107301, 1, 'eye'),
('d003', 15770490, 1, 'skin'),
('d004', 12981294, 1, 'psychology'),
('d005', 13576803, 1, 'eye'),
('p004', 18895767, 2, ''),
('r001', 1789, 2, ''),
('r002', 11089596, 2, ''),
('r003', 17243976, 2, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospitalstaff`
--
ALTER TABLE `hospitalstaff`
  ADD PRIMARY KEY (`StaffId`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `patientlist`
--
ALTER TABLE `patientlist`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `patientlist1`
--
ALTER TABLE `patientlist1`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `patientlist2`
--
ALTER TABLE `patientlist2`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `patientlist3`
--
ALTER TABLE `patientlist3`
  ADD PRIMARY KEY (`PId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
