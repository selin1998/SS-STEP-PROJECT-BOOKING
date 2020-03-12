package DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {
    final String DASHES = new String(new char[82]).replace("\0", "-");

    int idBooking;
//    LocalDateTime bookedTime;
   // String username;
    List<Passenger> passenger;
    String flightId;

    private static int counter = 0;

    {
        counter++;
    }

    public Booking( List<Passenger> passenger, String flightId) {  //String username,
        this.idBooking=counter;
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


        String str=String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Date", "Destination", "Airline", "Seats");
        String dash=DASHES;
        StringBuilder booking= new StringBuilder();
        booking.append(String.format("Booking ID: %d \n",idBooking));


        for (Passenger p: passenger) {
            booking.append(p.toString());
            booking.append("\n");
        }
        booking.append(String.format("%s\n%s\n%s\n%s\n ",dash,str,dash,flightId));

        return booking.toString();
//        return String.format("Booking ID: %d \n|%-20s\n%s\n%s\n%s\n%s\n ",
//                idBooking, passenger.toString(),dash,str,dash,flightId);
    }
}
