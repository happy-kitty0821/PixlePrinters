package controller.servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BrandModel;
import utils.Utilities;
import controller.DatabaseController;

/**
 * Servlet implementation class AddBrand
 */
@WebServlet("/AddBrand")
public class AddBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBrandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Call the getBrands method to fetch the brands from the database
    	System.out.println("Add brand servlet");
        List<BrandModel> brands = dbController.getBrandsFromDatabase();
        for(BrandModel bs: brands) {
        	System.out.println(bs.getCompanyName());
        }
        request.setAttribute("brands", brands);
        request.getRequestDispatcher(Utilities.ADD_BRAND).forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyName = request.getParameter("companyName");
		String country = request.getParameter("country");
		String contactInformation = request.getParameter("contactInformation");
		String website = request.getParameter("website");
		BrandModel brandModel = new BrandModel(companyName, country, contactInformation, website);
		int result = dbController.addNewBrands(brandModel);
		System.out.println("Add brand result is : "+result);
		if (result == 1) {
		    request.setAttribute(Utilities.SUCCESS_MESSAGE, Utilities.SUCCESSFULLY_ADD_BRAND_MESSAGE);
		    request.getRequestDispatcher(Utilities.ADD_BRAND).forward(request, response);
		} 
		else if (result == 0) {
		    request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.INCORRECT_FORM_DATA_MESSAGE);
		    request.getRequestDispatcher(Utilities.ADD_BRAND).forward(request, response);
		} 
		else {
		    request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.SERVER_ERROR_MESSAGE);
		    request.getRequestDispatcher(Utilities.ADD_BRAND).forward(request, response);
		}
	}

}