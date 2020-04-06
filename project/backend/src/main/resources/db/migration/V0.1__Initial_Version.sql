CREATE TABLE Usuario (
    id bigint auto_increment,
    username varchar(50) not null,
    password varchar(50),
    name varchar(100),
    email varchar(100) not null,

    CONSTRAINT Usuario_pk PRIMARY KEY (id)
);