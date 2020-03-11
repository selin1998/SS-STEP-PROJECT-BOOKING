package Controller;

import Service.FlightService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightController {
    FlightService service=new FlightService();

    public void displayAllFlights(){
        service.getAllFlights().stream().forEach(x->System.out.println(x));
    }

    public void displayFlightbyId(String id){

        System.out.println(service.getFlightbyId(id));

    }

    public void displayFlightsBy( String destination, String airline,int seats){
        AtomicInteger index = new AtomicInteger(0);
        service.getAllby(destination, airline,seats).stream().forEach(x->System.out.printf("| %-8d %s\n", index.addAndGet(1),x));
    }




}
