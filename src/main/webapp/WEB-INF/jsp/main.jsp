<%@ include file="common/IncludeTopMain.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!-- 
	<legend>Student Enroll Login Success</legend>
	 -->

<div class="panel panel-success">
	<div class="panel-heading">
		<h3 class="panel-title text-right">
		<c:if test="${not empty nickName}">
			<div class="message green">${nickName}님 <a href="logout.html">Logout</a></div>
		</c:if>
</h3>
	</div>
	<div class="panel-body">
		<div class="alert alert-dismissable alert-success">
			<button type="button" class="close" data-dismiss="alert">지우기</button>
			메인 입니다, 여려분의 <strong>꿈</strong>을 펼쳐 보세요.
		</div>
	</div>
</div>
<div></div>
<div></div>
<a class="btn btn-primary" href="<spring:url value="#"/>">
	테스트 버튼</a>
</body>
</html>