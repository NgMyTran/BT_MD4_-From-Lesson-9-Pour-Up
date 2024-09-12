package ra.mvc.dao.account;

import ra.mvc.configorutil.ConnectionDB;
import ra.mvc.model.Account;
//import ra.mvc.model.History;

import java.sql.*;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public Account login(String username, String password) {
        Connection conn= ConnectionDB.getOpenConnection();
        CallableStatement callStmt = null;
        try {
            callStmt=conn.prepareCall("{call login(?,?)}");
            //truyền tham số
            callStmt.setString(1, username);
            callStmt.setString(2, password);
            //thực thi lệnh
            ResultSet rs=callStmt.executeQuery();
            if(rs.next()){
                Account account=new Account(
                        rs.getInt("id"),
                        rs.getString("username"),
                        "",// k lay pass
                        rs.getString("fullName"),
                        rs.getInt("balance")
                );
                return account;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void sendMoney(int idSender, int idReceiver, int amount) {
        Connection conn= ConnectionDB.getOpenConnection();
        CallableStatement callStmt1 = null;
        CallableStatement callStmt2 = null;
        try {
            conn.setAutoCommit(false);
            // Gọi stored procedure để giảm số dư tk gửi
            callStmt1=conn.prepareCall("{call changeBalance(?,?)}");
            callStmt1.setInt(1, -amount);
            callStmt1.setInt(2, idSender);
            callStmt1.executeUpdate();

            callStmt2=conn.prepareCall("{call changeBalance(?,?)}");
            callStmt2.setInt(1,amount);
            callStmt2.setInt(2, idReceiver);
            callStmt2.executeUpdate();

            conn.commit(); // Xác nhận giao dịch
        } catch (SQLException e) {
            try {
                if (conn!=null) conn.rollback();// Hoàn tác giao dịch nếu có lỗi
            } catch (SQLException rollbackEx) {
                throw new RuntimeException("Không thể hoàn tác giao dịch", rollbackEx);
            } throw new RuntimeException("Giao dịch bị lỗi", e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

//    @Override
//    public void insertHistory(History history) {
//        Connection conn = ConnectionDB.getOpenConnection();
//        CallableStatement callStmt = null;
//        try {
//            callStmt = conn.prepareCall("{call insertHistory(?, ?, ?)}");
//            callStmt.setInt(1, history.getAccountId());
//            callStmt.setInt(2, history.getAmount());
//            callStmt.setDate(3, (Date) history.getCreatedTime());
//            callStmt.executeUpdate();
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            ConnectionDB.getClosedConnection(conn);
//        }
//    }
}
