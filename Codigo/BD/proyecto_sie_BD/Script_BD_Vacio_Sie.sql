create database proyecto_sie;
use proyecto_sie;

CREATE TABLE `area` (
  `idArea` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArea` varchar(50) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idArea`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

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

CREATE TABLE `tipoelemento`(
 `codigo` int(3) NOT NULL AUTO_INCREMENT,
 `nombre` varchar(100) DEFAULT NULL,
 PRIMARY KEY (codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bien` (
  `placa` varchar(30) NOT NULL,
  `serialB` varchar(50) DEFAULT NULL,
  `placaPadre` varchar(30) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `fechaIngreso` varchar(15) DEFAULT NULL,
  `valor` double NOT NULL,
  `nombreArea` varchar(50) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  `idArea` int(11) NOT NULL,
  `codigoTipo` int(3) NOT NULL,
  PRIMARY KEY (`placa`),
  FOREIGN KEY (`idArea`) REFERENCES `area` (`idArea`),
  FOREIGN KEY (`codigoTipo`) REFERENCES `tipoelemento` (`codigo`),
  FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bienesperdidos` (
  `idBienPer` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(25) NOT NULL,
  `idAmbAnt` int(11) NOT NULL,
  `idToma` int(11) NOT NULL,
  PRIMARY KEY (`idBienPer`),
  FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  FOREIGN KEY (`idAmbAnt`) REFERENCES `area` (`idArea`),
  FOREIGN KEY (`idToma`) REFERENCES `tomafisica` (`idToma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `historicomovimientos` (
  `idHistorico` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(25) NOT NULL,
  `ambAnt` int(11) NOT NULL,
  `ambAsignado` int(11) NOT NULL,
  `idToma` int(11) NOT NULL,
  PRIMARY KEY (`idHistorico`),
  FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  FOREIGN KEY (`ambAnt`) REFERENCES `area` (`idArea`),
  FOREIGN KEY (`ambAsignado`) REFERENCES `area` (`idArea`),
  FOREIGN KEY (`idToma`) REFERENCES `tomafisica` (`idToma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `novedades` (
  `idNovedad` int(11) NOT NULL AUTO_INCREMENT,
  `placa_Bien` varchar(25) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(10) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  `area` varchar(25) NOT NULL,
  PRIMARY KEY (`idNovedad`),
  FOREIGN KEY (`placa_Bien`) REFERENCES `bien` (`placa`),
  FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tomafisica` (
  `idToma` int(11) NOT NULL AUTO_INCREMENT,
  `fechaToma` datetime NOT NULL,
  `idArea` int(11) NOT NULL,
  `observacion` varchar(50) NOT NULL,
  `documento_User` varchar(12) NOT NULL,
  PRIMARY KEY (`idToma`),
  FOREIGN KEY (`idArea`) REFERENCES `area` (`idArea`),
  FOREIGN KEY (`documento_User`) REFERENCES `usuarios` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lectura` (
  `idArea` int(11) DEFAULT NULL,
  `idBien` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;