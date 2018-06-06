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

	<h2>Info about examination</h2>

	Id: ${ examinationDtoModel.id }<br>
	Registration Date: ${ examinationDtoModel.registrationDate }<br>
	Age: ${ examinationDtoModel.age }<br>
	Service: ${ examinationDtoModel.service }<br>
	Price: ${ examinationDtoModel.price }<br>
	Instruments: ${ examinationDtoModel.instruments }<br>
	Methost: ${ examinationDtoModel.methods }<br>
	Conclusion: ${ examinationDtoModel.conclusion }<br>
	Complaints: ${ examinationDtoModel.complaints }<br>
	Factors: ${ examinationDtoModel.factors }<br>
	Diagnosis: ${ examinationDtoModel.diagnosis }<br>
	Employee: <a href="/employee/info/${ examinationDtoModel.employee.id }" > ${ examinationDtoModel.employee.fullName }</a><br>
	
</body>
</html>