package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import dao.userDAO;
import beans.Customer;

public class user extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Fetch parameters from the request
            String cid = request.getParameter("cid");
            String cname = request.getParameter("cname");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String cnum = request.getParameter("cnum");

            // Validate input (optional, but recommended)
            if (cid == null || cid.isEmpty() || cname == null || cname.isEmpty() ||
                email == null || email.isEmpty() || pass == null || pass.isEmpty() ||
                cnum == null || cnum.isEmpty()) {
                response.sendRedirect("index.html?message=Missing+or+Invalid+Input");
                return;
            }

            // Create Customer object
            Customer customer = new Customer(cid, cname, cnum, email, pass);

            // Insert customer using userDAO
            userDAO user = new userDAO();
            boolean isInserted = user.insert(customer);

            if (isInserted) {
                response.sendRedirect("index.html?message=Registration+Successful");
            } else {
                response.sendRedirect("index.html?message=Error+in+Registration");
            }

        } catch (SQLException e) {
            System.out.print(e);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles customer registration.";
    }
}
