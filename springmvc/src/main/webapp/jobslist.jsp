<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs List</title>
</head>
<body>
	<h2>Jobs</h2>
	
	<a href="/job/add">Add New Job</a>
	<p></p>

	<table style="width:100%" border="1"  cellpadding="5px" >
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Min. Salary</th>
			<th>Action</th>
		</tr>
		<tr>
			<c:forEach var="job" items="${jobs}">
				<tr>
					<td>${job.id}</td>
					<td>${job.title}</td>
					<td style="text-align:right">${job.minsal}</td>
					<td style="text-align:center">
					   <a href="employees?jobid=${job.id}">Employees</a>&nbsp; 
					   <a href="job/update/${job.id}">Edit </a> &nbsp;
					   <a href="job/delete/${job.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>