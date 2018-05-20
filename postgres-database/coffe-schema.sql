/* apply normalization to the tables */

-- 					/**	relational model	**/
--		company ( company_id, name_company, address, legend, icon );
--		worker( worker_id, name, last_name, address, phone_number, email, photo, company_id, role_id , nick_name )
--		role ( role_id, role_name );
--		users ( nick_name, key, worker_id );
--		product ( product_id, product_name, price_tag, quantity, category_id, image);
--		category ( category_id, kind )
--		sale ( sale_id, date_sale, amount, nick_name, ticket_id );
--		sale_product ( sale_id, product_id, quantity_product, neto );  
--		ticket ( ticket_id, num_ticket_day, sale_id );


--					/**	script to create database	**/

-- name of database create database coffe-ito;
-- use
CREATE SEQUENCE company_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE company(
	company_id integer DEFAULT nextval('company_id_seq'::regclass) NOT NULL,
	name_company character varying(30) NOT NULL CONSTRAINT cu_name_company UNIQUE,
	address character varying(40),	
	legend character varying(70),
	icon character varying(50)		
);

CREATE SEQUENCE worker_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE worker(
	worker_id integer DEFAULT nextval('worker_id_seq'::regclass) NOT NULL,
	worker_name character varying(20) NOT NULL,
	last_name character varying(15),
	address character varying(40),
	phone_number character varying(10),
	email character varying(25) CONSTRAINT cu_email UNIQUE,
	photo character varying(100),
	company_id integer,
	role_id integer
);


CREATE SEQUENCE role_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE role(
	role_id integer DEFAULT nextval('role_id_seq'::regclass) NOT NULL,
	role_name character varying(20) CONSTRAINT cu_role_name UNIQUE
);



CREATE TABLE users(
	worker_id integer NOT NULL,
	nick_name character varying(10) NOT NULL CONSTRAINT cu_name UNIQUE,
	pass character varying(15) NOT NULL
);

CREATE SEQUENCE product_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE product(
	product_id integer DEFAULT nextval('product_id_seq'::regclass) NOT NULL,
	product_name character varying(40) CONSTRAINT cu_product_name UNIQUE,
	price_tag numeric(9,2),
	quantity integer check (quantity >=0),
	image character varying(100),
	category_id integer
);

CREATE SEQUENCE category_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE category(
	category_id integer DEFAULT nextval('category_id_seq'::regclass) NOT NULL,
	kind character varying(20) CONSTRAINT cu_kind UNIQUE
);


CREATE SEQUENCE sale_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE sale(
	sale_id integer DEFAULT nextval('sale_id_seq'::regclass) NOT NULL,
	worker_id integer NOT NULL,
	date_sale timestamp without time zone DEFAULT now() NOT NULL,
	amount numeric(9,2) check (amount >0)
);

CREATE TABLE sale_product(
	sale_id integer NOT NULL,
	product_id integer NOT NULL,
	quantity_product integer check (quantity_product>0),
	neto numeric(9,2) check (neto > 0)
);
	
CREATE SEQUENCE ticket_id_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE TABLE ticket(
	ticket_id integer DEFAULT nextval('ticket_id_seq'::regclass) NOT NULL CONSTRAINT cu_ticket_id UNIQUE,
	sale_id integer NOT NULL,
	num_ticket_day integer
);


	
--		/**	start adding primary keys to database	**/
ALTER TABLE ONLY company 
	ADD CONSTRAINT pk_company PRIMARY KEY (company_id);
ALTER TABLE ONLY worker 
	ADD CONSTRAINT pk_worker PRIMARY KEY (worker_id);
ALTER TABLE ONLY role	
	ADD CONSTRAINT pk_role PRIMARY KEY (role_id);
ALTER TABLE ONLY users
	ADD CONSTRAINT pk_users PRIMARY KEY (worker_id);
ALTER TABLE ONLY product
	ADD CONSTRAINT pk_product PRIMARY KEY (product_id);
ALTER TABLE ONLY category
	ADD CONSTRAINT pk_category PRIMARY KEY (category_id);
ALTER TABLE ONLY sale
	ADD CONSTRAINT pk_sale PRIMARY KEY (sale_id);
ALTER TABLE ONLY sale_product
	ADD CONSTRAINT pk_sales_product PRIMARY KEY (sale_id, product_id);
ALTER TABLE ONLY ticket 
	ADD CONSTRAINT pk_ticket PRIMARY KEY (sale_id);
--		/**	end adding primary keys to database	**/


--		/**	start adding constraint to database	**/	
ALTER TABLE ONLY worker 
	ADD CONSTRAINT fk_worker_company FOREIGN KEY (company_id) REFERENCES company(company_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY worker 
	ADD CONSTRAINT fk_worker_roles FOREIGN KEY (role_id) REFERENCES role(role_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY users 
	ADD CONSTRAINT fk_user_worker FOREIGN KEY (worker_id) REFERENCES worker(worker_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY product
	ADD CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY sale
	ADD CONSTRAINT fk_sale_users FOREIGN KEY (worker_id) REFERENCES worker(worker_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY sale_product	
	ADD CONSTRAINT fk_sale_product_sale FOREIGN KEY (sale_id) REFERENCES sale(sale_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY sale_product
	ADD CONSTRAINT fk_sale_product_product FOREIGN KEY (product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ONLY ticket
	ADD CONSTRAINT fk_ticket_sale FOREIGN KEY (sale_id) REFERENCES sale(sale_id) ON UPDATE CASCADE ON DELETE CASCADE;
--		/**	end adding constraint to database	**/


-- 		/**	Dictionary of data	**/

alter table product add constraint productQuantity check (quantity>=0);
alter table sale add constraint saleAmount check (amount>0);
alter table sale_product add constraint cons_neto check (neto>0);

-- trigger para actualizar automaticament el catalogo de productos.
create or replace function updateCatalogProduct() returns trigger as $$
declare
	actualQuantityProduct smallint;
begin
	select quantity into strict actualQuantityProduct from product where product_id=NEW.product_id;
	if actualQuantityProduct>=NEW.quantity_product then
		RAISE NOTICE 'Producto actuales %', actualQuantityProduct;
		update product set quantity = (actualQuantityProduct-NEW.quantity_product)
			where product_id=NEW.product_id;
		return new;
	else
		RAISE NOTICE 'Producto actuales insuficientes %', actualQuantityProduct;
		RAISE EXCEPTION 'No cuenta con productos suficientes';
		return null;
	end if;
end;
$$ language plpgsql;

create trigger updateCatalogAfterSale after insert or update on sale_product
for each row execute procedure updateCatalogProduct();
