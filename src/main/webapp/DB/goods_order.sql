-- orders 테이블
drop sequence orders_seq;
create sequence orders_seq start with 1;

select * from orders;


-- order_detail 테이블
drop sequence order_detail_seq;
create sequence order_detail_seq start with 1;

select * from ORDER_DETAIL;

-- order_datail에 orders,member,goods가 join된 view 생성
-- 1. orders테이블의 주문번호(oseq)에 따른 주문 goods들의 표시
-- 2. goods테이블의 굿즈번호(gseq)에 따른 상품 이름(gname)과 가격(price) 등의 정보 표시
-- 3. member테이블의 아이디에 따른 고객 이름(mname)과 배송주소(address1,2) 등의 정보 표시
create or replace view goods_order_view
as
select d.odseq, d.quantity, d.result,
	o.oseq, o.indate, o.id,
	m.name as mname, m.zip_num, m.address1, m.address2, m.phone,
	g.gseq, g.name as gname, g.price2 as price, g.image
from orders o, order_detail d, member m, goods g
where o.oseq=d.oseq and o.id=m.id and d.gseq=g.gseq;

select * from goods_order_view;

select distinct oseq
from GOODS_ORDER_VIEW;