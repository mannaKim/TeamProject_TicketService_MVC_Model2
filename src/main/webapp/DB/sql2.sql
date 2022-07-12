
/* Drop Tables */

DROP TABLE address CASCADE CONSTRAINTS;
DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE goods_cart CASCADE CONSTRAINTS;
DROP TABLE goods_review CASCADE CONSTRAINTS;
DROP TABLE order_detail CASCADE CONSTRAINTS;
DROP TABLE goods CASCADE CONSTRAINTS;
DROP TABLE introduce CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE qna CASCADE CONSTRAINTS;
DROP TABLE ticket_cart CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE ticket_product CASCADE CONSTRAINTS;
DROP TABLE worker CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE address
(
	zip_num varchar2(7) NOT NULL,
	sido varchar2(30) NOT NULL,
	gugun varchar2(30) NOT NULL,
	dong varchar2(100) NOT NULL,
	zip_code varchar2(30),
	bunji varchar2(30)
);


CREATE TABLE event
(
	-- 이벤트넘버
	enum number(10) NOT NULL,
	-- 이벤트이미지
	eimage varchar2(255) NOT NULL,
	-- 이벤트제목
	etitle varchar2(50) NOT NULL,
	-- 이벤트기간
	evdate varchar2(20),
	-- 당첨자발표날짜
	evperson varchar2(20),
	-- 게시글 삭제 비밀번호
	pass varchar2(30),
	readcount number(10) DEFAULT 0,
	-- 업로드날짜
	indate date DEFAULT SYSDATE,
	id varchar2(20) NOT NULL,
	PRIMARY KEY (enum)
);


CREATE TABLE goods
(
	gseq number(5) NOT NULL,
	name varchar2(100) NOT NULL,
	-- 카테고리
	kind char(1) NOT NULL,
	-- 원가
	price1 number(7),
	-- 판매가
	price2 number(7),
	-- 마진
	price3 number(7),
	content varchar2(1000),
	image varchar2(255),
	-- 상품 판매 유효 여부
	useyn char(1) DEFAULT 'y',
	bestyn char(1) DEFAULT 'n',
	-- 상품등록일
	indate date DEFAULT SYSDATE,
	PRIMARY KEY (gseq)
);


CREATE TABLE goods_cart
(
	g_cseq number(10) NOT NULL,
	quantity number(5) DEFAULT 1,
	result char(1) DEFAULT '1',
	indate date DEFAULT SYSDATE,
	id varchar2(20) NOT NULL,
	gseq number(5) NOT NULL,
	PRIMARY KEY (g_cseq)
);


CREATE TABLE goods_review
(
	g_rseq number(5) NOT NULL,
	subject varchar2(300) NOT NULL,
	content varchar2(1000) NOT NULL,
	indate date DEFAULT sysdate,
	image varchar2(255),
	id varchar2(20) NOT NULL,
	gseq number(5) NOT NULL,
	PRIMARY KEY (g_rseq)
);


CREATE TABLE introduce
(
	-- 소개게시판 번호
	itnum number(10) NOT NULL,
	-- 제목
	title varchar2(50) NOT NULL,
	-- 내용
	content varchar2(1000),
	-- 게시판생성날짜
	indate date DEFAULT SYSDATE,
	readcount varchar2(10) DEFAULT '0',
	pass varchar2(30),
	image varchar2(255),
	id varchar2(20) NOT NULL,
	PRIMARY KEY (itnum)
);


CREATE TABLE member
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(40) NOT NULL,
	zip_num varchar2(10),
	address1 varchar2(100),
	address2 varchar2(100),
	phone varchar2(20) NOT NULL,
	indate date DEFAULT SYSDATE,
	PRIMARY KEY (id)
);


CREATE TABLE notice
(
	-- 공지게시판 번호
	ntnum number(30) NOT NULL,
	-- 제목
	title varchar2(50) NOT NULL,
	-- 업로드날짜
	indate date DEFAULT SYSDATE NOT NULL,
	-- 내용
	content varchar2(1000),
	readcount number(10) DEFAULT 0,
	pass varchar2(30),
	id varchar2(20) NOT NULL,
	PRIMARY KEY (ntnum)
);


CREATE TABLE orders
(
	oseq number(10) NOT NULL,
	indate date DEFAULT SYSDATE,
	id varchar2(20) NOT NULL,
	PRIMARY KEY (oseq)
);


CREATE TABLE order_detail
(
	g_odseq number(10) NOT NULL,
	quantity number(5) DEFAULT 1,
	result char(1) DEFAULT '1',
	oseq number(10) NOT NULL,
	gseq number(5) NOT NULL,
	tpseq number(7) NOT NULL,
	PRIMARY KEY (g_odseq)
);


