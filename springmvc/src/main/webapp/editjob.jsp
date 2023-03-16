<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Job</title>
</head>
<body>
	<h1>Edit Job</h1>
	<form method="post">
		Job Id *<br /> <input type="text" name="id" required />
		<p></p>
		Job Title *<br /> <input type="text" name="title" required /> <p></p>
		<input type="submit" value="Update Job" />
	</form>
    <h3>${message}</h3>
</body>
</html>
