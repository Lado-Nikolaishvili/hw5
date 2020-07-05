<%@ page import="server.ShoppingCartManager" %>
<%@ page import="server.ShoppingCartManagerFactory" %>
<%@ page import="model.ItemInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/5/2020
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Shopping Cart</title>
</head>
<body>
<%
	ShoppingCartManager shoppingCartManager = ShoppingCartManagerFactory.getInstance();
	List<ItemInfo> addedItems = shoppingCartManager.getAddedItems();
%>
<h1>Shopping Cart</h1>
<form action="update" method="post">
	<ul>
		<%
			BigDecimal totalCount = BigDecimal.ZERO;
			for (ItemInfo itemInfo : addedItems) {
				out.println("<li> <input type ='number' value='" + itemInfo.getCount() + "' name='" + itemInfo.getItem().getId() + "'/> "
						+ itemInfo.getItem().getName() + ", " + itemInfo.getItem().getPrice() + "</li>");

				BigDecimal itemsPrice = itemInfo.getItem().getPrice().multiply(BigDecimal.valueOf(itemInfo.getCount()));
				totalCount = totalCount.add(itemsPrice);
			}
		%>
		Total: $<%=totalCount%> <input type="submit" value="Update Cart"/>
	</ul>
</form>
<a href="index.jsp">Continue Shopping</a>
</body>
</html>
