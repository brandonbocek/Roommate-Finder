package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet/*")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> param = new ArrayList<String>();
		param.add(request.getParameter("username"));
		param.add(request.getParameter("age"));
		param.add(request.getParameter("myGender"));
		param.add(request.getParameter("otherGender"));
		param.add(request.getParameter("dirtiness"));
		param.add(request.getParameter("availability"));
		param.add(request.getParameter("personality"));
		param.add(request.getParameter("sound"));
		param.add(request.getParameter("game"));
		param.add(request.getParameter("mammal"));
		param.add(request.getParameter("reptile"));
		param.add(request.getParameter("night"));
		param.add(request.getParameter("morning"));
		param.add(request.getParameter("realName"));
		param.add(request.getParameter("email"));
		
		//put the updated data in the text file
		PreferencesController prefcon = new PreferencesController(param);
		prefcon.sendPersonalInfoToFile();
		
		//compare the updated data with everyone else's data
		Comparator c = new Comparator(param);
		c.setAllPercent();
		c.getAllPeopleInfo();
		
		//the array list is passed to the Welcome JSP to be displayed
		request.getSession().setAttribute("people", c.getAllPeopleInfo());
		request.getRequestDispatcher("Welcome.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
