<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>

<div class="btn-toolbar" style="margin-top: 30px; margin-left: 105px">
		<a href="/company" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>

	<form:form action="/company/add"
		modelAttribute="companyDtoRegistrationModel" method="POST"
		cssClass="form-horizontal">
		<fieldset>
			<legend class="text-center">Нова страхова компанія</legend>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="name">Назва:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Назва"
						cssClass="form-control input-md" path="name" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="address">Адреса:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Адреса"
						cssClass="form-control input-md" path="address" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="type">Тип:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Тип"
						cssClass="form-control input-md" path="type" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="postIndex">Поштовий індекс:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Індекс"
						cssClass="form-control input-md" path="postIndex" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary center-block">
						Додати</button>
				</div>
			</div>

		</fieldset>
	</form:form>

</body>
</html>