-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 06, 2022 at 08:08 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiendaInformatica`
--

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` varchar(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `existencias` int(5) DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `tipo` varchar(60) NOT NULL,
  `idProveedor` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `existencias`, `precio`, `tipo`, `idProveedor`) VALUES
('p001', 'raton razer MX5', 23, '34.90', 'PERIFERICO', 'pr001'),
('p002', 'MSI GeForce RTX 3060', 12, '429.89', 'TARGETA GRAFICA', 'pr002'),
('p003', 'Tempest K9 RGB teclado gaming', 54, '19.98', 'PERIFERICO', 'pr003'),
('p004', 'Logitech MK470', 34, '45.99', 'PERIFERICO', 'pr004'),
('p005', 'ASUS TUF Gaming Geforce RTX 3070', 7, '679.90', 'TARGETA GRAFICA', 'pr005'),
('p006', 'Samsung T7 SSD 1 TB', 76, '151.00', 'ALMACENAMIENTO', 'pr006');

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` varchar(5) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id`, `nombre`, `direccion`, `telefono`) VALUES
('pr001', 'Razer', 'Calle Leonardo da Vinci, 7', 865372343),
('pr002', 'MSI', 'Calle de Velázquez, 80', 364354876),
('pr003', 'Tempest', 'Calle José Ortega y Gasset, 40', 765935275),
('pr004', 'Logitech', 'Calle La Loma, res.', 476987543),
('pr005', 'Asus', 'Dirección: calle Vitoshko Lale 16', 987678712),
('pr006', 'Samsung', 'Calle La Laja, 1', 999555444);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProveedor_fk` (`idProveedor`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `idProveedor_fk` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
