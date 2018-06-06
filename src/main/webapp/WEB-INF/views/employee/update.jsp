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

	<form:form action="/employee/info/update" method="POST" modelAttribute="employeeDtoModel">
		<form:hidden path="id"/>
		<form:hidden path="registrationDate"/>
		FullName: <form:input path="fullName"/><br>
		Email: <form:input path="email"/><br>
		Phone Number: <form:input path="phoneNumber"/><br>
		Cabinet: <form:input path="cabinet"/><br>
		Scientific Rank: <form:input path="scientificRank"/><br>
		Position: <form:input path="position"/><br>
		
		<button type="submit" > Commit </button>
	</form:form>

</body>
</html>