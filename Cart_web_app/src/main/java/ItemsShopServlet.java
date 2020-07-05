import server.ShoppingCartManager;
import server.ShoppingCartManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/store")
public class ItemsShopServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCartManager shoppingCartManager = ShoppingCartManagerFactory.getInstance();

		String itemId = request.getParameter("itemId");
		long count = Long.parseLong(request.getParameter("count"));

		shoppingCartManager.store(itemId, count);

		request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
	}

}
