<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale 2</title>
</head> 
<body>
	<h1>Sale 2</h1>
	<form action="sale2.jsp">
		Price <br /> <input type="number" name="price" value="${param.price}" />
		<p></p>
		Qty <br /> <input type="number" name="qty" value="${param.qty}" />
		<p></p>
		<button>Submit</button>
	</form>

	<%
	String sprice = request.getParameter("price");
	if (sprice == null) // no parameter found
	   return; // stop JSP
	   
	   
    String sqty = request.getParameter("qty");
	int price = Integer.parseInt(sprice);
	int qty = Integer.parseInt(sqty);

	int amount = price * qty;
	int discount = amount * 20 / 100;
	int netAmount = amount - discount;

	out.println("<h1>Net Amount = " + netAmount + "</h1>");
	%>
</body>
</html>