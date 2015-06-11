package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDTO;
import model.ProductInventoryDTO;
import model.ProductStockDTO;
import daos.DAOFactory;
import daos.ProductDAO;
import daos.ProductInventoryDAO;
import daos.ProductStockDAO;

/**
 * Servlet implementation class UpdateInventoryServlet
 */
@WebServlet("/udinventory")
public class UpdateInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductStockDAO ps = DAOFactory.getProductStockDAO();
		ArrayList<ProductStockDTO> pslist = ps.getAllProductList();
		request.setAttribute("productlist", pslist);
		ProductDAO p = DAOFactory.getProductDAO();
		ArrayList<String> category = p.getCategoryList();
		request.setAttribute("catlist", category);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/UpdateInventoryStock.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("partNo"));
		int total = Integer.parseInt(request.getParameter("total"));
		int available = Integer.parseInt(request.getParameter("available"));
		int damaged = Integer.parseInt(request.getParameter("damaged"));
		ProductInventoryDAO pinv = DAOFactory.getProductInventoryDAO();
		if(pinv.updateInventoryProduct(pno, total, damaged, available)){
			request.setAttribute("success", "true");
		}
		else{
			request.setAttribute("success", "false");
		}
		ProductStockDAO ps = DAOFactory.getProductStockDAO();
		ArrayList<ProductStockDTO> pslist = ps.getAllProductList();
		request.setAttribute("productlist", pslist);
		ProductDAO p = DAOFactory.getProductDAO();
		ArrayList<String> category = p.getCategoryList();
		request.setAttribute("catlist", category);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/UpdateInventoryStock.jsp");
		rd.forward(request, response);
	}

}
