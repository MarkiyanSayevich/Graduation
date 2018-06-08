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
		<a href="/patient" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12" style="margin-top: 20px">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Інформація про Пацієнта</h4>
					</div>
					<div class="panel-body">

						<div class="box box-info">

							<div class="box-body">
								<div class="col-sm-6">
									<br>
								</div>
								<div class="col-sm-6"></div>
								<div class="clearfix"></div>
								<hr style="margin: 5px 0 5px 0;">


								<div class="col-sm-5 col-xs-6 tital ">Ім'я:</div>
								<div class="col-sm-7 col-xs-6 ">${ patientDtoModel.fullName }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Дата народження:</div>
								<div class="col-sm-7">${ patientDtoModel.birthday }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Стать:</div>
								<div class="col-sm-7">${ patientDtoModel.gender }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Адреса:</div>
								<div class="col-sm-7">${ patientDtoModel.address }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Телефон:</div>
								<div class="col-sm-7">${ patientDtoModel.phoneNumber }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Номер карти
									пацієнта:</div>
								<div class="col-sm-7">${ patientDtoModel.patientCardNumber }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Статус пацієнта:</div>
								<div class="col-sm-7">${ patientDtoModel.patientStatus }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Дата регістрації:</div>
								<div class="col-sm-7">${ patientDtoModel.registrationDate }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Страхова компанія:</div>
								<div class="col-sm-7">
									<a
										href="/company/info/${ patientDtoModel.insuranceCompany.id }">
										${ patientDtoModel.insuranceCompany.name } </a>
								</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Кнопки:</div>
								<div class="col-sm-7">
									<a href="/patient/info/edit/${ patientDtoModel.id }"
										class="btn btn-xs btn-warning"><span
										class="glyphicon glyphicon-edit"></span> Редагувати</a> <a
										href="/patient/delete/${ patientDtoModel.id }"
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
</body>
</html>