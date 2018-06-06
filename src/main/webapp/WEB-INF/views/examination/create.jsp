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

	<h3>Add new examination</h3>

	<form:form action="/journal/examination/create" method="POST" modelAttribute="examinationCreationDtoModel">
		Service: <form:input path="service"/><br>
		Price: <form:input path="price"/> <br>
		Instruments: <form:input path="instruments"/><br>
		Methods: <form:input path="methods"/><br>
		Conclusion: <form:input path="conclusion"/><br>
		Complaints: <form:input path="complaints"/><br>
		Factors: <form:input path="factors"/><br>
		Diagnosis: <form:input path="diagnosis"/><br>
		Employee: <form:select path="employee">
						<form:options items="${ employeesModel }" itemLabel="fullName" />
					</form:select><br>
					<input type="hidden" name="patientId" value="${ patientId }" ><br>
			<button type="submit" > Create new examination </button>
	</form:form>

</body>
</html>