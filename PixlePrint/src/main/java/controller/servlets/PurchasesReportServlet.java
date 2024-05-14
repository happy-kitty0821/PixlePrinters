package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.AllPurchasesModel;

/**
 * Servlet implementation class PurchasesReportServlet
 */
@WebServlet("/PurchasesReportServlet")
public class PurchasesReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchasesReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DatabaseController dbController = new DatabaseController();
		 List<AllPurchasesModel> allUserPurchases = dbController.getAllPurchases();
	    request.setAttribute("allUserPurchases", allUserPurchases);
	    request.getRequestDispatcher("/pages/AdminReport.jsp").forward(request, response);
	}


}
