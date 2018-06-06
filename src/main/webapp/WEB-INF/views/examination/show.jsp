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


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> Поліклініка </a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/main-page">Головна</a></li>
				<li><a href="/employee"> Лікарі </a></li>
				<li><a href="/patient"> Пацієнти </a></li>
				<li class="active"><a href="/journal"> Журнал обстежень</a></li>
				<li><a href="/company"> Страхові компанії</a></li>
				<li><a href="#">Про програму</a></li>
			</ul>
		</div>
	</nav>

	<div class="btn-toolbar" style="margin-bottom: 30px; margin-left: 10px">
		<a href="/journal/examination/create/${ patientIdModel }"
			class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>
			Додати </a>
	</div>


	<div class="alert alert-info">
	<h4>Про журнал</h4>
		<ul class="list-group">
			<li class="list-group-item">Нотатка: ${ notesModel }</li>
			<li class="list-group-item">Загальна ціна: ${ priceModel }</li>
		</ul>
	</div>

	<div class="alert alert-info">
		<strong>Список обстежень ... </strong>
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Ім'я пацієнта</th>
				<th>Дата регістрації</th>
				<th>Кнопки</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${ examinationsDtoModel }" var="examination">
				<tr>
					<td>${ examination.id }</td>
					<td>${ examination.patient.fullName }</td>
					<td>${ examination.registrationDate }</td>
					<td><a href="/journal/examination/info/${ examination.id }"
						class="btn btn-xs btn-primary"><span
							class="glyphicon glyphicon-exclamation-sign"></span> Інфо</a> <a
						href="/journal/examination/delete/${ examination.patient.id }/${ examination.id }"
						class="btn btn-xs btn-primary"><span
							class="glyphicon glyphicon-trash"></span> Видалити</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="navbar-text pull-center">
				<small>© 2018 - by MarkiyanSayevich , All rights reserved</small>
			</p>
		</div>
	</div>
</body>
</html>