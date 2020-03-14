package Service;

import DAO.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private BookingService bookingService = new BookingService("./INFO/TestBooking.bin");
    User user;
    Passenger passenger1;
    Passenger passenger2;
    Flight flight;
    Booking booking1;
    Booking booking2;
    List<Passenger> listPassenger = new ArrayList<Passenger>();
    Pair pair;

    @BeforeEach
    public void setUp() {
        bookingService.clearBookings();

        pair = new Pair("sidiqa", "sidiqa");

        user = new User(pair, "Sidiqaa", "Qadirovaa");

        passenger1 = new Passenger("Sevda", "Qadirova");
        passenger2 = new Passenger("Seyran", "Qadirov");
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);

        flight = new Flight("SK9440", "09:50", "Vienna", "SAS", 100);

        booking1 = new Booking(1, listPassenger, flight.toString(), pair);
        booking2 = new Booking(2, listPassenger, flight.toString(), pair);

        bookingService.saveBookings(booking1);
        bookingService.saveBookings(booking2);

    }

    @Test
    void getAllBookings() {
        List<String> allBookings = bookingService.getAllBookings();
        assertEquals(2, allBookings.size());
    }

//    @Test
//    void getBookingByID() {
//        Booking booking = bookingService.getBookingByID(1);
//        assertEquals("Sevda",booking.);
//
//    }

    @Test
    void getBookingsByPair() {
        List<String> bookingsByPair = bookingService.getBookingsByPair(pair);
        assertEquals(2,bookingsByPair.size());
    }

    @Test
    void getBookingsByPair_isExist() {
        List<String> bookingsByPair = bookingService.getBookingsByPair(pair);
        assertFalse(bookingsByPair.isEmpty());
    }

    @Test
    void userPossession() {
       assertTrue(bookingService.userPossession(pair, 1));
    }

    @Test
    void saveBookings() {
        //before save booking3
        assertEquals(2,bookingService.getAllBookings().size());

        Pair pair2 = new Pair("sidiqa97", "sidiqa97");
       // User user2 = new User(pair, "Sidiqa", "Qadirova");

        Passenger passenger1 = new Passenger("Sevda", "Qadirova");
        List<Passenger> listPassenger2 = new ArrayList<Passenger>();
        listPassenger2.add(passenger1);

        Flight flight2 = new Flight("VA9440", "09:30", "Vienna", "ANA", 50);

        Booking booking3 = new Booking(3, listPassenger2, flight2.toString(), pair2);
        bookingService.saveBookings(booking3);
        //after save booking3
        assertEquals(3,bookingService.getAllBookings().size());
    }
}