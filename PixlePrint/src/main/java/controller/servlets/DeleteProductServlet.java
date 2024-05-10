package controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import utils.Utilities;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get productId parameter from the request
        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println("product id is : " + productId);
        HttpSession session = request.getSession();//getting the session object
        String username = (String) session.getAttribute("username");
        if (username != null) {
            int result = dbController.deleteProducts(productId);
            if (result == 1) {
                request.setAttribute(Utilities.SUCCESS_MESSAGE, Utilities.PRODUCT_DELETED_MESSAGE);
            } else if (result == 0) {
                request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.INCORRECT_FORM_DATA_MESSAGE);
            } else {
                request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.SERVER_ERROR_MESSAGE);
            }
        } else {
            System.out.println("user is not logged in");
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + Utilities.LOGIN_PAGE);
            return; // Added return statement to exit the method after redirect
        }
        request.getRequestDispatcher(Utilities.ADMIN_PRODUCT_PAGE).forward(request, response);
    }

}