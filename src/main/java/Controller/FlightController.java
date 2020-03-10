package Controller;

import Service.FlightService;

import java.util.List;

public class FlightController {
    FlightService service=new FlightService();

    public void displayAllFlights(){
        service.getAllFlights().stream().forEach(x->System.out.println(x));
    }
    public void displayFlightbyId(int index){
        System.out.println(service.getFlightbyId(index));

    }
    public List<String> displaySearchedFlight(String dest,String airline,String numberofplaces){
        List<String> strings = service.searchFlight(dest, airline,numberofplaces);
        return strings;
    }
    public void displayFlightsBy( String destination, String airline){
        System.out.println(service.getAllby(destination, airline));
    }

}
