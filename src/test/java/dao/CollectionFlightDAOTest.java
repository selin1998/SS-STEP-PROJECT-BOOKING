package dao;

import entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionFlightDAOTest {

    private FlightDAO<Flight> flightDao=new CollectionFlightDAO("./INFO/TestFlight.bin");
    Flight flight1;
    Flight flight2;
    Flight flight3;

    @BeforeEach
    void setUp() {
        flightDao.deleteAll();

        flight1 = new Flight("AZ1345","30/03/2019 13:45","Oslo", "Baku", "AZAL", 45);
        flightDao.save(flight1);
        flight2 = new Flight("AZ1234", "30/03/2019 10:00","Oslo", "Istanbul", "AZAL", 55);
        flightDao.save(flight2);
        flight3 = new Flight("AN1234", "30/03/2019 08:00","Oslo", "London", "Ana", 20);
        flightDao.save(flight3);
    }

    @Test
    void getAll() {
        int totalFlights = flightDao.getAll().size();
        assertEquals(3,totalFlights);
    }

    @Test
    void get() {
        if (flightDao.get("AZ1345").isPresent()){
            assertEquals("AZ1345",flightDao.get("AZ1345").get().flightId);
        }
    }

    @Test
    void delete() {
        flightDao.delete("AZ1234");
        assertEquals(2,flightDao.getAll().size());
    }

    @Test
    void save() {
      Flight  flight4=new Flight("AB1234","30/03/2019 06:00","Oslo","Rome","Ana",35);
      flightDao.save(flight4);

      assertEquals(4,flightDao.getAll().size());

    }
}