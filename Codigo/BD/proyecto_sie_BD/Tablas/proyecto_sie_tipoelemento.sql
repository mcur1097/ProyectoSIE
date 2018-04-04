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
-- Table structure for table `tipoelemento`
--

DROP TABLE IF EXISTS `tipoelemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoelemento` (
  `codigo` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoelemento`
--

LOCK TABLES `tipoelemento` WRITE;
/*!40000 ALTER TABLE `tipoelemento` DISABLE KEYS */;
INSERT INTO `tipoelemento` VALUES (1,'Aire Acondicionado'),(2,'Ambu'),(3,'Amplificador'),(4,'Antena'),(5,'Aparador o Armario'),(6,'Aparatos de Laboratorio'),(7,'Archivador'),(8,'Armario o Closet'),(9,'Atril'),(10,'Audiometro'),(11,'Audiovisuales'),(12,'Bajo'),(13,'Balanza'),(14,'Banco de Entrenamiento'),(15,'Banda Transportadora'),(16,'Bandeja'),(17,'Bascula'),(18,'Base o Soporte'),(19,'Bateria'),(20,'Biblioteca'),(21,'Bicicleta Estatica'),(22,'Biombo'),(23,'Botiquin'),(24,'Cama Para El Cuidado Del Paciente'),(25,'Cámara'),(26,'Cámara de Laboratorio'),(27,'Camilla'),(28,'Camilla Evacuación'),(29,'Caminador'),(30,'Caminadora o Trotadora'),(31,'Cartelera'),(32,'Cartilla'),(33,'Cilindro'),(34,'Clarinete'),(35,'Colchoneta o Almohadilla Deportiva'),(36,'Componente Electronico'),(37,'Compresor'),(38,'Computador'),(39,'Computador Portatil'),(40,'Conga'),(41,'Consola'),(42,'Consola de Luces'),(43,'Cosedora'),(44,'Cpu'),(45,'Cpu Integrada Con Monitor'),(46,'Desfibrilador'),(47,'Division'),(48,'Dominadas y Fondos Para 2 Personas'),(49,'Elemento Didactico'),(50,'Eliptica'),(51,'Equipo de Estudio Fotográfico'),(52,'Escaleras'),(53,'Escaner'),(54,'Escritorio'),(55,'Espirometro'),(56,'Estante'),(57,'Esterilizadores o Autoclaves de Vapor'),(58,'Estetoscopio'),(59,'Exhibidor'),(60,'Extintor'),(61,'Fonendoscopio'),(62,'Fotometro o Luxometro'),(63,'Gabinete'),(64,'Glucometro'),(65,'Grabadora'),(66,'Guaya De Seguridad'),(67,'Guayas'),(68,'Guillotina'),(69,'Guitarra'),(70,'Impresora'),(71,'Inmovilizador'),(72,'Insumos Para Formación Medica'),(73,'Juegos'),(74,'Lampara'),(75,'Maniqui'),(76,'Maniquies Humanos Anatomicos'),(77,'Maquinas y Herramientas'),(78,'Megafono'),(79,'Mesa'),(80,'Mesa de Examen o Procedimiento Clinico'),(81,'Mesa Deportiva'),(82,'Microfono'),(83,'Modem'),(84,'Monitor'),(85,'Monitor de Audio'),(86,'Mouse'),(87,'Mueble'),(88,'Muletas'),(89,'Multifuncional'),(90,'Organeta'),(91,'Orinales de Enfermo Uso General'),(92,'Pantallas de Proyección'),(93,'Papelera'),(94,'Parlante'),(95,'Perforadora'),(96,'Pistola de Pintar'),(97,'Plotter'),(98,'Proyector'),(99,'Radio'),(100,'Red o Malla Deportiva'),(101,'Redoblante'),(102,'Regulador'),(103,'Replicador de Puertos'),(104,'Reproductor de DVD'),(105,'Repuestos Para Computadores y Equipos de Computo'),(106,'Retroproyector'),(107,'Router'),(108,'Sabana'),(109,'Servidor'),(110,'Silla'),(111,'Silla de Ruedas'),(112,'Simulador Para Maquinaria Pesada'),(113,'Sonometro'),(114,'Tabla Digitalizadora'),(115,'Tablero'),(116,'Tablero Borrado en Seco'),(117,'Tablet'),(118,'Tambor'),(119,'Teclado'),(120,'Telefono'),(121,'Televisor'),(122,'Tensiometro'),(123,'Termohigrometro'),(124,'Tijera'),(125,'Unidades de Discos'),(126,'Ventilador'),(127,'Video Beam'),(128,'Videograbadora o Filmadora'),(129,'Vitrina');
/*!40000 ALTER TABLE `tipoelemento` ENABLE KEYS */;
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
