package class05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
			switch (action) {
				case "create":
					createUser(request, response);
					break;
				case "delete":
					deleteUser(request, response);
					break;
				case "update":
					updateUser(request, response);
					break;
				default:
					loginUser(request, response);
			}
	}
		
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usename = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userDao.findByUsername(usename);
		
		if (user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/class05/failure.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		userDao.save(newUser);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/class05/login.jsp");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		userDao.deleteByUsername(username);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/class05/login.jsp");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldUsername = request.getParameter("oldUsername");
		String newUsername = request.getParameter("newUsername");
		String newPassword = request.getParameter("newPassword");
		
		userDao.deleteByUsername(oldUsername);
		
		User updatedUser = new User(newUsername, newPassword);
		
		userDao.save(updatedUser);
		
		String contextPath = request.getC
		
	}

}
