<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Side Bar</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminSidebar.css"/>
</head>
<body>
	<div>
	      <aside id="sidebar">
        <div class="sidebar-title">
          <div class="sidebar-brand">
            <span class="material-icons-outlined">shopping_cart</span
            >Pixelprinter
          </div>
          <span class="material-icons-outlined" onclick="closeSidebar()"
            >close</span
          >
        </div>
 <ul class="sidebar-list">
    <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/AddProductServlet">
            <span class="material-icons-outlined">print</span> Add Product
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/DisplayProductServlet">
            <span class="material-icons-outlined">inventory_2</span> Products
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/AddBrand">
            <span class="material-icons-outlined">category</span> Add Categories
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/DisplayUserDetailsServlet">
            <span class="material-icons-outlined">group</span> Customers
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="inventory.jsp">
        	<span class="material-icons-outlined">mark_email_unread</span> Messages
        </a>
    </li>
        <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/pages/AddAdmin.jsp">
            <span class="material-icons-outlined">person_add</span> Add Admin
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="#">
            <span class="material-icons-outlined">view_kanban</span> Reports
        </a>
    </li>
        <li class="sidebar-list-item">
        <a href="${pageContext.request.contextPath}/LogoutServlet">
            <span class="material-icons-outlined">logout</span> Logout
        </a>
    </li>
</ul>
      </aside>
	</div>
	    <script
      type="text/javascript"
      src="${pageContext.request.contextPath}/js/AdminHome.js"
    ></script>
</body>
</html>