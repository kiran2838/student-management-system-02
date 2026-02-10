package util;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
