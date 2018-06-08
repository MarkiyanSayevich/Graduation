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


	<div class="container">
		<div class="row">
			<div class="col-md-12" style="margin-top: 20px">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Інформація про Страхову ...</h4>
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


								<div class="col-sm-5 col-xs-6 tital ">Назва:</div>
								<div class="col-sm-7 col-xs-6 ">${ companyDtoModel.name }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Тип:</div>
								<div class="col-sm-7">${ companyDtoModel.type }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Адреса:</div>
								<div class="col-sm-7">${ companyDtoModel.address }</div>
								<div class="clearfix"></div>
								<div class="bot-border"></div>

								<div class="col-sm-5 col-xs-6 tital ">Поштовий індекс:</div>
								<div class="col-sm-7">${ companyDtoModel.postIndex }</div>

								<div class="col-sm-5 col-xs-6 tital ">Кнопки:</div>
								<div class="col-sm-7">
									<a href="/company/info/edit/${ companyDtoModel.id }"
										class="btn btn-xs btn-warning"><span
										class="glyphicon glyphicon-edit"></span> Редагувати</a> <a
										href="/company/delete/${ companyDtoModel.id }"
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