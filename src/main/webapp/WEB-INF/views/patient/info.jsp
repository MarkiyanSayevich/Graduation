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

	Id: ${ patientDtoModel.id }<br>
	FullName: ${ patientDtoModel.fullName }<br>
	Birthday: ${ patientDtoModel.birthday }<br>
	Gender: ${ patientDtoModel.gender }<br>
	Address: ${ patientDtoModel.address }<br>
	PhoneNumber: ${ patientDtoModel.phoneNumber }<br>
	Card Number: ${ patientDtoModel.patientCardNumber }<br>
	Patient Status: ${ patientDtoModel.patientStatus }<br>
	RegistrationDate: ${ patientDtoModel.registrationDate }<br>
	InsuranceCompany: <a href="/company/info/${ patientDtoModel.insuranceCompany.id }" > ${ patientDtoModel.insuranceCompany.name } </a><br>
	

</body>
</html>