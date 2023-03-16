<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Job</title>
</head>
<body>
	<h1>Add New Job</h1>
	<form method="post">
		Job Id <br /> <input type="text" name="id" />
		<p></p>
		Job Title <br /> <input type="text" name="title" />
		<p></p>
		Minimum Salary <br /> <input type="number" name="minsal" />
		<p></p>
		<input type="submit" value="Add Job" />
	</form>
    <h3>${message}</h3>
</body>
</html>
