package ra.dao.order1;

import org.springframework.stereotype.Repository;
import ra.config.ConnectionDB;
import ra.model.Order1;

import java.sql.*;

@Repository
public class Order1DaoImpl implements IOrder1Dao {
    @Override
    public void save(Order1 order) {
        Connection connection = ConnectionDB.getOpenConnection();
        PreparedStatement sta = null;
        try {
            sta = connection.prepareStatement("INSERT INTO `order` (userId, totals, status) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            sta.setInt(1, order.getUserId());
            sta.setDouble(2, order.getTotals());
            sta.setString(3, order.getStatus().name());
            sta.executeUpdate();

            // Lấy ID của đơn hàng vừa tạo
            ResultSet generatedKeys = sta.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.getClosedConnection(connection);
        }
    }
}
