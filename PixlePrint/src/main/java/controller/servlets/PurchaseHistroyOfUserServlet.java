package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.PurchaseHistroyModel;
import utils.Utilities;

/**
 * Servlet implementation class PurchaseHistroyOfUserServlet
 */
@WebServlet("/PurchaseHistroyOfUserServlet")
public class PurchaseHistroyOfUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseHistroyOfUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if(username != null) {
			int userId = (int) request.getSession().getAttribute("userId");
			List<PurchaseHistroyModel> purchaseHistroy = dbController.getUserPruchaseHistroy(userId);
			request.setAttribute("purchaseHistroy", purchaseHistroy);
			request.getRequestDispatcher("/pages/PurchaseHistroy.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + Utilities.LOGIN_PAGE);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
