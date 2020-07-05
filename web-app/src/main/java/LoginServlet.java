import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountsManager accountsManager = AccountsManager.getInstance();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if(accountsManager.existsAccount(username) && accountsManager.isPasswordCorrect(username,password)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("TryAgain.jsp");
			dispatcher.forward(request,response);
		}
	}
}
