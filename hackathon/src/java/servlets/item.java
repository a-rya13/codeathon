package servlets;

import java.io.IOException;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import java.util.Base64;
import beans.Inventory;
import dao.itemDAO;

@MultipartConfig
public class item extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String pid = request.getParameter("pid");
            String quantity = request.getParameter("quantity");
            String shopid = request.getParameter("shopid");
            String pname = request.getParameter("pname");
            String price = request.getParameter("price");

            Inventory inv = new Inventory(pid, quantity, shopid, pname, price);
                itemDAO itemDao = new itemDAO();
                boolean isInserted = itemDao.insert(inv);
                if (isInserted) {
                    response.sendRedirect("shop.jsp?message=Item+Added+Successfully");
                } 
                else
                {
                    response.sendRedirect("shop.jsp?message=Item+not+added");
                }
            
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}