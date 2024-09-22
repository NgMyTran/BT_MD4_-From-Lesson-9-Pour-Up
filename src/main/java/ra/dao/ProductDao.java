package ra.dao;

import org.springframework.stereotype.Repository;
import ra.config.ConnectionDB;
import ra.model.Product;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date; // Thêm import cho java.sql.Date
//import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductDao implements IProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call DisplayProducts()}");
            ResultSet rs = callst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getDate("created").toLocalDate(), // Sửa ở đây
                        rs.getString("image"),
                        rs.getBoolean("status")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        String sql = "SELECT * FROM Products WHERE id = ?";
        try (Connection conn = ConnectionDB.getOpenConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getDate("created").toLocalDate(), // Sửa ở đây
                        rs.getString("image"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Product product) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call AddProduct(?,?,?,?,?)}");
            callst.setString(1, product.getName());
            callst.setDouble(2, product.getPrice());
            callst.setInt(3, product.getStock());
            callst.setString(4, product.getImage());
            callst.setBoolean(5, product.isStatus());
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void update(Product product) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call UpdateProduct(?,?,?,?,?,?)}");
            callst.setInt(1, product.getId());
            callst.setString(2, product.getName());
            callst.setDouble(3, product.getPrice());
            callst.setInt(4, product.getStock());
            callst.setString(5, product.getImage());
            callst.setBoolean(6, product.isStatus());
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call DeleteProduct(?)}");
            callst.setInt(1, id);
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }
}
