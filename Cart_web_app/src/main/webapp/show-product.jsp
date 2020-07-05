<%@ page import="dao.ItemDAO" %>
<%@ page import="dao.ItemDAOFactory" %>
<%@ page import="model.Item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	ItemDAO itemDAO = ItemDAOFactory.getInstance();
	Item item = itemDAO.find(request.getParameter("id"));
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><%=item.getName()%>
	</title>
</head>
<body>
<h1><%=item.getName()%>
</h1>
<img alt="<%=item.getName()%>" src="<%="/store-images/" + item.getImage()%>"/>

<form action="store" method="post">
	$<%=item.getPrice()%> <input name="itemId" type="hidden" value="<%=item.getId()%>"/>
	<input name="count" type="hidden" value="1"/>
	<input type="submit" value="Add to Cart"/>
</form>
</body>
</html>