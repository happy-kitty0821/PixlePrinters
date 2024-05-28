<%@ page import="java.util.List"%>
<%@ page import="models.BrandModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>

<style>

body {
    font-family: Arial, sans-serif;
    background-color: #f6f6f9;
    color: #363949;
    margin: 0;
    padding: 0;
}

.container {
    width: 1000px;
    margin: 0 auto;
    margin-top: 50px;
    padding: 20px;
    background-color: #fff;
    border-radius: 32px;
    box-shadow: 0 32px 48px rgba(132, 139, 200, 0.18);
}

.form-messages {
    margin-bottom: 20px;
}

.success-message, .error-message {
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 6.4px;
}

.success-message {
    background-color: #41f1b6;
    color: #fff;
}

.error-message {
    background-color: #ff7782;
    color: #fff;
}

h2 {
    font-size: 24px;
    font-weight: bold;
    color: #333;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

.form-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 10px;
    color: #333;
}

.form-group input[type="text"],
.form-group input[type="number"],
.form-group textarea,
.form-group select {
    width: 40%;
    padding: 10px;
    border: 1px solid #7d8da1;
    border-radius: 6.4px;
    box-sizing: border-box;
}

.form-group select {
    appearance: none;
    background: url('data:image/svg+xml;utf8,<svg fill="%237d8da1" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M7 10l5 5 5-5z"/><path d="M0 0h24v24H0z" fill="none"/></svg>') no-repeat right 10px center/14px auto;
    padding-right: 30px;
}

.form-group button {
    padding: 10px 20px;
    border: none;
    border-radius: 6.4px;
    background-color: cornflowerblue;
    color: #fff;
    cursor: pointer;
}

.form-group button:hover {
    background-color: #111e88;
}
</style>
</head>
<body style="display:flex; justify-content:space-between;"> 
<%@ include file="AdminSidebar.jsp" %>
	<div class="container">
		<div class="form-messages">
			<%
			if (request.getAttribute("successMessage") != null) {
			%>
			<div class="success-message"><%=request.getAttribute("successMessage")%></div>
			<%
			} else if (request.getAttribute("errorMessage") != null) {
			%>
			<div class="error-message"><%=request.getAttribute("errorMessage")%></div>
			<%
			}
			%>
		</div>
		<h2>Add Product</h2>
		<form action="${pageContext.request.contextPath}/ModifyProductServlet"
			method="POST" >
			<div style= "display:flex; ">
			<div style="width:1200px;">
			<input type="hidden" name="action" value="update">
			<div class="form-group">
			
				<label for="productName">Product Name</label> <input type="text"
					id="productName" name="productName" required>
			</div>
			<div class="form-group">
				<label for="productDescription">Product Description</label>
				<textarea id="productDescription" name="productDescription" rows="4"
					required></textarea>
			</div>
			<div class="form-group">
				<label for="productPrice">Price</label> <input type="text"
					id="productPrice" name="productPrice" required>
			</div>
			<div class="form-group">
				<label for="productQuantity">Quantity</label> <input type="number"
					id="productQuantity" name="productQuantity" required>
			</div>
			
			</div>
			
			<div style="width:1000px; ">
			<div class="form-group">
				<label for="printSpeed">Print Speed (e.g., "500ppm")</label> <input
					type="text" id="printSpeed" name="printSpeed" required>
			</div>
			<div class="form-group">
				<label for="printerDimensions">Printer Dimensions</label> <input type="text"
					id="printerDimensions" name="printerDimensions" required>
			</div>

			<div class="form-group">
				<label for="printerColor">Printer Color</label> <input type="text" id="printerColor"
					name="printerColor" required>
			</div>
						<div class="form-group">
				<label for="printerColor">Product Id</label> <input type="text" id="printerColor"
					name="productId" required>
			</div>
		</div>
		</div>
			<button type="submit">Add Product</button>
		</form>
	</div>
</body>
</html>
