<%@ include file="common/IncludeTop.jsp"%>

<!-- 
	<legend>Student Enroll Login Success</legend>
	 -->
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3 class="panel-title">Student Enroll Login failure</h3>
	</div>
	<div class="panel-body">
		<div class="alert alert-dismissable alert-danger">
			<button type="button" class="close" data-dismiss="alert">에러예요</button>
			<strong>Sorry!</strong> try it again.
		</div>
	</div>
</div>
<div></div>
<div></div>

<a class="btn btn-primary" href="<spring:url value="login.html"/>">Try
	again?</a>
</body>
</html>