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
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			DatabaseController dbController = new DatabaseController();
			int customerCount = dbController.getCustomerCount(); //calling of the getCustomerCount method
			int productCount = dbController.getProducCount();
			int brandCount = dbController.getBrandCount();
			int messageCount = dbController.getMessageCount();
			//when using request.setAttribute("key", value) we cannot send multiple key value pair at once we have to send them seperately
			request.setAttribute("customerCount", customerCount);//sending the customer count 
			request.setAttribute("productCount", productCount);//sending the product count
			request.setAttribute("brandCount",brandCount);//sending the brand count
			request.setAttribute("messageCount",messageCount);//sending the message count
			request.getRequestDispatcher(Utilities.ADMIN_HOME_PAGE).forward(request, response);//forwarding the request to the jsp page
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
