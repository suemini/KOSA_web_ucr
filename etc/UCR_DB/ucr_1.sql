--테이블 리셋
drop table wishlist;
drop table registration;
drop table PROCOURSE;
drop table notice;
drop table PASTCREDITS;
drop table STUDENT;
drop table PROFESSOR;
drop table COURSE;
drop table MAJOR;

--시퀀스 리셋
drop SEQUENCE notice_seq;
drop SEQUENCE major_seq;

--프로시저 리셋
--drop PROCEDURE increase_view_count;

--시퀀스 생성
CREATE SEQUENCE notice_seq;
CREATE SEQUENCE major_seq;

--전공 테이블 생성
CREATE TABLE MAJOR (
	m_no NUMBER,
	m_uni VARCHAR2(60) NOT NULL,
	m_name VARCHAR2(60) NOT NULL,
	CONSTRAINT m_no_pk PRIMARY KEY (m_no)
);

--강좌 테이블 생성
CREATE TABLE COURSE (
    co_code VARCHAR2(30),
    co_name VARCHAR2(255) NOT NULL,
    co_year NUMBER,
    co_limit NUMBER NOT NULL,
    co_credit NUMBER NOT NULL,
    classroom VARCHAR2(30),
    division VARCHAR2(12) NOT NULL,
	m_no NUMBER,
    regi_cnt number DEFAULT 0 NOT NULL, 
    co_day VARCHAR2(15) NOT NULL,
    co_time VARCHAR2(40) NOT NULL,
    CONSTRAINT co_code_pk PRIMARY KEY (co_code),
    CONSTRAINT course_m_no_fk FOREIGN KEY (m_no) REFERENCES major(m_no)
);

--학생 테이블 생성
CREATE TABLE STUDENT (
	stu_id NUMBER,
	stu_pwd VARCHAR2(30) NOT NULL,
	stu_name VARCHAR2(30) NOT NULL,
	stu_iden_num VARCHAR2(14) NOT NULL,
	stu_email VARCHAR2(50) NOT NULL,
	stu_phone VARCHAR2(13) NOT NULL,
	stu_credits NUMBER NOT NULL,	
	stu_grades NUMBER NOT NULL,	
	m_no NUMBER,
	CONSTRAINT stu_id_pk PRIMARY KEY (stu_id),
	CONSTRAINT student_m_no_fk FOREIGN KEY (m_no) REFERENCES major(m_no)
);

--교수 테이블 생성
CREATE TABLE PROFESSOR (
	pro_id NUMBER,
	pro_pwd VARCHAR2(30) NOT NULL,
	pro_name VARCHAR2(30) NOT NULL,
	pro_iden_num VARCHAR2(14) NOT NULL,
	pro_email VARCHAR2(50) NOT NULL,
	pro_phone VARCHAR2(13) NOT NULL,
	CONSTRAINT pro_id_pk PRIMARY KEY (pro_id)
);

--교수의 강좌테이블 생성
CREATE TABLE PROCOURSE (
	co_code VARCHAR2(30),
	pro_id NUMBER,
	CONSTRAINT procourse_pk PRIMARY KEY (co_code, pro_id),
	CONSTRAINT procourse_co_code_fk FOREIGN KEY (co_code) REFERENCES COURSE(co_code),
	CONSTRAINT procourse_pro_id_fk FOREIGN KEY (pro_id) REFERENCES PROFESSOR(pro_id)
);

--공지사항 테이블 생성
CREATE TABLE notice (
	notice_no NUMBER,
    title VARCHAR2(255) NOT NULL,
	write_date date NOT NULL,
	view_count NUMBER DEFAULT 0,
	contents VARCHAR2(4000) NOT NULL,
	CONSTRAINT notice_no_pk PRIMARY KEY (notice_no)
);

--수강신청 테이블 생성
CREATE TABLE registration (
	co_code VARCHAR2(30),
	stu_id NUMBER,
	CONSTRAINT registration_pk PRIMARY KEY (co_code, stu_id),
	CONSTRAINT registration_co_code_fk FOREIGN KEY (co_code) REFERENCES COURSE(co_code),
	CONSTRAINT registration_stu_id_fk FOREIGN KEY (stu_id) REFERENCES STUDENT(stu_id)
);

--희망강좌 테이블 생성
CREATE TABLE wishlist (
	co_code VARCHAR2(30),
	stu_id NUMBER,
	CONSTRAINT wishlist_pk PRIMARY KEY (co_code, stu_id),
	CONSTRAINT wishlist_co_code_fk FOREIGN KEY (co_code) REFERENCES COURSE(co_code),
	CONSTRAINT wishlist_stu_id_fk FOREIGN KEY (stu_id) REFERENCES STUDENT(stu_id)
);

-- 과거학점 테이블 생성
CREATE TABLE PASTCREDITS (
	stu_id NUMBER,
	division VARCHAR2(12) NOT NULL,
	credit NUMBER DEFAULT 0 NOT NULL,
	CONSTRAINT past_credits_stu_id_fk FOREIGN KEY (stu_id) REFERENCES STUDENT(stu_id)
);


