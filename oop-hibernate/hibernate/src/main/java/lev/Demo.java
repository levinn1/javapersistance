package lev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.Student;

public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/oop";
        String user = "root";
        String password = "";
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful: " + url);

            Student student = new Student("vin", 19, "IMT");
            String query = String.format("INSERT INTO students(name, age, major) VALUES ('lev', 18, 'IMT')",
                    student.getName(), student.getAge(), student.getMajor());

            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Success");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
