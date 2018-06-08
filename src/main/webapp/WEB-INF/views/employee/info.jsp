<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

	<div class="btn-toolbar" style="margin-top: 30px; margin-left: 95px">
		<a href="/employee" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-md-12" style="margin-top: 20px">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Інформація про Лікаря</h4>
					</div>
					<div class="panel-body">

						<div class="box box-info">

							<div class="box-body">
								<div class="col-sm-6">
									<div align="center">
										<img alt="User Pic" src="data:image/png;base64, ${ imgSrc }"
											id="profile-image1" class="img-circle img-responsive">
									</div>

									<br>
								</div>
								<div class="col-sm-6">

									<form action="/employee/info/${ employeeDtoModel.id }"
										method="POST" enctype="multipart/form-data">
										<input id="filebutton" name="file" class="input-file"
											type="file"><br>
										<button type="submit">Змінити фото</button>
									</form>

								</div>
								<div class="clearfix"></div>
								<hr style="margin: 5px 0 5px 0;">


								<div class="col-sm-5 col-xs-6 tital ">Ім'я:</div>
								<div class="col-sm-7 col-xs-6 ">${ employeeDtoModel.fullName }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Емейл:</div>
								<div class="col-sm-7">${ employeeDtoModel.email }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Телефон:</div>
								<div class="col-sm-7">${ employeeDtoModel.phoneNumber }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Кабінет:</div>
								<div class="col-sm-7">${ employeeDtoModel.cabinet }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Наукове звання:</div>
								<div class="col-sm-7">${ employeeDtoModel.scientificRank }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Посада:</div>
								<div class="col-sm-7">${ employeeDtoModel.position }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Дата регістрації:</div>
								<div class="col-sm-7">${ employeeDtoModel.registrationDate }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Кнопки:</div>
								<div class="col-sm-7">
									<a href="/employee/edit/${ employeeDtoModel.id }"
										class="btn btn-xs btn-warning"><span
										class="glyphicon glyphicon-edit"></span> Редагувати</a> <a
										href="/employee/delete/${ employeeDtoModel.id }"
										class="btn btn-xs btn-danger"><span
										class="glyphicon glyphicon-trash"></span> Видалити</a>
								</div>
							</div>


						</div>


					</div>
				</div>
			</div>
		</div>
	</div>

	<!--<div class="alert alert-info">
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
	</table>-->
</body>
</html>