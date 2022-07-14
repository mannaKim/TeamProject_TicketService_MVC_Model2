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



function checkPass(noticeNum, popupName){
	var url = "ticket.do?command=noticecheck&ntnum=" + noticeNum;
	var opt = "toolbar=no, scrollbar=yes, menubar=no, resizable=no, width=500, height=300";
	window.open(url, popupName, opt);
}


function passCheck(){
	if(document.frm.pass.value==""){
		alert("관리자 비밀번호를 입력해주세요.");
		document.frm.pass.focus();
		return false;
	}
	return true;
	
}