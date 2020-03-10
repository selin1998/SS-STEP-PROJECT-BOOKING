package Service;

import Controller.FlightController;
import DAO.Booking;
import DAO.BookingDAO;
import DAO.DAO_B;
import DAO.SearchAndBook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService extends SearchAndBook implements Serializable {
    BookingDAO daoBooking=new BookingDAO("./INFO/bookings.txt.txt");


    public List<String> getAllBookings(){
        return daoBooking.getAll().stream().map(b->b.toString()).collect(Collectors.toList());
    }

    public String getBookingByID(int index){
        return daoBooking.get(index).toString();
    }

    public List<String> getBookingsByUser(String username)   //User user
    {
        return daoBooking.getBookingsbyUser(username).stream().map(x->x.toString()).collect(Collectors.toList());
    }

    public boolean makeBooking(Booking booking) {

        return daoBooking.create(booking);
    }

    public boolean cancelBooking(int id) {
        return daoBooking.deleteByID(id);
    }


    public void saveBookings(){
        daoBooking.saveBookingstoFile();
    }

    public void loadBookings(){
        daoBooking.loadBookingsFromFile();
    }



}
