<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jobs</title>
</head>
<body>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jan30", "root", "mysql");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from jobs");
	%>
	<table border="1" cellpadding="5pt">
		<tr>
			<th>Id</th>
			<th>Title</th>
		</tr>

		<%
		while (rs.next()) {
			out.println("<tr><td>" + rs.getString("id") + "</td><td>" + rs.getString("title") + "</td></tr>");
		}

		st.close();
		con.close();
		%>

	</table>

</body>
</html>