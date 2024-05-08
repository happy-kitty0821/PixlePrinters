<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale= 1.0" />
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Admin.css"/>
  </head>
  <body>
    <div class="grid-container">
      <header class="header">
        <div class="menu-icon" onclick="openSidebar()">
          <span class="material-icons-outlined">menu </span>
        </div>
        <div class="header-left">
          <span class="material-icons-outlined">search</span>
        </div>
        <div class="header-right">
          <span class="material-icons-outlined">notifications</span>
          <span class="material-icons-outlined">email</span>
          <span class="material-icons-outlined">account_circle</span>
        </div>
      </header>
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
      <main class="main-container">
        <div class="main-title">
          <h2>DASHBOARD</h2>
        </div>

        <div class="main-cards">
          <div class="card">
            <div class="card-inner">
              <h3>PRODUCTS</h3>
              <span class="material-icons-outlined">inventory_2</span>
            </div>
            <h1>
              <span> <%=request.getAttribute("productCount")%> </span>
            </h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h3>Brands</h3>
              <span class="material-icons-outlined">category</span>
            </div>
            <h1>
              <span> <%=request.getAttribute("brandCount")%> </span>
            </h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h3>CUSTOMERS</h3>
              <span class="material-icons-outlined">groups</span>
            </div>
            <h1>
              <span> <%=request.getAttribute("customerCount")%> </span>
            </h1>
          </div>

          <div class="card">
            <div class="card-inner">
              <h3>MESSAGES</h3>
              <span class="material-icons-outlined"
                >notification_important</span
              >
            </div>
            <h1>
              <span> <%=request.getAttribute("messageCount")%> </span>
            </h1>
          </div>
        </div>

        <div class="charts">
          <div class="charts-card">
            <h2 class="chart-title">Top 6 Products</h2>
            <div id="bar-chart"></div>
          </div>

          <div class="charts-card">
            <h2 class="chart-title">Purchase and Sales Orders</h2>
            <div id="area-chart"></div>
          </div>
        </div>
      </main>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.49.0/apexcharts.min.js"></script>
    <script
      type="text/javascript"
      src="${pageContext.request.contextPath}/js/AdminHomePage.js"
    ></script>
  </body>
</html>
