<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/5/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Try Again</title>
</head>
<body>
	<header>
		<h1>Please Try Again</h1>
	</header>

	<p>Your user name or password are incorrect. Please try again</p>

	<form action = "LoginServlet" method="post">
		<label>Username :</label>
		<input type = "name" name ="name" /><br>

		<label>Password : </label>
		<input type = "password" name ="password" />

		<input type="submit" value ="Login">
	</form>
	<a href="">Create New Account </a>
</body>
</html>
