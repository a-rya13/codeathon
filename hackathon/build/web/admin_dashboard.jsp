<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Employee"%>
<%@page import="beans.Customer"%>
<%@page import="beans.Shop"%>
<%@page import="java.util.*"%>
<%@page import="dao.adminDAO"%>
<%@page import="dao.userDAO"%>
<%@page import="dao.shopDAO"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
            }
            
            .logout-button {
            position: fixed;
            top: 20px; /* Adjusted to 20px from the top */
            right: 20px;
            background-color: #d9534f;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

            .sidebar {
                width: 200px;
                background-color: #333;
                color: #fff;
                position: fixed;
                top: 0;
                left: 0;
                height: 100vh;
                padding-top: 20px;
                overflow-y: auto;
            }

            .sidebar a {
                display: block;
                color: white;
                padding: 15px;
                text-decoration: none;
                font-size: 18px;
            }

            .sidebar a:hover {
                background-color: #575757;
            }

            .content {
                margin-left: 220px;
                padding: 20px;
            }

            h2 {
                color: #333;
            }

            .details-section {
                display: none;
                max-height: 500px;
                overflow-y: auto;
                padding: 10px;
                background-color: #ffffff;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                margin-top: 20px;
                border-radius: 5px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
                padding: 8px;
            }

            th {
                background-color: #4CAF50;
                color: white;
                text-align: left;
            }

            .form-container {
                margin-top: 20px;
            }

            .form-container label, .form-container input {
                display: block;
                margin: 8px 0;
                width: 100%;
                padding: 8px;
                font-size: 16px;
            }

            .form-container button {
                background-color: #4CAF50;
                color: white;
                border: none;
                padding: 10px;
                cursor: pointer;
                font-size: 16px;
                width: 100%;
            }
        </style>
        <script>
            function showSection(section) {
                document.querySelectorAll('.details-section').forEach(div => div.style.display = 'none');
                document.querySelector('.' + section).style.display = 'block';
                console.log("showSection function called with section:", section);
            }
            
            window.onload = function() {
                const urlParams = new URLSearchParams(window.location.search);
                const message = urlParams.get('message'); // Get the 'message' query parameter
                
                if (message) {
                    // Show the message in an alert
                    alert(decodeURIComponent(message.replace(/\+/g, ' '))); 
                }
            };
        </script>
    </head>
    <body>
        <form method="post" action="logout">
           <button class="logout-button" type="submit">Logout</button>
        </form>
        <div class="sidebar">
            <h2>Admin Dashboard</h2>
            <a href="#" onclick="showSection('employee-details'); return false;">Employee Details</a>
            <a href="#" onclick="showSection('customer-details'); return false;">Customer Details</a>
            <a href="#" onclick="showSection('shop-details'); return false;">Shop Details</a>
        </div>

        <div class="content">
            <h2>Welcome to the Admin Dashboard</h2>

            <!-- Employee Details Section -->
            <div class="details-section employee-details">
                <h3>Employee Details</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Role</th>
                            <th>Shop ID</th>
                            <th>Contact No.</th>
                            <th>Salary</th>
                            <th>Address</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Employee> reqList = adminDAO.findAllRequests();
                            if (reqList != null && !reqList.isEmpty()) {
                                for (Employee r : reqList) {
                        %>
                        <tr>
                            <td><%= r.getEmpId()%></td>
                            <td><%= r.getName()%></td>
                            <td><%= r.getAge()%></td>
                            <td><%= r.getRole()%></td>
                            <td><%= r.getShopId()%></td>
                            <td><%= r.getContactNo()%></td>
                            <td><%= r.getSalary()%></td>
                            <td><%= r.getAddress()%></td>
                        </tr>

                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="8">No employee records found.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Customer Details Section -->
            <div class="details-section customer-details">
                <h3>Customer Details</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Contact</th>
                        </tr>
                    </thead>
                                        <tbody>
                        <%
                            List<Customer> reqList1 = userDAO.findAllRequests();
                            if (reqList != null && !reqList.isEmpty()) {
                                for (Customer r : reqList1) {
                        %>
                        <tr>
                            <td><%= r.getCustomerId()%></td>
                            <td><%= r.getName()%></td>
                            <td><%= r.getEmail()%></td>
                            <td><%= r.getContactNo()%></td>
                        </tr>

                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="8">No employee records found.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <!-- Shop Details Section -->
            <div class="details-section shop-details">
                <h3>Shop Details</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Shop ID</th>
                            <th>Shop Name</th>
                            <th>Owner Name</th>
                            <th>Contact No.</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Shop> reqList2 = shopDAO.findAllRequests();
                            if (reqList2 != null && !reqList2.isEmpty()) {
                                for (Shop r : reqList2) {
                        %>
                        <tr>
                            <td><%= r.getShopId()%></td>
                            <td><%= r.getShopName()%></td>
                            <td><%= r.getOwnerName()%></td>
                            <td><%= r.getContactInfo()%></td>
                        </tr>

                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="8">No employee records found.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <!-- Form to Add New Shop -->
                <div class="form-container">
                    <h4>Add New Shop</h4>
                    <form method="post" action="shop">
                        <label for="shopid">Shop ID:</label>
                        <input type="text" id="shopid" name="shopid" required>

                        <label for="sname">Shop Name:</label>
                        <input type="text" id="sname" name="sname" required>

                        <label for="oname">Owner Name:</label>
                        <input type="text" id="oname" name="oname" required>

                        <label for="cinfo">Contact Info:</label>
                        <input type="text" id="cinfo" name="cinfo" required>

                        <label for="pass">Password</label>
                        <input type="password" id="pass" name="pass" required>

                        <button type="submit">Add Shop</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>