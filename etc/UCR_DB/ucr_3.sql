--학과 가데이터 삽입
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '소프트웨어융합대학', '컴퓨터공학과');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '소프트웨어융합대학', '인공지능학과');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '정경대학', '경제학과');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '정경대학', '무역학과');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '정경대학', '행정학과');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '후마니타스칼리지교육과정', '인문사회');
INSERT INTO MAJOR(m_no, m_uni, m_name) VALUES (major_seq.NEXTVAL, '후마니타스칼리지교육과정', '체육');

--강의 가데이터 삽입
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE103-00', '객체지향프로그래밍', 1, 3, 3, '전205', '월, 수', '16:00-17:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE103-01', '객체지향프로그래밍', 1, 10, 3, 'B09', '화, 목', '13:00-14:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON253-00', '기계학습', 2, 50, 3, 'B06', '화, 목', '13:00-14:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON253-01', '기계학습', 2, 50, 3, 'B09', '화, 목', '15:00-16:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('EE209-00', '논리회로', 2, 50, 3, 'B06', '월, 수', '10:00-11:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('EE209-01', '논리회로', 2, 50, 3, '전226', '화, 목', '09:00-10:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE305-00', '데이터베이스', 3, 60, 3, '전211-1', '화, 목', '15:00-16:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE305-01', '데이터베이스', 3, 60, 3, '전102', '화, 목', '15:00-16:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE405-00', '캡스톤디자인', 4, 40, 3, 'B09', '화, 목', '19:00-20:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE405-01', '캡스톤디자인', 4, 40, 3, '전136', '화, 목', '19:00-20:50', '전공필수', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE224-00', 'UI/UX프로그래밍', 2, 48, 3, '전103', '월', '13:00-14:50', '전공선택', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON366-00', '3D데이터처리', 3, 40, 3, '전217', '월, 수', '15:00-16:50', '전공선택', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE444-00', 'AIoT네트워크', 4, 40, 3, 'B06', '금', '13:00-14:50', '전공선택', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('EE211-00', '확률및랜덤변수', 2, 40, 3, '전220', '월, 수', '15:00-16:50', '전공기초', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('EE211-01', '확률및랜덤변수', 2, 40, 3, '전445', '월, 수', '15:00-16:50', '전공기초', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE201-00', '이산구조', 2, 70, 3, 'B09', '화, 목', '11:00-12:50', '전공기초', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE201-01', '이산구조', 2, 60, 3, '전136', '월, 수', '09:00-10:50', '전공기초', 1);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON103-00', '디자인적사고 ', 1, 40, 3, '전205', '수', '09:00-10:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON103-01', '디자인적사고 ', 1, 40, 3, 'B09', '금', '09:00-10:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE204-00', '자료구조', 2, 60, 3, '전211-1', '수, 금', '15:00-16:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE204-01', '자료구조', 2, 60, 3, '전211-1', '수, 금', '11:00-12:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE304-00', '알고리즘', 3, 60, 3, '전211-1', '월, 수', '13:00-14:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE304-01', '알고리즘', 3, 60, 3, '전211-1', '화, 목', '13:00-14:50', '전공필수', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON104-00', '웹/파이선프로그래밍', 1, 30, 3, '전205', '월, 수', '13:00-14:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('SWCON104-01', '웹/파이선프로그래밍', 1, 30, 3, '전205', '화, 목', '13:00-14:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE330-00', 'SW스타트업비즈니스', 3, 50, 3, 'B01', '월', '09:00-10:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE324-00', '메타버스시스템', 3, 40, 3, 'B06', '월, 수', '15:00-16:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE340-00', '실전기계학습', 3, 80, 3, '전220', '금', '09:00-10:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE426-00', '영상처리', 4, 50, 3, 'B01', '월, 수', '13:00-14:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('CSE438-00', '최신기술콜로키움1', 4, 150, 2, '전205', '금', '10:00-11:50', '전공선택', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('AMTH1009-00', '미분적분학', 1, 50, 3, '전218', '월, 수', '15:00-16:50', '전공기초', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('AMTH1009-01', '미분적분학', 1, 50, 3, '멀107', '월, 수', '09:00-10:50', '전공기초', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('AMTH1004-00', '선형대수', 1, 50, 3, '전102', '월, 수', '12:00-13:50', '전공기초', 2);
INSERT INTO course (co_code, co_name, co_year, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('AMTH1004-01', '선형대수', 1, 50, 3, '멀304', '월, 수', '09:00-10:50', '전공기초', 2);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1801-S00', '고전읽기:그리스비극', 40, '3', '네104', '월, 수', '13:00-14:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1803-S00', '고전읽기:노자 장자', 50, '3', '청205', '금', '15:00-16:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1804-S00', '고전읽기:논어', 50, '3', '청620', '화, 목', '10:00-11:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1804-S01', '고전읽기:논어', 50, '3', '청308', '화, 목', '16:00-17:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1730-S00', '한국문화의이해', 40, '3', '네102', '화, 목', '13:00-14:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GED1876-S00', '한자의이해', 75, '3', '청307', '월, 수', '13:00-14:50','교양', 6);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GEE1601-S00', '골프', 28, '1', '골프장', '수, 금', '11:00-12:50','교양', 7);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GEE1601-S01', '골프', 28, '1', '골프장', '수, 금', '13:00-14:50','교양', 7);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GEE1633-S00', '웨이트트레이닝', 28, '1', '헬스장', '월', '13:00-14:50','교양', 7);
INSERT INTO course (co_code, co_name, co_limit, co_credit, classroom, co_day, co_time, division, m_no) VALUES ('GEE1633-S01', '웨이트트레이닝', 28, '1', '헬스장', '월', '15:00-16:50','교양', 7);

--교수 가데이터 삽입
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230001, '0000', '이대호', '770101-1000000', 'aaa@ucr.com', '010-1111-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230002, '0000', '최진우', '800101-1000000', 'bbb@ucr.com', '010-2222-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230003, '0000', '이원희', '820101-2000000', 'ccc@ucr.com', '010-3333-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230004, '0000', '김휘용', '840101-1000000', 'ddd@ucr.com', '010-4444-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230005, '0000', '박욱', '860101-1000000', 'eee@ucr.com', '010-5555-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230006, '0000', '정연모', '880101-1000000', 'fff@ucr.com', '010-6666-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230007, '0000', '박광훈', '900101-1000000', 'ggg@ucr.com', '010-7777-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230008, '0000', '김태연', '920101-2000000', 'hhh@ucr.com', '010-8888-0000');
INSERT INTO professor(pro_id, pro_pwd, pro_name, pro_iden_num, pro_email, pro_phone) VALUES (230009, '0000', '오민정', '720101-2000000', 'omj@ucr.com', '010-9999-0000');

--교수별 강의 삽입
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE103-00', 230001);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE103-01', 230001);
INSERT INTO procourse(co_code, pro_id) VALUES ('SWCON253-00', 230002);
INSERT INTO procourse(co_code, pro_id) VALUES ('SWCON253-01', 230002);
INSERT INTO procourse(co_code, pro_id) VALUES ('EE209-00', 230003);
INSERT INTO procourse(co_code, pro_id) VALUES ('EE209-01', 230003);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE305-00', 230004);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE305-01', 230005);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE405-00', 230006);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE405-01', 230007);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE224-00', 230008);
INSERT INTO procourse(co_code, pro_id) VALUES ('SWCON366-00', 230003);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE444-00', 230001);
INSERT INTO procourse(co_code, pro_id) VALUES ('EE211-00', 230004);
INSERT INTO procourse(co_code, pro_id) VALUES ('EE211-01', 230005);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE201-00', 230006);
INSERT INTO procourse(co_code, pro_id) VALUES ('CSE201-01', 230002);
INSERT INTO procourse(co_code, pro_id) VALUES ('GED1803-S00', 230009);

--공지사항 가데이터 삽입
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '학부 수강신청공지', sysdate,
'1. 2023학년도 2학기 수강신청시스템 로그인 안내<br>
2023학년도 2학기 수강신청시스템 로그인시 ID는 학번 PASSWORD는 경희대학교 포털(인포21) 비밀번호로 로그인<br>
PASSWORD는 경희대학교 포털(인포21) 로그인 -> MY PAGE -> 비밀번호변경 메뉴에서 변경 가능<br>
<br>
2. 수강신청안내 학사공지 <br>
※ 정규 수강신청 기간 매일 오전 10시부터 수강희망과목담기리스트 조회 가능<br>
<br>
3. 2023학년도 2학기 수업운영 안내 <br>
<br>
4. 재수강제도 안내 학사공지<br>
<br>
5. 수강신청「취소-신청 지연제」안내<br>
수강신청 전 반드시 [수강신청「취소-신청 지연제」안내] 내용 숙지하시기 바랍니다.<br>
<br>
6. 서울C 안내(2023학년도 2학기)<br>
<br>
7. 국제C 안내(2023학년도 2학기) <br>
<br>
<br>
[강의시간표 변경공지]<br>
최소수강학점과 장학금 수혜를 위한 최소이수학점 기준이 상이할 수 있으므로 장학금 수혜희망자는 장학심사기준을 반드시 확인하여 주시기 바랍니다.<br>
[2023-2학기 국가장학금 기준 : 직전학기 12학점 이상 이수 / 2023-2학기 교내장학 기준 : 일반계열 12학점(6년제 의·약학 계열 15학점) 이상 이수]<br>
서울 학생지원센터(장학) : 02-961-0045~6 / 국제 학생지원센터(장학) : 031-201-3055~9<br>
부모님이 본교 소속 교원인 경우, 부모님의 강의를 가급적 수강하지 않도록 유의하시기 바랍니다. (교육부 권고사항)<br>
<br>
8. 계열별 교차 전공 교과목 성적평가 선택제 시범운영 안내 참조 <br>
[비정상적 수강신청 접속 안내]<br>
- 수강신청 관련 사제 프로그램 사용, 과도한 로그인 및 수강신청 시도 등 비정상적 방법으로 수강신청 진행 시 경희톡 알림 (횟수 초과안내 2회) 및 수강신청 전체내역이 자동삭제(3차)되니 유의하시기 바랍니다.<br>
? 1차 입력횟수 1,000회, 혹은 로그인 횟수 100회 : 경희톡 알림<br>
? 2차 입력횟수 2,000회, 혹은 로그인 횟수 200회 : 경희톡 알림<br>
? 3차 입력횟수 3,000회, 혹은 로그인 횟수 300회 : 수강신청시스템 접속 제한 및 수강신청 전체내역 자동 삭제<br>
- 자세한 내용은 경희대학교 공지사항 - 학사 - 2023학년도 2학기 학부 수강신청 안내를 참조하여 주시기 바랍니다.');
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '학부 수강신청일정', sysdate,
'2023학년도 2학기 수강신청 일정 안내<br>
<br>
1.재학생 및 복학생 수강신청<br>
♠ 수강신청 로그인은 당일 자정(0시)부터 가능합니다.<br>
♠ 소속 학부(과) 개설과목 및 교양과목 수강신청<br>
4학년 : 2023.08.08.(화) 10:30 ~ 17:00<br>
3학년 : 2023.08.09.(수) 10:30 ~ 17:00<br>
2학년 : 2023.08.10.(목) 10:30 ~ 17:00<br>
1학년 : 2023.08.11.(금) 10:30 ~ 17:00<br>
<br>
※ 학년별 수강신청일의 학년기준은 가진급학년기준입니다.<br>
본인의 가진급학년은 수강희망과목담기 시 확인 가능합니다.<br>
<br>
<br>
2.다전공자 수강신청	<br>
다전공자 : 2023.08.14.(월) 10:30 ~ 17:00<br>
<br>
<br>
3.타학부 개설과목 수강신청(캠퍼스간 교차수강 포함) 및 재수강 신청<br>	
전학년 : 2023.08.16.(수) 10:30 ~ 17:00<br>
<br>
<br>
4.수강신청 확인 및 정정	<br>
2023.09.01.(금) 10:30 ~ 18:00<br>
2023.09.04.(월) ~ 09.06.(수) 09:30 ~ 17:00<br>
2023.09.07.(목) 10:30 ~ 18:00');

INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '학부 계절학기공지', sysdate,
'계절학기 수강신청 일정 등 관련 안내<br>
<br>
수강희망과목담기 기간: 2023.05.15(월) 10:00 ~ 05.17(수) 17:00<br>
- 수업시간 및 교강사는 희망과목담기를 통해 개설이 확정된 후 배정됨<br>
- 희망과목담기 결과 기준인원(15명) 미달 강좌는 개설되지 않을 수 있음<br>
수강신청 기간: 2023.05.30(화) ~ 06.01(목) 매일 10:30 ~ 17:00<br>
추가 수강신청기간: 2023.06.12(월) ~ 06.13(화) 매일 10:30 ~ 17:00<br>
- 1차 수강신청 및 등록 이후 수강신청 여석에 대한 추가 수강신청 실시<br>
- 1차 수강신청(수업료 납부)자는 수강가능 학점 내에서 추가 신청 가능 (수강 정정 및 취소는 불가)<br>
<br>
<br>
2023학년도 하계 계절학기 운영 방법<br>
1) 수업운영: 대면수업(8주) + 선택*<br>
* 선택: 대면수업 또는 비대면수업 또는 대면수업과 비대면수업을 혼합하여 구성<br>
2) 시험운영 : 대면시험 원칙<br>
(중간 시험은 생략 또는 과제물 제출 등 대체 가능)<br>
3) 성적평가: 상대평가[A-이상 45% 이내 적용]<br>
<br>
<br>
계절학기 수강신청시스템 로그인 안내<br>
1) 로그인은 수강신청 당일 자정부터 가능함[2023.05.30(화) 00:00]<br>
2) 로그인 창 상단 콤보 박스에서 계절학기 수강신청 클릭<br>
3) 수강신청시스템 로그인 시 ID는 학번 PASSWORD는 Info21 통합 PASSWORD를 사용하여야 함<br>
4) PASSWORD 분실 시 수강신청시스템 로그인 창 하단의 비밀번호 찾기 또는 Info21 통합로그인 페이지의 비밀번호 찾기 이용<br>
5) PASSWORD 변경은 Info21 통합 로그인 → 포털 → MY PAGE → 비밀번호변경 메뉴에서 변경 가능<br>
<br>
<br>
수강신청 관련 안내<br>
1) 종합시간표를 조회하여 수강할 과목의 학수번호를 확인한 후 수강신청하시기 바랍니다.<br>
2) 2023학년도 1학기 현재 수강 중인 강좌는 계절학기 수강신청이 불가합니다.<br>
3) 2014학년도 1학기(포함) 이후 강좌 중 B0 이상의 성적을 받은 경우 계절학기 재수강 신청이 불가합니다.<br>
4) 학교 홈페이지 → 공지사항 → 학사 → 2023학년도 하계 계절학기 개설 안내(서울·국제) 참조하시기 바랍니다.<br>
<br>
<br>
계절학기관련 문의처<br>
1) 서울 교무처 학사지원팀 : 02-961-0053~4 서울시 동대문구 경희대로 26 경희대학교 본관1층 113호<br>
2) 국제 교무처 교직팀 : 031-201-3047~8 경기도 용인시 기흥구 덕영대로 1732 경희대학교 중앙도서관 1층 통합사무실.');
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '학부 계절학기 등록일정', sysdate,
'학부 계절학기 등록일정<br>
1차	수강신청 : 2023.05.30(화) ~ 06.01(목) * 매일 10:30 ~ 17:00	<br>
1차 납부기간 : 2023.06.05(월) 09:30 ~ 06.07(수) 16:00<br>
2차	수강신청 : 2023.06.12(월) ~ 06.13(화) * 매일 10:30 ~ 17:00	<br>
2차 납구기간 : 2023.06.15(목) 09:30 ~ 06.16(금) 16:00<br>
<br>
▶ 1차 수강신청자는 반드시 1차 납부기간에 수업료를 납부해야 함(미납시 미등록으로 수강취소됨)<br>
▶ 수강신청한 과목 전체에 대한 금액을 일괄 납부함(과목별 납부 불가)<br>
<br>
<br>
유의사항<br>
1. 하나은행 가상계좌 입금(인터넷뱅킹 등). 은행방문 수납 시에는 은행 영업시간 중에만 가능<br>
2. 2차 폐강[2023.06.14(수)]의 경우 당일 서울C 교무처 학사지원팀, 국제C 교무처 교직팀 방문 또는 연락하여 다른 과목으로 수강신청을 변경하시기 바랍니다.<br>
    (1차 폐강[2023.06.09.(금)]의 경우, 2차 수강신청 기간 때 수강신청을 진행하여 주시기 바랍니다.)<br>
