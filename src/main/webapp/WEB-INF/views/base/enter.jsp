<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		.red{
			color: red;
		}
	</style>
	
</head>
<body>

	<h2>Hello login please</h2>

	<form:form action="/enter" method="POST" modelAttribute="enterModel">
	
		Login: <form:input path="login"/><br>
		<form:errors path="login" cssClass="red" ></form:errors><br>
		
		Password: <form:password path="password"/><br>
		<form:errors path="password" cssClass="red" ></form:errors><br><br>
		
		<button type="submit"> Enter </button>
	</form:form>

</body>
</html>