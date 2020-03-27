package dao;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionBookingFlightDAOTest {

    private BookingDAO<Booking> bookingDAO=new CollectionBookingDAO("./INFO/TestBooking.bin");
    User user;
    Passenger passenger1;
    Passenger passenger2;
    Flight flight;
    Booking booking1;
    Booking booking2;
    List<Passenger> listPassenger=new ArrayList<Passenger>();
    UserCredential userCredential;

    @BeforeEach
    public void setUp() {
        bookingDAO.deleteAll();

       userCredential =new UserCredential("sidiqa","sidiqa");
        user=new User(userCredential,"Sidiqaa","Qadirovaa");

        passenger1=new Passenger("Sevda","Qadirova");
        passenger2=new Passenger("Seyran","Qadirov");
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);

        flight=new Flight("SK9440","30/03/2019 09:50","London","Vienna","SAS",100);

        booking1=new Booking(1,listPassenger,flight.toString(), userCredential);
        booking2=new Booking(2,listPassenger,flight.toString(), userCredential);

        bookingDAO.save(booking1);
        bookingDAO.save(booking2);

    }


    @Test
    void get() {
        assertEquals("Seyran",bookingDAO.get(1).get().passenger.get(1).name);
    }


    @Test
    void getAll() {
        assertEquals(2,bookingDAO.getAll().size());
    }


    @Test
    void delete() {
        Passenger passenger3=new Passenger("Ali","Aliyev");
        List<Passenger> passengers=new ArrayList<Passenger>();
        passengers.add(passenger3);
        UserCredential userCredential2 =new UserCredential("ali1","ali1");
        Booking booking3=new Booking(3,passengers,flight.toString(), userCredential2);
        bookingDAO.save(booking3);
      //  assertEquals(3,bookingDAO.getAll().size());

        bookingDAO.delete(1);
        assertEquals(2,bookingDAO.getAll().size());

    }

    @Test
    void save() {
        //before save booking4
        assertEquals(2,bookingDAO.getAll().size());

        Passenger passenger4=new Passenger("Leyla","Hesenova");
        List<Passenger> passengers=new ArrayList<Passenger>();
        passengers.add(passenger4);
        UserCredential userCredential3 =new UserCredential("hleyla","hleyla");
        Booking booking4=new Booking(3,passengers,flight.toString(), userCredential3);
        bookingDAO.save(booking4);
        //after save booking4
        assertEquals(3,bookingDAO.getAll().size());
    }

}