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

function go_goodsInsert(){
	let url = "ticket.do?command=adminGoodsInsertForm";
	location.href = url;
}