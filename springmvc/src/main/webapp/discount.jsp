<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Discount Calculation</title>
</head>
<body>
	<h2>Discount Calculation</h2>
	<form method="post">
		Amount <br /> <input type="number" name="amount" value="${param.amount}" />
		<p></p>
		Discount Rate <br /> <input type="number" name="rate" value="${param.rate}" />
		<p></p>
		<input type="submit" value="Calculate" />
	</form>
    <h2>${result}</h2>
</body>
</html>