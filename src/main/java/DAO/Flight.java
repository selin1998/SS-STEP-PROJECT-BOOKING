package DAO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

public class Flight {
    int flightId;
    int numberOfFreePlaces;
    String destination;
    long arrivalTime;
    long departureTime;



    public Flight(int flightId,  String destination, long departureTime, long arrivalTime,int numberOfFreePlaces) {
        this.flightId = flightId;
        this.numberOfFreePlaces = numberOfFreePlaces;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;

    }


    public String getFormatDate(long time){

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), TimeZone.getDefault().toZoneId());
        return String.format("%d/%d/%d %d:%d", localDateTime.getDayOfMonth(), localDateTime.getMonthValue(), localDateTime.getYear(), localDateTime.getHour(), localDateTime.getMinute());

    }

    public String displayFlightInfo(){

       return String.format("| %-10d |%-12s |%-15s |%-15s |%-5d |", flightId,destination,getFormatDate(departureTime),getFormatDate(arrivalTime),numberOfFreePlaces);
    }

    public static Flight parse(String text) {
        String[] content = text.split(",");
        return new Flight(
                Integer.parseInt(content[0]),
                content[1],
                Integer.parseInt(content[2]),
                Integer.parseInt(content[3]),
                Integer.parseInt(content[4])

        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId &&
                departureTime == flight.departureTime &&
                arrivalTime == flight.arrivalTime &&
                numberOfFreePlaces == flight.numberOfFreePlaces &&
                destination.equals(flight.destination);
    }

    @Override
    public String toString() {
        return String.format("Flight{idFlight=%d, destination=%s ,departureTime=%s, arrivalTime=%s, numberOfFreePlaces=%d}", flightId,destination, getFormatDate(departureTime), getFormatDate(arrivalTime), numberOfFreePlaces);
    }

}
