package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginController lc = new LoginController(username, password);
		
		//making the comparisons for Welcome.jsp to display
		Comparator comp = new Comparator(username);
		comp.setAllPercent();
		
		//try to sign in
		switch(lc.validateLogin()){
		case 1:					//username doesn't exist in the text file
			response.sendRedirect("Register.jsp");
			break;
		case 2:					//password is incorrect
			response.sendRedirect("Login.jsp");
			break;
		case 3:					//success logging in
			request.getSession().setAttribute("people", comp.getAllPeople());
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
