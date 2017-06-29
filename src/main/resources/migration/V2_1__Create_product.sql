CREATE TABLE products
(
  id integer NOT NULL,
  tags character varying(255),
  description character varying(255) NOT NULL,
  price double precision NOT NULL,
  product_code character varying(255) NOT NULL,
  product_name character varying(255) NOT NULL,
  release_date timestamp without time zone NOT NULL,
  star_rating integer NOT NULL,
  CONSTRAINT products_pkey PRIMARY KEY (id)
);

  
CREATE SEQUENCE products_seq_gen
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE products_seq_gen
  OWNER TO postgres;
  