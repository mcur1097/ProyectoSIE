-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto_sie
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.26-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `historicomovimientos`
--

DROP TABLE IF EXISTS `historicomovimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historicomovimientos` (
  `idHistorico` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(25) NOT NULL,
  `ambAnt` int(11) NOT NULL,
  `ambAsignado` int(11) NOT NULL,
  `idToma` int(11) NOT NULL,
  PRIMARY KEY (`idHistorico`),
  KEY `placa_Bien` (`placa_Bien`),
  KEY `ambAnt` (`ambAnt`),
  KEY `ambAsignado` (`ambAsignado`),
  KEY `idToma` (`idToma`),
  CONSTRAINT `historicomovimientos_ibfk_1` FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  CONSTRAINT `historicomovimientos_ibfk_2` FOREIGN KEY (`ambAnt`) REFERENCES `area` (`idArea`),
  CONSTRAINT `historicomovimientos_ibfk_3` FOREIGN KEY (`ambAsignado`) REFERENCES `area` (`idArea`),
  CONSTRAINT `historicomovimientos_ibfk_4` FOREIGN KEY (`idToma`) REFERENCES `tomafisica` (`idToma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicomovimientos`
--

LOCK TABLES `historicomovimientos` WRITE;
/*!40000 ALTER TABLE `historicomovimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `historicomovimientos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-01 18:48:22
