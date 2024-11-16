package utilities;

import java.sql.*;

public class ConnectionDB {

    private static final String URL = ("jdbc:derby://localhost:1527/codeathon");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
