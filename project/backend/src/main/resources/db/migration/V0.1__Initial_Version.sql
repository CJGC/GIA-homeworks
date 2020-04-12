CREATE TABLE Professor (

    id bigint auto_increment,
    identification_card varchar(100) not null,
    name varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null,
    username varchar(100) not null,
    password varchar(100) not null,

    CONSTRAINT pk_professor PRIMARY KEY (id)
);


CREATE TABLE Exam (
    id bigint auto_increment,
    name varchar(100) not null,
    link varchar(512) not null,
    max_grade double default 0.0,
    description varchar(1024) not null,
    examtime int default 0,
    professor_id bigint,

    constraint pk_exam primary key (id),
    constraint fk_professor foreign key (professor_id)
    references Professor(id)
);