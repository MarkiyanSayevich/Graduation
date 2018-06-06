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

	<h2>Create new journal</h2>

	<form:form action="/journal/create" method="POST" modelAttribute="journalDtoModel">
		Patient: <form:select path="patient">
					<form:options items="${ patientsDtoModel }" itemLabel="fullName"/>
				</form:select><br>
		Notes: <form:input path="notes"/><br>
		
		<button type="submit"> Create </button>
	</form:form>

</body>
</html>