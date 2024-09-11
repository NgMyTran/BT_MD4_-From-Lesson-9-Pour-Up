package rikkei.academy.util;

import rikkei.academy.model.User;
import rikkei.academy.service.user.UserServiceIMPL;
import rikkei.academy.service.user.IUserService;
import ra.mvc.configOrUtil.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseSeeder {

    private static IUserService userService = new UserServiceIMPL();

    public static void main(String[] args) {
        try {
            createTable();

            clearData();

            seedData();

            listData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = ConnectionDB.getOpenConnection();
            stmt = conn.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS user ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "email VARCHAR(255) NOT NULL, "
                    + "country VARCHAR(100) NOT NULL)";

            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'user' is created or already exists.");
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) ConnectionDB.getClosedConnection(conn);
        }
    }

    private static void clearData() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionDB.getOpenConnection();
            String deleteSQL = "DELETE FROM user";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.executeUpdate();
            System.out.println("Old data cleared.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) ConnectionDB.getClosedConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void seedData() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionDB.getOpenConnection();
            String insertSQL = "INSERT INTO user (name, email, country) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Chèn dữ liệu giả
            pstmt.setString(1, "Alice Smith");
            pstmt.setString(2, "alicesmith@example.com");
            pstmt.setString(3, "USA");
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob Johnson");
            pstmt.setString(2, "bobjohnson@example.com");
            pstmt.setString(3, "Canada");
            pstmt.executeUpdate();

            pstmt.setString(1, "Charlie Brown");
            pstmt.setString(2, "charliebrown@example.com");
            pstmt.setString(3, "UK");
            pstmt.executeUpdate();

            System.out.println("Sample data inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) ConnectionDB.getClosedConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listData() {
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
