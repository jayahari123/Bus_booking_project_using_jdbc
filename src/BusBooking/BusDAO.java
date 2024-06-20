package BusBooking;
import java.sql.*;
public class BusDAO {

    public void DisplayBusInfo() throws SQLException {
        Connection conn = DBcon.getconnect();
        String Query = "Select * from bus";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        while (rs.next()) {
            System.out.println("Bus No: "+rs.getInt(1) + " has AC (True / False) :  " + rs.getBoolean(2) + " and Available Seets are " + rs.getInt(3) );
        }
    }
   // public int getcapacity

    public int getcapacity(int busNo) throws SQLException {
        String query="Select capacity from bus where id="+busNo;
        Connection con=DBcon.getconnect();
        Statement stmt=con.createStatement();
        ResultSet res= stmt.executeQuery(query);
        res.next();
       // System.out.println("The Available steats are "+res.getInt(1));
        return res.getInt(1);

    }
}
