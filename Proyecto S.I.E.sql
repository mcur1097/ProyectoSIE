/*
SQLyog Community v8.71 
MySQL - 5.5.5-10.1.13-MariaDB : Database - proyecto*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyecto` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `proyecto`;
drop database proyecto;

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;
DROP TABLE IF EXISTS `bien`;
DROP TABLE IF EXISTS `area`;
DROP TABLE IF EXISTS `historial`;

CREATE TABLE `usuarios` (
  `estado` boolean DEFAULT true,
  `nombreCompleto` varchar(100) DEFAULT NULL,
  `documento` varchar(12) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

CREATE TABLE `bien`(
`idBien` int auto_increment NOT NULL,
`placa` varchar(10) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `serial` varchar(25) NOT NULL,
  `nombreBien` varchar(100) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `fechaBien` date NOT NULL,
  PRIMARY KEY (`idBien`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE `area`(
`idArea` varchar(15) NOT NULL,
`idBien` int NOT NULL,
 `nombreArea` varchar(30) DEFAULT NULL,
 `areaActual` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idArea`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
  CREATE TABLE `historial`(
`idToma` int NOT NULL,
`documento` varchar(12) NOT NULL,
`idBien` int auto_increment NOT NULL,
`idArea` varchar(15) NOT NULL,
`observacion` varchar(50) NOT NULL,
 `fechaToma` datetime DEFAULT NULL,
  PRIMARY KEY (`idToma`),
  FOREIGN KEY (`documento`) references `usuarios`(`documento`),
  FOREIGN KEY (`idBien`) references `bien`(`idBien`),
  FOREIGN KEY (`idArea`) references `area`(`idArea`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `usuarios`(`nombreCompleto`,`documento`,`contrasena`,`telefono`,`email`) 
values ('Luis Espitia','1007361141','1007361141','3142331617','luchotaku8@gmail.com'),
('Sergio Lozada','123456789','123456789','3225698541','sergioLo12@gmail.com'),
('Daniel Cardona','985632474','985632474','3147856921','daniCardona@gmail.com'),
('Gian Martinez','457821456','457821456','3165479632','giankMartinez@gmail.com'),
('Jorge Mendez','932568790','932568790','3172721184','Jorge21@gmail.com');

insert  into `bien`(`idBien`,`placa`,`documento`,`serial`,`nombreBien`,`modelo`,`marca`,`valor`,`estado`,`fechaBien`) 
values ('1','54651','1007361141','zrd12','mesa','oficina','mdf',1200000,'bien','2000-02-18'),
('2','12344','123456789','kdm34','computador','2016','hp',12000000,'le falta una tecla','2000-04-21'),
('3','74635','985632474','ler21','tv','Smart','sony',1000000,'bien','2000-03-18'),
('4','98567','457821456','jh657','torre computador','2012','thinkCentre',800000,'bien','2000-05-18'),
('5','87656','932568790','xzs21','papelera','metalic','corona',50000,'bien','2000-12-11'),
('6','98456','1007361141','pl902','mouse','gamer','j&r',80000,'bien','2000-07-13'),
('7','19570','123456789','lxq54','silla','escritorio','mdf',250000,'bien','2000-10-04'),
('8','03747','985632474','win76','tv','2017','simpli',1800000,'bien','2000-11-28'),
('9','17456','457821456','zas34','mesa','2010','rh',400000,'bien','2000-02-28'),
('10','07576','932568790','lol54','parlantes','2015','soundplus',50000,'bien','2000-03-18'),
('11','48567','1007361141','gfy01','monitor','2016','hp',350000,'bien','2000-09-17'),
('12','12065','123456789','gat32','mouse','2013','hp',70000,'bien','2000-06-30'),
('13','19120','985632474','poi34','tv','2016','hp',350000,'bien','2000-02-11'),
('14','54323','457821456','gf099','monitor','2015','hp',350000,'bien','2000-06-07'),
('15','03748','932568790','gf07','monitor','2016','hp',350000,'bien','2000-06-12');

insert  into `area`(`idArea`,`idBien`,`nombreArea`,`areaActual`) 
values ('1','1','Ambiente 1','Ambiente 2'),
('2','2','Ambiente 19','Ambiente 18'),
('3','3','Ambiente 18','Ambiente 10'),
('4','4','Ambiente 17','Ambiente 15'),
('5','5','Ambiente 16','Ambiente 17'),
('6','6','Ambiente 15','Ambiente 12'),
('7','7','Ambiente 14','Ambiente 14'),
('8','8','Ambiente 13','Ambiente 11'),
('9','9','Ambiente 12','0'),
('10','10','Ambiente 11','0'),
('11','11','Ambiente 10','0'),
('12','12','Ambiente 9','0'),
('13','13','Ambiente 3','0'),
('14','14','Ambiente 2','0'),
('15','15','Ambiente 1','0');

insert  into `historial`(`idToma`,`documento`,`idBien`,`idArea`,`observacion`,`fechaToma`) 
values ('1','1007361141','1','15','todo en orden','2018-05-23 12:40:25'),
('2','123456789','2','14','3 bienes faltantes','2018-02-20 03:40:50'),
('3','985632474','3','13','7 bienes en mal estado','2018-03-01 02:19:55'),
('4','457821456','4','12','todo en orden','2018-04-10 02:40:05'),
('5','932568790','5','11','1 bien en mal estado','2017-10-20 03:10:05'),
('6','1007361141','6','10','1 bien perdido','2018-05-21 5:50:05'),
('7','123456789','7','9','todo en orden','2018-12-25 10:15:34'),
('8','985632474','8','8','3 bien perdido','2018-10-11 06:16:55'),
('9','457821456','9','7','1 bien perdido','2018-04-29 01:59:10'),
('10','932568790','10','6','2 bienes en mal estado','2018-03-01 02:10:05'),
('11','1007361141','11','5','todo en orden','2018-04-10 02:40:05'),
('12','123456789','12','4','1 bien en mal estado','2017-10-20 03:10:05'),
('13','985632474','13','3','1 bien perdido','2018-05-21 5:50:05'),
('14','457821456','14','2','todo en orden','2018-12-25 10:15:34'),
('15','932568790','15','1','1 bien perdido','2018-01-01 08:21:56');

select proyecto.bien.nombreBien, proyecto.bien.placa, proyecto.usuarios.nombreCompleto from usuarios,bien where proyecto.usuarios.documento=proyecto.bien.documento and 
proyecto.usuarios.documento=123456789;

select * from area where proyecto.area.idArea='15';

select proyecto.usuarios.nombreCompleto, proyecto.bien.nombreBien, proyecto.bien.placa, 
proyecto.bien.serial, proyecto.bien.valor, proyecto.area.nombreArea from usuarios, bien, area where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.idBien=proyecto.area.idBien order by proyecto.bien.valor;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.nombreArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.historial.fechaToma as FechaToma, proyecto.usuarios.nombreCompleto as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, historial where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.idBien=proyecto.area.idBien and proyecto.area.idArea=proyecto.historial.idArea and proyecto.area.nombreArea=proyecto.area.areaActual order by proyecto.area.nombreArea;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.nombreArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.historial.fechaToma as FechaToma, proyecto.usuarios.nombreCompleto as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, historial where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.idBien=proyecto.area.idBien and proyecto.area.idArea=proyecto.historial.idArea and proyecto.area.areaActual='0' order by proyecto.area.areaActual;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.nombreArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.historial.fechaToma as FechaToma, proyecto.usuarios.nombreCompleto as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, historial where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.idBien=proyecto.area.idBien and proyecto.area.idArea=proyecto.historial.idArea and proyecto.area.areaActual!='0' and proyecto.area.nombreArea!=proyecto.area.areaActual order by proyecto.area.areaActual;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
