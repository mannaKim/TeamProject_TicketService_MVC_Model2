function adminCheck() {
	if(document.frm.id.value==""){
		alert("아이디를 입력하세요");
		document.frm.id.focus();
		return false;
	} else if(document.frm.pwd.value==""){
		alert("비밀번호를 입력하세요.");
		document.frm.pwd.focus();
		return false;
	}
	
	return true;
}