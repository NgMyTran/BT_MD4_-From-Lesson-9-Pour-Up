package ra.dao.user1;

import ra.config.ConnectionDB;
import ra.model.User1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User11DaoImpl implements IUse1Dao {
    @Override
    public void register(User1 user){
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("insert into user (fullName, email, password, address, phone, status) values (?, ?, ?, ?, ?, ?)");
            sta.setString(1, user.getFullName());
            sta.setString(2, user.getEmail());
            sta.setString(3, user.getPassword());
            sta.setString(4, user.getAddress());
            sta.setString(5, user.getPhone());
            sta.setBoolean(6, true);
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }
    @Override
    public User1 login(String email, String password){
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try{
            sta = conn.prepareCall("select * from user where email =? and password =? and status = true");
            sta.setString(1, email);
            sta.setString(2, password);
            rs = sta.executeQuery();
            if (rs.next()){
                return new User1(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("phone"),
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
}
