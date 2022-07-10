<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="join_header.jsp" %>
<div>
	<ol>
		<li class="">약관동의</li>
		<li>정보입력</li>
		<li>가입완료</li>
	</ol>
</div>
<div class="clear"></div>
<article>
	<div>
		<h3>
			<span>약관에 동의해주세요</span>
		</h3>
	</div>
	<form method="post" name="termFrm">
		<div>
			<ul>
				<li>
					<span>
						<input id="termAll" name="termAll" type="checkbox" onclick="checkAll();">
						<label>모두 동의</label>
					</span>
				</li>
				<li>
					<span>
						<input name="term_agreement" type="checkbox" onclick="checkAllList();">
						<label>이용약관 (필수)</label>
					</span>
					<a href="#" onclick="showTerm(1)">내용보기</a>
				</li>
				<li>
					<span class="yesChk">
						<input name="term_agreement" type="checkbox" onclick="checkAllList();">
						<label>개인정보 수집 및 이용 동의 (필수)</label>
					</span>
					<a href="#" onclick="showTerm(2)">내용보기</a>
				</li>
				<li>
					<span class="yesChk">
						<input name="term_agreement" type="checkbox" onclick="checkAllList();">
						<label>개인정보 수집 및 이용 동의 (선택)</label>
					</span>
					<a href="#" onclick="showTerm(3)">내용보기</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<div>
			<input type="button" value="회원가입" onClick="go_joinForm();">
		</div>
	</form>
</article>
<%@ include file="../footer.jsp" %>