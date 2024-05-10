<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <div class="row">
            <div class="col-lg-6">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/Images/Product1.jpg" alt="" class="img-fluid">
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
    <p>Presenting cost-effective borderless A3 photo printing solutions perfectly suited for design drawing, stunning photos, and versatile media printing, with the Epson L18050...</p>
    <h2><u>Specifications</u></h2>
    <strong>Printer Model 1:</strong> 5-colour Dye based Inks<br>
    <strong>Product Code:</strong> C1LCK001<br>
    <strong>Ink Color:</strong> Magenta, Black, Cyan, Light Cyan, Yellow<br>
    <strong>Function:</strong> Print<br>
    <strong>Number of Inks:</strong> 5 Colours<br>
    <strong>Print Technology:</strong> Inkjet<br>
    <strong>Print Speed:</strong> Up to 15 ppm (Black), up to 8 ppm (Color)<br>
    <strong>Print Resolution:</strong> Up to 4800 x 1200 optimized dpi (Color), up to 1200 x 1200 rendered dpi (Black)<br>
    <strong>Weight:</strong> 12.32 lbs<br>
    <strong>Dimensions:</strong> 17.55 x 13.18 x 5.87 in<br>
    <strong>Operating System:</strong> Windows, macOS<br>
    <strong>Supported Page Size:</strong> A4, A5, A6, B5, DL<br>
    <strong>Color:</strong> Black<br>
    <strong>Print Color:</strong> Both<br>
</div>


                    <div class="product-btn-group">
                        <button class="btn btn-primary">Add to Cart</button>
                        <button class="btn btn-success">Buy Now</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
</html>