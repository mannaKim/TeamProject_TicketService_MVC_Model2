<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Term</title>
</head>
<body>
	<c:choose>
		<c:when test="${num=='1'}">
			<h1>11111111111111</h1>
		</c:when>
		<c:when test="${num=='2'}">
			<h1>2222222222222</h1>
		</c:when>
		<c:otherwise>
			<h1>3333333333333</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>