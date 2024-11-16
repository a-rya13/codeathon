<%@page import="beans.Employee"%>
<%@page import="beans.Shop"%>
<%@page import="beans.Inventory"%>
<%@page import="beans.Customer"%>
<%@page import="java.util.*"%>
<%@page import="dao.adminDAO"%>
<%@page import="dao.userDAO"%>
<%@page import="dao.shopDAO"%>
<%@page import="dao.itemDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Dashboard</title>
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
            }
        </script>

        <script>
            // Function to display an alert message based on the query parameter
            function showAlert() {
                // Get the query string from the URL
                const params = new URLSearchParams(window.location.search);

                // Get the 'message' parameter from the URL
                const message = params.get('message');

                if (message) {
                    // Display the message in an alert box
                    alert(decodeURIComponent(message.replace(/\+/g, ' ')));
                }
            }

            // Call the showAlert function when the page loads
            window.onload = showAlert;
        </script>
    </head>
    <body>
        <form method="post" action="logout">
            <button class="logout-button" type="submit">Logout</button>
        </form>

        <div class="sidebar">
            <h2>Shop Dashboard</h2>
            <a href="#" onclick="showSection('shop-details')">Shop Details</a>
            <a href="#" onclick="showSection('employee-management')">Employee Management</a>
            <a href="#" onclick="showSection('inventory-management')">Inventory Management</a>
        </div>

        <div class="content">
            <h2>Welcome to the Shop Dashboard</h2>

            <%String username = (String) session.getAttribute("username");%>

            <!-- Shop Details Section -->
            <div class="details-section shop-details">
                <h3>Shop Details</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Shop ID</th>
                            <th>Shop Name</th>
                            <th>Owner Name</th>
                            <th>Contact Info</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Shop> reqList2 = shopDAO.findSingleRequests(username);
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
            </div>

            <!-- Employee Management Section -->
            <div class="details-section employee-management">
                <h3>Employee Management</h3>
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
                            List<Employee> reqList = adminDAO.findSingleRequests(username);
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

                <!-- Form to Add New Employee -->
                <div class="form-container">
                    <h4>Add New Employee</h4>
                    <form method="post" action="employee">
                        <label for="employeeid">Employee ID:</label>
                        <input type="text" id="employeeid" name="empid" required>

                        <label for="ename">Name:</label>
                        <input type="text" id="ename" name="name" required>

                        <label for="age">Age:</label>
                        <input type="text" id="age" name="age" required>

                        <label for="shopid">Shop ID:</label>
                        <input type="text" id="shopid" name="shopid" required value=<%=username%> readonly>

                        <label for="role">Role:</label>
                        <input type="text" id="role" name="role" required>

                        <label for="salary">Salary:</label>
                        <input type="text" id="salary" name="salary" required>

                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" required>

                        <label for="empnum">Emp number :</label>
                        <input type="text" id="empnum" name="emp_numb" required>

                        <button type="submit">Add Employee</button>
                    </form>
                </div>
            </div>

            <!-- Inventory Management Section -->
            <div class="details-section inventory-management">
                <h3>Inventory Management</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Category</th>
                            <th>Shop ID</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Inventory> reqList3 = itemDAO.findSingleRequests(username);
                            if (reqList3 != null && !reqList3.isEmpty()) {
                                for (Inventory r : reqList3) {
                        %>
                        <tr>
                            <td><%= r.getProductId()%></td>
                            <td><%= r.getProductName()%></td>
                            <td><%= r.getQuantity() %></td>
                            <td><%= r.getShopId() %></td>
                            <td><%= r.getPrice() %></td>
                        </tr>

                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="8">No items records found.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <!-- Form to Add New Inventory Item -->
                <div class="form-container">
                    <h4>Add New Inventory Item</h4>
                    <form method="post" action="item">
                        <label for="pid">Product ID:</label>
                        <input type="text" id="pid" name="pid" required>

                        <label for="pname">Product Name:</label>
                        <input type="text" id="pname" name="pname" required>

                        <label for="shopid">Shop ID:</label>
                        <input type="text" id="shopid" name="shopid" required value=<%=username%> readonly>

                        <label for="quantity">Stock Quantity:</label>
                        <input type="number" id="quantity" name="quantity" required>

                        <label for="price">Price:</label>
                        <input type="number" id="price" name="price" required>

                        <button type="submit">Add Item</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>