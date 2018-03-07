CREATE TABLE `perfilUsuario` (
  `documento` int(12) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
   nombre varchar (30) not null,
   correo varchar (30) not null,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert  into `perfilUsuario`(`documento`,`contraseña`, nombre, correo)
values (10345,'santiago','santiago moreno', 'santiagomoreno643@gmail.com'),
(10346,'santi','leidy caranton', 'leidycaranton2000@gmail.com'),
(10347,'moreno','cristian henao','cdhenao@gmail.com');

CREATE TABLE `amb` (
  `numero` int(3) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE bien(
 placa INT(12) NOT NULL,
 serialB VARCHAR(25),
 nombre VARCHAR(45) NOT NULL,
 descripcion VARCHAR(200),
 modelo VARCHAR(45),
 marca VARCHAR(25),
 fecIngreso VARCHAR(25),
 valor VARCHAR(25),
 lugar VARCHAR(25),
 PRIMARY KEY (placa)
);

create table novedadusuarios(
placa int (12) not null,
area varchar (25) not null,
descripcion varchar (200) not null,
fecha date not null,
hora varchar (10) not null,
cedula int (12) not null,
foreign key (cedula) references perfilusuario (documento)
);