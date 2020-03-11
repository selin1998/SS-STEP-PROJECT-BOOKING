package Service;

import DAO.DAO;
import DAO.Flight;
import DAO.FlightDAO;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService implements Serializable {


    DAO<Flight> dao;
    public FlightService(String filename) {

        dao = new FlightDAO(filename);
    }


        public List<String> getAllFlights(){
            return dao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

        }

        public String getFlightbyId(String id){

            try {
                return dao.get(id).get().toString();
            }
            catch (NoSuchElementException ex){
                System.out.println("Flight with such ID Not Found!");
                return null;
            }


        }

       public List<String> getAllby( String destination,String airline, int numberofPlaces){

           Predicate<Flight> a=x->x.destination.equalsIgnoreCase(destination);
          Predicate<Flight> b=x->x.airline.equalsIgnoreCase(airline);
          Predicate<Flight> c=x->x.numberOfFreePlaces>=numberofPlaces;

           return dao.getAllBy(a.and(b).and(c)).stream().map(x -> x.toString()).collect(Collectors.toList());

       }

        public List<String> searchFlight(String destination, String airline,int numberofPlaces){
          return  dao.getAll().stream().filter(f->f.destination.equals(destination)).filter(f->f.airline.equals(airline)).filter(f->f.numberOfFreePlaces==numberofPlaces).map(x->x.toString()).collect(Collectors.toList());

        }

        int availableSeatsFlight(Flight flight){

            return flight.numberOfFreePlaces;

        }
        void changeAvailableSeats(Flight flight, int count){
            flight.numberOfFreePlaces+=count;
//            dao.saveData();

        }
        void saveFlight(Flight flight){
            dao.save(flight);

        }



        public int countFlights(){
            return dao.getAll().size();
        }





}
