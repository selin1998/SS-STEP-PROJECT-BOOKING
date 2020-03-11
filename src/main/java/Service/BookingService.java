package Service;

import Controller.FlightController;
import DAO.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BookingService implements Serializable {
    BookingDAO1 daoBooking=new BookingDAO1("./INFO/bookings.bin");

    BookingDAO1 daoB;
    public BookingService(String filename) {

        daoB = new BookingDAO1(filename);
    }


    public List<String> getAllBookings(){
        return daoBooking.getAll().stream().map(b->b.toString()).collect(Collectors.toList());
    }

    public String getBookingByID(int index){
        try {
            return daoBooking.get(index).get().toString();
        }
        catch (NoSuchElementException ex){
            System.out.println("Flight with such ID Not Found!");
            return null;
        }
//        return daoBooking.get(index).toString();
    }

//    public List<String> getBookingsByUser(String username)   //User user
//    {
//        return daoBooking.getBookingsbyUser(username).stream().map(x->x.toString()).collect(Collectors.toList());
//    }

    public boolean makeBooking(Booking booking) {

        return daoBooking.create(booking);
    }

    public boolean cancelBooking(int id) {
        return daoBooking.delete(id);
    }


    public void saveBookings(Booking booking){
        daoBooking.save(booking);
    }

//    public void loadBookings(){
//        daoBooking.loadBookingsFromFile();
//    }



}
