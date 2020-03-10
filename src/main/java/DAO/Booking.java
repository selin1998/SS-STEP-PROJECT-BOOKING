package DAO;

import java.util.Objects;

public class Booking {
    private static int counter = 0;

    int idBooking;
//    LocalDateTime bookedTime;
    String username;
    Passenger passenger;
    String flightId;

    public Booking(String username, Passenger passenger, String flightId) {
        this.username = username;
        this.passenger = passenger;
        this.flightId = flightId;
    }

    public Booking(int idBooking, String username, Passenger passenger, String flightId) {
        this.idBooking = idBooking;
        this.username = username;
        this.passenger = passenger;
        this.flightId = flightId;
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking,username, passenger.pass_ID,flightId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
                Objects.equals(username, booking.username) &&
                Objects.equals(passenger, booking.passenger) &&
                Objects.equals(flightId, booking.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, username, passenger, flightId);
    }

    @Override
    public String toString() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking,username, passenger.pass_ID,flightId);
    }
}
