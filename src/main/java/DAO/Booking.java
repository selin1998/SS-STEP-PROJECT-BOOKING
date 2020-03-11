package DAO;

import java.util.List;
import java.util.Objects;

public class Booking {
    private static int counter = 1;

    int idBooking;
//    LocalDateTime bookedTime;
   // String username;
    List<Passenger> passenger;
    String flightId;

    public Booking( List<Passenger> passenger, String flightId) {  //String username,
        this.idBooking=counter++;
        //this.username = username;
        this.passenger = passenger;
        this.flightId = flightId;
    }

    public Booking(int idBooking,  List<Passenger> passenger, String flightId) {  //String username,
        this.idBooking = idBooking;
        //this.username = username;
        this.passenger = passenger;
        this.flightId = flightId;
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-20s |%-10s |",
                idBooking, passenger.toString(),flightId);   //username,
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
              //  Objects.equals(username, booking.username) &&
                Objects.equals(passenger, booking.passenger) &&
                Objects.equals(flightId, booking.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking,  passenger, flightId);
    }  //username,

    @Override
    public String toString() {
        return String.format("| %-10d |%-20s |%-10s |",
                idBooking, passenger.toString(),flightId);   //username,
    }
}