CREATE TABLE qna
(
	qseq number(5) NOT NULL,
	subject varchar2(300) NOT NULL,
	content varchar2(1000) NOT NULL,
	reply varchar2(1000),
	rep char(1) DEFAULT '1',
	indate date DEFAULT SYSDATE,
	id varchar2(20) NOT NULL,
	PRIMARY KEY (qseq)
);


CREATE TABLE reply
(
	-- 댓글순번
	replynum number(7) NOT NULL,
	-- 댓글 작성일
	writedate date DEFAULT SYSDATE,
	-- 작성내용
	content varchar2(1000),
	-- 이벤트넘버
	enum number(10) NOT NULL,
	id varchar2(20) NOT NULL,
	PRIMARY KEY (replynum)
);


CREATE TABLE ticket_cart
(
	cseq number(7) NOT NULL,
	quantity number(7),
	result char(1),
	indate date DEFAULT SYSDATE,
	id varchar2(20) NOT NULL,
	tpseq number(7) NOT NULL,
	PRIMARY KEY (cseq)
);


CREATE TABLE ticket_product
(
	tpseq number(7) NOT NULL,
	-- 공연관람시간
	showtime varchar2(20) NOT NULL,
	-- 공연기간
	showdate varchar2(50) NOT NULL,
	-- 공연입장시간/날짜 같이표시
	daytime varchar2(100) NOT NULL,
	-- 공연장소
	place varchar2(30) NOT NULL,
	name varchar2(30) NOT NULL,
	content varchar2(1000),
	age number(10),
	image varchar2(255),
	price number(7),
	bestyn char(1) DEFAULT 'n',
	indate date DEFAULT SYSDATE,
	PRIMARY KEY (tpseq)
);


CREATE TABLE worker
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE reply
	ADD FOREIGN KEY (enum)
	REFERENCES event (enum)
;


ALTER TABLE goods_cart
	ADD FOREIGN KEY (gseq)
	REFERENCES goods (gseq)
;


ALTER TABLE goods_review
	ADD FOREIGN KEY (gseq)
	REFERENCES goods (gseq)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (gseq)
	REFERENCES goods (gseq)
;


ALTER TABLE goods_cart
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE goods_review
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE orders
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE qna
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE reply
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE ticket_cart
	ADD FOREIGN KEY (id)
	REFERENCES member (id)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (oseq)
	REFERENCES orders (oseq)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (tpseq)
	REFERENCES ticket_product (tpseq)
;


ALTER TABLE ticket_cart
	ADD FOREIGN KEY (tpseq)
	REFERENCES ticket_product (tpseq)
;


ALTER TABLE event
	ADD FOREIGN KEY (id)
	REFERENCES worker (id)
;


ALTER TABLE introduce
	ADD FOREIGN KEY (id)
	REFERENCES worker (id)
;


ALTER TABLE notice
	ADD FOREIGN KEY (id)
	REFERENCES worker (id)
;



/* Comments */

COMMENT ON COLUMN event.enum IS '이벤트넘버';
COMMENT ON COLUMN event.eimage IS '이벤트이미지';
COMMENT ON COLUMN event.etitle IS '이벤트제목';
COMMENT ON COLUMN event.evdate IS '이벤트기간';
COMMENT ON COLUMN event.evperson IS '당첨자발표날짜';
COMMENT ON COLUMN event.pass IS '게시글 삭제 비밀번호';
COMMENT ON COLUMN event.indate IS '업로드날짜';
COMMENT ON COLUMN goods.kind IS '카테고리';
COMMENT ON COLUMN goods.price1 IS '원가';
COMMENT ON COLUMN goods.price2 IS '판매가';
COMMENT ON COLUMN goods.price3 IS '마진';
COMMENT ON COLUMN goods.useyn IS '상품 판매 유효 여부';
COMMENT ON COLUMN goods.indate IS '상품등록일';
COMMENT ON COLUMN introduce.itnum IS '소개게시판 번호';
COMMENT ON COLUMN introduce.title IS '제목';
COMMENT ON COLUMN introduce.content IS '내용';
COMMENT ON COLUMN introduce.indate IS '게시판생성날짜';
COMMENT ON COLUMN notice.ntnum IS '공지게시판 번호';
COMMENT ON COLUMN notice.title IS '제목';
COMMENT ON COLUMN notice.indate IS '업로드날짜';
COMMENT ON COLUMN notice.content IS '내용';
COMMENT ON COLUMN reply.replynum IS '댓글순번';
COMMENT ON COLUMN reply.writedate IS '댓글 작성일';
COMMENT ON COLUMN reply.content IS '작성내용';
COMMENT ON COLUMN reply.enum IS '이벤트넘버';
COMMENT ON COLUMN ticket_product.showtime IS '공연관람시간';
COMMENT ON COLUMN ticket_product.showdate IS '공연기간';
COMMENT ON COLUMN ticket_product.daytime IS '공연입장시간/날짜 같이표시';
COMMENT ON COLUMN ticket_product.place IS '공연장소';



