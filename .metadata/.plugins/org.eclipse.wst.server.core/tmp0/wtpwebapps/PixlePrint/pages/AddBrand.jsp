<%@ include file="AdminSidebar.jsp" %>
<%@ page import="utils.Utilities"%>
<%@ page import="java.util.List, models.BrandModel"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Brand</title>
    <style>
        /* CSS styles for the table */
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
        /* CSS styles for action buttons */
        .action-btn {
            padding: 5px 10px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-right: 5px;
        }
        .action-btn.delete {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <div class="message-from-backend">
        <% if (request.getAttribute(Utilities.SUCCESS_MESSAGE) != null) { %>
        <div class="alert alert-success" role="alert">
            <%=request.getAttribute(Utilities.SUCCESS_MESSAGE)%>
        </div>
        <% } else if (request.getAttribute(Utilities.ERROR_MESSAGE) != null) { %>
        <% if (request.getAttribute(Utilities.ERROR_MESSAGE).equals(Utilities.INCORRECT_FORM_DATA_MESSAGE)) { %>
        <div class="alert alert-danger" role="alert">
            <%=request.getAttribute(Utilities.ERROR_MESSAGE)%>
        </div>
        <% } else if (request.getAttribute(Utilities.ERROR_MESSAGE).equals(Utilities.SERVER_ERROR_MESSAGE)) { %>
        <div class="alert alert-danger" role="alert">
            <%=request.getAttribute(Utilities.ERROR_MESSAGE)%>
        </div>
        <% } %>
        <% } %>
    </div>
    <h2>Add Brand</h2>
    <form action="${pageContext.request.contextPath}/AddBrand" method="post">
        <label for="companyName">Company Name:</label><br>
        <input type="text" id="companyName" name="companyName" required><br><br>
        <label for="country">Country:</label><br>
        <input type="text" id="country" name="country"><br><br>
        <label for="contactInformation">Contact Information:</label><br>
        <input type="text" id="contactInformation" name="contactInformation"><br><br>
        <label for="website">Website:</label><br>
        <input type="text" id="website" name="website"><br><br>
        <input type="submit" value="Submit">
    </form>
    <div class="show-brands">
        <h1>List of Brands</h1>
        <table>
            <tr>
                <th>Company Name</th>
                <th>Country</th>
                <th>Contact Information</th>
                <th>Website</th>
                <th>Actions</th>
            </tr>
            <% 
            List<BrandModel> brands = (List<BrandModel>) request.getAttribute("brands");
            if (brands != null) {
                for (BrandModel brand : brands) { 
            %>
            <tr>
                <td><%= brand.getCompanyName() %></td>
                <td><%= brand.getCountry() %></td>
                <td><%= brand.getContactInformation() %></td>
                <td><%= brand.getWebsite() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/ModifyBrandServlet?id=<%= brand.getBrandId() %>" class="action-btn">Edit</a>
                    <a href="${pageContext.request.contextPath}/ModifyBrandServlet?id=<%= brand.getBrandId() %>" class="action-btn delete">Delete</a>
                </td>
            </tr>
            <% 
                } 
            } 
            %>
        </table>
    </div>
</body>
</html>