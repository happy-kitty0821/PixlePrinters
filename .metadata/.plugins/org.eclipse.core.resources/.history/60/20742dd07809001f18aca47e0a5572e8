<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="models.BrandModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>
<style>
:root {
	--color-primary: cornflowerblue; /* #7380ec */
	--color-danger: coral; /* #ff7782 */
	--color-success: mediumspringgreen; /* #41f1b6 */
	--color-warning: sandybrown; /* #ffbb55 */
	--color-white: white; /* #fff */
	--color-info-dark: cadetblue; /* #7d8da1 */
	--color-info-light: lavender; /* #dce1eb */
	--color-dark: midnightblue; /* #363949 */
	--color-light: rgba(132, 139, 200, 0.18); /* rgba(132,139,200,0.18) */
	--color-primary-variant: midnightblue; /* #111e88 */
	--color-dark-variant: slategray; /* #677483 */
	--color-background: gainsboro; /* #f6f6f9 */
	--card-border-radius: 32px; /* 2rem = 2 * 16px */
	--border-radius-1: 6.4px; /* 0.4rem = 0.4 * 16px */
	--border-radius-2: 19.2px; /* 1.2rem = 1.2 * 16px */
	--card-padding: 28.8px; /* 1.8rem = 1.8 * 16px */
	--padding-1: 19.2px; /* 1.2rem = 1.2 * 16px */
	--box-shadow: 0 32px 48px var(--color-light);
	/* 2rem = 2 * 16px, 3rem = 3 * 16px */
}

body {
	background-color: var(--color-background);
	color: var(--color-dark);
	font-family: Arial, sans-serif;
}

.container {
	max-width: 600px;
	margin: 0 auto;
	padding: var(--padding-1);
	background-color: var(--color-white);
	border-radius: var(--card-border-radius);
	box-shadow: var(--box-shadow);
}

.form-group {
	margin-bottom: var(--padding-1);
}

.form-group label {
	display: block;
	margin-bottom: var(--padding-1);
	color: var(--color-dark);
}

.form-group input, .form-group textarea, .form-group select {
	width: 100%;
	padding: var(--padding-1);
	border: 1px solid var(--color-info-dark);
	border-radius: var(--border-radius-1);
	box-sizing: border-box; /* Include padding in width calculation */
}

.form-group button {
	padding: var(--padding-1);
	border: none;
	border-radius: var(--border-radius-1);
	background-color: var(--color-primary);
	color: var(--color-white);
	cursor: pointer;
}
</style>
</head>
<body>
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

			<button type="submit">Add Product</button>
		</form>
	</div>
</body>
</html>
