<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale</title>
</head>
<body>
<%
   int price = Integer.parseInt( request.getParameter("price"));
   int qty = Integer.parseInt( request.getParameter("qty"));
   
   int amount = price * qty;
   int discount = amount * 20 / 100;
   int netAmount = amount - discount;
   
   out.println("<h1>Net Amount = " + netAmount + "</h1>");

%>
</body>
</html>