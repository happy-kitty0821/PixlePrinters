package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import models.PurchaseModel;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
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
		String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
        	int productId = Integer.parseInt(request.getParameter("productId"));
        	int quantity = Integer.parseInt(request.getParameter("quantity"));
        	Double price = Double.parseDouble(request.getParameter("price"));
        	Double totalPrice = quantity * price;
        	int userId = (int) request.getSession().getAttribute("userId");
        	PurchaseModel purchaseModel = new PurchaseModel(quantity, totalPrice, userId, productId);
        	int result = dbController.purchaseProducts(purchaseModel, totalPrice);
        	System.out.println("purchase result is :  " + result);
        }
        else {
        	System.out.println("user is not logged in");
            response.sendRedirect(request.getContextPath() + "/pages/Login.jsp");
        }
	}

}
