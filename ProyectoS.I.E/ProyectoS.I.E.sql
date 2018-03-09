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
DROP TABLE IF EXISTS `tomaFisica`;

CREATE TABLE `usuarios` (
  `estado` boolean DEFAULT true,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `documento` varchar(12) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

CREATE TABLE `bien`(
`placa` varchar(10) NOT NULL,
 `documento` varchar(12) NOT NULL,
  `serial` varchar(25) NOT NULL,
  `nombreBien` varchar(100) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `valor` double NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `fechaBien` date NOT NULL,
  PRIMARY KEY (`placa`),
  FOREIGN KEY (`documento`) references `usuarios`(`documento`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
CREATE TABLE `area`(
`numeroArea` varchar(10) NOT NULL,
`areaActual` varchar(10) NOT NULL,
`placa` varchar(10) NOT NULL,
 `nombreArea` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`numeroArea`),
  FOREIGN KEY (`placa`) references `bien`(`placa`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
  CREATE TABLE `tomaFisica`(
`numeroToma` varchar(10) NOT NULL,
`numeroArea` varchar(10) NOT NULL,
`observacion` varchar(50) NOT NULL,
 `fechaToma` datetime DEFAULT NULL,
  PRIMARY KEY (`numeroToma`),
  FOREIGN KEY (`numeroArea`) references `area`(`numeroArea`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  

insert  into `usuarios`(`nombre`,`apellidos`,`documento`,`telefono`,`email`) 
values ('Luis','Espitia','1007361141','3142331617','luchotaku8@gmail.com'),
('Sergio','Lozada','123456789','3225698541','sergioLo12@gmail.com'),
('Daniel','Cardona','985632474','3147856921','daniCardona@gmail.com'),
('Gian','Martinez','457821456','3165479632','giankMartinez@gmail.com'),
('Jorge','Mendez','932568790','3172721184','Jorge21@gmail.com');

insert  into `bien`(`placa`,`documento`,`serial`,`nombreBien`,`modelo`,`marca`,`valor`,`estado`,`fechaBien`) 
values ('54651','1007361141','zrd12','mesa','oficina','mdf',1200000,'bien','2000-02-18'),
('12344','123456789','kdm34','computador','2016','hp',12000000,'le falta una tecla','2000-04-21'),
('74635','985632474','ler21','tv','Smart','sony',1000000,'bien','2000-03-18'),
('98567','457821456','jh657','torre computador','2012','thinkCentre',800000,'bien','2000-05-18'),
('87656','932568790','xzs21','papelera','metalic','corona',50000,'bien','2000-12-11'),
('98456','1007361141','pl902','mouse','gamer','j&r',80000,'bien','2000-07-13'),
('19570','123456789','lxq54','silla','escritorio','mdf',250000,'bien','2000-10-04'),
('03747','985632474','win76','tv','2017','simpli',1800000,'bien','2000-11-28'),
('17456','457821456','zas34','mesa','2010','rh',400000,'bien','2000-02-28'),
('07576','932568790','lol54','parlantes','2015','soundplus',50000,'bien','2000-03-18'),
('48567','1007361141','gfy01','monitor','2016','hp',350000,'bien','2000-09-17'),
('12065','123456789','gat32','mouse','2013','hp',70000,'bien','2000-06-30'),
('19120','985632474','poi34','tv','2016','hp',350000,'bien','2000-02-11'),
('54323','457821456','gf099','monitor','2015','hp',350000,'bien','2000-06-07'),
('03748','932568790','gf07','monitor','2016','hp',350000,'bien','2000-06-12');

insert  into `area`(`numeroArea`,`areaActual`,`placa`,`nombreArea`) 
values ('01','15','54651','gestion empresarial'),
('02','14','12344','ADSI'),
('03','13','74635','gestion documental'),
('04','12','98567','diseño multimedia'),
('05','11','87656','diseño multi'),
('06','10','98456','diseño multime'),
('07','09','19570','diseño'),
('08','08','03747','diseño web'),
('09','0','17456','actividad fisica'),
('10','0','07576','programación de videojuegos'),
('11','0','48567','programación de relojes'),
('12','0','12065','culinaria'),
('13','0','19120','mercadeo'),
('14','0','54323','logistica'),
('15','0','03748','programación de video');

insert  into `tomaFisica`(`numeroToma`,`numeroArea`,`observacion`,`fechaToma`) 
values ('1','01','todo en orden','2018-05-23 12:40:25'),
('2','02','3 bienes faltantes','2018-02-20 03:40:50'),
('3','03','7 bienes en mal estado','2018-03-01 02:19:55'),
('4','04','todo en orden','2018-04-10 02:40:05'),
('5','05','1 bien en mal estado','2017-10-20 03:10:05'),
('6','06','1 bien perdido','2018-05-21 5:50:05'),
('7','07','todo en orden','2018-12-25 10:15:34'),
('8','08','3 bien perdido','2018-10-11 06:16:55'),
('9','09','1 bien perdido','2018-04-29 01:59:10'),
('10','10','2 bienes en mal estado','2018-03-01 02:10:05'),
('11','11','todo en orden','2018-04-10 02:40:05'),
('12','12','1 bien en mal estado','2017-10-20 03:10:05'),
('13','13','1 bien perdido','2018-05-21 5:50:05'),
('14','14','todo en orden','2018-12-25 10:15:34'),
('15','15','1 bien perdido','2018-01-01 08:21:56');

select proyecto.bien.nombreBien, proyecto.bien.placa, proyecto.usuarios.nombre from usuarios,bien where proyecto.usuarios.documento=proyecto.bien.documento;

select * from usuarios;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.numeroArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.tomaFisica.fechaToma as FechaToma, proyecto.usuarios.nombre as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, tomaFisica where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.placa=proyecto.area.placa and proyecto.area.numeroArea=proyecto.tomaFisica.numeroArea and proyecto.area.numeroArea=proyecto.area.areaActual order by proyecto.area.numeroArea;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.numeroArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.tomaFisica.fechaToma as FechaToma, proyecto.usuarios.nombre as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, tomaFisica where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.placa=proyecto.area.placa and proyecto.area.numeroArea=proyecto.tomaFisica.numeroArea and proyecto.area.areaActual=0 order by proyecto.area.numeroArea;

select proyecto.bien.placa as Placa, proyecto.bien.serial as Serial, proyecto.bien.nombreBien as NombreBien, 
proyecto.area.numeroArea as AreaAsignada, proyecto.area.areaActual as AreaActual, 
proyecto.tomaFisica.fechaToma as FechaToma, proyecto.usuarios.nombre as NombreFuncionario, proyecto.usuarios.documento as DocumentoFuncionario
from usuarios, bien, area, tomaFisica where proyecto.usuarios.documento=proyecto.bien.documento and
proyecto.bien.placa=proyecto.area.placa and proyecto.area.numeroArea=proyecto.tomaFisica.numeroArea and proyecto.area.areaActual!=0 and 
proyecto.area.areaActual!=proyecto.area.numeroArea order by proyecto.area.numeroArea;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
