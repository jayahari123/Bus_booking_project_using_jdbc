package BusBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
   private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String user = "root";
   private static final String password = "pass123";

    public static Connection getconnect()throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
