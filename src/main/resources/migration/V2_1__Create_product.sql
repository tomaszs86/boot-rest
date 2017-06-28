create table products(
    id int primary key not null,    
    product_name varchar(100) not null,
    product_code varchar(100) not null,
    release_date timestamp without time zone DEFAULT now() NOT NULL,
    price decimal not null,
    description varchar(100) not null,
    star_rating int not null,
    tags varchar(500) null
);

create sequence products_seq_gen;