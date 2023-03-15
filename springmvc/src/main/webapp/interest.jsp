<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interest Calculation</title>
</head>
<body>
	<h2>Interest Calculation</h2>
	<form method="post">
		Amount <br /> <input type="number" name="amount" value="${param.amount}" />
		<p></p>
		<input type="submit" value="Calculate" />
	</form>
    <h2>${interest}</h2>
</body>
</html>