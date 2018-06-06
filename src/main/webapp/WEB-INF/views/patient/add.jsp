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

	<h2>Here you can Add Patient</h2><br>

	<form:form action="/patient/add" modelAttribute="patientDtoRegistrationModel" method="POST">
		Full Name: <form:input path="fullName"/><br>
		<h4>BirthDay</h4>
		Year:<form:input path="year"/>
		Mounth:<form:input path="mounth"/>
		Day:<form:input path="day"/><br>
		Gender: <form:select path="gender">
					<form:options items="${ genderModel }" />
				</form:select><br>
		Address: <form:input path="address"/><br>
		Phone Number: <form:input path="phoneNumber"/><br>
		Patient Card Number: <form:input path="patientCardNumber"/><br>
		Patient Status: <form:select path="patientStatus">
							<form:options items="${ statusModel }"/>
						</form:select><br>
		InsuraceCompany: <form:select path="insuranceCompany">
							<form:options items="${ companyModel }" itemLabel="name"/>
						</form:select><br>
								
		<button type="submit">Add Patient</button>
				
	</form:form>

</body>
</html>