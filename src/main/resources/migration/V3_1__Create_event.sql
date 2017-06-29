CREATE TABLE events
(
  id integer NOT NULL,
  date timestamp without time zone NOT NULL,
  image_url character varying(255) NOT NULL,
  name character varying(255) NOT NULL,
  online_url character varying(255),
  price double precision NOT NULL,
  "time" character varying(255) NOT NULL,
  CONSTRAINT events_pkey PRIMARY KEY (id)
);
  
  CREATE SEQUENCE events_seq_gen
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE events_seq_gen
  OWNER TO postgres;