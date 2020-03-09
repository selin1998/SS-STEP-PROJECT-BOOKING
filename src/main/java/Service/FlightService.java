package Service;

import DAO.DAO;
import DAO.Flight;
import DAO.FlightDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightService {
        DAO<Flight> dao=new FlightDAO();
        public List<Flight> getAllFlights(){
            return dao.getAll();

        }

        public Optional<Flight> getFlightbyId(String id){
            return dao.get(id);

        }

        public List<Flight> searchFlight(String destination, String airline){
          return  dao.getAll().stream().filter(f->f.destination.equals(destination)).filter(f->f.airline.equals(airline)).collect(Collectors.toList());

        }

        int availableSeatsFlight(Flight flight){

            return dao.get(flight).orElse(null).numberOfFreePlaces;

        }
        void changeAvailableSeats(Flight flight, int count){
            dao.get(flight).orElse(null).numberOfFreePlaces+=count;

        }
        void saveFlight(Flight flight){

        }
        public int countFlights(){
            return dao.getAll().size();
        }





}
