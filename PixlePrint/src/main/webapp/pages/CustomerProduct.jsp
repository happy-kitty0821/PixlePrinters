<%@ include file="Header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="models.ProductModel"%>

<html>
<head>
<title>Product Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
.product {
	border: 1px solid #ccc;
	padding: 10px;
	transition: box-shadow 0.3s;
}

.product img {
	max-width: 100%;
	height: auto;
	display: block;
	margin: 0 auto;
}

.add-to-cart-btn {
	background-color: #007bff;
	border-color: #007bff;
}

.buy-now-btn {
	background-color: #28a745;
	border-color: #28a745;
}

.product:hover {
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.mb-4 {
	margin-bottom: 1.5rem;
}
</style>
</head>
<body>
	<br>
	<br>
	<div class="container mt-5">
		<%
		// Check if a success or error message exists in the request scope
		String successMessage = (String) request.getAttribute("successMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");

		if (successMessage != null) {
		%>
		<div class="alert alert-success" role="alert">
			<%=successMessage%>
		</div>
		<%
		}

		if (errorMessage != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=errorMessage%>
		</div>
		<%
		}
		%>

		<div class="row">
			<%
			List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
			if (products != null) {
				for (ProductModel product : products) {
			%>
			<div class="col-md-4 mb-4">
				<div class="product">
					<h2><%=product.getProductName()%></h2>
					<p><%=product.getProductDescription()%></p>
					<p>Price: <%=product.getPrice()%></p>
					<img
						src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>"
						alt="<%= product.getProductName() %>" class="img-fluid">
					<div class="d-grid gap-2">
						<form action="${pageContext.request.contextPath}/AddToCartServlet" method="post"	>
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
			<%
			}
			}
			%>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ include file="Footer.jsp"%>
