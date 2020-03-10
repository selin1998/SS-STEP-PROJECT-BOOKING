package Controller;

import Service.FlightService;

public class FlightController {
    FlightService service=new FlightService();

    public void displayAllFlights(){
        service.getAllFlights().stream().forEach(x->System.out.println(x));
    }
    public void displayFlightbyId(int index){
        System.out.println(service.getFlightbyId(index));

    }
    public void displaySearchedFlight(String dest,String airline){
        service.searchFlight(dest,airline).forEach(x-> System.out.println(x));
    }

}
