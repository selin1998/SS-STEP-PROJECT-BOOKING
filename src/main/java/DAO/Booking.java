package DAO;

import java.util.Objects;

public class Booking {
    private static int counter = 0;

    int idBooking;
//    LocalDateTime bookedTime;
    User user;
    Passenger passenger;
    Flight flight;

    public Booking(User user, Passenger passenger, Flight flight) {
        this.idBooking = counter++;
        this.user = user;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Booking(int idBooking, User user, Passenger passenger, Flight flight) {
        this.idBooking = idBooking;
        this.user = user;
        this.passenger = passenger;
        this.flight = flight;
    }

    public String displayBookingInfo() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking, passenger.name.toUpperCase(), passenger.lastname.toUpperCase(), flight);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return idBooking == booking.idBooking &&
                user.equals(booking.user) &&
                passenger.equals(booking.passenger) &&
                flight.equals(booking.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, user, passenger, flight);
    }

    @Override
    public String toString() {
        return String.format("| %-10d |%-10s |%-10s |%-15s |",
                idBooking, passenger.name.toUpperCase(), passenger.lastname.toUpperCase(), flight);
    }
}
