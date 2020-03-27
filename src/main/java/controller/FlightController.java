package controller;

import entity.Flight;
import service.FlightService;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightController {
  final String DASHES2 = new String(new char[123]).replace("\0", "-");
  public  HashMap<Integer, String> map;
    FlightService service;

    public FlightController(String filename) {

        service = new FlightService(filename);
    }

    public void displayAllFlights(){
        service.getAllFlights().forEach(x->System.out.println(x));
    }

    public void changeDepartureTime(){
        service.changeDepartureTime();
    }

    public void displayFlightbyId(String id){

        System.out.println(service.getFlightbyId(id));

    }
    public String getFlightbyId(String id){

        return service.getFlightbyId(id);

    }

    public void read(){
        service.read();
    }
    public void write(){
        service.write();
    }

    public boolean displayFlightsBy( String origin,String destination, int seats) {
        AtomicInteger index = new AtomicInteger(0);
        List<String> list=service.getAllby(origin,destination, seats);
        if(list.isEmpty()){
            System.out.println("No direct flights were found!!!");
            return false;
        }
        else{
            list.stream().forEach(x -> System.out.printf("| %-8d %s\n", index.addAndGet(1), x));
            return true;
        }

    }
    public boolean displayConnectingFlightsBy(String origin,String destination,int seats){
        AtomicInteger index = new AtomicInteger(0);
        List<Flight> conFlights=service.getConnectingFlights(origin,destination,seats);
        if(conFlights.isEmpty()){
            System.out.println("No connecting flights were found!!!");
            return false;
        }
        else{
            System.out.println("CONNECTING FLIGHTS");

            for (Flight conFlight : conFlights) {
                System.out.println(DASHES2);
                System.out.printf("| %-8d %s ---->\n", index.addAndGet(1), conFlight);

            }


//
//            conFlights.stream().
//                    forEach(x->x.stream().forEach(y-> System.out.printf("| %-8d %s ---->\n", index.addAndGet(1), y)));
           return true;
        }

    }



    public HashMap<Integer,String> getFlightsBymap( String origin,String destination, String airline,int seats){
        AtomicInteger index = new AtomicInteger(0);
        map= new HashMap<Integer, String>();
        service.getAllby(origin,destination,seats).stream().forEach(x->map.put(index.addAndGet(1),x));
        return map;

    }

    public void decreaseSeats(String id, int count){
        service.decreaseAvailableSeats(id,count);
    }
    public void inreaseSeats(String id, int count){
        service.increaseAvailableSeats(id,count);
    }

}
