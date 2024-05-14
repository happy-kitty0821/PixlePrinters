/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-05-14 20:52:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import models.AllPurchasesModel;
import utils.Utilities;

public final class AdminReport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/pages/AdminSidebar.jsp", Long.valueOf(1715719904804L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("utils.Utilities");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("models.AllPurchasesModel");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Admin Side Bar</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap\"rel=\"stylesheet\"/>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons+Outlined\" rel=\"stylesheet\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/AdminSidebar.css\"/>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div style=\"width:400px; height: 850px;\">\n");
      out.write("	      <aside id=\"sidebar\">\n");
      out.write("        <div class=\"sidebar-title\">\n");
      out.write("          <div class=\"sidebar-brand\">\n");
      out.write("            <span class=\"material-icons-outlined\">shopping_cart</span\n");
      out.write("            >Pixelprinter\n");
      out.write("          </div>\n");
      out.write("          <span class=\"material-icons-outlined\" onclick=\"closeSidebar()\"\n");
      out.write("            >close</span>\n");
      out.write("        </div>\n");
      out.write(" <ul class=\"sidebar-list\">\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/AddProductServlet\">\n");
      out.write("            <span class=\"material-icons-outlined\">print</span> Add Product\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayProductServlet\">\n");
      out.write("            <span class=\"material-icons-outlined\">inventory_2</span> Products\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/AddBrand\">\n");
      out.write("            <span class=\"material-icons-outlined\">category</span> Add Categories\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayUserDetailsServlet\">\n");
      out.write("            <span class=\"material-icons-outlined\">group</span> Customers\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayContactUsMessageServlet\">\n");
      out.write("        	<span class=\"material-icons-outlined\">mark_email_unread</span> Messages\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("        <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/AddAdmin.jsp\">\n");
      out.write("            <span class=\"material-icons-outlined\">person_add</span> Add Admin\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/PurchasesReportServlet\">\n");
      out.write("            <span class=\"material-icons-outlined\">view_kanban</span> Reports\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("        <li class=\"sidebar-list-item\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/LogoutServlet\">\n");
      out.write("            <span class=\"material-icons-outlined\">logout</span> Logout\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
      out.write("      </aside>\n");
      out.write("	</div>\n");
      out.write("	    <script\n");
      out.write("      type=\"text/javascript\"\n");
      out.write("      src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/AdminHome.js\"\n");
      out.write("    ></script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Display All Purchases</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"path/to/your/css/styles.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            display: flex; /* Use flexbox for layout */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .main-body {\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #fff;\n");
      out.write("            margin: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("            flex: 1; /* Allow the main content to grow to fill the available space */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            padding: 8px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Add more styles as needed */\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"main-body\">\n");
      out.write("    <h1>Displaying all purchases</h1>\n");
      out.write("    <table>\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>Date</th>\n");
      out.write("                <th>Quantity</th>\n");
      out.write("                <th>Product Name</th>\n");
      out.write("                <th>Product Image</th>\n");
      out.write("                <th>Total Price</th>\n");
      out.write("                <th>Company</th>\n");
      out.write("                <th>Phone Number</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>User Name</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");
 List<AllPurchasesModel> allUserPurchases = (List<AllPurchasesModel>) request.getAttribute("allUserPurchases"); 
      out.write("\n");
      out.write("            ");
 for (AllPurchasesModel purchase : allUserPurchases) { 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( purchase.getDateTime() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getQuantity() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getProductName() );
      out.write("</td>\n");
      out.write("                    <td><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Uploads/ProductImages/");
      out.print( purchase.getProductImage() );
      out.write("\" alt=");
      out.print( purchase.getProductName() );
      out.write(" style=\"max-width: 100px;\"></td>\n");
      out.write("                    <td>");
      out.print( purchase.getTotalAmount() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getCompanyName() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getPhoneNumber() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getEmail() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( purchase.getUserName() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}