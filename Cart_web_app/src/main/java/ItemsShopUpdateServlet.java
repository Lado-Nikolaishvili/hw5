import server.ShoppingCartManager;
import server.ShoppingCartManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/update")
public class ItemsShopUpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCartManager shoppingCartManager = ShoppingCartManagerFactory.getInstance();

		Map<String, Long> carts = new HashMap<>();

		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String id = params.nextElement();
			long count = Long.parseLong(request.getParameter(id));
			if (count != 0) {
				carts.put(id, count);
			}
		}

		shoppingCartManager.update(carts);

		request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
	}

}
