<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
</head>
<body>
	<h1>Courses</h1>
	<c:forEach var="course" items="${courses}">
		<li>${course.title} - ${course.fee} - ${course.duration}</li>
	</c:forEach>

</body>
</html>