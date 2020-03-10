package Service;

import DAO.DAO;
import DAO.Flight;
import DAO.FlightDAO;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService implements Serializable {
        DAO<Flight> dao = new FlightDAO("./INFO/flight.bin");
        public List<String> getAllFlights(){
            return dao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

        }

        public String getFlightbyId(int index){
            return dao.get(index).toString();

        }

//        public List<String> getAllby(Predicate<Flight> p){
//                    return dao.getAllBy(p).
//        }

        public List<String> searchFlight(String destination, String airline){
          return  dao.getAll().stream().filter(f->f.destination.equals(destination)).filter(f->f.airline.equals(airline)).map(x->x.toString()).collect(Collectors.toList());

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
