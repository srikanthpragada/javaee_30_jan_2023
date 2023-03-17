<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Job</title>
</head>
<body>
	<h1>Update Job</h1>
	<sf:form modelAttribute="job" method="post">
	Job Id <br />
		<sf:input path="id"  readonly="true" />
		<p></p>
	
	Job Title <br />
		<sf:input path="title" />
		<p></p>
	Min. Salary <br />
		<sf:input path="minsal" />
		<p></p>
		<button type="submit">Update Job</button>
	</sf:form>
</body>
</html>
