-- introduce DB내용
select * from introduce;

insert into introduce(title, content, pass, image, id) 
values('회사소개 입니다.', '회사소개 내용입니다.', '1234', 'intro.jpg', 'admin');


-- notice DB내용
drop sequence ntnum_seq;
create sequence ntnum_seq start with 1;

select * from notice;

insert into notice(ntnum, title, content, pass, id)
values(ntnum_seq.nextVal, '공지사항 1번', '공지사항 1번의 내용', '1234', 'admin');
insert into notice(ntnum, title, content, pass, id)
values(ntnum_seq.nextVal, '공지사항 2번', '공지사항 2번의 내용', '1234', 'admin');
insert into notice(ntnum, title, content, pass, id)
values(ntnum_seq.nextVal, '공지사항 3번', '공지사항 3번의 내용', '1234', 'admin');
insert into notice(ntnum, title, content, pass, id)
values(ntnum_seq.nextVal, '공지사항 4번', '공지사항 4번의 내용', '1234', 'admin');
insert into notice(ntnum, title, content, pass, id)
values(ntnum_seq.nextVal, '공지사항 5번', '공지사항 5번의 내용', '1234', 'admin');


-- event DB내용
drop sequence evt_seq;
create sequence evt_seq start with 1;

select * from event;

insert into event(evnum, eimage, eimage2, title, evdate, evperson, pass, id)
values(evt_seq.nextVal, 'event1.jpg', 'mainevent1.png', '이벤트1', '22-07-20 ~ 22-07-28', '22-07-30', '1234', 'admin');
insert into event(evnum, eimage, eimage2, title, evdate, evperson, pass, id)
values(evt_seq.nextVal, 'event2.jpg', 'mainevent2.png', '이벤트2', '22-06-20 ~ 22-10-05', '22-10-15', '1234', 'admin');
insert into event(evnum, eimage, eimage2, title, evdate, evperson, pass, id)
values(evt_seq.nextVal, 'event3.jpg', 'mainevent3.png', '이벤트3', '22-08-02 ~ 22-08-30', '22-09-10', '1234', 'admin');


-- reply DB내용
drop sequence reply_seq;
create sequence reply_seq start with 1 increment by 1;

select * from reply;

insert into reply (replynum, evnum, content, rate, id)
values(reply_seq.nextVal, 1, '첫번째 댓글입니다.', 3 , 'scott');
insert into reply (replynum, evnum, content, rate, id)
values(reply_seq.nextVal, 1, '이벤트 좋아요.', 4 , 'scott');
insert into reply (replynum, evnum, content, rate, id)
values(reply_seq.nextVal, 1, '음?', 2 , 'scott');