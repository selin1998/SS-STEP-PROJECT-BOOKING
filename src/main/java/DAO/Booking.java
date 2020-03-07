package DAO;

import java.util.List;
import java.util.Objects;

public class Booking {
    int idFlight;
    int idBooking;
    String username;
    String namePassenger;
    String lastnamePassenger;
    List<Passenger> passengers;
    List<Flight> flights;

    public Booking(int idFlight, int idBooking, String username, String namePassenger, String lastnamePassenger)  //, List<Passenger> passengers, List<Flight> flights
     {
        this.idFlight = idFlight;
        this.idBooking = idBooking;
        this.username = username;
        this.namePassenger = namePassenger;
        this.lastnamePassenger = lastnamePassenger;
//        this.passengers = passengers;
//        this.flights = flights;
    }

    public static Booking parse(String text) {
        String[] content = text.split("|");
        return new Booking(
                Integer.parseInt(content[0]),
                Integer.parseInt(content[1]),
                content[2],
                content[3],
                content[4]
//                content[5],
//                content[6]
        );
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |%-10d |%-10s|",
                idFlight, idBooking, username, namePassenger, lastnamePassenger, passengers, flights);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return idFlight == booking.idFlight &&
                idBooking == booking.idBooking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight, idBooking);
    }
}
