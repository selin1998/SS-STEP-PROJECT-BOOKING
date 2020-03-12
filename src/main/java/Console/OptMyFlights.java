package Console;

import Controller.BookingController;

public class OptMyFlights implements Option {

    @Override
    public int optNumber() {
        return 5;
    }

    @Override
    public String text() {
        return "MY FLIGHTS";
    }

    @Override
    public void execution() {
        System.out.println("Your bookings:");
        bc.displayAllBookings();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
