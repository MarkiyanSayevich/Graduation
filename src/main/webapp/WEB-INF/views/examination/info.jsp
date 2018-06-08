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
		<a href="/journal/examination/${patientIdModel}/${journalIdModel}" class="btn btn-primary"><span
			class="glyphicon glyphicon-arrow-left"></span> Назад </a>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12" style="margin-top: 20px">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Інформація про Обстеженя ...</h4>
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


								<div class="col-sm-5 col-xs-6 tital ">Дата регістрації:</div>
								<div class="col-sm-7 col-xs-6 ">${ examinationDtoModel.registrationDate }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Вік:</div>
								<div class="col-sm-7">${ examinationDtoModel.age }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Послуга:</div>
								<div class="col-sm-7">${ examinationDtoModel.service }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Ціна:</div>
								<div class="col-sm-7">${ examinationDtoModel.price }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Інструменти:</div>
								<div class="col-sm-7">${ examinationDtoModel.instruments }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Методи:</div>
								<div class="col-sm-7">${ examinationDtoModel.methods }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Висновки:</div>
								<div class="col-sm-7">${ examinationDtoModel.conclusion }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Скарги:</div>
								<div class="col-sm-7">${ examinationDtoModel.complaints }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Фактори ризику:</div>
								<div class="col-sm-7">${ examinationDtoModel.factors }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Діагноз:</div>
								<div class="col-sm-7">${ examinationDtoModel.diagnosis }</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Лакар:</div>
								<div class="col-sm-7">
									<a href="/employee/info/${ examinationDtoModel.employee.id }">
										${ examinationDtoModel.employee.fullName }</a>
								</div>

								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Кнопки:</div>
								<div class="col-sm-7">
									<a href="/journal/examination/info/edit/${ examinationDtoModel.id }" class="btn btn-xs btn-warning"><span
										class="glyphicon glyphicon-edit"></span> Редагувати</a> <a
										href="/journal/examination/delete/${patientIdModel}/${examinationIdModel}" class="btn btn-xs btn-danger"><span
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