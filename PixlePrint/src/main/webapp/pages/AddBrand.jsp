<%@ include file="AdminSidebar.jsp" %>
<%@ page import="utils.Utilities"%>
<%@ page import="java.util.List, models.BrandModel"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Brand</title>
    <style>
    
    	input[type="submit"] {
	    background-color: #ffb6c1; /* Light pink color */
	    color: white;
	    border: none;
	    border-radius: 4px;
	    padding: 10px 20px;
	    cursor: pointer;
	    font-weight: bold;
	}
	
	input[type="submit"]:hover {
	    background-color: #ff99b4; /* Lighter pink color on hover */
	}
    	input[type="text"] {
    width: 300px; /* Set the width of the text boxes */
    padding: 5px; /* Add some padding for better appearance */
    margin-bottom: 10px; /* Add some space between the text boxes */
}
    	
  		.container {
	    width: 150px; /* Set the width of the container */
	    margin: 0 500px auto; /* Center the container horizontally */
	    margin-top: -850px;
	    padding: 5px;
	    flex-direction: column; /* Arrange children vertically */
	    align-items: flex-end; /* Align children to the right */
}
  		
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
        .show-brands {
	    margin: 400px;
	    margin-top: -20px;
		}
		
		.show-brands table {
		    width: 100%;
		    border-collapse: collapse;
		    margin: 200px; /* Add some space between the heading and the table */
		}
		
		.show-brands th, .show-brands td {
		    padding: 8px;
		    border-bottom: 1px solid #ddd;
		    text-align: left;
		}
		 h1{
			margin-top: 80px;
			text-align: center;
		}
		.show-brands{
		margin-top: -150px;
		}
		
		.show-brands th {
			justify-content: center;
		    background-color: #f2f2f2;
		}
		
		.show-brands .action-btn {
		    display: inline-block;
		    padding: 6px 12px;
		    text-decoration: none;
		    border-radius: 4px;
		    background-color: #007bff;
		    color: #fff;
		    margin-right: 5px;
		}
		
		.show-brands .action-btn.delete {
		    background-color: #dc3545;
		}
		
		.show-brands .action-btn:hover {
		    background-color: #0056b3;
		}
		
		.show-brands .action-btn.delete:hover {
		    background-color: #c82333;
		}
	     .message-from-backend {
	    margin-top: 20px;
	    padding: 10px;
	}
	
	.alert {
	    padding: 15px;
	    margin-bottom: 20px;
	    border-radius: 4px;
	}
	
	.alert-success {
	    color: #155724;
	    background-color: #d4edda;
	    border-color: #c3e6cb;
	}
	
	.alert-danger {
	    color: #721c24;
	    background-color: #f8d7da;
	    border-color: #f5c6cb;
	}
	.alert-success strong {
    font-weight: bold;
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
    <div class="container">
        <h2>Add Brand</h2>
       <form id="brandForm" action="${pageContext.request.contextPath}/AddBrand" method="post">
	    <label for="companyName">Company Name:</label><br>
	    <input type="text" id="companyName" name="companyName" required><br><br>
	    <label for="country">Country:</label><br>
	    <input type="text" id="country" name="country"><br><br>
	    <label for="contactInformation">Contact Information:</label><br>
	    <input type="text" id="contactInformation" name="contactInformation"><br><br>
	    <label for="website">Website:</label><br>
	    <input type="text" id="website" name="website"><br><br>
	    <input type="submit" value="Submit" >
	</form>
	
	
    </div>
        <h1>List of Brands</h1>
        <div class="show-brands">
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