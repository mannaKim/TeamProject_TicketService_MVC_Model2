<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="join_header.jsp" %>
<div>
	<ol>
		<li>약관동의</li>
		<li class="">정보입력</li>
		<li>가입완료</li>
	</ol>
</div>
<div class="clear"></div>
<article>
	<form method="post" name="joinFrm">
		<fieldset>
			<label>아이디</label><input type="text" name="id" size="12">
			<input type="hidden" name="idCheck">
			<input type="button" value="중복체크" onclick="idcheck();"><br>
			<label>Password</label><input type="password" name="pwd"><br>
			<label>Password확인</label><input type="password" name="pwdCheck"><br>
			<label>Name</label><input type="text" name="name"><br>
			<label>E-Mail</label><input type="text" name="email"><br>
      		<label>주소</label><input type="text" name="zip_num" size="10">
      		<input type="button" value="주소 찾기" onclick="find_address();"><br>
      		<label>Address</label><input type="text" name="address1" size="50"><br>
      		<label>&nbsp;</label><input type="text" name="address2" size="25"><br>
      		<label>Phone Number</label><input type="text" name="phone"><br>
    	</fieldset>
    	<div class="clear"></div>
    	<div id="buttons">
      		<input type="button" value="회원가입" class="submit" onClick="go_join();">
      		<input type="reset" value="취소" class="cancel">
    	</div>
  	</form>
</article>
<%@ include file="../footer.jsp" %>
