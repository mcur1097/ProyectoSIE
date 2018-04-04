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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `idArea` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArea` varchar(50) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'1',''),(2,'2',''),(3,'3',''),(4,'4',''),(5,'5',''),(6,'6',''),(7,'7',''),(8,'8',''),(9,'9',''),(10,'10',''),(11,'11',''),(12,'12',''),(13,'16',''),(14,'17',''),(15,'18',''),(16,'19',''),(17,'20',''),(18,'21',''),(19,'22',''),(20,'23',''),(21,'7934',''),(22,'ambiente apuestas ochoa fuera del centro',''),(23,'Audiovisuales',''),(24,'Auditorio',''),(25,'Biblioteca',''),(26,'Bienestar',''),(27,'Bodega ambiente 12',''),(28,'Bodega auditorio Sandra',''),(29,'bodega cafeteria',''),(30,'Bodega de reintegros',''),(31,'Bodega Reintegro',''),(32,'Centro de cableado',''),(33,'Coliseo',''),(34,'Consumo',''),(35,'Cuentadante',''),(36,'Cuentadante - Sala de instructores',''),(37,'Linea Administracion Edificio',''),(38,'Empleo',''),(39,'Enfermeria',''),(40,'Gestion Educativa',''),(41,'Gimnasio',''),(42,'In House',''),(43,'INEM',''),(44,'LEGO',''),(45,'MESA DE SEREVICIOS',''),(46,'Mesa de servicios',''),(47,'MUSICA',''),(48,'No aparece en miinventario',''),(49,'Oficina Ciceron Botero',''),(50,'Oficina de deportes',''),(51,'Parqueadero interno',''),(52,'Pasillos',''),(53,'paso al inventario de juan guillermo el 9/03/2017 ',''),(54,'Planta energía',''),(55,'Servicio Medico',''),(56,'Proceso de responsabilidades',''),(57,'Punto vive digital centenario',''),(58,'Reintegro',''),(59,'Responsabilidad',''),(60,'Sala de instructores',''),(61,'Sala de Instructores Turismo',''),(62,'Salud',''),(63,'Taller',''),(64,'Tercer piso bilinguismo',''),(65,'Turismo ambiente 5',''),(66,'Turismo ambiente 6',''),(67,'PorAsignar',''),(68,'sin ambiente','');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-01 18:48:20
