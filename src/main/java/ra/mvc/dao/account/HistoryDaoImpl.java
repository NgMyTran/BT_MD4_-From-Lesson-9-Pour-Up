//package ra.mvc.dao.account;
//
//import ra.mvc.configorutil.ConnectionDB;
//import ra.mvc.model.History;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HistoryDaoImpl implements IHistoryDao {
//
//    @Override
//    public List<History> getHistoryByUserId(int userId) {
//        Connection conn = ConnectionDB.getOpenConnection();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        List<History> historyList = new ArrayList<>();
//
//        try {
//            pstmt = conn.prepareStatement("SELECT * FROM balance_history WHERE user_id = ? ORDER BY created_time DESC");
//            pstmt.setInt(1, userId);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                History history = new History(
//                        rs.getInt("id"),
//                        rs.getInt("user_id"),
//                        rs.getInt("change_amount"),
//                        rs.getInt("balance_after_change"),
//                        rs.getDate((Date)"created_time")
//                );
//                historyList.add(history);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error fetching balance history", e);
//        } finally {
//            ConnectionDB.getClosedConnection(conn);
//        }
//
//        return historyList;
//    }
//}
