<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> Here you can add new Employee </h2><br>
	
	<form:form action="/employee/add" modelAttribute="employeeDtoRegistrationModel" method="POST">
	
		Full Name: <form:input path="fullName"/><br>
		Email: <form:input path="email"/> <br>
		Phone Number : <form:input path="phoneNumber"/><br>
		Cabinet : <form:input path="cabinet"/><br>
		ScientificRank: <form:input path="scientificRank"/><br>
		Position: <form:input path="position"/><br>
		DB : <form:select path="theRightToWorkWithDatabase">
				<form:option value="true">Так</form:option>
				<form:option value="false">Ні</form:option>
			</form:select><br>
		Login: <form:input path="login"/><br>
		Password: <form:input path="password"/><br>
		
		<button type="submit" > Add employee </button><br>
	
	</form:form>
	
</body>
</html>