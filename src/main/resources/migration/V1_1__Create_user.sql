CREATE TABLE users
(
  id integer NOT NULL,
  created timestamp without time zone NOT NULL,
  is_active boolean NOT NULL,
  username character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);


  CREATE SEQUENCE users_seq_gen
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE users_seq_gen
  OWNER TO postgres;