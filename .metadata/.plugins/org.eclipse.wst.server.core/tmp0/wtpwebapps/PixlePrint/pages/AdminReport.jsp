<%@ include file="AdminSidebar.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="models.AllPurchasesModel" %>
<%@ page import="utils.Utilities" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display All Purchases</title>
    <link rel="stylesheet" type="text/css" href="path/to/your/css/styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex; /* Use flexbox for layout */
        }

        .main-body {
            padding: 20px;
            background-color: #fff;
            margin: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            flex: 1; /* Allow the main content to grow to fill the available space */
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        /* Add more styles as needed */
    </style>
</head>
<body>
<div class="main-body">
    <h1>Displaying all purchases</h1>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Quantity</th>
                <th>Product Name</th>
                <th>Product Image</th>
                <th>Total Price</th>
                <th>Company</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>User Name</th>
            </tr>
        </thead>
        <tbody>
            <% List<AllPurchasesModel> allUserPurchases = (List<AllPurchasesModel>) request.getAttribute("allUserPurchases"); %>
            <% for (AllPurchasesModel purchase : allUserPurchases) { %>
                <tr>
                    <td><%= purchase.getDateTime() %></td>
                    <td><%= purchase.getQuantity() %></td>
                    <td><%= purchase.getProductName() %></td>
                    <td><img src="${pageContext.request.contextPath}/Uploads/ProductImages/<%= purchase.getProductImage() %>" alt=<%= purchase.getProductName() %> style="max-width: 100px;"></td>
                    <td><%= purchase.getTotalAmount() %></td>
                    <td><%= purchase.getCompanyName() %></td>
                    <td><%= purchase.getPhoneNumber() %></td>
                    <td><%= purchase.getEmail() %></td>
                    <td><%= purchase.getUserName() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
