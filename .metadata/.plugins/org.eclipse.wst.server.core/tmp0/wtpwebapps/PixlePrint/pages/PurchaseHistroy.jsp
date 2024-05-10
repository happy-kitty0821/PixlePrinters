<%@ page import="java.util.List" %>
<%@ page import="models.PurchaseHistroyModel" %>
<%@ page import="utils.Utilities" %>
<%@ include file="Header.jsp" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!-- Add Bootstrap CSS link -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<body>
    <div class="container mt-5">
        <h1>Purchase History</h1>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Product Name</th>
                    <th>Ordered Date</th>
                    <th>Quantity</th>
                    <th>Total Amount</th>
                    <th>Price</th>
                    <th>Order Status</th>
                    <th>Product Image</th>
                </tr>
            </thead>
            <tbody>
                <% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); %>
                <% for (PurchaseHistroyModel purchase : (List<PurchaseHistroyModel>) request.getAttribute("purchaseHistroy")) { %>
                    <tr>
                        <td><%= purchase.getProductName() %></td>
                        <td><%= dateFormat.format(purchase.getDateTime()) %></td>
                        <td><%= purchase.getQuantity() %></td>
                        <td>NPR <%= purchase.getTotalAmount() %></td>
                        <td>NPR <%= purchase.getPrice() %></td>
                        <td><%= purchase.getPurchaseStatus() %></td>
                        <td><img src="<%= request.getContextPath() %>/Uploads/ProductImages/<%= purchase.getProductImage() %>" alt="<%= purchase.getProductName() %>" style="max-width: 100px; max-height: 100px;"></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <!-- Add Bootstrap JavaScript and dependencies (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
