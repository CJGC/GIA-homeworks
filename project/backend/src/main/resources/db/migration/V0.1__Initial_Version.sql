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

CREATE TABLE Question (
    id bigint auto_increment,
    question_type varchar(10) not null,
    weight double default 0.0,
    description varchar(2048) not null,
    question_image varbinary,
    exam_id bigint,

    constraint pk_question primary key (id),
    constraint fk_exam foreign key (exam_id)
    references Exam(id)
);

CREATE TABLE Answer_option (
    id bigint auto_increment,
    index varchar(1) not null,
    description varchar(2048) not null,
    correct_answer boolean default false,
    weight double default 0.0,
    question_id bigint,
    
    constraint pk_asnwer_option primary key (id),
    constraint fk_question foreign key (question_id)
    references Question(id)
);