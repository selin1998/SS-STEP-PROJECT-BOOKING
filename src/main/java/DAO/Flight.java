package DAO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

public class Flight {
  public  String flightId;
   public int numberOfFreePlaces;
  public  String destination;
  public  long departureTime;
  public  String airline;



    public Flight(String flightId,  long departureTime, String destination, String airline,int numberOfFreePlaces) {
        this.flightId = flightId;
        this.numberOfFreePlaces = numberOfFreePlaces;
        this.destination = destination;
        this.departureTime = departureTime;
        this.numberOfFreePlaces=numberOfFreePlaces;

    }


    public String getFormatDate(long time){

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), TimeZone.getDefault().toZoneId());
        return String.format("%d:%d", localDateTime.getHour(), localDateTime.getMinute());

    }

    public String displayFlightInfo(){

       return String.format("| %-10s |%-12s |%-15s |%-15s |%-5d |", flightId,getFormatDate(departureTime),destination,airline,numberOfFreePlaces);
    }

    public static Flight parse(String text) {
        String[] content = text.split(",");
        return new Flight(
                content[0],
                Integer.parseInt(content[1]),
                content[2],
                content[3],
                Integer.parseInt(content[4])

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
        return String.format("Flight{idFlight=%d, departureTime=%s,destination=%s , airline=%s, numberOfFreePlaces=%d}", flightId, getFormatDate(departureTime),destination,airline, numberOfFreePlaces);
    }

}
