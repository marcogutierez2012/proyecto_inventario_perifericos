drop database if exists bdpcfast;
create database bdpcfast;

use bdpcfast;

create table tb_rol
(
	id_rol int auto_increment primary key,
    des_rol varchar(20) not null
);

create table tb_usuario
(
	id_usuario int auto_increment primary key,
    nom_usuario varchar(100) not null,
    ape_usuario varchar(100) not null,
    correo_usuario varchar(150) not null,
	tel_usuario varchar(9) not null,
    pass_usuario varchar(100) not null,
    id_rol int,
    foreign key (id_rol) references tb_rol(id_rol)
);

create table tb_tipo_cliente
(
	id_tipo_cliente int auto_increment primary key,
    des_tipo_cliente varchar(50) not null
);

create table tb_cliente
(
	id_cliente int auto_increment primary key,
    nom_cliente varchar(100) not null,
    doc_cliente varchar(11) not null,
    dir_cliente varchar(100) not null,
    tel_cliente varchar(9) not null,
    id_tipo_cliente int,
    foreign key (id_tipo_cliente) references tb_tipo_cliente(id_tipo_cliente)
);

create table tb_tipo_producto
(
	id_tipo_producto int auto_increment primary key,
    des_tipo_producto varchar(50) not null
);

create table tb_producto
(
	id_producto int auto_increment primary key,
	id_tipo_producto int,
    des_producto varchar(100) not null,
    cant_producto int default '0' not null,
    pre_producto decimal(8,2) default '0.00' not null,
    foreign key (id_tipo_producto) references tb_tipo_producto(id_tipo_producto)
);

create table tb_tipo_comprobante
(
	id_tipo_comprobante int auto_increment primary key,
    des_tipo_comprobante varchar(20) not null
);

create table tb_comprobante
(
	id_comprobante int auto_increment primary key,
    id_usuario int,
    id_cliente int,
    fec_comprobante date not null,
    base_comprobante decimal(8,2) not null,
    igv_comprobante decimal(8,2) not null,
    tot_comprobante decimal(8,2) not null,
    foreign key (id_usuario) references tb_usuario(id_usuario),
    foreign key (id_cliente) references tb_cliente(id_cliente)
);

create table tb_detalle_comprobante
(
	id_comprobante int,
    id_producto int,
    cantidad int not null,
    total decimal(8,2) not null,
    foreign key (id_comprobante) references tb_comprobante(id_comprobante),
    foreign key (id_producto) references tb_producto(id_producto),
    primary key (id_comprobante, id_producto)
);

insert into tb_rol(des_rol) values('Administrador'),('Empleado');
insert into tb_tipo_cliente(des_tipo_cliente) values('Persona'),('Empresa'),('Empresa No Lucrativa');
insert into tb_tipo_producto(des_tipo_producto) values('Perifericos'),('Monitores'),('Componentes');
insert into tb_tipo_comprobante(des_tipo_comprobante) values('Boleta'),('Factura');

select * from tb_usuario;
insert into tb_usuario values (null,'Marco','Gutierrez','marcogutierrez@gmail.com','992478429','123456',1);
insert into tb_usuario values (null,'Martin','Gonzales','martingonzales@gmail.com','987654321','123456',2);
insert into tb_usuario values (null,'Jose','Martinez','josegonzales@gmail.com','999123456','123456',2);

select * from tb_producto;
insert into tb_producto values (null,1,'Mouse Gamer',20,30.0);
insert into tb_producto values (null,1,'Audifonos Gamer',25,50.0);
insert into tb_producto values (null,1,'Teclado Gamer',20,70.0);


select * from tb_cliente;
insert into tb_cliente values (null,'Maria Jimenez','78945612','Av. Las Flores 123','987446123',1);
insert into tb_cliente values (null,'Jesus Del Carpio','71245872','Calle los tigres 100','912458953',1);
insert into tb_cliente values (null,'Libreria Alfredyto','20123612451','Av. Los Jardines 123','963124784',2);

select * from tb_rol;
select * from tb_tipo_cliente;
select * from tb_tipo_producto;
select * from tb_tipo_comprobante;



