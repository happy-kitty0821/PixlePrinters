<%@ include file="AdminSidebar.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="models.ProductModel"%>
<%@ page import="utils.Utilities"%>

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

.alert {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
}

.alert-success {
	color: #155724;
	background-color: #d4edda;
	border-color: #c3e6cb;
}

.alert-danger {
	color: #721c24;
	background-color: #f8d7da;
	border-color: #f5c6cb;
}

.btn-edit, .btn-delete {
	padding: 6px 12px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	display: inline-block;
}

.btn-edit {
	background-color: #007bff;
	color: #fff;
}

.btn-delete {
	background-color: #dc3545;
	color: #fff;
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

.btn-edit, .btn-delete {
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

td, img {
	height: 100px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Product Management</h2>
		<div class="message-from-backend">
			<%
			if (request.getAttribute(Utilities.SUCCESS_MESSAGE) != null) {
			%>
			<div class="alert alert-success" role="alert">
				<%=request.getAttribute(Utilities.SUCCESS_MESSAGE)%>
			</div>
			<%
			} else if (request.getAttribute(Utilities.ERROR_MESSAGE) != null) {
			%>
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute(Utilities.ERROR_MESSAGE)%>
			</div>
			<%
			}
			%>
		</div>
		<%
		List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
		if (products.isEmpty()) {
		%>
		<p>No products have been added.</p>
		<%
		} else {
		%>
		<div class="message-from-backend">
			<%
			if (request.getAttribute("successMessage") != null) {
			%>
			<div class="alert alert-success" role="alert">
				<%=request.getAttribute("successMessage")%>
			</div>
			<%
			} else if (request.getAttribute("errorMessage") != null) {
			%>
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute("errorMessage")%>
			</div>
			<%
			}
			%>
		</div>

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
				<%
				for (ProductModel product : products) {
				%>
				<tr>
					<td><img
						src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= product.getProductImage() %>"
						alt="<%= product.getProductName() %>"></td>
					<td><%=product.getProductName()%></td>
					<td><%=product.getProductDescription()%></td>
					<td><%=product.getPrice()%></td>
					<td><%=product.getPrintSpeed()%></td>
					<td><%=product.getPrintColor()%></td>
					<td><%=product.getDimensions()%></td>
					<td>
						<form method="post"
							action="${pageContext.request.contextPath}/UpdateProductServlet">
							<input type="hidden" name="productId"
								value="<%=product.getProductId()%>">
							<button type="submit" class="btn-edit">Edit</button>
						</form>
						<form method="post"
							action="${pageContext.request.contextPath}/DeleteProductServlet">
							<input type="hidden" name="productId"
								value="<%=product.getProductId()%>">
							<button type="submit" class="btn-delete">Delete</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>
