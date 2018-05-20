

-- el script se debe de ir ejecutando tabla por tabla
-- sigue las instrucciones que se indican

insert into company(name_company, address, legend, icon ) values
('CAFETERIA BUHOS', 'ORIENTE 9 #234', 'ALIMENTANDO EL FUTURO',NULL);

insert into "role" (role_name) 
values	('ADMINISTRADOR'),
			('CAJERO')


insert into worker(worker_name, last_name, address, phone_number, email, photo, company_id, role_id)
values	('PENELOPE','ARELLANO','ORIZABA COL ZAPATA #224', 2721342343, NULL, NULL, 1, 2),
		('ERICK','MARTINEZ',	'ORIZABA COL OCAMPO #53', 2721239023, NULL, NULL, 1, 1),
		('PEDRO', 'FERNANDEZ', 'COL CENTRO #34',	2729092312,	NULL, NULL, 1, 2);

insert into users (worker_id, nick_name, pass)
values	(1, 'ARE@EMP',	'1234'),
		(2, 'ERI@EMP', 'erick'),
		(3, 'PED@EMP', 'pedro12');


insert into category(kind)
values	('COMIDA RAPIDA'),
		('COMIDA'),
		('BEBIDA'),
		('SNACK'),
		('BREAD');

insert into product (product_name, price_tag, quantity, category_id)
values	('COCA COLA 600ML',	15,	100, 3),
		('COCA COLA 320ML',	10, 75, 3),
		('COCA COLO ZERO 600ML',	15,	65,	3),
		('AGUA MINERAL',	12,	50,	3),
		('PEÑAFIEL',	12,	50,	3),
		('PEÑAFIEL NARANJA',	12,	50, 3),
		('PEÑAFIEL LIMONADA', 12, 50,	3),
		('PEPSI', 13, 100, 3),
		('PEPSI VIDRIO',	15, 50,	3),
		('MANZANITA', 15, 50, 3),
		('CHILAQUILES', 30, NULL, 2),
		('ENCHILADAS',	30,	NULL, 2),
		('TACOS DORADOS', 25, NULL, 2),
		('ENMOLADAS', 30, NULL, 2),
		('HUEVOS FRITOS', 25, NULL, 2),
		('HUEVOS RANCHERO',	25,	NULL, 2),
		('HUEVOS REVUELTOS', 25, NULL, 2),
		('SALSA ROJA HUEVOS', 30, NULL, 2),
		('SALSA VERDE HUEVOS',	30,	NULL, 2),
		('PECHUGA POLLO ASADA',	30,	NULL, 2),
		('BISTECK ASADA', 30, NULL, 2),
		('PECHUGA EMPANIZADA POLLO', 30, NULL, 2),
		('TORTA PECHUGA', 15, NULL, 1),
		('TORTA MILANESA', 17, NULL, 1),
		('SANDWICH', 17, NULL, 1),
		('PAN',	4, NULL, 5),
		('CAFE AMERICANO', 4, NULL, 3),
		('PASTEL CHOCOLATE', 10, NULL, 4),
		('PASTEL LIMON', 10, NULL, 4);

-- más adelante se volverá a esta tabla para cambiar la llave
-- foranéa ticket_id
insert into sale(date_sale, amount, worker_id)
values	('2018-02-15 09:57:20', 130, 1),
		('2018-02-15 10:23:20', 72, 1),
		('2018-02-15 11:24:20',	85, 1),
		('2018-02-15 11:57:20', 39, 1),
		('2018-02-15 12:30:10', 175, 1),
		('2018-02-15 13:23:40', 70, 1),
		('2018-02-15 13:57:20',	60, 1),
		('2018-02-15 14:27:20',	30, 1),
		('2018-02-15 14:57:20',	51, 1),
		('2018-02-15 14:59:20',	50, 1),
		('2018-02-15 15:51:20',	10, 1),
		('2018-02-15 16:23:20',	135, 1),
		('2018-02-15 16:44:20',	45, 1),
		('2018-02-15 16:55:20',	90, 1),
		('2018-02-15 17:31:20',	30, 1),
		('2018-02-15 18:34:20',	119, 1),
		('2018-02-15 18:36:20',	50, 1),
		('2018-02-15 18:56:20',	70, 1),
		('2018-02-16 18:56:20',	107, 3),
		('2018-02-16 18:56:20',	135, 3),
		('2018-02-16 18:56:20',	60, 3);

insert into sale_product(sale_id, product_id, quantity_product, neto)
values	(1,	1,	2,	30),
		(1,	2,	1,	10),
		(1,	12,	3,	90),
		(2,	10,	2,	30),
		(2,	12,	1,	30),
		(2,	6,	1,	12),
		(3,	20,	2,	60),	
		(3,	15,	1,	25),
		(4,	8,	3,	39),
		(5,	3,	1,	15),
		(5,	2,	1,	10),
		(5,	12,	3,	90),
		(5,	18,	2,	60),
		(6,	17,	1,	25),
		(6,	10,	3,	45),
		(7,	11,	2,	60),
		(8,	22,	1,	30),
		(9,	25,	3,	51),
		(10, 13, 2,	50),	
		(11,	29,	1,	10),
		(12,	23,	3,	90),
		(12,	20,	2,	30),
		(12,	1,	1,	15),
		(13,	10,	3,	45),
		(14,	11,	2,	60),
		(14,	22,	1,	30),
		(15,	19,	1,	30),
		(16,	16,	2,	50),
		(16,	19,	1,	30),
		(16,	9,	1,	15),
		(16,	7,	2,	24),
		(17,	2,	2,	20),
		(17,	12,	1,	30),
		(18,	2,	1,	30),
		(18,	3,	1,	15),
		(18,	17,	1,	25),
		(19,	21,	2,	60),
		(19,	25,	1,	17),
		(19,	20,	1,	30),
		(20,	12,	2,	60),
		(20,	3,	1,	15),
		(20,	2,	2,	60),
		(21,	19,	2,	60);

insert into ticket(num_ticket_day, sale_id)
values	(1,	1),
		(2,	2),
		(3,	3),
		(4,	4),
		(5,	5),
		(6,	6),
		(7,	7),
		(8,	8),
		(9,	9),
		(10, 10),
		(11, 11),
		(12, 12),
		(13, 13),
		(14, 14),
		(15, 15),
		(16, 16),
		(17, 17),
		(18, 18),
		(1,	19),
		(2,	20),
		(3,	21);


