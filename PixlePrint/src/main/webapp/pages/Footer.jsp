<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Footer</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Footer.css">
</head>
<body>
    <div class="footer">
        <div class="container">
            <div class="row">
                <!-- App download, company info, useful links, and social media -->
                <div class="footer-col1">
                    <h3>Download Our App</h3>
                    <p>Download App for Android and IOS mobile phones</p>
                    <div class="app-logo">
                        <img src="${pageContext.request.contextPath}/Images/app-store.png" alt="">
                        <img src="${pageContext.request.contextPath}/Images/play-store.png" alt="">
                    </div>
                </div>
                <div class="footer-col2">
                    <img src="${pageContext.request.contextPath}/Images/pixelprinter-high-resolution-logo.png" width="160px" />
                    <p><strong>Our purpose is your satisfaction and happiness</strong></p>
                </div>
                <div class="footer-col3">
                    <!-- Useful links -->
                    <h3>Useful links</h3>
                    <ul type="none">
                        <li>Coupons</li>
                        <li class="blog-link"><a href="${pageContext.request.contextPath}/Html/blog.jsp" style="color: #8a8a8a;">Blog Post</a></li>
                        <li>Return Policy</li>
                    </ul>
                </div>
                <div class="footer-col4">
                    <!-- Social media links -->
                    <h3>Follow Us</h3>
                    <i class='bx bxl-youtube'>Youtube</i><br>
                    <i class='bx bxl-instagram'>Instagram</i><br>
                    <i class='bx bxl-facebook-circle'>Facebook</i>
                </div>
            </div>
            <!-- Copyright Section -->
            <hr />
            <p class="copyright"> &copy; All rights reserved- Pixel Printer</p>
        </div>
    </div>
</body>
</html>
