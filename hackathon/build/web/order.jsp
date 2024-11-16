<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.Inventory" %>
<%@ page import="java.util.*" %>
<%@ page import="dao.itemDAO" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Order Page</title>
        <style>
           
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
            }

            .content {
                padding: 20px;
                max-width: 1000px;
                margin: auto;
            }

            h2 {
                color: #333;
                text-align: center;
                margin-bottom: 20px;
            }

            .card-container {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
            }

            .card {
                background-color: #fff;
                border: 1px solid #ddd;
                border-radius: 8px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
                text-align: center;
                overflow: hidden;
                flex: 1 1 30%;
            }

            .card-content {
                padding: 15px;
            }

            .card-content h3 {
                font-size: 18px;
                margin: 10px 0;
            }

            .card-content p {
                font-size: 14px;
                color: #555;
            }

            .price {
                font-weight: bold;
                margin: 10px 0;
            }

            .quantity-input {
                width: 50px;
                padding: 5px;
                font-size: 16px;
                margin-top: 10px;
                text-align: center;
            }

            .purchase-container {
                text-align: center;
                margin-top: 30px;
                padding: 20px;
            }

            .purchase-button {
                background-color: #4CAF50;
                color: white;
                border: none;
                padding: 12px 20px;
                font-size: 18px;
                cursor: pointer;
                border-radius: 5px;
                width: 100%;
                max-width: 300px;
            }

            /* Responsive Design */
            @media (max-width: 1024px) {
                .card {
                    flex: 1 1 45%;
                    max-width: 45%;
                }
            }

            @media (max-width: 768px) {
                .card {
                    flex: 1 1 100%;
                    max-width: 100%;
                }
            }
        </style>
    </head>
    <body>

        <div class="content">
            <h2>Order Page</h2>

            <div class="card-container">
                <form method="post" action="OrderServlet">
                    <%
                        // Fetch shop parameter
                        String shopId = request.getParameter("shop");
                        if (shopId == null || shopId.trim().isEmpty()) {
                            out.println("<p>Error: Shop parameter is missing.</p>");
                        } else {
                            List<Inventory> inventoryList = itemDAO.findSingleRequests(shopId);

                            // Generate Random Order ID based on timestamp for uniqueness
                            String orderId = "ORD" + new Date().getTime();
                            request.setAttribute("orderId", orderId);

                            if (inventoryList != null && !inventoryList.isEmpty()) {
                                for (Inventory r : inventoryList) {
                    %>
                    <div class="card">
                        <div class="card-content">
                            <h3><%= r.getProductName()%></h3>
                            <p class="price">₹<%= r.getPrice()%></p>
                            <input type="hidden" name="productId_<%= r.getProductId()%>" value="<%= r.getProductId()%>">
                            <input type="hidden" name="shopId" value="<%= r.getShopId()%>">
                            <input type="hidden" name="productPrice_<%= r.getProductId()%>" value="<%= r.getPrice()%>">
                            <input type="hidden" name="productName_<%= r.getProductId()%>" value="<%= r.getProductName()%>"> <!-- Add this line -->
                            <label>Quantity:</label>
                            <input type="number" name="quantity_<%= r.getProductId()%>" min="0" value="0" class="quantity-input">
                        </div>
                    </div>

                    <%
                        }
                    } else {
                    %>
                    <p>No items available for this shop.</p>
                    <%
                            }
                        }
                    %>

                    <!-- Purchase Button -->
                    <div class="purchase-container">
                        <input type="hidden" name="orderId" value="1">
                        <button class="purchase-button" type="submit">Purchase</button>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
