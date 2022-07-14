drop sequence goods_cart_seq;
create sequence goods_cart_seq start with 1;

select * from goods_cart;


-- 굿즈 정보, 회원 정보까지 보여주는 카트 뷰 생성
create or replace view goods_cart_view
as
select c.gcseq, c.id, c.gseq, c.quantity, c.result, c.indate,
m.name as mname, g.name as gname, g.price2 as price, g.image
from goods_cart c, goods g, member m
where c.gseq=g.gseq and c.id=m.id;

select * from goods_cart_view;