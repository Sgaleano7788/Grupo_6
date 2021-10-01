create database TiendaGenerica;
Use tiendagenerica;
create table clientes(
cedula bigint(20) primary key,
direccion varchar(255),
email varchar(255),
nombre varchar(255),
telefono varchar(255)
);
create table usuarios(
cedula bigint(20) primary key,
email varchar(255),
nombre varchar(255),
password varchar(255) not null,
usuario varchar(255) not null
);
create table proveedores(
nitProveedor bigint(20) primary key,
ciudad varchar(255),
direccion varchar(255),
nombre varchar(255),
telefono varchar(255)
);
create table productos(
codigoProducto bigint(20) auto_increment primary key,
ivaCompra double not null,
nitProveedor bigint(20) not null,
nombre varchar(255) not null,
precioCompra double not null,
precioVenta double not null,
foreign key (nitProveedor) references proveedores(nitProveedor) 
);
create table ventas(
codigoVenta bigint(20) auto_increment primary key,
cedulaCliente bigint(20) not null,
cedulaUsuario bigint(20) not null,
ivaVenta double,
totalVenta double,
valorVenta double,
foreign key (cedulaCliente) references clientes(cedula),
foreign key (cedulaUsuario) references usuarios(cedula)
);
create table detalleVentas(
codigoDetalle bigint(20) auto_increment primary key,
cantidadProducto int(11),
codigoProducto bigint(20),
codigoVenta bigint (20),
valorTotal double,
valorVenta double,
valorIva double,
foreign key (codigoProducto) references productos(codigoProducto),
foreign key (codigoVenta) references ventas(codigoVenta)
);