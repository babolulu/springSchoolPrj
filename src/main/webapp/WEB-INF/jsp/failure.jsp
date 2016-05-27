<%@ include file="common/IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!-- 
	<legend>Student Enroll Login Success</legend>
	 -->
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3 class="panel-title">로그인 실패</h3>
	</div>
	<div class="panel-body">
		<div class="alert alert-dismissable alert-danger">
			<button type="button" class="close" data-dismiss="alert">지우기</button>
			<strong>죄송합니다. </strong> 다시 로그인 해주세요.
		</div>
	</div>
</div>
<div></div>
<div></div>

<a class="btn btn-primary" href="<spring:url value="login.html"/>">다시 로그인</a>
</body>
</html>