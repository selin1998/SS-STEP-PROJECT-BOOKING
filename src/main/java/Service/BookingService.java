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
   // BookingDAO1 daoBooking=new BookingDAO1("./INFO/booking.bin");

    DAO_B<Booking> daoBooking;

    public BookingService(String filename) {

        daoBooking = new BookingDAO1(filename);
    }


    public List<String> getAllBookings(){
        return daoBooking.getAll().stream().map(b->b.toString()).collect(Collectors.toList());
    }




    public Booking getBookingByID(int index){


            return daoBooking.get(index).get();


    }




    public void cancelBooking(int id) {
         daoBooking.delete(id);
    }



//    public int passengerSize(int id) {
//
//
//        return daoBooking.get(id).get().passenger.size();
//
//
//    }
//
//    public String bookingFlightid(int id){
//        return daoBooking.get(id).get().flight;
//    }




    public void saveBookings(Booking booking){
        daoBooking.save(booking);
    }




}
