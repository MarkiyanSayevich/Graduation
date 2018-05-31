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

	<a href="/employee/add" >Add Employee</a><br>


	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<c:forEach items="${ employeesDtoModel }" var="employee">
					<td>${ employee.id }</td>
					<td>${ employee.fullName }</td>
					<td>${ employee.email }</td>
					<td><a href="#" >Info</a></td>
				</c:forEach>
			</tr>
		</tbody>
		
	</table>
	
</body>
</html>