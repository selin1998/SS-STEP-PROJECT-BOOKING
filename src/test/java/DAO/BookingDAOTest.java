package DAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingDAOTest {

    private BookingDAO bookingDAO;
    User user;
    Passenger passenger1;
    Passenger passenger2;
    Flight flight;
    Booking booking1;
    Booking booking2;

    @BeforeAll
    public void setUp() {
        bookingDAO=new BookingDAO("./INFO/booking.bin");
       // user=new User();
    }


    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }
}