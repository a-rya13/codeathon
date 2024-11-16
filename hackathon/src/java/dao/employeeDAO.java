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
import beans.Employee;

/**
 *
 * @author vanshamaggarwal
 */
public class employeeDAO {
    private Connection con;
    private PreparedStatement ps;
    // Constructor to initialize the database connection
    public employeeDAO() throws SQLException {
        this.con = ConnectionDB.getConnection();
        this.ps = null;
    }
    
    public boolean validate(String shopid,String password)
    {
        try{
            String sql = "select * from  shop where shopid = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,shopid);
            ps.setString(2,password);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
        return true;
    }
    
    public boolean insert(Employee employee)
    {
        try{
            String sql = "INSERT INTO Employee (empid,name,age,shopid,role,salary,address,emp_numb) VALUES(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, employee.getEmpId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getAge());
            ps.setString(4, employee.getShopId());
            ps.setString(5, employee.getRole());
            ps.setString(6, employee.getSalary());
            ps.setString(7, employee.getAddress());
            ps.setString(8, employee.getContactNo());
            int x = ps.executeUpdate();
            return x>0;
        }
        catch(SQLException e){
            System.out.print(e);
        }
        
        return false;
    }
}
