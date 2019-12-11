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
                                                      
alter table notice modify(notice_title varchar2(200));


insert into Member values(Member_seq.nextval, 'test2', '123', '123', '1', '1', 1);
insert into SNS values(SNS_seq.nextval, '123', '1', sysdate);
create sequence Member_seq;


select * from SNS;

CREATE TABLE SNS 
(
    sns_number    NUMBER(10)       primary key, 
    member_id     VARCHAR2(10)    NOT NULL, 
    sns_text      VARCHAR2(255)    NOT NULL, 
    sns_date      DATE             NOT NULL,
    CONSTRAINT FK_SNS_member_id
    FOREIGN KEY (member_id) REFERENCES Member (member_id) 
);


CREATE TABLE SNS 
(
    sns_number    NUMBER(10)       primary key, 
    sns_user     VARCHAR2(10)    NOT NULL, 
    sns_text      VARCHAR2(255)    NOT NULL, 
    sns_date      DATE             NOT NULL,
    CONSTRAINT FK_SNS_sns_user
    FOREIGN KEY (sns_user) REFERENCES Member (member_id) 
);


create sequence sns_reply_seq;


select * from Member where member_id = 'test';

select * from sns;

select *
		from (
			select  rownum as rn, snum, sid, stxt, sdate, mpho
			from (
				select sns_number as snum, s.member_id as sid, sns_text as stxt, sns_date as sdate, member_photo as mpho
				from SNS s, Member m
				where s.member_id = m.member_id
				order by sns_date desc
			);
		)
where rn &gt;= #{start} and rn &lt;= #{end};

drop sequence sns_reply_seq;

CREATE TABLE sns_reply
(
    member_id       VARCHAR2(10)    NOT NULL, 
    sns_number      NUMBER(10)      NOT NULL, 
    reply_date      DATE            NOT NULL, 
    reply_text      VARCHAR2(80)    NOT NULL, 
    reply_number    number(4)       primary key,
    constraint sns_reply_delete FOREIGN KEY (sns_number) REFERENCES SNS (sns_number) on delete cascade,
	constraint member_id_delete FOREIGN KEY (member_id) REFERENCES Member (member_id) on delete cascade
    );
    
CREATE TABLE sns_reply
(
    reply_user       VARCHAR2(10)    NOT NULL, 
    reply_number      NUMBER(10)     PRIMARY KEY, 
    reply_date      DATE            NOT NULL, 
    reply_text      VARCHAR2(80)    NOT NULL, 
    reply_number_num    number(4)      	NOT NULL,
    CONSTRAINT FK_sns_reply_reply_number_SNS_ FOREIGN KEY (reply_number_num)
        REFERENCES SNS (sns_number) on delete cascade,
	CONSTRAINT FK_sns_reply_reply_user_Member FOREIGN KEY (reply_user)
        REFERENCES Member (member_id) on delete cascade
    ); 
    
drop table sns_reply;
select * from casting;
    
select * from (select ti.theater_number as tn, c.code, p.person_number, p.person_name from (select * from theater_info t, person p, code c, casting g where ti.theater_number = g.person_number)) where tn = 5;

select * from sns_reply where reply_number = 1;
select * from sns_reply;
insert into sns_reply values (123, '21', sysdate, '1', 10); 
select * from sns;
select * from sns_reply_seq;

insert into sns_reply values('123', 21, sysdate, '1', sns_reply_seq.nextval);

select count(*) from SNS s, member m
where s.member_id = m.member_id;

select * from sns_reply where reply_number = #{sns_number};


create table notice (
   notice_number    NUMBER(10)        primary key, 
    notice_title     VARCHAR2(20)      NOT NULL, 
    notice_text      VARCHAR2(1500)    NOT NULL, 
    notice_id        VARCHAR2(10)      NOT NULL, 
   CONSTRAINT FK_Notice_id_Member_id FOREIGN KEY (notice_id)
        REFERENCES Member (member_id) on delete cascade
);

insert into notice values(notice_seq.nextval, '제목', '내용', '123');

create sequence notice_seq;

select * from notice;

drop table notice;