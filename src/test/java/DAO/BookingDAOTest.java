package DAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingDAOTest {

    private BookingDAO bookingDAO;
    User user;
    Passenger passenger1;
    Passenger passenger2;
    Flight flight;
    Booking booking1;
    Booking booking2;
    List<Passenger> listPassenger=new ArrayList<Passenger>();

    @BeforeAll
    public void setUp() {
        bookingDAO=new BookingDAO("./INFO/booking.bin");

        Pair pair=new Pair("sidiqa97","sidiqa97");
        user=new User(pair,"Sidiqa","Qadirova");

        passenger1=new Passenger("Sevda","Qadirova");
        passenger2=new Passenger("Seyran","Qadirov");
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);

        flight=new Flight("SK9440","09:50","Vienna","SAS",100);

        booking1=new Booking(listPassenger,flight.toString());
        booking2=new Booking(listPassenger,flight.toString());

        bookingDAO.create(booking1);
        bookingDAO.create(booking2);
    }


    @Test
    void get() {
        assertEquals("Sevda",bookingDAO.get(1).get().passenger.get(1).name);
    }


    @Test
    void getAll() {
        assertEquals(2,bookingDAO.getAll().size());
    }

    @Test
    void delete() {
        Passenger passenger=new Passenger("Ali","Aliyev");
        List<Passenger> passengers=new ArrayList<Passenger>();
        Booking booking3=new Booking(passengers,flight.toString());
        bookingDAO.create(booking3);
        assertEquals(3,bookingDAO.getAll().size());

        bookingDAO.delete(3);

    }
}