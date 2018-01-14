package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoitierPrimaire;
import beans.Category;
import serviceactivity.BoitierService;
import serviceactivity.CategoryService;

/**
 * Servlet implementation class Visualisation
 */
@WebServlet("/Visualisation")
public class Visualisation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visualisation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoitierPrimaire> listeBoitier = BoitierService.getBoitierList();
		request.setAttribute("boitierList", listeBoitier);
		request.getRequestDispatcher("/visualiser_reseau.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String boitier = (String)request.getParameter("boitiername");
		BoitierPrimaire boitierSelect = BoitierService.getBoitierFromName(boitier);
		request.setAttribute("boitier", boitierSelect);
		doGet(request, response);
	}

}
