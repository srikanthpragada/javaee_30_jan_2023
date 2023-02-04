<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>
</head>
<body>

	<%
	String input = request.getParameter("age");
	int age = Integer.parseInt(input);

	if (age < 30)
		out.println("<h1>Young!!!</h1>");
	else
		out.println("<h1>Not so young!!!</h1>");
	%>

</body>
</html>