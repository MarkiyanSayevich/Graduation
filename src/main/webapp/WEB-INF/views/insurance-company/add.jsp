<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>

	<h2>Here you can add new Insurance Company</h2>
	
	<form:form action="/company/add" method="POST" modelAttribute="companyDtoRegistrationModel" >
		Name: <form:input path="name"/><br>
		Address: <form:input path="address"/><br>
		Type: <form:input path="type"/><br>
		Post Index: <form:input path="postIndex"/><br>
		
		<button type="submit" > Add Insurace Company </button>
	</form:form>
	
</body>
</html>