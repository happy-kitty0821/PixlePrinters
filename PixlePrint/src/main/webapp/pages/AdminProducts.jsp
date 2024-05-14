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
	width: 500px;
	margin: 20px auto;
	margin-top: -800px;
	padding: 50px;
	background-color: var(--color-white);	
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


.btn-edit {
	padding: 100px;
	background-color: #007bff;
	color: #fff;
	
}

.btn-delete {
	background-color: #dc3545;
	color: #fff;
}

table {
	width: 200%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	width: 200px;
	padding: 10px;
	border-bottom: 1px solid var(--color-background);
	vertical-align: middle;
}

th {
	width: 200px;
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
						<%-- <form method="post"
							action="${pageContext.request.contextPath}/DeleteProductServlet">
							<input type="hidden" name="productId"
								value="<%=product.getProductId()%>">
							<button type="submit" class="btn-delete">Delete</button>
						</form>  --%>
						<form id="deleteForm<%=product.getProductId()%>" method="post" action="${pageContext.request.contextPath}/DeleteProductServlet">
					    <input type="hidden" name="productId" value="<%=product.getProductId()%>">
					    <button type="button" onclick="confirmDelete('<%=product.getProductName()%>', '<%=product.getProductId()%>')">Delete</button>
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
	<script>
	function confirmDelete(productName, productId) {
	    if (confirm(`Are you sure you want to delete ${productName}?`)) {
	        // If user confirms, send AJAX request to delete servlet
	        let xhr = new XMLHttpRequest();
	        xhr.open('POST', `${pageContext.request.contextPath}/DeleteProductServlet`, true);
	        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === 4 && xhr.status === 200) {
	                // Handle the response from the servlet if needed
	                // For example, you can reload the page to reflect the updated product list
	                window.location.reload();
	            }
	        };
	        xhr.send(`productId=${productId}`);
	    }
	}


	</script>

	
</body>
</html>
