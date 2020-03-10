package Service;

import DAO.DAO;
import DAO.Flight;
import DAO.FlightDAO;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService implements Serializable {

    private File file;



    DAO<Flight> dao = new FlightDAO("./INFO/flight.bin");
        public List<String> getAllFlights(){
            return dao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

        }

        public String getFlightbyId(int index){
            return dao.get(index).toString();

        }

       public List<String> getAllby( String destination,String airline){
        //   Predicate<Flight> b= x->x.equals(date);
           Predicate<Flight> a=x->x.equals(destination);

           Predicate<Flight> d=x->x.equals(airline);
         //  Predicate<Flight> c=x->x.equals(numberofplaces);


           return dao.getAllBy(a.and(d)).stream().map(x -> x.toString()).collect(Collectors.toList());




       }

        public List<String> searchFlight(String destination, String airline,String numberofPlaces){
          return  dao.getAll().stream().filter(f->f.destination.equals(destination)).filter(f->f.airline.equals(airline)).filter(f->f.numberOfFreePlaces.equals(numberofPlaces)).map(x->x.toString()).collect(Collectors.toList());

        }

        int availableSeatsFlight(Flight flight){

            return Integer.parseInt(flight.numberOfFreePlaces);

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
