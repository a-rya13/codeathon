package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username"); // Get customer ID from session

        // Generate unique order ID using date and time
        String orderId = "ORDER-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        double totalPrice = 0.0;
        String shopId = "";

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Order Summary</title>");
        out.println("<style>");
        out.println("table { width: 80%; margin: auto; border-collapse: collapse; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println(".total { font-weight: bold; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 style='text-align: center;'>Order Summary</h2>");
        out.println("<p style='text-align: center;'>Order ID: " + orderId + "</p>");
        out.println("<p style='text-align: center;'>Customer: " + username + "</p>");

        out.println("<table>");
        out.println("<tr><th>Product Name</th><th>Price</th><th>Quantity</th><th>Item Total</th></tr>");

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("quantity_")) {
                int quantity = Integer.parseInt(request.getParameter(paramName));
                if (quantity > 0) {
                    String productId = paramName.split("_")[1];
                    String productName = request.getParameter("productName_" + productId);
                    double price = Double.parseDouble(request.getParameter("productPrice_" + productId));
                    shopId = request.getParameter("shopId");

                    double itemTotal = price * quantity;
                    totalPrice += itemTotal;

                    out.println("<tr>");
                    out.println("<td>" + productName + "</td>");
                    out.println("<td>" + price + "</td>");
                    out.println("<td>" + quantity + "</td>");
                    out.println("<td>" + itemTotal + "</td>");
                    out.println("</tr>");
                }
            }
        }

        out.println("<tr class='total'>");
        out.println("<td colspan='3'>Total Price</td>");
        out.println("<td>" + totalPrice + "</td>");
        out.println("</tr>");
        out.println("</table>");

        out.println("<p style='text-align: center;'>Shop ID: " + shopId + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}