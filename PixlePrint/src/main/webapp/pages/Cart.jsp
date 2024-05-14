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
							<%
    							double price = cartItem.getPrice();
							    int quantity = cartItem.getQuantity();
    							double totalPrice = price * quantity;
							%>
								<p class="card-text">Total Price: NRP <%= totalPrice %></p>
                        
                        <div class="d-flex justify-content-between">
                            <div class="quantity-control">
                                 <form action="${pageContext.request.contextPath}/RemoveCartServlet" method="post">
                                <input type="hidden" name="productId" value="<%= cartItem.getProductId() %>">
                                <input type="hidden" name="quantity" value="<%= cartItem.getQuantity() %>">
                                <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
                                <button type="submit" class="btn btn-primary">Remove Item</button>
                            </form>
                            </div>
                            <form action="${pageContext.request.contextPath}/PurchaseServlet" method="post">
                            	<input type="hidden" name="price" value=<%= cartItem.getPrice() %>>
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
    <!-- Add Bootstrap JavaScript and dependencies (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
