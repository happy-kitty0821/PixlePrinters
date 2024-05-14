package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BrandModel;
import models.ProductModel;
import controller.DatabaseController;
/**
 * Servlet implementation class DisplayProductServlet
 */
@WebServlet("/DisplayProductServlet")
public class DisplayProductToAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductToAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		DatabaseController dbController = new DatabaseController();
		List<ProductModel> products = dbController.getProductsFromDatabase();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pages/AdminProducts.jsp").forward(request, response);
	}
}
