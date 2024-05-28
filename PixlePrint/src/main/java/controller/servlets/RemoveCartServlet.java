package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import utils.Utilities;

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DatabaseController dbController = new DatabaseController();

    public RemoveCartServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int result = dbController.removeCartItems(userId, productId);

        if (result == 0) {
            request.setAttribute(Utilities.SUCCESS_MESSAGE, "Product removed from cart successfully.");
            System.out.print("yay");
        } 
        else if(result == 1) {
        	request.setAttribute(Utilities.ERROR_MESSAGE, "Failed to remove product from cart.");
        }
        else {
            request.setAttribute(Utilities.ERROR_MESSAGE, "Failed to remove product from cart.");
            System.out.print("yay");
        }
        response.sendRedirect(request.getContextPath() + "/pages/Cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
