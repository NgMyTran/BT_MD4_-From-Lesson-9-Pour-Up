package ra.dao.produc1;

import org.springframework.stereotype.Repository;
import ra.config.ConnectionDB;
import ra.model.Product1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@Repository
public class Product1DaoImpl implements IProduct1Dao {
    @Override
    public List<Product1> findAll() {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        List<Product1> products = new ArrayList<>();
        try{
            sta = conn.prepareCall("SELECT * FROM product1");
            rs = sta.executeQuery();
            while (rs.next()){
                Product1 product = new Product1(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("categoryId"),
                        rs.getBoolean("status")
                );
                products.add(product);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return products;
    }

    @Override
    public Product1 findById(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try{
            sta = conn.prepareCall("SELECT * FROM product1 WHERE id =?");
            sta.setInt(1, id);
            rs = sta.executeQuery();
            if (rs.next()){
                return new Product1(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("categoryId"),
                        rs.getBoolean("status")
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return null;
    }

    @Override
    public void update(Product1 product) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("UPDATE product1 SET name =?, price =?, stock =?, categoryId = ?, status =? WHERE id =?");
            sta.setString(1, product.getName());
            sta.setDouble(2, product.getPrice());
            sta.setInt(3, product.getStock());
            sta.setInt(4, product.getCategoryId());
            sta.setBoolean(5, product.isStatus());
            sta.setInt(6, product.getId());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("DELETE FROM product1 WHERE id =?");
            sta.setInt(1, id);
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void create(Product1 product) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("INSERT INTO product1 (name, price, stock, categoryId, status) VALUES (?,?,?,?,?)");
            sta.setString(1, product.getName());
            sta.setDouble(2, product.getPrice());
            sta.setInt(3, product.getStock());
            sta.setInt(4, product.getCategoryId());
            sta.setBoolean(5, product.isStatus());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }
}
