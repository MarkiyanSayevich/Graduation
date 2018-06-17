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

	<form:form action="/patient/info/edit"
		modelAttribute="patientEditRegistration" method="POST"
		cssClass="form-horizontal">

		<form:hidden path="id"/>
		<form:hidden path="registrationDate"/>
		<form:hidden path="admissionsJournals"/>
		<form:hidden path="examinations"/>

		<fieldset>

			<legend class="text-center">Редагувати інформацію про пацієнта</legend>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="fullName">Повне ім'я:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Повне ім'я"
						cssClass="form-control input-md" path="fullName" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="year">Рік:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="****"
						cssClass="form-control input-md" path="year" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="mounth">Місяць:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="**"
						cssClass="form-control input-md" path="mounth" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="day">День:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="**"
						cssClass="form-control input-md" path="day" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="gender">Стать:</form:label>
				<div class="col-md-4">

					<form:select path="gender" cssClass="form-control">
						<form:options items="${ genderModel }" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="address">Адрес:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Адреса"
						cssClass="form-control input-md" path="address" />
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
				<form:label cssClass="col-md-4 control-label"
					path="patientCardNumber">Номер карт пацієнта:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="№****"
						cssClass="form-control input-md" path="patientCardNumber" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="patientStatus">Статус пацієнта:</form:label>
				<div class="col-md-4">

					<form:select path="patientStatus" cssClass="form-control">
						<form:options items="${ statusModel }" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label"
					path="insuranceCompany">Страхова компанія:</form:label>
				<div class="col-md-4">

					<form:select path="insuranceCompany" cssClass="form-control">
						<form:options items="${ companiesModel }" itemLabel="name" />
					</form:select>
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