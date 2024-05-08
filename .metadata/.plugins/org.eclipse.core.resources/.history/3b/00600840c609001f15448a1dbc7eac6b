<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>

<html>
<head>
    <title>Product Page</title>
</head>
<body>
    <h1>Products</h1>
    <%
        List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
        if (products != null) {
            for (ProductModel product : products) {
    %>
                <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
                    <h2><%= product.getProductName() %></h2>
                    <p><%= product.getProductDescription() %></p>
                    <p>Price: <%= product.getPrice() %></p>
                    <img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>" alt="<%= product.getProductName() %>" style="max-width: 200px; max-height: 200px;">
                </div>
    <%
            }
        }
    %>
</body>
</html>