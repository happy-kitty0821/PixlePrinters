<%@ include file="AdminSidebar.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Management</title>
  <style>
    .container {
      max-width: 80%;
      margin: 20px auto;
      padding: 20px;
      background-color: var(--color-white);
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    th, td {
      padding: 10px;
      border-bottom: 1px solid var(--color-background);
      vertical-align: middle;
    }

    th {
      background-color: var(--color-primary);
      color: var(--color-white);
      text-align: left;
    }

    td {
      text-align: left;
    }

    .btn-edit,
    .btn-delete {
      padding: 6px 12px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      display: inline-block;
    }

    .btn-edit {
      background-color: var(--color-primary);
      color: var(--color-white);
    }

    .btn-delete {
      background-color: var(--color-danger);
      color: var(--color-white);
    }

    td,img{
        height: 100px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Product Management</h2>
    <% 
      List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
      if (products.isEmpty()) { %>
        <p>No products have been added.</p>
      <% } else { %>
        <table>
          <thead>
            <tr>
              <th>Product Image</th>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Print Speed</th> 
              <th>Color</th>
              <th>Dimensions</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <% for (ProductModel product : products) { %>
              <tr>
                <td><img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>" alt="<%= product.getProductName() %>"></td>
                <td><%= product.getProductName() %></td>
                <td><%= product.getProductDescription() %></td>
                <td>NPR <%= product.getPrice() %></td>
                <td><%= product.getPrintSpeed() %></td>
                <td><%= product.getPrintColor() %></td>
                <td><%= product.getDimensions() %></td>
                <td>
                  <button href="#" class="btn-edit">Edit</button>
                  <button href="#" class="btn-delete">Delete</button>
                </td>
              </tr>
            <% } %>
          </tbody>
        </table>
      <% } %>
  </div>
</body>
