package service;

import dao.CollectionFlightDAO;
import dao.FlightDAO;
import entity.Flight;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightService implements Serializable {

    FlightDAO<Flight> flightDao;

    public FlightService(String filename) {

        flightDao = new CollectionFlightDAO(filename);
    }

    public List<String> getAllFlights() {
        return flightDao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

    }

    public String getFlightbyId(String id) {

        try {
            return flightDao.get(id).get().toString();
        } catch (NoSuchElementException ex) {
            System.out.println("Flight with such ID Not Found!");
            return null;
        }
    }

    public List<String> getAllby(String destination, String airline, int numberofPlaces, String date) {

        Predicate<Flight> a = x -> x.destination.equalsIgnoreCase(destination);
        Predicate<Flight> b = x -> x.airline.equalsIgnoreCase(airline);
        Predicate<Flight> c = x -> x.numberOfFreePlaces >= numberofPlaces;
        Predicate<Flight> d = x -> x.departureDate.equalsIgnoreCase(date.trim());

        return flightDao.getAllBy(a.and(b).and(c).and(d)).stream().map(x -> x.toString()).collect(Collectors.toList());

    }

    public List<String> searchFlight(String destination, String airline, int numberofPlaces) {
        return flightDao.getAll().stream().filter(f -> f.destination.equals(destination)).filter(f -> f.airline.equals(airline)).filter(f -> f.numberOfFreePlaces == numberofPlaces).map(x -> x.toString()).collect(Collectors.toList());

    }

    public int availableSeatsFlight(String id) {

        return flightDao.get(id).get().numberOfFreePlaces;

    }


    public void read(){
        flightDao.read();
    }
    public void write(){
        flightDao.write();
    }

    public void decreaseAvailableSeats(String id, int count) {
        Flight f = flightDao.get(id).get();
        flightDao.delete(f.flightId);
        f.numberOfFreePlaces -= count;
        saveFlight(f);

    }

    public void increaseAvailableSeats(String id, int count) {
        Flight f = flightDao.get(id).get();
        flightDao.delete(f.flightId);
        f.numberOfFreePlaces += count;
        saveFlight(f);
    }


    public void saveFlight(Flight flight) {
        flightDao.save(flight);

    }

    public void clearAllFlights(){
        flightDao.deleteAll();
    }

    public int countFlights() {
        return flightDao.getAll().size();
    }

}