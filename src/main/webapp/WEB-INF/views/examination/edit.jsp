<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>

<div class="btn-toolbar" style="margin-top: 30px; margin-left: 105px">
		<a href="#" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>

	<form:form action="/journal/examination/info/edit" method="POST"
		modelAttribute="examinationDtoModel"
		cssClass="form-horizontal">

	 <form:hidden path="id"/>
	 <form:hidden path="registrationDate"/>
	 <form:hidden path="age"/>
	 <form:hidden path="patient"/>

		<fieldset>
			<legend class="text-center">Редагувати обстеження</legend>

			<input type="hidden" name="patientId" value="${ patientId }">

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="service">Послуги:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Послуги"
						cssClass="form-control input-md" path="service" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="price">Ціна:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="00.00"
						cssClass="form-control input-md" path="price" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="instruments">Інтрументи, препарати:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Інструменти"
						cssClass="form-control input-md" path="instruments" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="methods">Методи:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Методи"
						cssClass="form-control input-md" path="methods" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="conclusion">Висновки:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Висновки"
						cssClass="form-control input-md" path="conclusion" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="complaints">Скарги:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Скарги"
						cssClass="form-control input-md" path="complaints" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="factors">Фактори ризику:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Фактори"
						cssClass="form-control input-md" path="factors" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="diagnosis">Діагноз:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Діагноз"
						cssClass="form-control input-md" path="diagnosis" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="employee">Лікар:</form:label>
				<div class="col-md-4">

					<form:select path="employee" cssClass="form-control">
						<form:options items="${ employeesModel }" itemLabel="fullName" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary center-block">
						Створити</button>
				</div>
			</div>

		</fieldset>
	</form:form>

</body>
</html>