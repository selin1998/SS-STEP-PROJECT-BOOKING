package DAO;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

public class Flight implements Serializable {
  public  String flightId;
   public String numberOfFreePlaces;
  public  String destination;
  public  String departureTime;
  public  String airline;



    public Flight(String flightId,  String departureTime, String destination, String airline,String numberOfFreePlaces) {
        this.flightId = flightId;
        this.numberOfFreePlaces = numberOfFreePlaces;
        this.destination = destination;
        this.departureTime = departureTime;
        this.airline=airline;

    }


    public String getFormatDate(long time){

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), TimeZone.getDefault().toZoneId());
        return String.format("%d:%d", localDateTime.getHour(), localDateTime.getMinute());

    }

    public String displayFlightInfo(){

       return String.format("| %-10s | %-8s | %-15s | %-25s | %-5s |", flightId,departureTime,destination,airline,numberOfFreePlaces);
    }

    public static Flight parse(String text) {
        String[] content = text.split(",");
        return new Flight(
                content[0],
                content[1],
                content[2],
                content[3],
                content[4]

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
        return String.format("| %-10s | %-8s | %-15s | %-25s | %-5s |", flightId,departureTime,destination,airline,numberOfFreePlaces);
    }

}
