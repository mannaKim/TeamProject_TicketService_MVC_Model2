-- Qna 추가
drop sequence qna_seq;
create sequence qna_seq start with 1;

select * from qna;

insert into qna (qseq, kind, subject, content, id) 
values(qna_seq.nextval,'1', '전시 내역 관련 문의입니다', '전시 내역 보내주세요', 'scott');
insert into qna (qseq, kind, subject, content, id) 
values(qna_seq.nextval, '4', '굿즈 환불절차 안내부탁드려요', '환불하고 싶어요', 'scott');
insert into qna (qseq, kind, subject, content, id) 
values(qna_seq.nextval, '4', '굿즈 교환 하고 싶어요', '교환절차 안내부탁드려요', 'scott');
insert into qna (qseq, kind, subject, content, id) 
values(qna_seq.nextval, '2', '비밀번호 변경', '변경 적용이 안됩니다', 'scott');
insert into qna (qseq, kind, subject, content, id) 
values(qna_seq.nextval, '3', '예약 관련', '예약 인원 언제 충원하나요?', 'scott');


-- qreply 추가
drop sequence qreply_seq;
create sequence qreply_seq start with 1;

select * from qreply;

insert into qreply (renum, qnanum, content, id) 
values(qreply_seq.nextval, 1, '문의 답변', 'scott');
insert into qreply (renum, qnanum, content, id) 
values(qreply_seq.nextval, 2, '확인 후 연락 드리겠습니다.', 'scott');