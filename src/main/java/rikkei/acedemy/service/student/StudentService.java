package rikkei.acedemy.service.student;

import java.sql.CallableStatement;

import ra.mvc.configorutil.ConnectionDB;
import rikkei.acedemy.model.Student;
import rikkei.acedemy.service.student.IStudentService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService implements IStudentService {


    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call getAllStudents()}");
            ResultSet rs = callst.executeQuery();
            while (rs.next()) {
                Student c = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")

                );
                studentList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            callst = conn.prepareCall("{call getStudentById(?)}");
            // Thiết lập giá trị cho tham số
            callst.setInt(1,id);
            rs = callst.executeQuery();
            if (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
        return null;
    }

    @Override
    public void create(Student student) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("call createStudent(?, ?, ?,?)");
            callst.setString(1, student.getFullName());
            callst.setString(2, student.getEmail());
            callst.setString(3, student.getEmail());
            callst.setString(4, student.getPhone());

            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    @Override
    public void update(Student student) {
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        try {
            callst = conn.prepareCall("{call updateStudent(?, ?, ?, ?, ?, ?)}");
            callst.setInt(1, student.getId()); // ID để xác định bản ghi cần cập nhật
            callst.setString(2, student.getFullName());
            callst.setString(3, student.getEmail());
            callst.setString(4, student.getAddress());
            callst.setString(5, student.getPhone());
            callst.setBoolean(6, student.isStatus());
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
            callst = conn.prepareCall("{call deleteStudent(?)}");
            callst.setInt(1, id);
            callst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
        }
    }

    public List<Student> searchByName(String name) {
        List<Student> studentList = new ArrayList<>();
        Connection conn = ConnectionDB.getOpenConnection();
        CallableStatement callst = null;
        ResultSet rs = null;
        try {
            callst = conn.prepareCall("{call searchStudentsByName(?)}");
            callst.setString(1, name);
            rs = callst.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getBoolean("status")
                );
                studentList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getClosedConnection(conn);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (callst != null) {
                try { callst.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return studentList;
    }

}
