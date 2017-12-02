package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatchController
 */
@WebServlet("/matches")
public class MatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("active", "matches");
		request.setAttribute("header_message", "SQL: SELECT * FROM matches;");
		request.setAttribute("green_button", "Ajouter un match");
		// set sql,description,table content: using the serviceResponse 
		
		request.getRequestDispatcher("crud.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
