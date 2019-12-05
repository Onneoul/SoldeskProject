CREATE TABLE Member
(
    member_number NUMBER(7) NOT NULL, 
    member_id VARCHAR2(10) primary key, 
    member_pw VARCHAR2(10)    NOT NULL, 
    member_name      VARCHAR2(8)     NOT NULL, 
    member_addr      VARCHAR2(80)    NOT NULL, 
    member_photo     VARCHAR2(50)    NOT NULL, 
    member_level     NUMBER(1)       NOT NULL
);

insert into Member values(Member_seq.nextval, 'test2', '123', '123', '1', '1', 1);

create sequence Member_seq;

drop table Member;

select * from Member;

CREATE TABLE SNS
(
    sns_number    NUMBER(10)       primary key, 
    member_id     VARCHAR2(10)     NOT NULL, 
    sns_text      VARCHAR2(255)    NOT NULL, 
    sns_date      DATE             NOT NULL, 
);

create sequence SNS_seq;

select * from Member where member_id = 'test';