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
		<a href="/journal" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>
	
	<form:form action="/journal/create" method="POST"
		modelAttribute="journalDtoModel" cssClass="form-horizontal">
		<fieldset>

			<legend class="text-center">Новий Журнал обстежень</legend>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="patient">Статус пацієнта:</form:label>
				<div class="col-md-4">

					<form:select path="patient" cssClass="form-control">
						<form:options items="${ patientsDtoModel }" itemLabel="fullName" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-md-4 control-label" path="notes">Нотатки:</form:label>
				<div class="col-md-4">
					<form:input type="text" placeholder="..."
						cssClass="form-control input-md" path="notes" />
				</div>
			</div>

			<div class="col-md-12">
				<button type="submit" class="btn btn-primary center-block">
					Створити</button>
			</div>

		</fieldset>
	</form:form>

</body>
</html>