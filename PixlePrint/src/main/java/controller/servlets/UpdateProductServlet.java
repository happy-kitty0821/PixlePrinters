package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.ProductModel;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName= request.getParameter("productName");
		String productDescription= request.getParameter("productDescription");
		double price= Double.parseDouble(request.getParameter("price"));
		String printSpeed= request.getParameter("printSpeed");
		String color= request.getParameter("color");
		String dimensions= request.getParameter("dimensions");
		ProductModel editProduct = new ProductModel(productId, productName, productDescription,  price, printSpeed, dimensions, color);
		DatabaseController databaseController = new DatabaseController();
		System.out.println(productName);
		databaseController.editProduct(editProduct);
		response.sendRedirect("/DisplayProductServlet");
		
	}

}
