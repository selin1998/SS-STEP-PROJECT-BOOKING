package DAO;

import java.util.List;

public class Booking {
    final int idFlight;
    final int idBooking;
    String username;
    String namePassenger;
    String lastnamePassenger;
    List<Passenger> passengers;
    List<Flight> flights;

    public Booking(int idFlight, int idBooking, String username, String namePassenger, String lastnamePassenger, List<Passenger> passengers, List<Flight> flights) {
        this.idFlight = idFlight;
        this.idBooking = idBooking;
        this.username = username;
        this.namePassenger = namePassenger;
        this.lastnamePassenger = lastnamePassenger;
        this.passengers = passengers;
        this.flights = flights;
    }

    public String toString() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |%-10d |%-10s|",
                idFlight, idBooking, username, namePassenger, lastnamePassenger, passengers, flights);
    }
}
