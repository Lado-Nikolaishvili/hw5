<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/5/2020
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Create Account</title>
</head>
<body>
	<header>
		<h1>Create New Account</h1>
	</header>
	<p>please enter proposed name and password</p>

	<form action = "CreateNewAccount" method="post">
		<label>Username :</label>
		<input type = "name" name ="name" /><br>

		<label>Password : </label>
		<input type = "password" name ="password" />

		<input type="submit" value ="Create">
	</form>

</body>
</html>
