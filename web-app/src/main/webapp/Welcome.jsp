<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/5/2020
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Logged In</title>
</head>

<body>
	<header>
		<h1>Welcome <%= request.getParameter("name")%></h1>
	</header>

</body>
</html>
