package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.CartModel;
import utils.Utilities;

/**
 * Servlet implementation class AddToCartServlets
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
        	System.out.println("Username is : " + username);
        	int productId = Integer.parseInt(request.getParameter("productId"));
    	    String productName = request.getParameter("productName");
    	    int quantity = Integer.parseInt(request.getParameter("quantity"));
    	    int userId = Integer.parseInt(request.getParameter("userId"));
    	    Double price = Double.parseDouble(request.getParameter("price"));
    	    CartModel cartModel = new CartModel(userId, productId, productName, quantity, price);
    	    int result = dbController.addProductToCart(cartModel);
            if (result == 1) {
                request.setAttribute(Utilities.SUCCESS_MESSAGE, "Product added to cart successfully");
            } 
            else {
                request.setAttribute(Utilities.ERROR_MESSAGE, "Failed to add product to cart");
            }
            request.getRequestDispatcher("/DisplayProductToCustomerServlet").forward(request, response);
    	}
        else {
        	System.out.println("user is not logged in");
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + Utilities.LOGIN_PAGE);
        }	
}

}
