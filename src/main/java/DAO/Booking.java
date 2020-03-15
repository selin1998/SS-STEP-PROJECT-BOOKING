package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {
    final String DASHES = new String(new char[82]).replace("\0", "-");
  //  BookingController controllerBooking=new BookingController("./INFO/book.bin");


   public int idBooking;
  public  List<Passenger> passenger;
   public  String flight;
   public Pair pair;

    private static int counter;

    {
        ArrayList<Booking> all = new BookingDAO("./INFO/booking.bin").getAll();
        counter = all.stream().map(b -> b.idBooking).max((id1, id2) -> id1 - id2).orElse(0);
    }

    public Booking( List<Passenger> passenger, String flight,Pair pair) {

        this.idBooking=++counter;
        this.pair = pair;
        this.passenger = passenger;
        this.flight = flight;
    }
    public Booking(int idBooking, List<Passenger> passenger, String flight, Pair pair) {
        this.idBooking = idBooking;
        this.passenger = passenger;
        this.flight = flight;
        this.pair = pair;
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-20s |%-10s |",
                idBooking, passenger.toString(),flight);   //username,
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
              //  Objects.equals(username, booking.username) &&
                Objects.equals(passenger, booking.passenger) &&
                Objects.equals(flight, booking.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking,  passenger, flight);
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
        booking.append(String.format("%s\n%s\n%s\n%s\n ",dash,str,dash,flight));
        booking.append("\n###");
        booking.append(pair.toString());
        booking.append("\n");
        return booking.toString();
//        return String.format("Booking ID: %d \n|%-20s\n%s\n%s\n%s\n%s\n ",
//                idBooking, passenger.toString(),dash,str,dash,flightId);
    }
}
