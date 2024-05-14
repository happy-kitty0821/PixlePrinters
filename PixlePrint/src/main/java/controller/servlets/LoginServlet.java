package controller.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import utils.Utilities;

@WebServlet("/UserLogin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.sendRedirect(request.getContextPath() + Utilities.HOME_PAGE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests here
        String username = request.getParameter(Utilities.user_name);
        String password = request.getParameter(Utilities.password);

        int loginResult = dbController.getUserLoginInformation(username, password);
        
        System.out.println("Login result is :"+loginResult);

        if (loginResult == 1) {
        	HttpSession session = request.getSession();
            int userId = dbController.getUserId(username);
            String accountType = dbController.getAccountType(userId);
            session.setAttribute("username", username);
            session.setAttribute("userId", userId); 
            session.setAttribute("accountType", accountType);
            session.setMaxInactiveInterval(30 * 60);//setting the maximum session timeout to 30 minutes
            /* session part end 
             *----- cookie start-----*/
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(30 * 60); //cookie expires after 30 minutes
            response.addCookie(userCookie);
            //creating a new cookie for the account type
            Cookie accountTypeCookie = new Cookie("accountType", accountType);
            accountTypeCookie.setMaxAge(30 * 60); //cookie expires after 30 minutes
            response.addCookie(accountTypeCookie);
            response.sendRedirect(request.getContextPath() + Utilities.HOME_PAGE);
        } 
        else if (loginResult == 5) {
        	HttpSession session = request.getSession();
            
            int userId = dbController.getUserId(username);
            String accountType = dbController.getAccountType(userId);
            session.setAttribute("userId", userId);
            session.setAttribute("username", username);
            session.setAttribute("accountType", accountType);
            /* session part end 
             *----- cookie start-----*/
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(30 * 60); //cookie expires after 30 minutes
            response.addCookie(userCookie);
            //creating a new cookie for the account type
            Cookie accountTypeCookie = new Cookie("accountType", accountType);
            accountTypeCookie.setMaxAge(30 * 60); //cookie expires after 30 minutes
            response.addCookie(accountTypeCookie);
            response.sendRedirect(request.getContextPath() + Utilities.ADMIN_HOME_SERVLET);	
        } 
        else if (loginResult == 0) {
            request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.INCORRECT_LOGIN_CREDENTIAL_ERROR);
            System.out.println("Username or Password Incorrect");
            request.getRequestDispatcher(Utilities.LOGIN_PAGE).forward(request, response);
        } 
        else {
            request.setAttribute(Utilities.ERROR_MESSAGE, Utilities.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(Utilities.LOGIN_PAGE).forward(request, response);
        }
    }
}
