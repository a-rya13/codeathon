/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.ConnectionDB;
import beans.Inventory;
import java.util.ArrayList;
import java.util.List;

public class itemDAO {
    private Connection con;
    private PreparedStatement ps;
    // Constructor to initialize the database connection
    public itemDAO() throws SQLException {
        this.con = ConnectionDB.getConnection();
        this.ps = null;
    }
    
    public boolean insert(Inventory inv)
    {
        try{
            String sql = "insert into inventory (productid,quantity,shopid,product_name,price) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,inv.getProductId());
            ps.setString(2,inv.getQuantity());
            ps.setString(3,inv.getShopId());
            ps.setString(4,inv.getProductName());
            ps.setString(5,inv.getPrice());
            
            int x = ps.executeUpdate();
            return x > 0;
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
        return true;
    }
    
    public static List<Inventory> findSingleRequests(String username) {
        List<Inventory> requests = new ArrayList<>();
        String sql = "SELECT * FROM inventory WHERE shopid = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the username parameter in the query
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Inventory request = new Inventory();
                    request.setPrice(rs.getString("price"));
                    request.setProductId(rs.getString("productid"));
                    request.setProductName(rs.getString("product_name"));
                    request.setQuantity(rs.getString("quantity"));
                    request.setShopId(rs.getString("shopid"));
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }
    
}
