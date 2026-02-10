package dao;

import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO {

    public void addStudent(Student student) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO student VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getCourse());

            ps.executeUpdate();
            System.out.println("Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement()
                              .executeQuery("SELECT * FROM student");

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
public void updateStudent(Student student) {
    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Database connection failed");
        return;
    }

    try {
        String sql = "UPDATE student SET name=?, age=?, course=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getCourse());
        ps.setInt(4, student.getId());

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student updated successfully");
        else
            System.out.println("Student ID not found");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
public void deleteStudent(int id) {
    Connection con = DBConnection.getConnection();

    if (con == null) {
        System.out.println("Database connection failed");
        return;
    }

    try {
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student deleted successfully");
        else
            System.out.println("Student ID not found");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
