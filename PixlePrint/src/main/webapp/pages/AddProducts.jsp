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
		<form action="${pageContext.request.contextPath}/AddProductServlet"
			method="POST" enctype="multipart/form-data">
			<div style= "display:flex; ">
			<div style="width:1200px;">
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
			<div class="form-group">
				<label for="productImage">Product Image</label> <input type="file"
					id="productImage" name="productImage" accept="image/*" required>
			</div>

			<div class="form-group">
				<label for="brandName">Brand</label> <select id="brandName"
					name="brandName" required>
					<option value="" selected disabled>Select Brand</option>
					<%
					if (request.getAttribute("brands") != null) {
						List<BrandModel> brands = (List<BrandModel>) request.getAttribute("brands");
						for (BrandModel brand : brands) {
					%>
					<option value="<%=brand.getCompanyName()%>"><%=brand.getCompanyName()%></option>
					<%
					}
					}
					%>
				</select>
			</div>
			
			</div>
			
			<div style="width:1000px; ">
			<div class="form-group">
				<label for="printTechnology">Print Technology</label> <select
					id="printTechnology" name="printTechnology" required>
					<option value="" selected disabled>Select Print Technology</option>
					<option value="Inkjet">Inkjet</option>
					<option value="Laser">Laser</option>
					<option value="LED">LED</option>
					<option value="Dot Matrix">Dot Matrix</option>
					<option value="Dye Sublimation">Dye Sublimation</option>
				</select>
			</div>
			<div class="form-group">
				<label for="printColor">Print Color</label> <select id="printColor"
					name="printColor" required>
					<option value="" selected disabled>Select Print Color</option>
					<option value="Black and white">Black and White</option>
					<option value="Color">Color</option>
					<option value="Supports Both">Supports Both</option>
				</select>
			</div>
			<div class="form-group">
				<label for="printSpeed">Print Speed (e.g., "500ppm")</label> <input
					type="text" id="printSpeed" name="printSpeed" required>
			</div>
			<div class="form-group">
				<label for="printResolution">Print Resolution</label> <input
					type="text" id="printResolution" name="printResolution" required>
			</div>

			<div class="form-group">
				<label for="printerWeight">Printer Weight</label> <input type="text" id="weight"
					name="printerWeight" required>
			</div>

			<div class="form-group">
				<label for="printerDimensions">Printer Dimensions</label> <input type="text"
					id="printerDimensions" name="printerDimensions" required>
			</div>

			<div class="form-group">
				<label for="operatingSystem">Operating Systems</label> <input
					type="text" id="operatingSystem" name="operatingSystem" required>
			</div>

			<div class="form-group">
				<label for="printerColor">Printer Color</label> <input type="text" id="printerColor"
					name="printerColor" required>
			</div>

			<div class="form-group">
				<label for="supportedPageSize">Supported Page Size</label> <input
					type="text" id="supportedPageSize" name="supportedPageSize"
					required>
			</div>
		</div>
		</div>
			<button type="submit">Add Product</button>
		</form>
	</div>
</body>
</html>
