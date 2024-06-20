package busResv;

import BusBooking.BookingDAO;
import BusBooking.BusDAO;
import busResv.Booking;


import java.sql.SQLException;
import java.util.Scanner; //nested package/ hierarchical package
import java.util.ArrayList;

public class BusDemo {

    public static void main(String[] args) throws SQLException {
        BusDAO businfo=new BusDAO();
        int userOpt = 1;
        Scanner scanner = new Scanner(System.in);


            businfo.DisplayBusInfo();


        while(userOpt==1) {
            System.out.println("Enter 1 to Book and 2 to exit");
            userOpt = scanner.nextInt();
            if(userOpt == 1) {
                Booking booking = new busResv.Booking();
                if(booking.isAvailable()) {
                    BookingDAO bookingDAO=new BookingDAO();
                    bookingDAO.addBooking(booking);
                    System.out.println("Your booking is confirmed");
                }
                else
                    System.out.println("Sorry. Bus is full. Try another bus or date.");
            }
        }
    }

}