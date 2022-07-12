drop sequence goods_seq;
create sequence goods_seq start with 1;

delete from goods;

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'샤크 샤프 0.5mm','1',800,1600,800,'goods/goods_images/shark_pencil_2.jpg','goods/goods_images/shark_pencil_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'빈티지 금장 노트','1',12000,14000,2000,'goods/goods_images/note_2.jpg','goods/goods_images/note_1.jpg','y');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'스누피 에어팟 프로 케이스','2',10000,13800,3800,'goods/goods_images/airpods_case_2.jpg','goods/goods_images/airpods_case_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'미니가습기','2',12000,15800,3800,'goods/goods_images/humidifier_2.jpg','goods/goods_images/humidifier_1.jpg','y');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'버지니아 울프 주트백','3',15000,17800,2800,'goods/goods_images/bag1_2.jpg','goods/goods_images/bag1_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'본투리드 보냉백','3',15000,18800,3800,'goods/goods_images/bag2_2.jpg','goods/goods_images/bag2_1.jpg','y');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'D.I.Y 유화도구 세트 어쩌다 화가 - 피너츠','4',5000,9800,4800,'goods/goods_images/painting_pnt_2.jpg','goods/goods_images/painting_pnt_1.jpg','y');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'D.I.Y 유화도구 세트 어쩌다 화가 - 둘리','4',5000,8500,3500,'goods/goods_images/painting_DOOLY_2.jpg','goods/goods_images/painting_DOOLY_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'휴대가 편한 여행 슬리퍼 (파우치 포함)','5',10000,15800,5800,'goods/goods_images/slipper_2.jpg','goods/goods_images/slipper_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'피너츠 키링','5',5000,9800,4800,'goods/goods_images/peanuts_keyring_2.jpg','goods/goods_images/peanuts_keyring_1.jpg','n');

insert into goods(gseq,name,kind,price1,price2,price3,content,image,bestyn)
values(goods_seq.nextVal,'본투리드 카드지갑','5',7000,11800,4800,'goods/goods_images/card_holder_2.jpg','goods/goods_images/card_holder_1.jpg','y');

select * from goods;

-- 신상품 view 생성
create or replace view new_goods_view
as
select * from
(select rownum,gseq,name,price2,image from goods where useyn='y' order by indate desc)
where rownum<=8;

select * from new_goods_view;

-- 베스트 상품 view 생성
create or replace view best_goods_view
as
select * from
(select rownum,gseq,name,price2,image from goods where bestyn='y' order by indate desc)
where rownum<=4;

select * from best_goods_view;
