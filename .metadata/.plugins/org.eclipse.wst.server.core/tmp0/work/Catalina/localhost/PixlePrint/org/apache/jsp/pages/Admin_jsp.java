/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-05-03 17:55:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale= 1.0\" />\n");
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap\"rel=\"stylesheet\"/>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons+Outlined\" rel=\"stylesheet\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/Admin.css\"/>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"grid-container\">\n");
      out.write("      <header class=\"header\">\n");
      out.write("        <div class=\"menu-icon\" onclick=\"openSidebar()\">\n");
      out.write("          <span class=\"material-icons-outlined\">menu </span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header-left\">\n");
      out.write("          <span class=\"material-icons-outlined\">search</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header-right\">\n");
      out.write("          <span class=\"material-icons-outlined\">notifications</span>\n");
      out.write("          <span class=\"material-icons-outlined\">email</span>\n");
      out.write("          <span class=\"material-icons-outlined\">account_circle</span>\n");
      out.write("        </div>\n");
      out.write("      </header>\n");
      out.write("      <aside id=\"sidebar\">\n");
      out.write("        <div class=\"sidebar-title\">\n");
      out.write("          <div class=\"sidebar-brand\">\n");
      out.write("            <span class=\"material-icons-outlined\">shopping_cart</span\n");
      out.write("            >Pixelprinter\n");
      out.write("          </div>\n");
      out.write("          <span class=\"material-icons-outlined\" onclick=\"closeSidebar()\"\n");
      out.write("            >close</span\n");
      out.write("          >\n");
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
      out.write("        <a href=\"inventory.jsp\">\n");
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
      out.write("        <a href=\"#\">\n");
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
      out.write("\n");
      out.write("      </aside>\n");
      out.write("      <main class=\"main-container\">\n");
      out.write("        <div class=\"main-title\">\n");
      out.write("          <h2>DASHBOARD</h2>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-cards\">\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-inner\">\n");
      out.write("              <h3>PRODUCTS</h3>\n");
      out.write("              <span class=\"material-icons-outlined\">inventory_2</span>\n");
      out.write("            </div>\n");
      out.write("            <h1>\n");
      out.write("              <span> ");
      out.print(request.getAttribute("productCount"));
      out.write(" </span>\n");
      out.write("            </h1>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-inner\">\n");
      out.write("              <h3>Brands</h3>\n");
      out.write("              <span class=\"material-icons-outlined\">category</span>\n");
      out.write("            </div>\n");
      out.write("            <h1>\n");
      out.write("              <span> ");
      out.print(request.getAttribute("brandCount"));
      out.write(" </span>\n");
      out.write("            </h1>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-inner\">\n");
      out.write("              <h3>CUSTOMERS</h3>\n");
      out.write("              <span class=\"material-icons-outlined\">groups</span>\n");
      out.write("            </div>\n");
      out.write("            <h1>\n");
      out.write("              <span> ");
      out.print(request.getAttribute("customerCount"));
      out.write(" </span>\n");
      out.write("            </h1>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"card\">\n");
      out.write("            <div class=\"card-inner\">\n");
      out.write("              <h3>MESSAGES</h3>\n");
      out.write("              <span class=\"material-icons-outlined\"\n");
      out.write("                >notification_important</span\n");
      out.write("              >\n");
      out.write("            </div>\n");
      out.write("            <h1>\n");
      out.write("              <span> ");
      out.print(request.getAttribute("messageCount"));
      out.write(" </span>\n");
      out.write("            </h1>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"charts\">\n");
      out.write("          <div class=\"charts-card\">\n");
      out.write("            <h2 class=\"chart-title\">Top 6 Products</h2>\n");
      out.write("            <div id=\"bar-chart\"></div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"charts-card\">\n");
      out.write("            <h2 class=\"chart-title\">Purchase and Sales Orders</h2>\n");
      out.write("            <div id=\"area-chart\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </main>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.49.0/apexcharts.min.js\"></script>\n");
      out.write("    <script\n");
      out.write("      type=\"text/javascript\"\n");
      out.write("      src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/AdminHome.js\"\n");
      out.write("    ></script>\n");
      out.write("  </body>\n");
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
