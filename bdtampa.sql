-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 26-Ago-2020 às 01:58
-- Versão do servidor: 8.0.21
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdtampa`
--
CREATE DATABASE IF NOT EXISTS `bdtampa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `bdtampa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcollection`
--

DROP TABLE IF EXISTS `tbcollection`;
CREATE TABLE IF NOT EXISTS `tbcollection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `year` int NOT NULL,
  `volume` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tbcollection`
--

INSERT INTO `tbcollection` (`id`, `name`, `brand`, `manufacturer`, `year`, `volume`) VALUES
(1, 'asdasd', 'asdasdasd', 'asdasd', 111, 111),
(3, 'pipipipi', 'popopo', 'dadada', 123, 123);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbusers`
--

DROP TABLE IF EXISTS `tbusers`;
CREATE TABLE IF NOT EXISTS `tbusers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `login` varchar(100) NOT NULL,
  `pass` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tbusers`
--

INSERT INTO `tbusers` (`id`, `name`, `login`, `pass`) VALUES
(1, 'pau', 'pau', 'pau'),
(2, 'asd', 'aa', 'aaaa'),
(3, 'asdasd', 'asdasdasd', 'asdasdasd'),
(4, 'pedro costa', 'ponei', 'abc123'),
(6, 'adsada', 'aaaaaaaa', 'teste');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
