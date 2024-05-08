package controller.servlets;
import controller.DatabaseController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.AdminModel;
import utils.Utilities;

/**
 * Servlet implementation class AdminRegister
 */
@WebServlet("/AdminRegister")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 5,//upto 5mb file size will be saved in the database and system
maxFileSize = 1024*1024*10,//10mb 
maxRequestSize = 1024*1024*50 //incoming request size containing all information  must be equals to or less than 50
		)
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DatabaseController dbController = new DatabaseController();//creating a new object of the dbController class (servlet file)
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(Utilities.user_name);
		String fullName = request.getParameter(Utilities.full_name);
		String email = request.getParameter(Utilities.email);
		String password = request.getParameter(Utilities.password);
		String phoneNumber = request.getParameter(Utilities.phone_number);
		String accountType = request.getParameter(Utilities.account_type);
		Part imagePart = request.getPart("image");
		
		AdminModel adminModel =  new AdminModel(fullName, email, userName, accountType, password, phoneNumber, imagePart);
		
		int result = dbController.registerNewAdmin(adminModel);
		System.out.println("Admin register result is : "+ result);
		
		if (result == 1) {
		    request.setAttribute(Utilities.SUCCESS_MESSAGE, Utilities.SUCCESSFULLY_REGISTERED_MESSAGE);
//		    response.sendRedirect(request.getContextPath() + Utilities.ADMIN_REGISTRATION_PAGE);
		    request.getRequestDispatcher(Utilities.ADMIN_REGISTRATION_PAGE).forward(request, response);
		} 
		else if (result == 0) {
		    request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.INCORRECT_FORM_DATA_MESSAGE);
		    request.getRequestDispatcher(Utilities.REGISTER_PAGE).forward(request, response);
		} 
		else {
		    request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.SERVER_ERROR_MESSAGE);
		    request.getRequestDispatcher(Utilities.REGISTER_PAGE).forward(request, response);
		}
	}
}
