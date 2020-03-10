package DAO;

import Controller.FlightController;
import Service.FlightService;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import DAO.DAO;

public class SearchAndBook {

    //LIKE ANOTHER FLIGHTSERVICE

    DAO<Flight> dao = new FlightDAO("./INFO/flight.bin");

    FlightController controllerFlight = new FlightController();

//If in FlightService something changes:------>
    public List<String> getAllFlights(){
        return dao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

    }

    public List<String> searchFlight(String destination, int numberofPlaces) {
        return dao.getAll().stream()
                .filter(f -> f.destination.equals(destination))
                .filter(f -> Integer.parseInt(f.numberOfFreePlaces) >= numberofPlaces)
                .map(x -> x.toString()).collect(Collectors.toList());
    }


}
