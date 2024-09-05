CREATE database TIENDA_ELECTROSHOP;
USE TIENDA_ELECTROSHOP;

CREATE TABLE categorias_producto (
  id_categoria_producto INT AUTO_INCREMENT,
  nombre_producto VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_categoria_producto)
);

CREATE TABLE productos (
  id_producto INT AUTO_INCREMENT,
  nom_producto VARCHAR(255) NOT NULL,
  precio_producto BIGINT NOT NULL,
  id_categoria INT NOT NULL,
  PRIMARY KEY (id_producto),
  FOREIGN KEY (id_categoria) REFERENCES categorias_producto(id_categoria_producto)
);

CREATE TABLE inventarios (
  id_stock INT AUTO_INCREMENT,
  id_producto INT NOT NULL,
  cantidad_stock INT NOT NULL,
  PRIMARY KEY (id_stock),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE clientes (
  id_cliente VARCHAR(255) NOT NULL,
  nom_cliente VARCHAR(50) NOT NULL,
  edad_cliente INT,
  direccion VARCHAR(255),
  PRIMARY KEY (id_cliente)
);

CREATE TABLE metodos_pago (
  id_met_pago INT AUTO_INCREMENT,
  nom_metodo_pago VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_met_pago)
);

CREATE TABLE pedidos (
  id_pedido INT AUTO_INCREMENT,
  id_cliente VARCHAR(255) NOT NULL,
  id_met_pago INT,
  valor_total BIGINT,
  PRIMARY KEY (id_pedido),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  FOREIGN KEY (id_met_pago) REFERENCES metodos_pago(id_met_pago)
);

CREATE TABLE detalles_pedido (
  id_pedido INT,
  id_producto INT,
  cantidad_producto_pedido INT,
  PRIMARY KEY (id_pedido, id_producto),
  FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Celulares");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Computadores");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Televisores");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Electrodomesticos");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Electrohogar");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Accsesorios");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Videojuegos");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Smartwatch");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Audio");
INSERT INTO tienda_electroshop.categorias_producto VALUES(NULL, "Casa Inteligente");

INSERT INTO tienda_electroshop.productos VALUES (NULL, "Celular REDMI Note 13 Pro", 999900, 1);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Portátil ASUS Vivobook 16", 4299000, 2);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Tv Samsung 60", 1999900, 3);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Nevera Samsung No Frost", 1999900, 4);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Raclette KALLEY", 199900, 5);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Cargador APPLE MagSafe", 219000, 6);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Xbox series S", 1699900, 7);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Banda Galaxy Smart BandFit3", 269900, 8);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Parlante BOSE SoundLink Flex Negro", 549900, 9);
INSERT INTO tienda_electroshop.productos VALUES (NULL, "Parlante AMAZON Echo POP Negro", 199900, 10);

INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 1, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 2, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 3, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 4, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 5, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 6, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 7, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 8, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 9, 1000000);
INSERT INTO tienda_electroshop.inventarios VALUES (NULL, 10, 1000000);

INSERT INTO tienda_electroshop.clientes VALUES ("1234567891", "Jhon", 24, "Calle 1");
INSERT INTO tienda_electroshop.clientes VALUES ("1234597891", "Kevin", 19, "Calle 2");
INSERT INTO tienda_electroshop.clientes VALUES ("1234587891", "David", 20, "Calle 3");
INSERT INTO tienda_electroshop.clientes VALUES ("1234557891", "Felipe", 23, "Calle 145");
INSERT INTO tienda_electroshop.clientes VALUES ("1234577891", "Andres", 18, "Calle 13");
INSERT INTO tienda_electroshop.clientes VALUES ("1274567891", "Alberto", 17, "Calle 56");
INSERT INTO tienda_electroshop.clientes VALUES ("1234547891", "Juan", 25, "Calle 67");
INSERT INTO tienda_electroshop.clientes VALUES ("1234537891", "Johan", 23, "Calle 41");
INSERT INTO tienda_electroshop.clientes VALUES ("1234527891", "Juliana", 24, "Calle 87");
INSERT INTO tienda_electroshop.clientes VALUES ("1234517891", "Nicole", 22, "Calle 11");

INSERT INTO tienda_electroshop.metodos_pago VALUES (NULL, "Debito");
INSERT INTO tienda_electroshop.metodos_pago VALUES (NULL, "Credito");
INSERT INTO tienda_electroshop.metodos_pago VALUES (NULL, "Effecty");

INSERT INTO tienda_electroshop.pedidos VALUES (NULL, "1234597891", 1, 3656545);
INSERT INTO tienda_electroshop.pedidos VALUES (NULL, "1234577891", 2, 2758412);
INSERT INTO tienda_electroshop.pedidos VALUES (NULL, "1234587891", 3, 3140543);
INSERT INTO tienda_electroshop.pedidos VALUES (NULL, "1234537891", 1, 1257687);

INSERT INTO tienda_electroshop.detalles_pedido VALUES(1, 3, 3);
INSERT INTO tienda_electroshop.detalles_pedido VALUES(2, 7, 2);
INSERT INTO tienda_electroshop.detalles_pedido VALUES(3, 5, 1);
INSERT INTO tienda_electroshop.detalles_pedido VALUES(4, 1, 2);

select * from tienda_electroshop.detalles_pedido;