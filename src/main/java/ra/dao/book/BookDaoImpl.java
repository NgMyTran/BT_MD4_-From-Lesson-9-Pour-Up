package ra.dao.book;

import ra.model.Book;
import ra.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {


    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;

        try {
            callst = conn.prepareCall("{call DisplayBooks()}");
            ResultSet rs = callst.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call getBookById(?)}");
            callst.setInt(1, id);
            ResultSet rs = callst.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return null;
    }

    @Override
    public void create(Book book) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;

        try {
            callst = conn.prepareCall("{call AddBook(?,?,?,?,?,?,?,?)}");
            callst.setInt(1, book.getCategory_id());
            callst.setString(2, book.getName());
            callst.setDouble(3, book.getPrice());
            callst.setInt(4, book.getStock());
            callst.setInt(5, book.getTotalPages());
            callst.setInt(6, book.getYearCreated());
            callst.setString(7, book.getAuthor());
            callst.setBoolean(8, book.isStatus());
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }


    @Override
    public void update(Book book) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;

        try {
            callst = conn.prepareCall("{call UpdateBook(?,?,?,?,?,?,?,?,?)}");
            callst.setInt(1, book.getId());
//            callst.setInt(2, book.getCategory_id());
            callst.setInt(2, book.getCategory_id());
            callst.setString(3, book.getName());
            callst.setDouble(4, book.getPrice());
            callst.setInt(5, book.getStock());
            callst.setInt(6, book.getTotalPages());
            callst.setInt(7, book.getYearCreated());
            callst.setString(8, book.getAuthor());
            callst.setBoolean(9, book.isStatus());
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
            callst = conn.prepareCall("{call DeleteBook(?)}");
            callst.setInt(1, id);
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public List<Book> findByCategoryId(Integer categoryId) {
        Connection conn = ConnectionDB.getOpenConnection();
        List<Book> books = new ArrayList<>();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call getBookByCategoryId(?)}");
            callst.setInt(1, categoryId);
            ResultSet rs = callst.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return books;
    }

}

