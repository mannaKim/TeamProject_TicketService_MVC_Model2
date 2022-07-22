drop sequence ticket_product_tpseq;
create sequence ticket_product_tpseq start with 1;

drop sequence ticket_cart_cseq;
create sequence ticket_cart_cseq start with 1;

select * from ticket_product;


insert into ticket_product(tpseq, showtime, daytime, name, age, image, price1, price2, price3, place, content )
values(ticket_product_tpseq.nextval, '50분', '1시', 'test', 5, '4.jpg', 10000, 5000, 1000, '서울', 'test');

insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, place, bestyn) 
values(ticket_product_tpseq.nextval, '1시간', '2022-07-10', '2022-07-20','1시', '2022 경기전 왕과의 산책', 
   5, '1.jpg', 15000, 10000, '전주한옥마을 경기전',  'n');

insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, place, bestyn) 
values(ticket_product_tpseq.nextval, '1시간20분', '2022-07-12', '2022-07-25','2시', '2022 CJ대한통운 슈퍼레이스 챔피언십 ROUND.4', 
   12, '2.jpg', 15000, 10000, '영암코리아 인터내셔널서킷 (국제 자동차 경주장)',  'n');
   
insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, price3, place, bestyn) 
values(ticket_product_tpseq.nextval, '총 50분', '2022-07-01', '2022-08-25','2시', 
   'IVEX 스튜디오 X 캐리와 친구들 썸머 스케이팅 페스타', 6, '3.jpg', 10000, 10000, 3000, 'IVEX 스튜디오(광명 AK프라자 5층)','n');
   
insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, price3, place, bestyn) 
values(ticket_product_tpseq.nextval, '총 50분', '2022-07-29', '2022-08-25','2시', 
   '테스트4', 6, '4.jpg', 10000, 10000, 3000, '테스트4','n');
	
create or replace view ticket_cart_view
as
select c.cseq, c.id, m.name as mname, c.tpseq, p.name as pname,
	c.choisdate, c.quantity1, c.quantity2, p.price1, p.price2, p.price3, p.daytime, p.edate, c.result, c.indate
from ticket_cart c, ticket_product p, member m
where c.tpseq = p.tpseq and c.id = m.id;