3. 폐강된 과목 이외에는 수강 신청을 정정할 수 없으므로 수강 신청 시 신중하게 선택하기 바랍니다.(수강정정은 잔여석이 있는 강좌에 한함)<br>
4. 관련 문의사항 서울/학사지원팀 02-961-0053~4, 국제/교직팀 031-201-3047~8<br>
<br>
<br>
등록금 수납 방법<br>
학교 홈페이지 → 인포 → 등록/장학 → 계절학기수업료 조회 참조');
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '학부 희망과목공지', sysdate,
'수강희망과목담기 실시기간<br>
-2023.07.17.(월) 10:00 ~ 07.21.(금) 17:00<br>
<br>
<br>
2023학년도 2학기 수강희망과목담기 로그인 안내<br>
-2023학년도 2학기 수강희망과목담기 로그인시 ID는 학번, PASSWORD는 인포21 비밀번호 사용<br>
-Password 변경 방법 : 인포21 통합로그인 → 경희대학교 포털 → My Page → 비밀번호변경<br>
<br>
<br>
수강희망과목담기 유형<br>
수강희망과목담기는 “희망과목담기”와 “예비과목담기”로 구분하여 실시됨<br>
<br>
가. 희망과목담기<br>
-본인의 수강허용학점 범위 내에서 희망과목담기 강좌 선택 가능<br>
-동일 학수번호 강좌 중복 선택 불가<br>
-결과는 전공별 강좌개설 및 여석배정을 위한 수강 수요 기초자료로 활용<br>
<br>
나. 예비과목담기(희망과목담기가 종료되어야 예비과목담기가 가능)<br>
-희망과목담기 외 10개 강좌까지 선택 가능<br>
-동일 학수번호 강좌 중복 선택 가능<br>
-수강 수요 예측과 관계없이 단순 수강신청 편의 제공용<br>
<br>
<br>
대상강좌 : 2023학년도 2학기 개설강좌(경희사이버대학교를 포함한 학점교류강좌 제외)
<br><br>
유의사항<br>
-희망과목담기 및 예비과목담기는 수강신청 인원제한 없이 신청 가능<br>
-희망과목담기 및 예비과목담기에 담아 놓은 강좌 중 실제 수강신청을 희망하는 강좌는 수강신청 기간에 반드시 별도로 수강신청을 해야 함<br>
-희망과목담기 및 예비과목담기는 수강인원, 선수과목, 타전공 제어 등 강좌별 제한사항과 관계없이 신청이 가능하나, 수강신청 시에는 제한사항이 반영되므로 본인에게 제한되는 과목을 희망과목으로 담지 않도록 주의 요함<br>
-※ 강좌별 제한사항은 반드시 개설 단과대학에 확인 요망<br>
-“종합시간표 조회>강의계획서”에 "조회" 아이콘이 보이지 않는 강좌는 아직 강의계획서가 입력되지 않은 강좌임<br>
-“종합시간표 조회>강의평가결과”에서 담당 교강사의 과거 3개 학년도의 강의평가 결과를 조회할 수 있음. 평가 내역이 없는 경우 "조회" 아이콘이 보이지 않음.<br>
-추후 단과대학의 사정에 의해 개설강좌의 강의시간, 강의실, 교강사 등이 변경될 수 있음');
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '대학원 수강신청공지', sysdate,
'대학원수강신청방법<br>
2016학년도 2학기 부터 학부 수강신청과 통합 운영<br>
가. 수강신청방법<br>
-수강신청/희망과목 탭을 클릭<br>
-구분에서 [대학원수강신청]선택<br>
-ID/PASSWORD란에 ID는 학번, PASSWORD는 Info21 비밀번호를 입력 후 로그인 버튼 클릭<br>
-수강신청 탭에서 수강신청');
INSERT INTO notice(notice_no, title, write_date, contents)
VALUES(notice_seq.NEXTVAL, '신규시스템유의사항', sysdate,
'매크로 프로그램 방지<br>
-매크로프로그램 사용을 방지하기 위하여 저장을 관리자가 지정한 횟수이상 시도하면 화면에 나타나는 문자열을 입력하고 계속 사용<br>
-문자열 입력 시 5회 이상 틀리면 자동 로그아웃<br>
<br><br>
멀티 로그인 시 처리기능 방지<br>
-동일한 학번으로 동시에 두 군데 이상의 PC에서 로그인을 했을 경우 조회 기능은 가능하나<br>
수강신청 저장을 시도하면 마지막으로 로그인한 사용자만 저장 가능하고 나머지는 로그아웃 처리<br>
<br><br>
팝업차단 해제<br>
-팝업차단 설정이 해제되지 않았을 경우 팝업차단을 해제<br>
-팝업차단 해제 방법으로 브라우저에서 "도구/인터넷옵션/팝업차단설정/" 현재 사이트의 팝업을 항상 "허용"<br>
<br><br>
모니터 해상도<br>
-수강신청시스템의 최저해상도는 1366 * 768이며, 1920 * 1080에 최적화되어 있으며 그 이상의 해상도로 화면 설정<br>
<br><br>
브라우저<br>
-크롬, 파이어폭스 브라우저에 최적화되었습니다.<br>
<br><br>
브라우저 별 캐시 삭제 방법<br>
-크롬<br>
Ctrl+F5 또는 Ctrl+Shift+R<br>
설정 ? 인터넷 사용 기록 삭제 ? 쿠키 및 사이트데이터, 캐시 된 이미지파일 삭제<br>
<br>
-엣지<br>
도구 ? 설정 ? 개인정보, 검색 및 서비스 ? 검색데이터 지우기 [지울항목선택] ? [지금지우기]');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '후마니타스 서울 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '후마니타스 국제 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '문과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '정경대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '경영대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '호텔관광대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '이과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '생활과학대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '의과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '한의과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '치과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '약학대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '간호과학대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '음악대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '미술대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '무용학부 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '자율전공학부 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '공과대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '전자정보대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '소프트웨어융합대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '응용과학대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '생명과학대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '국제대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '외국어대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '예술디자인대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '체육대학 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '경희사이버대학(학점교류) 서울 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '경희사이버대학(학점교류) 국제 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '동서의학대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '국제대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '체육대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '법학전문대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '경영대학원대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '교육대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '공공대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '평화복지대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '테크노경영대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '미디어커뮤니케이션대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '법무대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '관광대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '간호대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '아트퓨전디자인대학원 공지사항', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 여름학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 여름학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 여름학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 1학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 1학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2023학년도 1학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 겨울학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 겨울학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 겨울학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 2학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 2학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 2학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 여름학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 여름학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 여름학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 1학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 1학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2022학년도 1학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 겨울학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 겨울학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 겨울학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 2학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 2학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 2학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 여름학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 여름학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 여름학기 개설강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 1학기 강좌목록', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 1학기 폐강강좌', sysdate, '-상세없음-');
INSERT INTO notice(notice_no, title, write_date, contents) VALUES(notice_seq.NEXTVAL, '2021학년도 1학기 개설강좌', sysdate, '-상세없음-');

