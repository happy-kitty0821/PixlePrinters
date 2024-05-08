<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.Utilities"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon"
    href="${pageContext.request.contextPath}/Images/pixelprinter-high-resolution-logo.png"
    type="image/png">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>
    <%-- Default title --%>
    Printer Design
    <%-- Get the current page from the request URI and set the title accordingly --%>
    <% String currentPage = request.getRequestURI();
       if (currentPage.endsWith("Index.jsp")) { %>
           | Home
       <% } else if (currentPage.endsWith("DisplayProductToCustomerServlet")) { %>
           | Product
       <% } else if (currentPage.endsWith("Contact.jsp")) { %>
           | About Us
       <% } else if (currentPage.endsWith("Login.jsp")) { %>
           | Login
       <% } else if (currentPage.endsWith("LogoutServlet")) { %>
           | Logout
       <% } %>
</title>
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/css/Header.css" />
</head>

<body>
    <section id="header" class="header">
        <a href="${pageContext.request.contextPath}/pages/Index.jsp"><img
            src="${pageContext.request.contextPath}/Images/logo.png" class="logo"
            style="width: 120px; height: auto;"></a>
        <nav class="navbar">
            <a class="active"
                href="${pageContext.request.contextPath}/pages/Index.jsp">Home</a> <a
                href="${pageContext.request.contextPath}/DisplayProductToCustomerServlet">Product</a>
            <a href="${pageContext.request.contextPath}/pages/Contact.jsp">About
                Us</a> 
            <% 
            if (session.getAttribute("username") == null) {
            %>
                <a href="${pageContext.request.contextPath}/pages/Login.jsp">Login</a>
            <% } else { %>
                <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
            <% } %>
        </nav>
        <div class="icons">
            <div id="menu-btn" class="fas fa-bars"></div>
            <a href="#" class="fas fa-user-circle"></a> 
            <a href="#" class="fas fa-search"></a> 
            <a href="${pageContext.request.contextPath}/DisplayCart" class="fas fa-shopping-cart"></a>
        </div>
    </section>
</body>
</html>