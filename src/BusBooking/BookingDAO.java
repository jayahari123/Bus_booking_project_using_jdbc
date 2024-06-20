package BusBooking;
import java.util.Date;
import java.sql.*;
import busResv.Booking;

public class BookingDAO {

    public static int getBoolCount(int busNo, Date date) throws SQLException {
         Connection con=DBcon.getconnect();
         String Query="Select count(Name) from booking where busNo=? and traveldate=?";
         PreparedStatement ps=con.prepareStatement(Query);
         java.sql.Date sqldate=new java.sql.Date(date.getTime());
         ps.setInt(1,busNo);
         ps.setDate(2,sqldate);
         ResultSet rs=ps.executeQuery();
         rs.next();
         return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException {
        Connection con=DBcon.getconnect();
        String Query="Insert into booking values (?,?,?)";
        PreparedStatement ps=con.prepareStatement(Query);
        ps.setString(1,booking.passengerName);
        ps.setInt(2,booking.busNo);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());

        ps.setDate(3,sqldate);
        ps.executeUpdate();

    }
}
