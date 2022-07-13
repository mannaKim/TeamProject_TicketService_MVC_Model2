function count(num){
	let q = document.goodsFrm.quantity.value;
	if(num==-1 && q>1) q--;
	else if (num==1) q++;
	document.goodsFrm.quantity.value = q;
}

function go_cart(){
	document.goodsFrm.action="ticket.do?command=goodsCartInsert";
	document.goodsFrm.submit();
}

function changeQuantity(num,gseq,quantity){
	if(num==-1 && quantity<=1) return;
	let url = "ticket.do?command=goodsCartInsert&gseq="+gseq+"&quantity="+num;
	location.href = url;
}

function go_cart_delete(){
	var count = 0;
	if(document.goodsCartFrm.gcseq.length == undefined){
		if(document.goodsCartFrm.gcseq.checked==true) count++;
	}else{
		for(var i=0; i<document.goodsCartFrm.gcseq.length; i++){
			if(document.goodsCartFrm.gcseq[i].checked==true) count++;
		}
	}
	
	if(count==0)
		alert("삭제할 항목을 선택하세요.");
	else{
		document.goodsCartFrm.action="ticket.do?command=goodsCartDelete";
		document.goodsCartFrm.submit();
	}
}

function go_order_insert(){
	document.goodsCartFrm.action="ticket.do?command=goodsOrderListInsert";
	document.goodsCartFrm.submit();
}

function go_order(){
	document.goodsCartFrm.action="ticket.do?command=goodsOrderInsert";
	document.goodsCartFrm.submit();
}