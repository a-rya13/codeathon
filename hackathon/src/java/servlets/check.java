package servlets;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.userDAO;
import dao.employeeDAO;
import jakarta.servlet.http.HttpSession;

public class check extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            userDAO user = new userDAO();
            employeeDAO emp = new employeeDAO();
            String admin = "admin";
            String pass = "admin";

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nm = request.getParameter("nm");

            if (nm != null) {
                switch (nm) {
                    case "admin":
                        if (admin.equals(username) && pass.equals(password)) {
                            HttpSession session = request.getSession();
                            if (session.getAttribute("username") == null) {
                                session.setAttribute("username", "admin");
                            }
                            response.sendRedirect("admin_dashboard.jsp");
                        } else {
                            response.sendRedirect("index.html?error=invalid");
                        }
                        break;

                    case "customer":
                        if (user.validate(username, password)) {
                            HttpSession session = request.getSession();
                            if (session.getAttribute("username") == null) {
                                session.setAttribute("username", username);
                            }
                            response.sendRedirect("user.jsp");
                        } else {
                            response.sendRedirect("index.html?error=invalid");
                        }
                        break;

                    case "shop":
                        if (emp.validate(username, password)) {
                            HttpSession session = request.getSession();
                            if (session.getAttribute("username") == null) {
                                session.setAttribute("username", username);
                            }
                            response.sendRedirect("shop.jsp");

                        } else {
                            response.sendRedirect("index.html?error=invalid");
                        }
                        break;

                    default:
                        response.sendRedirect("index.html?error=invalid");
                        break;
                }
            } else {
                response.sendRedirect("index.html?error=missingRole");
            }
        } catch (SQLException e) {
            System.out.print(e);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles login authentication for admin, customer, and shop users.";
    }
}
