function reply_check() {
	if(document.frm_event.id.value==""){
		alert("로그인을 먼저 해주세요.");
		document.frm_event.action = "ticket.do?command=loginForm";
		document.frm_event.submit();
		return false;
	} 
	
	if(document.frm_event.reply.value=="") {
		alert("내용을 입력해주세요");
		return false;
	}
	
	return true;
}




