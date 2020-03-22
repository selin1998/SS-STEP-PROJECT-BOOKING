package console;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import dao.*;
import entity.Booking;
import entity.Flight;
import entity.User;

public class Database {
    public  UserController users;
    public  FlightController flights;
    public  BookingController bookings;

    public Database() {
        this.users = new UserController("./INFO/user.bin");
        this.flights = new FlightController("./INFO/flight.bin");
        this.bookings = new BookingController("./INFO/booking.bin");
    }

    public void writeData(){
        flights.write();
        bookings.write();
        users.write();

    }

}
