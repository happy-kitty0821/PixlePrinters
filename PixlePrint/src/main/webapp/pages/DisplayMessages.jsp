<%@ include file="AdminSidebar.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ContactUsMessageModel" %>
<%@ page import="java.text.SimpleDateFormat" %>

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
    table.message-table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 5px;
        overflow: hidden;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }

    /* Style the table header */
    table.message-table th {
        background-color: #f8f8f8;
        border-bottom: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    /* Style the table body */
    table.message-table td {
        border-bottom: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }

    /* Style the table body alternate row */
    table.message-table tbody tr:nth-child(even) {
        background-color: #f9f9f9;
    }
		
</style>

<div class="main-content">
    <h1>Contact Us Messages</h1>
    <table class="message-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Contact Number</th>
                <th>Email</th>
                <th>Message</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <% List<ContactUsMessageModel> contactUsMessages = (List<ContactUsMessageModel>) request.getAttribute("contactUsMessages");
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               for (ContactUsMessageModel message : contactUsMessages) { %>
                <tr>
                    <td><%= message.getName() %></td>
                    <td><%= message.getContactNumber() %></td>
                    <td><%= message.getEmail() %></td>
                    <td><%= message.getMessage() %></td>
                    <td><%= dateFormat.format(message.getDateTime()) %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</div>