--학생 가데이터 삽입
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20230001, '1111', '박민서', '020101-4000000', 'bms@ucr.com', '010-0000-0001', 3.0, 1, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20230002, '1111', '김태영', '020102-3000000', 'kty@ucr.com', '010-0000-0002', 3.1, 1, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20230003, '1111', '이지훈', '020103-3000000', 'ljh@ucr.com', '010-0000-0003', 3.2, 1, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20230004, '1111', '정은지', '020104-4000000', 'jej@ucr.com', '010-0000-0004', 3.3, 1, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20230005, '1111', '지영수', '020105-3000000', 'cys@ucr.com', '010-0000-0005', 3.4, 1, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20220001, '1111', '유지원', '010101-4000000', 'yjo@ucr.com', '010-0000-0006', 3.5, 2, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20220002, '1111', '장현우', '010102-3000000', 'jgw@ucr.com', '010-0000-0007', 3.6, 2, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20220003, '1111', '한지윤', '010103-4000000', 'hjy@ucr.com', '010-0000-0008', 3.7, 2, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20220004, '1111', '송현아', '010104-4000000', 'sha@ucr.com', '010-0000-0009', 3.8, 2, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20210001, '1111', '강준영', '010105-3000000', 'rjy@ucr.com', '010-0000-0010', 3.9, 3, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20210002, '1111', '박준호', '000101-3000000', 'bjh@ucr.com', '010-0000-0011', 3.10, 3, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20210003, '1111', '이나영', '000102-4000000', 'lny@ucr.com', '010-0000-0012', 3.11, 3, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20210004, '1111', '정태우', '000103-3000000', 'jtw@ucr.com', '010-0000-0013', 3.12, 3, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20210005, '1111', '최지원', '000104-4000000', 'cjo@ucr.com', '010-0000-0014', 3.13, 3, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20200001, '1111', '한성호', '000105-3000000', 'hsh@ucr.com', '010-0000-0015', 3.14, 4, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20200002, '1111', '송미영', '990101-2000000', 'smy@ucr.com', '010-0000-0016', 3.15, 4, 2);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20200003, '1111', '김민지', '990102-2000000', 'kmj@ucr.com', '010-0000-0017', 3.16, 4, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20200004, '1111', '유현주', '990103-2000000', 'yhj@ucr.com', '010-0000-0018', 3.17, 4, 1);
INSERT INTO student(stu_id, stu_pwd, stu_name, stu_iden_num, stu_email, stu_phone, stu_credits, stu_grades, m_no) VALUES (20200005, '1111', '박미리', '990104-2000000', 'bml@ucr.com', '010-0000-0019', 3.18, 4, 1);

