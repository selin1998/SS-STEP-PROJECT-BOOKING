package service;

import entity.Booking;
import dao.CollectionBookingDAO;
import dao.BookingDAO;
import entity.UserCredential;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService implements Serializable {

    BookingDAO<Booking> daoBooking;

    public BookingService(String filename) {

        daoBooking = new CollectionBookingDAO(filename);
    }


    public List<String> getAllBookings() {
        return daoBooking.getAll().stream().map(b -> b.toString()).collect(Collectors.toList());
    }

    public List<Booking> getAll(){
        return daoBooking.getAll();
    }

    public Booking getBookingByID(int index) {
        return daoBooking.get(index).get();
    }

    public List<Booking> getBookingsbyPair(UserCredential userCredential) {
        return daoBooking.getAll().stream().filter(x -> x.userCredential.equals(userCredential)).collect(Collectors.toList());
    }

    public List<String> getBookingsByPair(UserCredential userCredential) {
        return daoBooking.getAll().stream().filter(x -> x.userCredential.equals(userCredential)).map(b -> b.toString()).collect(Collectors.toList());
    }

    public Booking getBookingbyPairAndId(UserCredential userCredential, int bookingid) {
        return getBookingsbyPair(userCredential).stream().filter(x -> x.idBooking == bookingid).findAny().get();

    }

    public void read(){
        daoBooking.read();
    }
    public void write(){
        daoBooking.write();
    }

    public void cancelBooking(int id) {
        daoBooking.delete(id);
    }

    public void clearBookings(){
        daoBooking.deleteAll();
    }

    public boolean userPossession(UserCredential userCredential, int id) {
        return getBookingsbyPair(userCredential).stream().anyMatch(x -> x.idBooking == id);
    }

    public void saveBookings(Booking booking) {
        daoBooking.save(booking);
    }

}
