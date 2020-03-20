package controller;

import service.FlightService;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightController {
  public  HashMap<Integer, String> map;
    FlightService service;

    public FlightController(String filename) {

        service = new FlightService(filename);
    }

    public void displayAllFlights(){
        service.getAllFlights().stream().forEach(x->System.out.println(x));
    }

    public void displayFlightbyId(String id){

        System.out.println(service.getFlightbyId(id));

    }
    public String getFlightbyId(String id){

        return service.getFlightbyId(id);

    }
    public boolean displayFlightsBy( String destination, String airline,int seats) {
        AtomicInteger index = new AtomicInteger(0);
        List<String> list=service.getAllby(destination, airline, seats);
        if(list.isEmpty()){
            System.out.println("No corresponding flights were found!!!");
            return false;
        }
        else{
            list.stream().forEach(x -> System.out.printf("| %-8d %s\n", index.addAndGet(1), x));
            return true;
        }

    }

    public HashMap<Integer,String> getFlightsBymap( String destination, String airline,int seats){
        AtomicInteger index = new AtomicInteger(0);
        map= new HashMap<Integer, String>();
        service.getAllby(destination, airline,seats).stream().forEach(x->map.put(index.addAndGet(1),x));
        return map;

    }

    public void decreaseSeats(String id, int count){
        service.decreaseAvailableSeats(id,count);
    }
    public void inreaseSeats(String id, int count){
        service.increaseAvailableSeats(id,count);
    }

}