--위시리스트 가데이터 삽입
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20230001);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20230002);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20230003);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20230004);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20230005);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20220001);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20220002);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20220003);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20220004);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20210001);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20210002);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20210003);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20210004);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20210005);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20200001);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20200002);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20200003);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20200004);
INSERT INTO wishlist(co_code, stu_id) VALUES ('GED1876-S00', 20200005);

--수강신청 가데이터 삽입
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20230001);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20230002);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20230003);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20230004);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20230005);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20220001);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20220002);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20220003);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20220004);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20210001);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20210002);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20210003);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20210004);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20210005);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20200001);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20200002);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20200003);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20200004);
INSERT INTO registration(co_code, stu_id) VALUES ('GED1803-S00', 20200005);
INSERT INTO registration(co_code, stu_id) VALUES ('CSE103-00', 20220001);
INSERT INTO registration(co_code, stu_id) VALUES ('CSE103-00', 20220002);
INSERT INTO registration(co_code, stu_id) VALUES ('CSE103-00', 20220003);

-- 과거학점 가데이터 생성
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230001, '전공필수', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230001, '전공선택', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230001, '전공기초', 3);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230001, '교양', 15);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230002, '전공필수', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230002, '전공선택', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230002, '전공기초', 3);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230002, '교양', 15);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230003, '전공필수', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230003, '전공선택', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230003, '전공기초', 3);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230003, '교양', 15);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230004, '전공필수', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230004, '전공선택', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230004, '전공기초', 3);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230004, '교양', 15);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230005, '전공필수', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230005, '전공선택', 0);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230005, '전공기초', 3);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20230005, '교양', 15);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220001, '전공필수', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220001, '전공선택', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220001, '전공기초', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220001, '교양', 36);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220002, '전공필수', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220002, '전공선택', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220002, '전공기초', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220002, '교양', 36);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220003, '전공필수', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220003, '전공선택', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220003, '전공기초', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220003, '교양', 36);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220004, '전공필수', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220004, '전공선택', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220004, '전공기초', 6);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20220004, '교양', 36);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210001, '전공필수', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210001, '전공선택', 21);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210001, '전공기초', 9);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210001, '교양', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210002, '전공필수', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210002, '전공선택', 21);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210002, '전공기초', 9);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210002, '교양', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210003, '전공필수', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210003, '전공선택', 21);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210003, '전공기초', 9);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210003, '교양', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210004, '전공필수', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210004, '전공선택', 21);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210004, '전공기초', 9);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210004, '교양', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210005, '전공필수', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210005, '전공선택', 21);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210005, '전공기초', 9);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20210005, '교양', 30);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200001, '전공필수', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200001, '전공선택', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200001, '전공기초', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200001, '교양', 40);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200002, '전공필수', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200002, '전공선택', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200002, '전공기초', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200002, '교양', 40);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200003, '전공필수', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200003, '전공선택', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200003, '전공기초', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200003, '교양', 40);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200004, '전공필수', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200004, '전공선택', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200004, '전공기초', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200004, '교양', 40);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200005, '전공필수', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200005, '전공선택', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200005, '전공기초', 27);
INSERT INTO PASTCREDITS(stu_id, division, credit) VALUES (20200005, '교양', 40);

UPDATE course SET regi_cnt = 3 WHERE co_code = 'CSE103-00';
UPDATE course SET regi_cnt = 19 WHERE co_code = 'GED1803-S00';

commit;