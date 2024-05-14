package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import utils.Utilities;

/**
 * Servlet implementation class MopdifyProductServlet
 */
@WebServlet("/MopdifyProductServlet")
public class MopdifyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MopdifyProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("Delete".equals(action)) { // Use equals() for string comparison
            int productId = Integer.parseInt(request.getParameter("productId"));
            System.out.println(productId);
            // Forward to doDelete() method
            request.setAttribute("deleteId", productId);
            doDelete(request, response);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Delete Triggered");
        int deleteId = Integer.parseInt(request.getParameter("productId"));
        if (dbController.deleteProduct(deleteId) == 1) {
            request.setAttribute(Utilities.SUCCESS_MESSAGE, Utilities.SUCCESS_DELETE_MESSAGE);
        } else {
            request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.ERROR_DELETE_MESSAGE);
        }
        response.sendRedirect(request.getContextPath() + "/DisplayProductServlet");
    }
}
