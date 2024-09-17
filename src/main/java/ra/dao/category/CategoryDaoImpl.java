package ra.dao.category;

import java.sql.*;

import ra.model.Category;
import ra.util.ConnectionDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {


    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        // mở két nối
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try{
            callst = conn.prepareCall("{call DisplayCategories()}");
            ResultSet rs = callst.executeQuery();
            while (rs.next()){
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                list.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // dóng kết nối
            ConnectionDB.getClosedConnection(conn);
        }
        return list;
    }

//    @Override
//    public Category findById(Integer id) {
//        Connection conn = ConnectionDB.getOpenConnection();
//        CallableStatement callst = null;
//        try{
//            callst = conn.prepareCall("{call getCategoryById(?)}");
//
//            // Thiết lập tham số cho câu lệnh gọi thủ tục
//            callst.setInt(1, id);
//
//            // Thực thi câu lệnh gọi thủ tục và lấy kết quả
//            ResultSet rs = callst.executeQuery();
//            if(rs.next()){
//                Category c = new Category(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getBoolean("status")
//                );
//                return c;
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            // dóng kết nối
//            ConnectionDB.getClosedConnection(conn);
//        }
//        return null;
//    }
    public Category findById(Integer id) {
        // Kiểm tra SQL query và logic
        String sql = "SELECT * FROM category WHERE id = ?";
        try (Connection conn = ConnectionDB.getOpenConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(Category category) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try{
            callst = conn.prepareCall("{call AddCategory(?,?)}");
            callst.setString(1,category.getName());
            callst.setBoolean(2, category.isStatus());
            callst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // dóng kết nối
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void update(Category category) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;

        try{
            callst = conn.prepareCall("{call UpdateCategory(?,?,?)}");
            callst.setInt(1, category.getId());
            callst.setString(2, category.getName());
            callst.setBoolean(3, category.isStatus());
            callst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try{
            callst = conn.prepareCall("{call DeleteCategory(?)}");
            callst.setInt(1,id);
            callst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }
}
