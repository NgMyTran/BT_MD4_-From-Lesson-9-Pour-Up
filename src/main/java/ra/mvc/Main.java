package ra.mvc;

import ra.mvc.configOrUtil.ConnectionDB;

import java.sql.*;

public class Main {

//    private static final String URL="jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true";
//    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
//    private static final String USERNAME="root";
//    private static final String PASSWORD="MySQLPass30rd";
//
//    public static void main(String[] args) {
//        Connection conn=null;
//        try {
//            Class.forName(DRIVER);
//            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            System.out.println("successfull connection");
//        } catch (ClassNotFoundException e) {
//            System.out.println("driver not found");
//        } catch (SQLException e) {
//            System.out.println("error occured SQL");
//            throw new RuntimeException(e);
//        }finally {
//            System.out.println("End");
//        }
//        System.out.println(conn);
//
//    }
public static void main(String[] args) {
    Connection conn=null;
    try {
        conn = ConnectionDB.getOpenConnection();
//        String createTableSQL = "CREATE TABLE IF NOT EXISTS customer("
//                + "id INT PRIMARY KEY AUTO_INCREMENT, "
//                + "name VARCHAR(100) NOT NULL, "
//                + "address VARCHAR(255) NOT NULL, "
//                + "email VARCHAR(255) NOT NULL)";
        Statement statement = conn.createStatement();
//        statement.executeUpdate(createTableSQL);
//        System.out.println("Table 'customer' is created or already exists.");
//        // Thêm
//        String insertSQL = "INSERT INTO customer (name, address, email) VALUES ('John Doe', '123 Street', 'johndoe@example.com')";
//        int rowsInserted = statement.executeUpdate(insertSQL);
//        if (rowsInserted > 0) {
//            System.out.println("A new customer was inserted successfully!");
//        }

        //       // Thêm prepareStatement
//        String insertSQL = "INSERT INTO customer (name, address, email) VALUES (?, ?, ?)";
//        PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);

//        preparedStatement.setString(1, "Alice Smith");
//        preparedStatement.setString(2, "789 Boulevard");
//        preparedStatement.setString(3, "alicesmith@example.com");
//        int rowsInserted1 = preparedStatement.executeUpdate();
//        if (rowsInserted1 > 0) {
//            System.out.println("A new customer (Alice Smith) was inserted successfully!");
//        }
//
//        preparedStatement.setString(1, "Bob Johnson");
//        preparedStatement.setString(2, "101 Road");
//        preparedStatement.setString(3, "bobjohnson@example.com");
//        int rowsInserted2 = preparedStatement.executeUpdate();
//        if (rowsInserted2 > 0) {
//            System.out.println("A new customer (Bob Johnson) was inserted successfully!");
//        }

////         update
//        String updateSQL = "UPDATE customer SET name = ?, address = ?, email = ? WHERE id = ?";
//        PreparedStatement preparedStatement = conn.prepareStatement(updateSQL);
//        preparedStatement.setString(1, "Jane Doe");
//        preparedStatement.setString(2, "456 Avenue");
//        preparedStatement.setString(3, "janedoe@example.com");
//        preparedStatement.setInt(4, 2);
//        int rowsUpdated = preparedStatement.executeUpdate();
//        if (rowsUpdated > 0) {
//            System.out.println("Customer data updated successfully!");
//        }

//        //delete statement
//        String deleteSQL = "DELETE FROM customer WHERE id = 3";
//        int rowsDeleted = statement.executeUpdate(deleteSQL);
//        if (rowsDeleted > 0) {
//            System.out.println("Customer was deleted successfully!");
//        }
       //delete preparestatement
        String delSQL="DELETE from customer WHERE id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(delSQL);
        preparedStatement.setInt(1, 4);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        // Đóng kết nối
        ConnectionDB.getClosedConnection(conn);
    }
}
}
