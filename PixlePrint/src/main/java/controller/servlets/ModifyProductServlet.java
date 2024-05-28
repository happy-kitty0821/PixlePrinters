package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.ProductModel;
import utils.Utilities;

/**
 * Servlet implementation class MopdifyProductServlet
 */
@WebServlet("/ModifyProductServlet")
public class ModifyProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public ModifyProductServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("Delete".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            System.out.println(productId);
            request.setAttribute("deleteId", productId);
            doDelete(request, response);
        }
        else if ("update".equals(action)) {
            System.out.println("Update product method");
            doPut(request, response);
            
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Delete Triggered");
        try {
            int deleteId = Integer.parseInt(request.getParameter("deleteId"));
            if (dbController.deleteProduct(deleteId) == 1) {
                request.setAttribute(Utilities.SUCCESS_MESSAGE, Utilities.SUCCESS_DELETE_MESSAGE);
            } else {
                request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.ERROR_DELETE_MESSAGE);
            }
        } catch (NumberFormatException e) {
            request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.ERROR_DELETE_MESSAGE);
        }
        // Forward to a JSP for displaying product information
        request.getRequestDispatcher("/DisplayProductServlet").forward(request, response);
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String productIdStr = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productDescription = request.getParameter("productDescription");
            String productPriceStr = request.getParameter("productPrice");
            String productQuantityStr = request.getParameter("productQuantity");
            String printSpeed = request.getParameter("printSpeed");
            String printerDimensions = request.getParameter("printerDimensions");
            String printerColor = request.getParameter("printerColor");

            // Convert numeric inputs to integers or doubles
            int productId = Integer.parseInt(productIdStr);
            double productPrice = Double.parseDouble(productPriceStr);
            int productQuantity = Integer.parseInt(productQuantityStr);

            // Create a ProductModel object
            ProductModel productModel = new ProductModel(productId, productName, productDescription, productPrice, productQuantity, printSpeed, printerDimensions, printerColor);

            // Update the product in the database
            int result = dbController.editProduct(productModel);

            if (result == 1) {
                request.setAttribute(Utilities.SUCCESS_MESSAGE, "Product updated successfully");
            } else {
                request.setAttribute(Utilities.ERROR_MESSAGE, "Failed to update product");
            }
        } catch (NumberFormatException e) {
            request.setAttribute(Utilities.ERROR_MESSAGE, "Invalid input for numeric fields");
        }

        // Forward or redirect to appropriate page
        request.getRequestDispatcher("/DisplayProductServlet").forward(request, response);
    }

}
