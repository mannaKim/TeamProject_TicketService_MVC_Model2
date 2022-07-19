<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	if(window.name == 'update'){
		window.opener.location.href="ticket.do?command=updateNoticeForm&ntnum=${param.ntnum}";
	} else if(window.name == 'delete'){
		var bool = confirm("게시글을 삭제하시겠습니까?");
		if(bool) {
			window.opener.location.href="ticket.do?command=deleteNotice&ntnum=${param.ntnum}";
		}
	}
	self.close();
</script>
</body>
</html>