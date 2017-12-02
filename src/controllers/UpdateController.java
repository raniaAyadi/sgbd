package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Championnat;
import DAO.ChampionnatDAO;
import DAO.ChampionnatDAOImp;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("EC") == null){ // entity code
			request.getRequestDispatcher("update_error").forward(request, response);
		}
	
		
		if(request.getParameter("update") != null){
			handelUpdate(request,response);
		}else if(request.getParameter("delete") != null){
			handelDelete(request,response);
		}else if(request.getParameter("create") != null){
			handelCreate(request,response);
		}
	}
	
	protected void handelUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id = (String) request.getParameter("id");
		int entity_code =  Integer.parseInt((String) request.getParameter("EC"));
		switch(entity_code){
		case EC.CHAMPIONNAT: 
			
			
			//ChampionnatDAO dao = new ChampionnatDAOImp();
			//Championnat c = dao.findById(   new Integer(  id));
			
			// testing
			Championnat c = new Championnat();
			c.setDate_debut(new Date(entity_code));
			c.setDate_fin(new Date(entity_code));
			c.setNiveau("niveau debutant");
			
			
			request.setAttribute("championnat", c);
			request.getRequestDispatcher("update_championnat.jsp").forward(request, response);
		break;
		case EC.CLUB:
			
			request.getRequestDispatcher("update_clubs.jsp").forward(request, response);
		break;
		case EC.ENTRAINEUR:
		break;	
		}
	}
	
	protected void handelDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = (String) request.getParameter("id");
		int entity_code =  Integer.parseInt((String) request.getParameter("EC"));
		switch(entity_code){
		case EC.CHAMPIONNAT: 
			// serviceChampionat.delete(id);
			response.sendRedirect("/sgbd/championnats");
		break;
		case EC.CLUB:
			// serviceClub.delete(id);
			response.sendRedirect("/sgbd/clubs");
		break;
		case EC.ENTRAINEUR:
		break;	
		}
	}
	
	protected void handelCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int entity_code =  Integer.parseInt((String) request.getParameter("EC"));
		switch(entity_code){
		case EC.CHAMPIONNAT:
			request.setAttribute("EC", EC.CHAMPIONNAT);
			request.getRequestDispatcher("update_championnat.jsp").forward(request,response);
		break;
		case EC.CLUB:
			request.setAttribute("EC", EC.CLUB);
			request.getRequestDispatcher("update_club.jsp").forward(request,response);
		break;
		case EC.ENTRAINEUR:
			request.setAttribute("EC", EC.ENTRAINEUR);
			request.getRequestDispatcher("update_entraineur.jsp").forward(request,response);
		break;	
		}
		// ...
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("update") != null)
			updateInDatabase(request,response);
		else
			addToDataBase(request,response);
	}

	private void addToDataBase(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getParameter("id");
		int entity_code =  Integer.parseInt((String) request.getParameter("EC"));
		switch(entity_code){
		case EC.CHAMPIONNAT:
			Championnat c = new Championnat();
			// c.set c.set ....
			// dao.add(c)
			System.out.println(request.getParameter("date_debut"));
			System.out.println(request.getParameter("date_fin"));
			System.out.println(request.getParameter("niveau"));
			response.sendRedirect("/sgbd/championnats?id=");
		break;
		case EC.CLUB:
		break;
		case EC.ENTRAINEUR:
		break;	
		}
	}
	
	
	
	
	void updateInDatabase(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = (String) request.getParameter("id");
		int entity_code =  Integer.parseInt((String) request.getParameter("EC"));
		switch(entity_code){
		case EC.CHAMPIONNAT:
			Championnat c = new Championnat();
			// c.set c.set ....
			// dao.update(c)
			System.out.println(request.getParameter("date_debut"));
			System.out.println(request.getParameter("date_fin"));
			System.out.println(request.getParameter("niveau"));
			response.sendRedirect("/sgbd/championnats?id=");
		break;
		case EC.CLUB:
		break;
		case EC.ENTRAINEUR:
		break;	
		}	
	}
}
