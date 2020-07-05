<%@ page import="dao.ItemDAO" %>
<%@ page import="dao.ItemDAOFactory" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<html>
<head>
	<title>Student Store</title>
</head>
<body>
<h1>Student Store</h1>
<h2>Items available: </h2>
<%
	ItemDAO itemsDao = ItemDAOFactory.getInstance();
	List<Item> items = itemsDao.findAll();

	for (Item item : items) {%>
		<li><a href=show-product.jsp?id=<%=item.getId()%>><%=item.getName()%></a></li>
	<%}%>
</body>
</html>
