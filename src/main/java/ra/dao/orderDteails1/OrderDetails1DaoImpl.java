package ra.dao.orderDteails1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.config.ConnectionDB;
import ra.dao.produc1.IProduct1Dao;
import ra.model.OrderDetails1;
import ra.model.Product1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetails1DaoImpl implements IOrderDetails1Dao {

    @Autowired
    private IProduct1Dao iProductDao1;

    @Override
    public List<OrderDetails1> findAll() {
        Connection connection = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        List<OrderDetails1> orderDetailsList = new ArrayList<>();
        try {
            sta = connection.prepareCall("SELECT * FROM OrderDetails");
            rs = sta.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                Product1 product = iProductDao1.findById(productId); // Lấy thông tin sản phẩm

                OrderDetails1 orderDetails = new OrderDetails1(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        productId,
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        product
                );
                orderDetailsList.add(orderDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.getClosedConnection(connection);
        }
        return orderDetailsList;
    }


    @Override
    public OrderDetails1 findById(Integer id) {
        Connection connection = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try {
            sta = connection.prepareCall("SELECT * FROM OrderDetails WHERE id = ?");
            sta.setInt(1, id);
            rs = sta.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("orderId");
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Product1 product = iProductDao1.findById(productId);
                return new OrderDetails1(id, orderId, productId, quantity, price, product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.getClosedConnection(connection);
        }
        return null;
    }


    @Override
    public void update(OrderDetails1 orderDetails) {
        Connection connection = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("update OrderDetails set quantity=?");
            sta.setInt(1, orderDetails.getQuantity());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("DELETE FROM OrderDetails WHERE id =?");
            sta.setInt(1, id);
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(connection);
        }
    }

    @Override
    public void create(OrderDetails1 orderDetails) {
        Connection connection = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = connection.prepareCall("INSERT INTO OrderDetails (orderId, productId, quantity, price) VALUES (?,?,?,?)");
            sta.setInt(1, orderDetails.getOrderId());
            sta.setInt(2, orderDetails.getProductId());
            sta.setInt(3, orderDetails.getQuantity());
            sta.setDouble(4, orderDetails.getPrice());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(connection);
        }
    }
}
