<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Printer Design</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/DetailedProduct.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Footer.css">
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>

    <div class="container mt-5">
                        <%
                        List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
                        if (products != null) {
                            for (ProductModel product : products) {
                    %>
        <div class="row">
            <div class="col-lg-6">
                <div class="product-image">
                	<img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>"
                                    alt="<%= product.getProductName() %>" class="img-fluid">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product-details">
                    <h2>PIXMA G44770</h2>
                    <div class="product-price">
                        <span class="sale-price">NRP 10000.00</span>
                    </div>
                    <div class="product-details">
                        <h3>What You Get</h3>
                        <p><%=product.getProductDescription()%></p>
                        <h2><u>Specifications</u></h2>

                        <strong>Print Technology:</strong> <%=product.getPrintTechnology()%><br> 
                        <strong>Print Speed:</strong> <%=product.getPrintSpeed()%><br> 
                        <strong>Print Resolution:</strong> <%=product.getPrintResolution()%><br> 
                        <strong>Weight:</strong> <%=product.getWeight()%><br> 
                        <strong>Dimensions:</strong> <%=product.getDimensions()%><br>
                        <strong>Operating System:</strong> <%=product.getOperatingSystem()%><br> 
                        <strong>Supported Page Size:</strong> <%=product.getSupportedPageSize()%><br> 
                        <strong>Printer Color:</strong> <%=product.getColor()%><br> 
                        <strong>Print Color:</strong> <%=product.getPrintColor()%><br>
                    </div>
                    <div class="product-btn-group">
                        <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
                            <input type="hidden" value="<%=product.getProductId()%>" name="productId"> 
                            <input type="hidden" value="<%=product.getProductName()%>" name="productName">
                            <input type="hidden" value="1" name="quantity"> 
                            <input type="hidden" value="<%=session.getAttribute("userId")%>" name="userId">
                            <input type="hidden" value=<%=product.getPrice()%> name="price"> 
                            <button type="submit" class="btn add-to-cart-btn" >Add to cart</button>
                        </form>
                        <br>
                        <form action="${pageContext.request.contextPath}/PurchaseServlet" method="post">
                            <input type="hidden" value="1" name="quantity"> 
                            <input type="hidden" value=<%=product.getPrice()%> name="price"> 
                            <input type="hidden" value=<%=product.getProductId()%> name="productId"> 
                            <button type="submit" class="btn buy-now-btn" type="button">Buy Now</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                                        
                    <%
                            }
                        }
                    %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
