create table users(
    id int primary key not null,
    username varchar(100) not null,
	is_active boolean not null,
	created timestamp without time zone DEFAULT now() NOT NULL
);