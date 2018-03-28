/*
SQLyog Community v8.71 
MySQL - 5.5.5-10.1.13-MariaDB : Database - proyecto_sie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyecto_sie` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `proyecto_sie`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `idArea` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArea` varchar(30) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `area` */

insert  into `area`(`idArea`,`nombreArea`,`descripcion`) values (1,'Ambiente 10','Ambiente de Sistemas ADSI'),(2,'Ambiente 19','Ambiente Tics ADSI segundo piso'),(3,'Ambiente 18','Ambiente Gestion documental segundo piso');

/*Table structure for table `bien` */

DROP TABLE IF EXISTS `bien`;

CREATE TABLE `bien` (
  `placa` varchar(15) NOT NULL,
  `serialB` varchar(25) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `marca` varchar(25) DEFAULT NULL,
  `valor` double NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fechaIngreso` varchar(25) DEFAULT NULL,
  `tipo` int(3) DEFAULT NULL,
  `idArea` int(11) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  PRIMARY KEY (`placa`),
  KEY `idArea` (`idArea`),
  KEY `documento_User` (`documento_User`),
  CONSTRAINT `bien_ibfk_1` FOREIGN KEY (`idArea`) REFERENCES `area` (`idArea`),
  CONSTRAINT `bien_ibfk_2` FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bien` */

insert  into `bien`(`placa`,`serialB`,`nombre`,`modelo`,`marca`,`valor`,`descripcion`,`fechaIngreso`,`tipo`,`idArea`,`documento_User`) values ('1094899169','22222','usuario','NA','persona',12364,'prueba persona','2018-15-12',1,1,'1094899169'),('123456','4444','Numeros','BA','NA',56632,'Prueba numeros','2015-15-08',2,2,'123456'),('7701235999918','11111','portatil','HC04','Lenovo',1256005,'Pc portatil lenovo negro','2016-08-12',2,1,'1094899169'),('7702004003508','33333','silla','BF06','NA',546335,'Silla de oficina para ambiente','2018-12-12',3,1,'123456');

/*Table structure for table `bienper` */

DROP TABLE IF EXISTS `bienper`;

CREATE TABLE `bienper` (
  `idBienPer` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(12) NOT NULL,
  `idAmbAnt` int(11) NOT NULL,
  `idToma` int(11) NOT NULL,
  PRIMARY KEY (`idBienPer`),
  KEY `placa_Bien` (`placa_Bien`),
  KEY `idAmbAnt` (`idAmbAnt`),
  KEY `idToma` (`idToma`),
  CONSTRAINT `bienper_ibfk_1` FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  CONSTRAINT `bienper_ibfk_2` FOREIGN KEY (`idAmbAnt`) REFERENCES `area` (`idArea`),
  CONSTRAINT `bienper_ibfk_3` FOREIGN KEY (`idToma`) REFERENCES `tomafisica` (`idToma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bienper` */

/*Table structure for table `historicomov` */

DROP TABLE IF EXISTS `historicomov`;

CREATE TABLE `historicomov` (
  `idHistorico` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(12) NOT NULL,
  `ambAnt` int(11) NOT NULL,
  `ambAsignado` int(11) NOT NULL,
  `idToma` int(11) NOT NULL,
  PRIMARY KEY (`idHistorico`),
  KEY `placa_Bien` (`placa_Bien`),
  KEY `ambAnt` (`ambAnt`),
  KEY `ambAsignado` (`ambAsignado`),
  KEY `idToma` (`idToma`),
  CONSTRAINT `historicomov_ibfk_1` FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  CONSTRAINT `historicomov_ibfk_2` FOREIGN KEY (`ambAnt`) REFERENCES `area` (`idArea`),
  CONSTRAINT `historicomov_ibfk_3` FOREIGN KEY (`ambAsignado`) REFERENCES `area` (`idArea`),
  CONSTRAINT `historicomov_ibfk_4` FOREIGN KEY (`idToma`) REFERENCES `tomafisica` (`idToma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `historicomov` */

/*Table structure for table `lectura` */

DROP TABLE IF EXISTS `lectura`;

CREATE TABLE `lectura` (
  `idArea` int(11) DEFAULT NULL,
  `idBien` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lectura` */

insert  into `lectura`(`idArea`,`idBien`) values (1,'123456'),(1,'7701235999918'),(1,'7702004003508'),(1,'7702212605013'),(1,'7591005003446'),(1,'6920729113130'),(3,'1094899169'),(3,'123456'),(3,'7701235999918'),(3,'7702004003508'),(3,'7702212605013'),(3,'7591005003446'),(3,'6920729113130'),(2,'123456'),(2,'1094899169'),(2,'95387189'),(2,'95387179');

/*Table structure for table `novedades` */

DROP TABLE IF EXISTS `novedades`;

CREATE TABLE `novedades` (
  `idNovedad` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(12) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(10) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  `area` varchar(25) NOT NULL,
  PRIMARY KEY (`idNovedad`),
  KEY `placa_Bien` (`placa_Bien`),
  KEY `documento_User` (`documento_User`),
  CONSTRAINT `novedades_ibfk_1` FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  CONSTRAINT `novedades_ibfk_2` FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `novedades` */

/*Table structure for table `tomafisica` */

DROP TABLE IF EXISTS `tomafisica`;

CREATE TABLE `tomafisica` (
  `idToma` int(11) NOT NULL AUTO_INCREMENT,
  `fechaToma` datetime NOT NULL,
  `idArea` int(11) NOT NULL,
  `observacion` varchar(50) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  PRIMARY KEY (`idToma`),
  KEY `idArea` (`idArea`),
  KEY `documento_User` (`documento_User`),
  CONSTRAINT `tomafisica_ibfk_1` FOREIGN KEY (`idArea`) REFERENCES `area` (`idArea`),
  CONSTRAINT `tomafisica_ibfk_2` FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tomafisica` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `documento` varchar(12) NOT NULL,
  `nombreCompleto` varchar(100) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `estado` tinyint(1) DEFAULT '1',
  `tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

insert  into `usuarios`(`documento`,`nombreCompleto`,`telefono`,`email`,`contrasena`,`estado`,`tipo`) values ('1094899169','Cristian David Henao Hoyos','3113841824','cdhenao9@misena.edu.co','123',1,'instructor'),('123456','Pepito Perez','1254636','pepito@gmail.com','321',1,'instructor');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
