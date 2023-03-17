<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<h2>Employees of Job -> ${job}</h2>

	<table style="width:100%;cell-padding:5px" border="1"  >
		<tr>
			<th>Id</th>
			<th>Fullname</th>
			<th>Salary</th>
		</tr>
		<tr>
			<c:forEach var="emp" items="${employees}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td style="text-align:right">${emp.salary}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>