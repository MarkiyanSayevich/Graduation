<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.red {
	color: red;
}
</style>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<form:form cssClass="form-horizontal" action="/" method="POST"
			modelAttribute="enterModel">
			<fieldset>

				<!-- Form Name -->
				<legend class="text-center">Увійти</legend>

				<!-- Text input-->
				<div class="form-group">
					<form:label cssClass="col-md-4 control-label" path="login">Логін</form:label>
					<div class="col-md-4">
						<form:input type="text" placeholder="введіть логін"
							cssClass="form-control input-md" path="login" />
						<form:errors path="login" cssClass="help-block"></form:errors>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<form:label cssClass="col-md-4 control-label" path="password">Пароль</form:label>
					<div class="col-md-4">
						<form:password cssClass="form-control input-md" path="password"
							placeholder="введіть пароль" />
						<form:errors path="password" cssClass="help-block red"></form:errors>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary center-block">Увійти</button>
					</div>
				</div>
			</fieldset>
		</form:form>
		
		<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="navbar-text pull-left"> <small>© 2018 -
				by MarkiyanSayevich , All rights reserved</small></p>
		</div>
	</div>
	</div>
</body>
</html>