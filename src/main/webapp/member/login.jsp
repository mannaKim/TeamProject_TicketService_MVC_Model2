<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="login_header.jsp" %>
<%@ include file="../header.jsp" %>

<article>
<div width="500px" height="500px"></div>
	<form method="post" name="loginFrm" action="ticket.do">
		<input type="hidden" name="command" value="login">
		<fieldset>
        	<label>User ID</label><input type="text" name="id"><br>
        	<label>Password</label><input type="password" name="pwd"><br>
        	<div>${message}</div>
    	</fieldset>
    	
    	<div id="buttons">
      		<input type="submit" value="Login" class="submit" onClick="return loginCheck();">
    	</div>
    	<ul>
    		<li><a href="#" onClick="findAccount('id');">아이디 찾기</a></li>
    		<li><a href="#" onClick="findAccount('pwd');">비밀번호 찾기</a></li>
    	</ul>
	</form>
</article>

<%@ include file="../footer.jsp" %>