<%@ include file="Header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="models.ProductModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
            margin-bottom: 40px;
        }
        .input-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Search Products</h1>
        <form action="${pageContext.request.contextPath}/SearchServlet" method="GET">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search..." name="query" required>
                <button class="btn btn-primary" type="submit">Search</button>
            </div>
        </form>
<div id="searchResults">
    <h2>Search Results:</h2>
    <div class="row">
        <% 
        List<ProductModel> searchResults = (List<ProductModel>) request.getAttribute("SearchResult");
        if (searchResults != null && !searchResults.isEmpty()) {
            for (ProductModel product : searchResults) {
        %>
        <div class="col-md-4">
            <div class="card mb-4">
                <img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>" class="card-img-top" alt="<%= product.getProductName() %>">
                <div class="card-body">
                    <h5 class="card-title"><%= product.getProductName() %></h5>
                    <p class="card-text"><%= product.getProductDescription() %></p>
                    <p class="card-text">Price: <%= product.getPrice() %></p>
                    <p class="card-text">Quantity: <%= product.getQuantity() %></p>
                    <p class="card-text">Company: <%= product.getCompanyName() %></p>
                </div>
            </div>
        </div>
        <% 
            }
        } else {
        %>
        <div class="col">
            <p>No results found.</p>
        </div>
        <% 
        }
        %>
    </div>
</div>

    </div>
</body>
</html>
