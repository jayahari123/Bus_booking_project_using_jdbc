package busResv;
import BusBooking.BookingDAO;
import BusBooking.BusDAO;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
public class Booking {
    public String passengerName;
    public int busNo;
  public  Date date;

    Booking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public boolean isAvailable() throws SQLException {
        BusDAO busdao = new BusDAO();
        int capacity =busdao.getcapacity(busNo);
        int booked = BookingDAO.getBoolCount(busNo,date);
        return booked < capacity;

    }
}