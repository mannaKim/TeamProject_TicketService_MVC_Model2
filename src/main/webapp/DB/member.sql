drop sequence goods_seq;
create sequence goods_seq start with 1;

drop sequence goods_cart_seq;
create sequence goods_cart_seq start with 1;

drop sequence goods_orders_seq;
create sequence goods_orders_seq start with 1;

drop sequence goods_order_detail_seq;
create sequence goods_order_detail_seq start with 1;

select * from member;

insert into member(id,pwd,name,zip_num,address1,address2,phone,email) values
('one','1111','김나리','133-110','서울시 성동수 성수동1가','1번지21호','017-777-7777','abc@abc.com');

insert into member(id,pwd,name,zip_num,address1,address2,phone,email) values
('two','2222','김길동','130-120','서울시 송파구 잠실2동','리센츠 아파트 201동 505호','011-123-4567','acc@abc.com');