create table events(
    id int primary key not null,    
    name varchar(100) not null,    
    date timestamp without time zone DEFAULT now() NOT NULL,
    time varchar(100) not null,     
    price decimal not null,   
    image_url varchar(100) null,
    online_url varchar(100) null
);

create sequence events_seq_gen;