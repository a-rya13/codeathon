package dao;

import java.sql.*;
import utilities.ConnectionDB;
import beans.Employee;
import java.util.*;

public class adminDAO {

    public static List<Employee> findAllRequests() {
        List<Employee> requests = new ArrayList<>();
        String sql = "select * from employee";
        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Employee request = new Employee();
                request.setShopId(rs.getString("shopid"));
                request.setAddress(rs.getString("address"));
                request.setContactNo(rs.getString("emp_numb"));
                request.setEmpId(rs.getString("empid"));
                request.setRole(rs.getString("role"));
                request.setSalary(rs.getString("salary"));
                request.setName(rs.getString("name"));
                request.setAge(rs.getString("age"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static List<Employee> findSingleRequests(String username) {
        List<Employee> requests = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE shopid = ?";

        try (Connection conn = ConnectionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set the username parameter in the query
            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Employee request = new Employee();
                    request.setShopId(rs.getString("shopid"));
                    request.setAddress(rs.getString("address"));
                    request.setContactNo(rs.getString("emp_numb"));
                    request.setEmpId(rs.getString("empid"));
                    request.setRole(rs.getString("role"));
                    request.setSalary(rs.getString("salary"));
                    request.setName(rs.getString("name"));
                    request.setAge(rs.getString("age"));
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return requests;
    }
}
