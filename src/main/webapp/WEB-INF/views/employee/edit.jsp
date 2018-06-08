<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" >
</head>
<body>

<div class="btn-toolbar" style="margin-top: 30px; margin-left: 105px">
		<a href="#" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>

	<form:form action="/employee/edit"
		modelAttribute="employeeDtoModel" method="POST"
		cssClass="form-horizontal">

	<form:hidden path="id"/>
	<form:hidden path="registrationDate"/>
	<form:hidden path="examinations"/>
	<form:hidden path="imageName"/>

		<fieldset>
			

			<legend class="text-center" >Редагувати інформацію про Лікаря</legend>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="fullName">Повне ім'я:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Повне ім'я"
						cssClass="form-control input-md" path="fullName" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="email">Емейл:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="example@mail.com"
						cssClass="form-control input-md" path="email" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="phoneNumber">Телефон:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="+380*********"
						cssClass="form-control input-md" path="phoneNumber" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="cabinet">Кабінет:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="каб.***"
						cssClass="form-control input-md" path="cabinet" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="scientificRank">Наукове звання:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Звання"
						cssClass="form-control input-md" path="scientificRank" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="position">Посада:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Посада"
						cssClass="form-control input-md" path="position" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label"
					path="theRightToWorkWithDatabase">Дозвіл на роботу з БД:</form:label>
				<div class="col-md-4">

					<form:select path="theRightToWorkWithDatabase"
						cssClass="form-control">
						<form:option value="true">Так</form:option>
						<form:option value="false">Ні</form:option>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="login">Логін:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="login"
						cssClass="form-control input-md" path="login" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="password">Пароль:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="***************"
						cssClass="form-control input-md" path="password" />
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