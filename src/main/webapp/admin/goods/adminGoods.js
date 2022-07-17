function go_totalGoodsList(){
	document.frm.key.value="";
	let url = "ticket.do?command=adminGoodsList&page=1";
	document.frm.action = url;
	document.frm.submit();
}

function go_goodsCategory(kind){
	let url = "ticket.do?command=adminGoodsList&page=1&kind="+kind;
	document.frm.action = url;
	document.frm.submit();
}

function go_searchGoodsList(){
	let url = "ticket.do?command=adminGoodsList&page=1";
	document.frm.action = url;
	document.frm.submit();
}

function go_goodsInsertForm(){
	let url = "ticket.do?command=adminGoodsInsertForm";
	location.href = url;
}

function go_goodsInsert(){
	if(document.frm.kind.value=="" || document.frm.kind.value==0){
		alert("상품분류를 선택하세요.");
		document.frm.kind.focus();
	}else if(document.frm.name.value==""){
		alert("상품명을 입력하세요.");
		document.frm.name.focus();
	}else if(document.frm.price1.value==""){
		alert("원가를 입력하세요.");
		document.frm.price1.focus();
	}else if(document.frm.price2.value==""){
		alert("판매가를 입력하세요.");
		document.frm.price2.focus();
	}else if(document.frm.content.value==""){
		alert("상품상세를 입력하세요.");
		document.frm.content.focus();
	}else if(document.frm.image.value==""){
		alert("상품 대표이미지를 입력하세요.");
		document.frm.image.focus();
	}else if(document.frm.detail_img.value==""){
		alert("상품 상세이미지를 입력하세요.");
		document.frm.image.focus();
	}else{
		document.frm.action="ticket.do?command=adminGoodsInsert";
		document.frm.submit();
	}
}

function calculatePrice(){
	if(document.frm.price1.value=="" || document.frm.price2.value=="") return;
	else document.frm.price3.value = document.frm.price2.value - document.frm.price1.value;
}
