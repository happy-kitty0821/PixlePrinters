<%@ include file="Header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.UserCartModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add To Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Cart.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/11d376cef2.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-left mb-5">User Cart </h1>
        <div class="row">
            <% 
            List<UserCartModel> userCartDetails = (List<UserCartModel>) request.getAttribute("userCartDetails");
            if (userCartDetails != null && !userCartDetails.isEmpty()) {
                for (UserCartModel cartItem : userCartDetails) {
            %>
            <div class="col-md-6 col-lg-4 mb-4">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= cartItem.getProductImage() %>" class="card-img-top" alt="<%= cartItem.getProductName() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= cartItem.getProductName() %></h5>
                        <p class="card-text">Quantity: <span id="quantity_<%= cartItem.getProductId() %>"><%= cartItem.getQuantity() %></span></p>
                        <p class="card-text">Price: <%= cartItem.getPrice() %></p>
                        <div class="d-flex justify-content-between">
                            <div class="quantity-control">
                                <button onclick="decreaseQuantity(<%= cartItem.getProductId() %>)" class="btn btn-sm btn-outline-primary">-</button>
                                <button onclick="increaseQuantity(<%= cartItem.getProductId() %>)" class="btn btn-sm btn-outline-primary">+</button>
                            </div>
                            <form action="${pageContext.request.contextPath}/CheckoutServlet" method="post">
                                <input type="hidden" name="productId" value="<%= cartItem.getProductId() %>">
                                <input type="hidden" name="quantity" value="<%= cartItem.getQuantity() %>">
                                <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
                                <button type="submit" class="btn btn-primary">Buy Now</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <div class="col">
                <p>Your cart is empty</p>
            </div>
            <%
            }
            %>
        </div>
    </div>
    <script>
        function decreaseQuantity(productId) {
            var quantityElement = document.getElementById('quantity_' + productId);
            var currentQuantity = parseInt(quantityElement.innerText);
            if (currentQuantity > 1) {
                quantityElement.innerText = currentQuantity - 1;
                updateQuantityInCart(productId, currentQuantity - 1);
            }
        }

        function increaseQuantity(productId) {
            var quantityElement = document.getElementById('quantity_' + productId);
            var currentQuantity = parseInt(quantityElement.innerText);
            quantityElement.innerText = currentQuantity + 1;
            updateQuantityInCart(productId, currentQuantity + 1);
        }

        function updateQuantityInCart(productId, newQuantity) {
            // Send an AJAX request to update the quantity in the cart
            fetch('UpdateCartServlet?productId=' + productId + '&quantity=' + newQuantity, {
                method: 'POST'
            })
            .then(response => response.json())
            .then(data => {
                if (!data.success) {
                    alert('Failed to update quantity in cart');
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }
    </script>
    <!-- Add Bootstrap JavaScript and dependencies (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
