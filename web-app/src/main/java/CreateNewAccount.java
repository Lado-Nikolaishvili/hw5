import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/CreateNewAccount")
public class CreateNewAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountsManager accountsManager = AccountsManager.getInstance();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if(accountsManager.existsAccount(username)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("AccountExists.jsp");
			dispatcher.forward(request,response);
		}else{
			accountsManager.addAccount(username, password);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AccountCreated.jsp");
			dispatcher.forward(request,response);
		}

	}
}
