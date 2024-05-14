/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-05-14 17:30:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Utilities;
import java.util.List;
import models.ProductModel;

public final class CustomerProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/pages/Footer.jsp", Long.valueOf(1714793031737L));
    _jspx_dependants.put("/pages/Header.jsp", Long.valueOf(1715699734640L));
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
    _jspx_imports_classes.add("models.ProductModel");
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<link rel=\"icon\"\n");
      out.write("    href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Images/pixelprinter-high-resolution-logo.png\"\n");
      out.write("    type=\"image/png\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<title>\n");
      out.write("    ");
      out.write("\n");
      out.write("    Printer Design\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 String currentPage = request.getRequestURI();
       if (currentPage.endsWith("Index.jsp")) { 
      out.write("\n");
      out.write("           | Home\n");
      out.write("       ");
 } else if (currentPage.endsWith("DisplayProductToCustomerServlet")) { 
      out.write("\n");
      out.write("           | Product\n");
      out.write("       ");
 } else if (currentPage.endsWith("Contact.jsp")) { 
      out.write("\n");
      out.write("           | About Us\n");
      out.write("       ");
 } else if (currentPage.endsWith("Login.jsp")) { 
      out.write("\n");
      out.write("           | Login\n");
      out.write("       ");
 } else if (currentPage.endsWith("LogoutServlet")) { 
      out.write("\n");
      out.write("           | Logout\n");
      out.write("       ");
 } 
      out.write("\n");
      out.write("</title>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("    href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("    href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/Header.css\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <section id=\"header\" class=\"header\">\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/Index.jsp\"><img\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Images/logo.png\" class=\"logo\"\n");
      out.write("            style=\"width: 120px; height: auto;\"></a>\n");
      out.write("        <nav class=\"navbar\">\n");
      out.write("            <a class=\"active\"\n");
      out.write("                href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/Index.jsp\">Home</a> <a\n");
      out.write("                href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayProductToCustomerServlet\">Product</a>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/Contact.jsp\">About\n");
      out.write("                Us</a> \n");
      out.write("            ");
 
            if (session.getAttribute("username") == null || "Admin".equals(session.getAttribute("accountType"))) {
            
      out.write("\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/Login.jsp\">Login</a>\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/LogoutServlet\">Logout</a>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <div class=\"icons\">\n");
      out.write("            <div id=\"menu-btn\" class=\"fas fa-bars\"></div>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/UserProfile\" class=\"fas fa-user-circle\"></a> \n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/SearchServlet\" class=\"fas fa-search\"></a> \n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayCart\" class=\"fas fa-shopping-cart\"></a>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Product Page</title>\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<style>\n");
      out.write(".product {\n");
      out.write("	border: 1px solid #ccc;\n");
      out.write("	padding: 10px;\n");
      out.write("	transition: box-shadow 0.3s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".product img {\n");
      out.write("	max-width: 100%;\n");
      out.write("	height: auto;\n");
      out.write("	display: block;\n");
      out.write("	margin: 0 auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".add-to-cart-btn {\n");
      out.write("	background-color: #007bff;\n");
      out.write("	border-color: #007bff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".buy-now-btn {\n");
      out.write("	background-color: #28a745;\n");
      out.write("	border-color: #28a745;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".product:hover {\n");
      out.write("	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".mb-4 {\n");
      out.write("	margin-bottom: 1.5rem;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<br>\n");
      out.write("	<br>\n");
      out.write("	<div class=\"container mt-5\">\n");
      out.write("		");

		// Check if a success or error message exists in the request scope
		String successMessage = (String) request.getAttribute("successMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (successMessage != null) {
		
      out.write("\n");
      out.write("		<div class=\"alert alert-success\" role=\"alert\">\n");
      out.write("			");
      out.print(successMessage);
      out.write("\n");
      out.write("		</div>\n");
      out.write("		");

		}

		if (errorMessage != null) {
		
      out.write("\n");
      out.write("		<div class=\"alert alert-danger\" role=\"alert\">\n");
      out.write("			");
      out.print(errorMessage);
      out.write("\n");
      out.write("		</div>\n");
      out.write("		");

		}
		
      out.write("\n");
      out.write("\n");
      out.write("		<div class=\"row\">\n");
      out.write("			");

			List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
			if (products != null) {
				for (ProductModel product : products) {
			
      out.write("\n");
      out.write("			<div class=\"col-md-4 mb-4\">\n");
      out.write("				<div class=\"product\">\n");
      out.write("					<h2>");
      out.print(product.getProductName());
      out.write("</h2>\n");
      out.write("					<p>");
      out.print(product.getProductDescription());
      out.write("</p>\n");
      out.write("					<p>Price: ");
      out.print(product.getPrice());
      out.write("</p>\n");
      out.write("					<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/DisplayProductDetailServlet?productId=");
      out.print(product.getProductId());
      out.write(" \">\n");
      out.write("					<img\n");
      out.write("						src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Uploads/ProductImages/");
      out.print( product.getProductImage() );
      out.write("\"\n");
      out.write("						alt=\"");
      out.print( product.getProductName() );
      out.write("\" class=\"img-fluid\">\n");
      out.write("					</a>\n");
      out.write("					<div class=\"d-grid gap-2\">\n");
      out.write("						<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/AddToCartServlet\" method=\"post\"	>\n");
      out.write("							<input type=\"hidden\" value=\"");
      out.print(product.getProductId());
      out.write("\" name=\"productId\"> \n");
      out.write("							<input type=\"hidden\" value=\"");
      out.print(product.getProductName());
      out.write("\" name=\"productName\">\n");
      out.write("							<input type=\"hidden\" value=\"1\" name=\"quantity\"> \n");
      out.write("							<input type=\"hidden\" value=\"");
      out.print(session.getAttribute("userId"));
      out.write("\" name=\"userId\">\n");
      out.write("							<input type=\"hidden\" value=");
      out.print(product.getPrice());
      out.write(" name=\"price\"> \n");
      out.write("							<button type=\"submit\" class=\"btn add-to-cart-btn\" >Add to cart</button>\n");
      out.write("						</form>\n");
      out.write("						<br>\n");
      out.write("						<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/PurchaseServlet\" method=\"post\">\n");
      out.write("						<input type=\"hidden\" value=\"1\" name=\"quantity\"> \n");
      out.write("						<input type=\"hidden\" value=");
      out.print(product.getPrice());
      out.write(" name=\"price\"> \n");
      out.write("						<input type=\"hidden\" value=");
      out.print(product.getProductId());
      out.write(" name=\"productId\"> \n");
      out.write("						<button type=\"submit\" class=\"btn buy-now-btn\" type=\"button\">Buy Now</button>\n");
      out.write("						</form>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("			");

			}
			}
			
      out.write("\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<title>Footer</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/Footer.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <!-- App download, company info, useful links, and social media -->\n");
      out.write("                <div class=\"footer-col1\">\n");
      out.write("                    <h3>Download Our App</h3>\n");
      out.write("                    <p>Download App for Android and IOS mobile phones</p>\n");
      out.write("                    <div class=\"app-logo\">\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Images/app-store.png\" alt=\"\">\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Images/play-store.png\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-col2\">\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Images/pixelprinter-high-resolution-logo.png\" width=\"160px\" />\n");
      out.write("                    <p><strong>Our purpose is your satisfaction and happiness</strong></p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-col3\">\n");
      out.write("                    <!-- Useful links -->\n");
      out.write("                    <h3>Useful links</h3>\n");
      out.write("                    <ul type=\"none\">\n");
      out.write("                        <li>Coupons</li>\n");
      out.write("                        <li class=\"blog-link\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Html/blog.jsp\" style=\"color: #8a8a8a;\">Blog Post</a></li>\n");
      out.write("                        <li>Return Policy</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-col4\">\n");
      out.write("                    <!-- Social media links -->\n");
      out.write("                    <h3>Follow Us</h3>\n");
      out.write("                    <i class='bx bxl-youtube'>Youtube</i><br>\n");
      out.write("                    <i class='bx bxl-instagram'>Instagram</i><br>\n");
      out.write("                    <i class='bx bxl-facebook-circle'>Facebook</i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Copyright Section -->\n");
      out.write("            <hr />\n");
      out.write("            <p class=\"copyright\"> &copy; All rights reserved- Pixel Printer</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
