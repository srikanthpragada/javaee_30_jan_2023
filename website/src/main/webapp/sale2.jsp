<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale 2</title>
</head> 
<body>
    <%
      String sprice = request.getParameter("price");
      String sqty = request.getParameter("qty");
    %>
	<h1>Sale 2</h1>
	<form action="sale2.jsp">
		Price <br /> <input type="number" name="price" value=<%=sprice%> />
		<p></p>
		Qty <br /> <input type="number" name="qty" value=<%=sqty%> />
		<p></p>
		<button>Submit</button>
	</form>

	<%
	if (sprice == null) // no parameter found
	   return; // stop JSP
	
	int price = Integer.parseInt(sprice);
	int qty = Integer.parseInt(sqty);

	int amount = price * qty;
	int discount = amount * 20 / 100;
	int netAmount = amount - discount;

	out.println("<h1>Net Amount = " + netAmount + "</h1>");
	%>
</body>
</html>