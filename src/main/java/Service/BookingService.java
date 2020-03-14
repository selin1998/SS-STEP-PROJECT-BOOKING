package Service;

import DAO.Booking;
import DAO.BookingDAO;
import DAO.DAO_B;
import DAO.Pair;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService implements Serializable {

    DAO_B<Booking> daoBooking;

    public BookingService(String filename) {

        daoBooking = new BookingDAO(filename);
    }


    public List<String> getAllBookings() {
        return daoBooking.getAll().stream().map(b -> b.toString()).collect(Collectors.toList());
    }

    public Booking getBookingByID(int index) {
        return daoBooking.get(index).get();
    }

    public List<Booking> getBookingsbyPair(Pair pair) {
        return daoBooking.getAll().stream().filter(x -> x.pair.equals(pair)).collect(Collectors.toList());
    }

    public List<String> getBookingsByPair(Pair pair) {
        return daoBooking.getAll().stream().filter(x -> x.pair.equals(pair)).map(b -> b.toString()).collect(Collectors.toList());
    }

    public Booking getBookingbyPairAndId(Pair pair, int bookingid) {
        return getBookingsbyPair(pair).stream().filter(x -> x.idBooking == bookingid).findAny().get();

    }

    public void cancelBooking(int id) {
        daoBooking.delete(id);
    }

    public boolean userPossession(Pair pair, int id) {
        return getBookingsbyPair(pair).stream().anyMatch(x -> x.idBooking == id);
    }

    public void saveBookings(Booking booking) {
        daoBooking.save(booking);
    }

}
