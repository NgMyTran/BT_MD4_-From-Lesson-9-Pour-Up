package ra.dao.category1;


import org.springframework.stereotype.Repository;
import ra.config.ConnectionDB;
import ra.model.Category1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Category1Dao implements ICategory1Dao {
    @Override
    public List<Category1> findAll() {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        List<Category1> categories = new ArrayList<>();
        try{
            sta = conn.prepareCall("SELECT * FROM category");
            rs = sta.executeQuery();
            while (rs.next()){
                Category1 category = new Category1(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                categories.add(category);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return categories;
    }

    @Override
    public Category1 findById(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        ResultSet rs = null;
        try{
            sta = conn.prepareCall("SELECT * FROM category WHERE id =?");
            sta.setInt(1, id);
            rs = sta.executeQuery();
            if (rs.next()){
                return new Category1(
                        rs.getInt("id"),
                        rs.getString("name"),
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
    public void update(Category1 category) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("UPDATE category SET name =?, status =? WHERE id =?");
            sta.setString(1, category.getName());
            sta.setBoolean(2, category.isStatus());
            sta.setInt(3, category.getId());
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
            sta = conn.prepareCall("DELETE FROM category WHERE id =?");
            sta.setInt(1, id);
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void create(Category1 category) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement sta = null;
        try{
            sta = conn.prepareCall("INSERT INTO category (name, status) VALUES (?,?)");
            sta.setString(1, category.getName());
            sta.setBoolean(2, category.isStatus());
            sta.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }
}
