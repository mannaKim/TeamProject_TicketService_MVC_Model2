drop sequence goods_cart_seq;
create sequence goods_cart_seq start with 1;

delete from GOODS_CART;

insert into GOODS_CART values(goods_cart_seq.nextVal,1,'1',sysdate,'one',1);
insert into GOODS_CART values(goods_cart_seq.nextVal,1,'1',sysdate,'one',2);

select * from goods_cart;



create or replace view goods_cart_view
as
select c.gcseq, c.id, c.gseq, c.quantity, c.result, c.indate,
m.name as mname, g.name as gname, g.price2 as price, g.image
from goods_cart c, goods g, member m
where c.gseq=g.gseq and c.id=m.id;

select * from goods_cart_view;



select quantity from goods_cart where id='one' and gseq=1 and result='1';
update goods_cart set quantity=3 where id='one' and gseq=1 and result='1';
update goods_cart set quantity=2, indate=sysdate 
where id='one' and gseq=2 and result='1';