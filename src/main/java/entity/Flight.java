package entity;

import java.io.Serializable;

public class Flight implements Serializable {
  public  String flightId;
   public int numberOfFreePlaces;
  public  String destination;
  public  String departureTime;
  public String departureDate;
  public  String airline;



    public Flight(String flightId,String departureDate,  String departureTime, String destination, String airline,int numberOfFreePlaces) {
        this.flightId = flightId;
        this.departureDate=departureDate;
        this.numberOfFreePlaces = numberOfFreePlaces;
        this.destination = destination;
        this.departureTime = departureTime;
        this.airline=airline;

    }
    public Flight(){}


    public String displayFlightInfo(){

       return String.format("| %-10s | %-10s | %-6s | %-15s | %-28s | %-5d |", flightId,departureDate,departureTime,destination,airline,numberOfFreePlaces);
    }

    public  Flight parse(String text) {
        String[] content = text.split(",");
        return new Flight(
                content[0],
                content[1],
                content[2],
                content[3],
                content[4],
                Integer.parseInt(content[5].trim())

        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId &&
                destination.equals(flight.destination);
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-6s | %-15s | %-28s | %-5d |", flightId,departureDate,departureTime,destination,airline,numberOfFreePlaces);
    }

}
