package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DAOFactory;
import daos.ProductDAO;

/**
 * Servlet implementation class LoadPrdServlet
 */
@WebServlet("/LoadPrdServlet")
public class LoadPrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPrdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductDAO dao=DAOFactory.getProductDAO();		
		ArrayList<String> catlist=dao.getCategoryList();
		ArrayList<String> manufacturerlist=dao.getManufacturernName();
		ArrayList<String> shelflocation=dao.getShelfLocation();
		
		request.setAttribute("catlist", catlist);
		request.setAttribute("mlist", manufacturerlist);
		request.setAttribute("slocation", shelflocation);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/AddNewProduct.jsp");
		rd.forward(request, response);
	}

}
