package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import beans.Employee;
import dao.employeeDAO;
import java.sql.SQLException;

public class employee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Get parameters from the request
            String name = request.getParameter("name");
            String empid = request.getParameter("empid");
            String age = request.getParameter("age");
            String shopid = request.getParameter("shopid");
            String role = request.getParameter("role");
            String salary = request.getParameter("salary");
            String address = request.getParameter("address");
            String emp_numb = request.getParameter("emp_numb");
            
            // Validate the parameters
            if (name == null || name.isEmpty() || empid == null || empid.isEmpty() || 
                age == null || age.isEmpty() || shopid == null || shopid.isEmpty() || 
                role == null || role.isEmpty() || salary == null || salary.isEmpty() || 
                address == null || address.isEmpty() || emp_numb == null || emp_numb.isEmpty()) {
                
                // Redirect with error message if any parameter is missing
                response.sendRedirect("shop.jsp?message=Missing+or+Invalid+Input");
                return;
            }

            // Create an Employee object with the validated parameters
            Employee emp = new Employee(empid, name, age, role, shopid, emp_numb, salary, address);
            employeeDAO user = new employeeDAO();

            // Attempt to insert the employee and redirect based on success or failure
            boolean isInserted = user.insert(emp);
            if (isInserted) {
                response.sendRedirect("shop.jsp?message=Registration+Successful");
            } else {
                response.sendRedirect("shop.jsp?message=Error+in+Registration");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("shop.jsp?message=Database+Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles employee registration";
    }
}
