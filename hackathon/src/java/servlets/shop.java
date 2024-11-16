package servlets;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import beans.Shop;
import dao.shopDAO;

public class shop extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String shopid = request.getParameter("shopid");
            String oname = request.getParameter("oname");
            String cinfo = request.getParameter("cinfo");
            String pass = request.getParameter("pass");
            String sname = request.getParameter("sname");

            if (shopid == null || shopid.isEmpty() || cinfo == null || cinfo.isEmpty()
                    || oname == null || oname.isEmpty() || pass == null || pass.isEmpty()
                    || sname == null || sname.isEmpty()) {
                response.sendRedirect("admin_dashboard.jsp?message=Missing+or+Invalid+Input");
                return;
            }

            Shop shop = new Shop(shopid, sname, oname, cinfo, pass);

            shopDAO sh = new shopDAO();
            boolean isInserted = sh.insert(shop);

            if (isInserted) {
                response.sendRedirect("admin_dashboard.jsp?message=Shop+Added");
            }
            else
            {
                response.sendRedirect("admin_dashboard.jsp?message=failure");
            }
        } catch (SQLException e) {
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
        return "Short description";
    }// </editor-fold>

}
