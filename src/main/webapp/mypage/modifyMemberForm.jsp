<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>
<article>
	<br><br>
	<form method="post" name="frm">
		<fieldset>
			<label>아이디</label><input type="text" name="id" size="12" value="${loginUser.id}" readonly><br>
			<label>Password</label><input type="password" name="pwd"><br>
			<label>Password확인</label><input type="password" name="pwdCheck"><br>
			<label>Name</label><input type="text" name="name" value="${loginUser.name}"><br>
			<label>E-Mail</label><input type="text" name="email" value="${loginUser.email}"><br>
      		<label>주소</label><input type="text" name="zip_num" size="10" value="${loginUser.zip_num}">
      		<input type="button" value="주소 찾기" onclick="find_address();"><br>
      		<label>Address</label><input type="text" name="address1" size="50" value="${loginUser.address1}"><br>
      		<label>&nbsp;</label><input type="text" name="address2" size="25" value="${loginUser.address2}"><br>
      		<label>Phone Number</label><input type="text" name="phone" value="${loginUser.phone}"><br>
    	</fieldset>
    	<div class="clear"></div>
    	<div id="buttons">
      		<input type="button" value="수정" onClick="go_modify();">
      		<input type="reset" value="취소">
    	</div>
  	</form>
  	<br><br>
</article>
<%@ include file="../footer.jsp" %>