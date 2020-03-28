package service;

import dao.CollectionFlightDAO;
import dao.FlightDAO;
import entity.Flight;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public List<String> getAllby(String origin,String destination,String date,  int numberofPlaces) {

        Predicate<Flight> a = x -> x.destination.equalsIgnoreCase(destination);
        Predicate<Flight> b = x -> x.departureTime.contains(date);
        Predicate<Flight> c = x -> x.numberOfFreePlaces >= numberofPlaces;
        Predicate<Flight> d = x -> x.origin.equalsIgnoreCase(origin);
     //   Predicate<Flight> d = x -> x.departureDate.equalsIgnoreCase(date.trim());

        return flightDao.getAllBy(a.and(c).and(d).and(b)).stream().map(x -> x.toString()).collect(Collectors.toList());

    }

    public boolean hoursBetween(String depT1, String depT2){
        LocalDateTime ldt1 = LocalDateTime.parse(depT1,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        LocalDateTime ldt2 = LocalDateTime.parse(depT2,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        long duration=ChronoUnit.HOURS.between(ldt1, ldt2);
        if(duration<12&&duration>=3){
            return  true;
        }
        else return false;
    }


    public List<Flight> getConnectingFlights(String origin,String destination, int numberofPlaces) {

        List<Flight> result = new ArrayList<>();
        Predicate<Flight> a = x -> !x.destination.equalsIgnoreCase(destination);
    //    Predicate<Flight> b = x -> x.departureTime.contains(date);
        Predicate<Flight> c = x -> x.numberOfFreePlaces >= numberofPlaces;
        Predicate<Flight> d = x -> x.origin.equalsIgnoreCase(origin);
        Predicate<Flight> e = x -> x.destination.equalsIgnoreCase(destination);

        List<Flight> fromOrigin = flightDao.getAllBy(a.and(c).and(d));
        List<Flight> toDestination = flightDao.getAllBy(e.and(c));



        fromOrigin.stream().forEach(flight -> {
            toDestination.stream().
                    filter(cflight -> (cflight.origin.equalsIgnoreCase(flight.destination)) &&(hoursBetween(flight.departureTime, cflight.departureTime)) ).forEach(cflight -> {

                result.add(flight);
                result.add(cflight);

            });

        });
        return  result;

    }


    public void changeDepartureTime(){

        LocalDateTime time=LocalDateTime.now();
        int index=5;int interval=0;
        for (Flight flight : flightDao.getAll()) {
            flight.departureTime=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(time.plus(Duration.ofMinutes(index)));
            interval++;
            if(interval==6){
                index+=4;
                interval=0;
            }

           flightDao.save(flight);
        }
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