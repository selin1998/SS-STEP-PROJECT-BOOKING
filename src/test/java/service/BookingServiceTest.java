package service;

import entity.*;
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
    UserCredential userCredential;

    @BeforeEach
    public void setUp() {
        bookingService.clearBookings();

        userCredential = new UserCredential("sidiqa", "sidiqa");

        user = new User(userCredential, "Sidiqaa", "Qadirovaa");

        passenger1 = new Passenger("Sevda", "Qadirova");
        passenger2 = new Passenger("Seyran", "Qadirov");
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);

        flight = new Flight("SK9440", "30/03/2019","09:50", "Vienna", "SAS", 100);

        booking1 = new Booking(1, listPassenger, flight.toString(), userCredential);
        booking2 = new Booking(2, listPassenger, flight.toString(), userCredential);

        bookingService.saveBookings(booking1);
        bookingService.saveBookings(booking2);

    }

    @Test
    void getAllBookings() {
        List<String> allBookings = bookingService.getAllBookings();
        assertTrue(!allBookings.isEmpty());
    }

    @Test
    void getBookingsByPair() {
        List<String> bookingsByPair = bookingService.getBookingsByPair(userCredential);
        assertEquals(2,bookingsByPair.size());
    }

    @Test
    void getBookingsByPair_isExist() {
        List<String> bookingsByPair = bookingService.getBookingsByPair(userCredential);
        assertTrue(!bookingsByPair.isEmpty());
    }

    @Test
    void userPossession() {
       assertTrue(bookingService.userPossession(userCredential, 1));
    }

    @Test
    void saveBookings() {
        //before save booking3
        assertEquals(2,bookingService.getAllBookings().size());

        UserCredential userCredential2 = new UserCredential("sidiqa97", "sidiqa97");
       // User user2 = new User(userCredential, "Sidiqa", "Qadirova");

        Passenger passenger1 = new Passenger("Sevda", "Qadirova");
        List<Passenger> listPassenger2 = new ArrayList<Passenger>();
        listPassenger2.add(passenger1);

        Flight flight2 = new Flight("VA9440", "30/03/2019","09:30", "Vienna", "ANA", 50);

        Booking booking3 = new Booking(3, listPassenger2, flight2.toString(), userCredential2);
        bookingService.saveBookings(booking3);
        //after save booking3
        assertEquals(3,bookingService.getAllBookings().size());
    }
}