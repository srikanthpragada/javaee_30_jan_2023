<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale 3</title>
</head> 
<body>
	<h1>Sale 3</h1>
	<form action="sale3.jsp">
		Price <br /> <input type="number" name="price" value="${param.price}" />
		<p></p>
		Qty <br /> <input type="number" name="qty"  value="${param.qty}"  />
		<p></p>
		<button>Submit</button>
	</form>
	
	<jsp:useBean id="salesBean" class="beans.SalesBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="salesBean"/>
	<p></p>
	<h3>${salesBean.amount}</h3>
</body>
</html>