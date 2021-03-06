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

	<c:url var="firstUrl"
		value="/company/filter?page=0&name=${ filter.name }&size=${ sizeModel }" />
	<c:url var="lastUrl"
		value="/company/filter?page=${ page.totalPages - 1 }&name=${ filter.name }&size=${ sizeModel }" />

	<c:url var="nextUrl"
		value="/company/filter?page=${ currentPage + 1 }&name=${ filter.name }&size=${ sizeModel }" />
	<c:url var="prevUrl"
		value="/company/filter?page=${ currentPage - 1 }&name=${ filter.name }&size=${ sizeModel }" />


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> Поліклініка </a>
			</div>
			<ul class="nav navbar-nav">
				<!-- <li class="active"><a href="/main-page">Головна</a></li>-->
				<li><a href="/employee"> Лікарі </a></li>
				<li><a href="/patient"> Пацієнти </a></li>
				<li><a href="/journal"> Журнал обстежень</a></li>
				<li class="active"><a href="/company"> Страхові компанії</a></li>
			</ul>
			<form:form cssClass="navbar-form navbar-right"
				action="/company/filter" modelAttribute="filterModel" method="GET">
				<div class="form-group">
					<form:input type="text" cssClass="form-control" placeholder="Пошук"
						path="name" />
				</div>
				<form:select cssClass="form-control" path="size">
					<form:option value="10">10</form:option>
					<form:option value="20">20</form:option>
					<form:option value="30">30</form:option>
					<form:option value="40">40</form:option>
					<form:option value="50">50</form:option>
				</form:select>
				<button type="submit" class="btn btn-primary">Знайти</button>
			</form:form>

		</div>
	</nav>

	<div class="btn-toolbar" style="margin-bottom: 30px; margin-left: 10px">
		<a href="company/add" class="btn btn-primary"><span
			class="glyphicon glyphicon-plus"></span> Додати</a>
	</div>


	<div class="alert alert-info">
		<strong>Список страхових ... </strong>
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Назва</th>
				<th>Адреса</th>
				<th>Кнопки</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ companiesModel }" var="company">
				<tr>
					<td>${ company.id }</td>
					<td>${ company.name }</td>
					<td>${ company.address }</td>
					<td><a href="/company/info/${ company.id }"
						class="btn btn-xs btn-primary"><span
							class="glyphicon glyphicon-exclamation-sign"></span> Інфо</a> <a
						href="/company/delete/${ company.id }"
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
			<ul class="pagination navbar-right">
				<c:choose>
					<c:when test="${ currentPage == 0 }">
						<li class="disabled"><a href="#">&lt;&lt;</a></li>
						<li class="disabled"><a href="#">&lt;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${ firstUrl }">&lt;&lt;</a></li>
						<li><a href="${ prevUrl }">&lt;</a></li>
					</c:otherwise>
				</c:choose>

				<li class="active"><a>${ currentPage + 1 }</a></li>

				<c:choose>
					<c:when test="${ currentPage + 1  == pageModel.totalPages}">
						<li class="disabled"><a href="#">&gt;</a></li>
						<li class="disabled"><a href="#">&gt;&gt;</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="${ nextUrl }">&gt;</a></li>
						<li><a href="${ lastUrl }">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</div>
</body>
</html>