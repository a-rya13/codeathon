package dao;
import java.sql.*;
import utilities.ConnectionDB;
import beans.Customer;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
    private Connection con;
    private PreparedStatement ps;
    // Constructor to initialize the database connection
    public userDAO() throws SQLException {
        this.con = ConnectionDB.getConnection();
        this.ps = null;
    }
    
    public boolean validate(String email,String password)
    {
        try{
            String sql = "select * from customer where email = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,password);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
        return false;
    }
    
    public boolean insert(Customer customer)
    {
        try{
            String sql = "INSERT INTO CUSTOMER (CUSTOMERID, CUST_NAME, CUST_NUM, EMAIL, PASSWORD) VALUES(?, ?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getContactNo());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPassword());
            int x = ps.executeUpdate();
            return x>0;
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
        return false;
    }
    
    public static List<Customer> findAllRequests() {
        List<Customer> requests = new ArrayList<>();
        String sql = "select * from customer";
        try (Connection conn = ConnectionDB.getConnection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                ResultSet rs = pstmt.executeQuery()) 
        {
            while (rs.next()) {
                Customer request = new Customer();
                request.setCustomerId(rs.getString("customerid"));
                request.setName(rs.getString("cust_name"));
                request.setEmail(rs.getString("email"));
                request.setContactNo(rs.getString("cust_num"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }
}
