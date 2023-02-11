<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="sales" class="beans.SalesBean" scope="page"/>

<%
   pageContext.setAttribute("name","Java EE");  // attribute in page
   request.setAttribute("name","Srikanth");  // attribute in request
%>
Page's Name : ${name} 
<br/>
Request's Name : ${requestScope.name}

<p/>
${sales.price} 
<br/>
Name : ${param.name}
<p/>
Request Header -> User-Agent : ${header["User-Agent"]}
<p/>
${cookie.city.value}
<p/>
${param.n1 + param.n2}
<p/>
${param.n1 == param.n2}
<p/>
${param.n1 > param.n2 ? "First":"Second"}

</body>
</html>