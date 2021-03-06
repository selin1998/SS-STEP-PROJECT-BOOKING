package service;

import entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
    private FlightService flightService=new FlightService("./INFO/TestFlight.bin");
    Flight flight1;
    Flight flight2;
    Flight flight3;

    @BeforeEach
    void setUp() {
        flightService.clearAllFlights();

        flight1 = new Flight("AZ1345","30/03/2019 13:45","Oslo", "Baku", "AZAL", 45);
        flightService.saveFlight(flight1);
        flight2 = new Flight("AZ1234", "30/03/2019 10:00", "Oslo","Istanbul", "AZAL", 55);
        flightService.saveFlight(flight2);

    }

    @Test
    void getAllFlights() {
        List<String> allFlights =flightService.getAllFlights();
        assertTrue(!allFlights.isEmpty());
    }

    @Test
    void getAllFlights_Count() {
        List<String> allFlights =flightService.getAllFlights();
        assertEquals(2,allFlights.size());
    }

    @Test
    void getFlightbyId() {
        String flight = flightService.getFlightbyId("AZ1345");
        assertTrue(!flight.isEmpty());
    }

    @Test
    void getAllby() {
        List<String> allbyCriteria = flightService.getAllby("Oslo","Istanbul","28/09/2020",  55);
        assertTrue(!allbyCriteria.isEmpty());
    }


    @Test
    void saveFlight() {
        //before save flight3
        assertEquals(2,flightService.getAllFlights().size());

        flight3 = new Flight("AN1234", "30/03/2019 08:00","Oslo", "London", "Ana", 20);
        flightService.saveFlight(flight3);

        //after save flight3
        assertEquals(3,flightService.getAllFlights().size());

    }

}