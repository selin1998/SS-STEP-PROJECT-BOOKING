package entity;

import dao.CollectionBookingDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {
    final String DASHES = new String(new char[107]).replace("\0", "-");


   public int idBooking;
  public  List<Passenger> passenger;
   public  String flight;
   public UserCredential userCredential;


    public Booking(int idBooking, List<Passenger> passenger, String flight, UserCredential userCredential) {
        this.idBooking = idBooking;
        this.passenger = passenger;
        this.flight = flight;
        this.userCredential = userCredential;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
                Objects.equals(passenger, booking.passenger) &&
                Objects.equals(flight, booking.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking,  passenger, flight);
    }  //username,

    @Override
    public String toString() {


        String str=String.format("| %-10s | %-16s | %-15s | %-15s | %-28s | %-5s |", "FlightID","Departure Time","Origin", "Destination", "Airline", "Seats");
        String dash=DASHES;
        StringBuilder booking= new StringBuilder();
        booking.append(String.format("Booking ID: %d \n",idBooking));


        for (Passenger p: passenger) {
            booking.append(p.toString());
            booking.append("\n");
        }
        booking.append(String.format("%s\n%s\n%s\n%s\n ",dash,str,dash,flight));
        booking.append("\n###");
        booking.append(userCredential.toString());
        booking.append("\n");
        return booking.toString();

    }
}
