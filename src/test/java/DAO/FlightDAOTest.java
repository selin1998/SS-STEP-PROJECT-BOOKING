package DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightDAOTest {

    private DAO<Flight> flightDao=new FlightDAO("./INFO/TestFlight.bin");
    Flight flight1;
    Flight flight2;
    Flight flight3;

    @BeforeEach
    void setUp(){
        flightDao.deleteAll();

        flight1=new Flight("AZ1345","13:45","Baku","AZAL",45);
        flightDao.save(flight1);
        flight2=new Flight("AZ1234","10:00","Istanbul","AZAL",55);
        flightDao.save(flight2);
        flight3=new Flight("AN1234","08:00","London","Ana",20);
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
      Flight  flight4=new Flight("AB1234","06:00","Rome","Ana",35);
      flightDao.save(flight4);

      assertEquals(4,flightDao.getAll().size());

    }
}