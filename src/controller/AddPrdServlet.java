package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductDTO;
import model.ProductInventoryDTO;
import daos.DAOFactory;
import daos.ProductDAO;
import daos.ProductInventoryDAO;

/**
 * Servlet implementation class AddPrdServlet
 */
@WebServlet("/AddPrdServlet")
public class AddPrdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=true;
		
		
		String partname=request.getParameter("partname");
		double price=Double.parseDouble(request.getParameter("price"));
		String des=request.getParameter("des");
		String color=request.getParameter("color");
		String dim=request.getParameter("dim");
		String cat=request.getParameter("cat");
		String man=request.getParameter("man");
		int reorder=Integer.parseInt(request.getParameter("reorder"));
		int reqty=Integer.parseInt(request.getParameter("reqty"));
		String loc=request.getParameter("loc");
		int total=Integer.parseInt(request.getParameter("total"));
		
		ProductDAO dao=DAOFactory.getProductDAO();			
		ProductDTO p=new ProductDTO(dao.getAutoPartNo(),partname, price , des, color, dim, cat, man, reorder,reqty , loc);
		
		ProductInventoryDAO daoInv=DAOFactory.getProductInventoryDAO();
		ProductInventoryDTO pInv=new ProductInventoryDTO(dao.getAutoPartNo(), total, 0,total);
	    dao.createNewProduct(p);
	    daoInv.insertProduct(pInv);
	    
	    
	    String path="";
	    
	    if(flag==true){
	    	path+="/pages/AddNewProduct.jsp";
	    	request.setAttribute("origin", "true");
	    }
	    else
	    {
	    	path+="/pages/AddNewProduct.jsp";
	    	request.setAttribute("origin", "false");
	    }
		
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
