CREATE TABLE notice
(
    notice_number    NUMBER(10)        PRIMARY KEY, 
    notice_title     VARCHAR2(20)      NOT NULL, 
    notice_text      VARCHAR2(1500)    NOT NULL, 
    member_id        VARCHAR2(10)      NOT NULL
);

CREATE TABLE theater_info (
    theater_number    NUMBER(8)       PRIMARY KEY,
    theater_title     VARCHAR2(20)    NOT NULL, 
    theater_photo     VARCHAR2(40)    NOT NULL, 
    thaeter_time      NUMBER(3)       NOT NULL, 
    theater_age       NUMBER(3)       NOT NULL
);

CREATE TABLE person
(
    person_number        NUMBER(8)       PRIMARY KEY, 
    person_name          VARCHAR2(10)    NOT NULL, 
    person_birth         DATE            NOT NULL, 
    person_birthplace    VARCHAR2(30)    NOT NULL, 
    person_photo         VARCHAR2(40)    NULL, 
    code                 NUMBER(2)       NOT NULL
);

CREATE TABLE casting
(
    theater_number    NUMBER(8)    NOT NULL, 
    person_number     NUMBER(8)    NOT NULL
);

CREATE TABLE stage
(
    stage_number    NUMBER(4)       PRIMARY KEY, 
    stage_name      VARCHAR2(30)    NOT NULL, 
    stage_place     VARCHAR2(60)    NOT NULL, 
    stage_date      DATE            NOT NULL, 
    stage_photo     VARCHAR2(40)    NOT NULL
);

CREATE TABLE theater_stage
(
    theater_number    NUMBER(8)    NOT NULL, 
    stage_number      NUMBER(4)    NOT NULL
);

CREATE TABLE date_time
(
    theater_number    NUMBER(10)    PRIMARY KEY, 
    theater_date      DATE          NOT NULL, 
    date_number       NUMBER(6)     NOT NULL
);

CREATE TABLE theater_date_time
(
    theater_number    NUMBER(8)    NOT NULL, 
    theater_date      DATE         NOT NULL
);

CREATE TABLE organization
(
    group_number    NUMBER(4)       PRIMARY KEY, 
    group_name      VARCHAR2(20)    NOT NULL
);

CREATE TABLE theater_organization
(
    group_number      NUMBER(4)    NOT NULL, 
    theater_number    NUMBER(8)    NOT NULL
);

CREATE TABLE genre
(
    genre_number    number(2)       PRIMARY KEY, 
    genre_name      VARCHAR2(20)    NOT NULL, 
    code            NUMBER(2)       NOT NULL
);

CREATE TABLE theater_genre
(
    theater_number    NUMBER(8)    NOT NULL, 
    genre_number      number(2)    NOT NULL
);

CREATE TABLE code (
	code_name varchar2(10) NOT NULL,
	code_comment varchar2(20) NOT NULL,
	code number(2) NOT NULL
);

create sequence theater_seq;
create sequence person_seq;
create sequence date_seq;
create sequence stage_seq;
create sequence group_seq;
insert into theater_info values (theater_seq.nextval, '고도를 기다리', '1', 120, 15);
insert into theater_info values (theater_seq.nextval, '뽀로로', '1', 90, 7);
insert into theater_info values (theater_seq.nextval, '가나다', '1', 110, 15);
insert into person values (person_seq.nextval, 'Kim', sysdate, '청주', '1', 01);
insert into person values (person_seq.nextval, 'Lee', sysdate, '홍성', '1', 02);
insert into person values (person_seq.nextval, 'Park', sysdate, '양주', '1', 02);
insert into person values (person_seq.nextval, 'Hong', sysdate, '파주', '1', 02);
insert into code values ('person','감독',01);
insert into code values ('person', '배우', 02);

select * from code;
delete code;

insert into casting values (1, 1);
insert into casting values (1, 2);
insert into casting values (1, 4);
insert into casting values (2, 1);
insert into casting values (2, 3);
insert into casting values (2, 2);
insert into casting values (3, 1);
insert into casting values (3, 3);

select * from (
	select rownum as rn, theater_title, theater_number, person_name, code, code_comment from (select t.theater_number, p.person_number, c.code, code_comment, person_name, theater_title from theater_info t, person p, code c, casting g group by theater_number)
) where theater_number = 1;

select * from theater_info;

alter table theater_info rename column thaeter_time to theater_time;