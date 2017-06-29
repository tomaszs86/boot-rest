CREATE TABLE locations
(
  id integer NOT NULL,
  address character varying(255) NOT NULL,
  city character varying(255) NOT NULL,
  country character varying(255) NOT NULL,
  CONSTRAINT locations_pkey PRIMARY KEY (id)
);

