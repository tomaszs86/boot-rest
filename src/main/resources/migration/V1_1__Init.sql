CREATE TABLE events (
    event_id integer NOT NULL,
    date timestamp without time zone NOT NULL,
    image_url character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    online_url character varying(255),
    price double precision NOT NULL,
    "time" character varying(255) NOT NULL
);

CREATE SEQUENCE events_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE locations (
    event_id integer NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    country character varying(255) NOT NULL
);

CREATE TABLE products (
    product_id integer NOT NULL,
    tags character varying(255),
    description character varying(255) NOT NULL,
    price double precision NOT NULL,
    product_code character varying(255) NOT NULL,
    product_name character varying(255) NOT NULL,
    release_date timestamp without time zone NOT NULL,
    star_rating integer NOT NULL
);

CREATE SEQUENCE products_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE sessions (
    session_id integer NOT NULL,
    abstraction character varying(255) NOT NULL,
    duration double precision NOT NULL,
    level character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    presenter character varying(255) NOT NULL,
    event_id integer NOT NULL
);

CREATE SEQUENCE sessions_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



CREATE TABLE users (
    user_id integer NOT NULL,
    created timestamp without time zone NOT NULL,
    is_active boolean NOT NULL,
    username character varying(255) NOT NULL
);


CREATE SEQUENCE users_seq_gen
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ONLY events
    ADD CONSTRAINT events_pkey PRIMARY KEY (event_id);


ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (event_id);

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);

ALTER TABLE ONLY schema_version
    ADD CONSTRAINT schema_version_pk PRIMARY KEY (version);


ALTER TABLE ONLY sessions
    ADD CONSTRAINT sessions_pkey PRIMARY KEY (session_id);

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);

ALTER TABLE ONLY sessions
    ADD CONSTRAINT fkpeyjpa5p9rfg5ofhtwh8h61x7 FOREIGN KEY (event_id) REFERENCES events(event_id);
