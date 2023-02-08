<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Cookies</title>
</head>
<body>
City = ${cookie.city.value}
<p></p>
<%
   Cookie[] cookies = request.getCookies(); 
   for(Cookie c : cookies)
	   out.println(c.getName() + " -  " + c.getValue() + "<p></p>");
%>

</body>
</html>