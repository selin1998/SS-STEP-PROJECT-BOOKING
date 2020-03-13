package DAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingDAOTest {

    private DAO_B<Booking> bookingDAO=new BookingDAO("./INFO/Test.bin");
    User user;
    Passenger passenger1;
    Passenger passenger2;
    Flight flight;
    Booking booking1;
    Booking booking2;
    List<Passenger> listPassenger=new ArrayList<Passenger>();
    Pair pair;

    @BeforeEach
    public void setUp() {
        bookingDAO.deleteAll();

       pair=new Pair("sidiqa","sidiqa");
        user=new User(pair,"Sidiqaa","Qadirovaa");

        passenger1=new Passenger("Sevda","Qadirova");
        passenger2=new Passenger("Seyran","Qadirov");
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);

        flight=new Flight("SK9440","09:50","Vienna","SAS",100);

        booking1=new Booking(listPassenger,flight.toString(),pair);
        booking2=new Booking(listPassenger,flight.toString(),pair);

        bookingDAO.save(booking1);
        bookingDAO.save(booking2);

    }


    @Test
    void get() {
        assertEquals("Seyran",bookingDAO.get(1).get().passenger.get(1).name);
//        bookingDAO.deleteAll();

    }


    @Test
    void getAll() {
        assertEquals(2,bookingDAO.getAll().size());
//        bookingDAO.deleteAll();
    }


    @Test
    void delete() {
        Passenger passenger=new Passenger("Ali","Aliyev");
        List<Passenger> passengers=new ArrayList<Passenger>();
        passengers.add(passenger);
        Pair pair2=new Pair("ali1","ali1");
        Booking booking3=new Booking(passengers,flight.toString(),pair2);
        bookingDAO.save(booking3);
        assertEquals(3,bookingDAO.getAll().size());

        bookingDAO.delete(1);
        assertEquals(2,bookingDAO.getAll().size());

    }
}