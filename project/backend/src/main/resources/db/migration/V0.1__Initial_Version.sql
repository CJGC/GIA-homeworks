CREATE TABLE Professor (

    id bigint auto_increment,
    identification_card varchar(100) not null,
    name varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null,
    username varchar(100) not null,
    password varchar(100) not null,

    CONSTRAINT Usuario_pk PRIMARY KEY (id)
);