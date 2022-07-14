drop sequence ticket_product_tpseq;
create sequence ticket_product_tpseq start with 1;

drop sequence ticket_cart_cseq;
create sequence ticket_cart_cseq start with 1;



insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, place, bestyn) 
values(ticket_product_tpseq.nextval, '1시간', '2022-07-10', '2022-07-20','1시', '2022 경기전 왕과의 산책', 
	5, '1.jpg', 15000, 10000, '전주한옥마을 경기전',  'n');

insert into ticket_product(tpseq, showtime, sdate, edate, daytime, name, age, image, price1, price2, place, bestyn) 
values(ticket_product_tpseq.nextval, '1시간20분', '2022-07-12', '2022-07-25','2시', '2022 CJ대한통운 슈퍼레이스 챔피언십 ROUND.4', 
	12, '2.jpg', 15000, 10000, '영암코리아 인터내셔널서킷 (국제 자동차 경주장)',  'n');
