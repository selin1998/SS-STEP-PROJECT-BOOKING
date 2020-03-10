package DAO;

import java.util.Objects;

public class Booking {
    private static int counter = 0;

    int idBooking;
//    LocalDateTime bookedTime;
    String username;
    String passengerId;
    String flightId;

    public Booking(String userId, String passengerId, String flightId) {
        this.username = userId;
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public Booking(int idBooking, String userId, String passengerId, String flightId) {
        this.idBooking = idBooking;
        this.username = userId;
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking,username, passengerId,flightId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
                Objects.equals(username, booking.username) &&
                Objects.equals(passengerId, booking.passengerId) &&
                Objects.equals(flightId, booking.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, username, passengerId, flightId);
    }

    @Override
    public String toString() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking,username, passengerId,flightId);
    }
}
