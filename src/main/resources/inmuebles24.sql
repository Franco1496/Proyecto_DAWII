/*CREACION BASE DE DATOS -- ACTUALIZACION FINAL */
CREATE DATABASE BD_DAWII_INMUEBLES24;

USE BD_DAWII_INMUEBLES24;

/*CREACION TABLAS*/
-- Tabla de asesores
create table if not exists tb_asesor (
  id_asesor int auto_increment primary key not null,
  nom_asesor varchar(100),
  ape_asesor varchar(100),
  tel_asesor varchar(20),
  correo_asesor varchar(100),
  pass_asesor varchar(255), -- Trabajar con Spring Security
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla propiedades
create table if not exists tb_propiedad (
  id_propiedad int auto_increment primary key not null,
  dir_propiedad varchar(100),
  id_ubigeo int, -- foreign key
  id_tipo_propiedad int, -- foreign key
  cant_habitaciones int,
  cant_banhos int,
  area_total int,
  id_unidad_medida int, -- foreign key
  precio_venta decimal(10,2),
  disponible_venta boolean,
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla tipo propiedades
create table if not exists tb_tipo_propiedad (
  id_tipo_propiedad int auto_increment primary key not null,
  tipo_propiedad varchar(50), -- Casas, Apartamentos, Terrenos, Oficinas, Comerciales, Bodegas, Edificios, Rurales, Industriales
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla unidad medida
create table if not exists tb_unidad_medida (
  id_unidad_medida int auto_increment primary key not null,
  unidad_medida varchar(50), -- Metro cuadrado	m²	1 m², Decímetro cuadrado	dm²	0.01 m², Centímetro cuadrado	cm²	0.0001 m², Milímetro cuadrado	mm²	0.000001 m²
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla ubigeo
create table if not exists tb_ubigeo (
  id_ubigeo int auto_increment primary key not null,
  ubigeo varchar(6),
  cod_departamento varchar(2),
  departamento varchar(30),
  cod_provincia varchar(2),
  provincia varchar(30),
  cod_distrito varchar(2),
  distrito varchar(30),
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla clientes
create table if not exists tb_cliente (
  id_cliente int auto_increment primary key not null,
  documento varchar(11),
  nom_cliente varchar(100),
  ape_cliente varchar(100),
  dir_cliente varchar(100),
  id_ubigeo int, -- foreign key
  tel_cliente varchar(20),
  correo_cliente varchar(100),
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla citas
create table if not exists tb_cita (
  id_cita int auto_increment primary key not null,
  id_propiedad_asesor int, -- foreign key
  id_cliente int, -- foreign key
  fec_cita date,
  hora_cita time,
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla Propiedad Asesor
create table if not exists tb_propiedad_asesor (
  id_propiedad_asesor int auto_increment primary key not null,
  id_propiedad int, -- foreign key
  id_asesor int, -- foreign key
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

-- Tabla Ventas
create table if not exists tb_venta (
  id_venta int auto_increment primary key not null,
  id_propiedad_asesor int, -- foreign key
  id_cliente int, -- foreign key
  monto_venta decimal(10,2),
  fec_creacion timestamp default current_timestamp, -- Genera automaticamente fecha y hora
  flag_estado boolean
);

/* Asignacion de llaves foraneas con restricciones (CONSTRAINT) */
alter table tb_propiedad add constraint FK_000 foreign key (id_ubigeo) REFERENCES tb_ubigeo (id_ubigeo);
alter table tb_propiedad add constraint FK001 foreign key (id_tipo_propiedad) REFERENCES tb_tipo_propiedad (id_tipo_propiedad);
alter table tb_propiedad add constraint FK002 foreign key (id_unidad_medida) REFERENCES tb_unidad_medida (id_unidad_medida);
alter table tb_cliente add constraint FK003 foreign key (id_ubigeo) REFERENCES tb_ubigeo (id_ubigeo);
alter table tb_venta add constraint FK004 foreign key (id_propiedad_asesor) REFERENCES tb_propiedad_asesor (id_propiedad_asesor);
alter table tb_venta add constraint FK005 foreign key (id_cliente) REFERENCES tb_cliente (id_cliente);
alter table tb_cita add constraint FK006 foreign key (id_propiedad_asesor) REFERENCES tb_propiedad_asesor (id_propiedad_asesor);
alter table tb_cita add constraint FK007 foreign key (id_cliente) REFERENCES tb_cliente (id_cliente);
alter table tb_propiedad_asesor add constraint FK008 foreign key (id_asesor) REFERENCES tb_asesor (id_asesor);
alter table tb_propiedad_asesor add constraint FK009 foreign key (id_propiedad) REFERENCES tb_propiedad (id_propiedad);
