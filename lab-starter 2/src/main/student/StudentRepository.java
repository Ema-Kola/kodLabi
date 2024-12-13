package main.student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static Connection c;

    public StudentRepository() {
        try {
            if(c!=null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:students.db", "SA", "");
            c.prepareStatement("create table students (id integer, fullName varchar(100), cgpa float)").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement("select * from students");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                float cgpa = rs.getFloat("cgpa");
                students.add(new Student(id, fullName, cgpa));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return students;
        }
    }

    public void save(Student student) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into students (id, fullName, cgpa) values (?,?,?)");
            ps.setInt(1, student.getId());
            ps.setString(2, student.getFullName());
            ps.setFloat(3, student.getCgpa());
            ps.execute();
            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
