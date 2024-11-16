<%-- 
    Document   : user
    Created on : 09-Nov-2024, 7:39:47 pm
    Author     : vanshamaggarwal
--%>
<%@page import="beans.Shop"%>
<%@page import="java.util.*"%>
<%@page import="dao.adminDAO"%>
<%@page import="dao.userDAO"%>
<%@page import="dao.shopDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
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
            max-height: 500px;
            overflow-y: auto;
            padding: 10px;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            border-radius: 5px;
        }

        .form-container label, .form-container select, .form-container button {
            display: block;
            margin: 8px 0;
            padding: 10px;
            font-size: 16px;
        }

        .form-container button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
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
    </style>
</head>
<body>
    
    <form method="post" action="logout">
           <button class="logout-button" type="submit">Logout</button>
        </form>
    <div class="sidebar">
        <h2>User Dashboard</h2>

        
    </div>

    <div class="content">
        <h2>Welcome to Your Dashboard</h2>
        
        <!-- Shop Selection Section -->
        <div class="details-section shop-selection" style="display: block;">
            <form class="form-container" method="post" action="order.jsp">
                <select id="shop-select" name="shop" >
                    <option disabled selected>Select a shop</option>
                        <%
                            List<Shop> reqList2 = shopDAO.findAllRequests();
                            if (reqList2 != null && !reqList2.isEmpty()) {
                                for (Shop r : reqList2) {
                        %>
                            <option value=<%= r.getShopId()%>><%= r.getShopName() %></option>
                        <%
                            }
                        } 
                        %>
                    </tbody>
                </select>
                <div>
                    <button type="submit">Go to Shop</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>

