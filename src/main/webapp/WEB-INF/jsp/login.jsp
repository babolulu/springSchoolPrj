<%@ include file="common/IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>환영 : 온라인 학교</h1>
				<p>회원가입시 다양한 자료를 경험할 수 있습니다.</p>
			</div>
		</div>

		<div></div>
	</div>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="post"
							class="bs-example form-horizontal" commandName="studentLogin">
							<fieldset>
								<legend>로그인 해주세요!</legend>

								<div class="form-group">
									<label for="userNameInput" class="col-lg-3 control-label">사용자 아이디</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="emailAddress"
											id="userNameInput" placeholder="User Email" />
										<form:errors path="emailAddress" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">비밀번호</label>
									<div class="col-lg-9">
										<form:input type="password" class="form-control"
											path="password" id="passwordInput" placeholder="Password" />
										<form:errors path="password" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<!-- <button class="btn btn-default">Cancel</button> -->
									<button class="btn btn-primary">Login</button>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>