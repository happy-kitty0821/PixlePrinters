<%@ include file="Header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="models.UserCartModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add To Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Cart.css">
    <script src="https://kit.fontawesome.com/11d376cef2.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-left mb-5">Best Seller</h1>
        <div id="root">
            <% 
            List<UserCartModel> userCartDetails = (List<UserCartModel>) request.getAttribute("userCartDetails");
            if (userCartDetails != null && !userCartDetails.isEmpty()) {
                for (UserCartModel cartItem : userCartDetails) {
            %>
            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= cartItem.getProductImage() %>" alt="<%= cartItem.getProductName() %>">
                </div>
                <div class="product-details">
                    <h2><%= cartItem.getProductName() %></h2>
                    <p>Quantity: <span id="quantity_<%= cartItem.getProductId() %>"><%= cartItem.getQuantity() %></span></p>
                    <p>Price: <%= cartItem.getPrice() %></p>
                    <div class="quantity-control">
                        <button onclick="decreaseQuantity(<%= cartItem.getProductId() %>)">-</button>
                        <button onclick="increaseQuantity(<%= cartItem.getProductId() %>)">+</button>
                    </div>
                    <form action="CheckoutServlet" method="post">
                        <input type="hidden" name="productId" value="<%= cartItem.getProductId() %>">
                        <input type="hidden" name="quantity" value="<%= cartItem.getQuantity() %>">
                        <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
                        <button type="submit" class="buy-now-btn">Buy Now</button>
                    </form>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <p>Your cart is empty</p>
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
</body>
</html>