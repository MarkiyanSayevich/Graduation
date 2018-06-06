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

	<h2>Info</h2>
	Id: ${ companyDtoModel.id }<br>
	Name: ${ companyDtoModel.name }<br>
	Type: ${ companyDtoModel.type }<br>
	Address: ${ companyDtoModel.address }<br>
	Post Index: ${ companyDtoModel.postIndex }<br>

</body>
</html>