package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class Medium
 */
@WebServlet("/RegisterSerlvet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("password2");
		CorrectUser cu = new CorrectUser(username,password,rePassword);
		
		switch(cu.validateNewUser()){
		case 1: 
			response.sendRedirect("UsernameBlank.jsp");
			break;
		case 2:
			response.sendRedirect("PasswordBlank.jsp");
			break;
		case 3:
			response.sendRedirect("PasswordMismatch.jsp");
			break;
		case 4:
			response.sendRedirect("UsernameTaken.jsp");
			break;
		case 5:
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
