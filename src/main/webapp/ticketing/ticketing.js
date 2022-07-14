function choiceDayCheck(  ){
	if(document.formm.selectedDate.value==""){
		alert("날짜를 선택해주세요");
		document.formm.selectedDate.focus();
		return;
	}
	
	document.formm.action="ticket.do?command=ticketingCart";
	document.formm.submit();
	
	//var url="ticket.do?command=ticketingCart&tpseq"+ tpseq;
	//var option="width=600, height=400, toolbar=no, menubar=no, resizable = no, scrollbars = no";
	//popup = window.open(url, 'ticketingCartList', option);
}

function go_CartList(  ){
	if(document.cartlist.quantity1.value=="0"){
		alert("예매권 수량을 먼저 선택 해주세요.");
		document.formm.selectedDate.focus();
		return;
	} else if (document.cartlist.quantity2.value=="0"){
		alert("예매권 수량을 먼저 선택 해주세요.");
		document.formm.selectedDate.focus();
		return;
	}
	document.formm.action="ticket.do?command=ticketingCartList";
	document.formm.submit();
}


function go_ticketing( ){
	document.formm.action="ticket.do?command=ticketing";
	document.formm.submit();
}

function showCheck(ticketNum) {
	document.frm.action = "ticket.do?command=showUpdate&tpseq="+ticketNum;
	document.frm.submit();
}

function showDelete(ticketNum) {
	alert("게시글을 삭제하시겠습니까?");
	document.frm.action = "ticket.do?command=showDelete&tpseq="+ticketNum;
	document.frm.submit();
}
