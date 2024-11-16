package dao;

import beans.Shop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilities.ConnectionDB;

public class shopDAO {

    private Connection con;
    private PreparedStatement ps;

    // Constructor to initialize the database connection
    public shopDAO() throws SQLException {
        this.con = ConnectionDB.getConnection();
        this.ps = null;
    }

    public boolean insert(Shop shop) {
        try {
            String sql = "INSERT INTO shop (shopid, owner_name, contact_info, PASSWORD, SNAME) VALUES(?, ?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, shop.getShopId());
            ps.setString(2, shop.getOwnerName());
            ps.setString(3, shop.getContactInfo());
            ps.setString(4, shop.getPass());
            ps.setString(5, shop.getShopName());
            int x = ps.executeUpdate();
            return x > 0;
        } catch (SQLException e) {
            System.out.print(e);
        }

        return false;
    }

    public static List<Shop> findAllRequests() {
        List<Shop> requests = new ArrayList<>();
        String sql = "select * from shop";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Shop request = new Shop();
                request.setShopId(rs.getString("shopid"));
                request.setShopName(rs.getString("sname"));
                request.setOwnerName(rs.getString("owner_name"));
                request.setContactInfo(rs.getString("contact_info"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static List<Shop> findSingleRequests(String username) {
        List<Shop> requests = new ArrayList<>();
        String sql = "SELECT * FROM shop WHERE shopid = ?";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the username parameter in the query
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Shop request = new Shop();
                    request.setShopId(rs.getString("shopid"));
                    request.setShopName(rs.getString("sname"));
                    request.setOwnerName(rs.getString("owner_name"));
                    request.setContactInfo(rs.getString("contact_info"));
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }

}
