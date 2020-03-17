package Console;

import Controller.BookingController;
import DAO.Pair;

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
    public void execution(Pair pair) {
        console2.printLn("Your bookings:");
        bc.displayBookingsbyPair(pair);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
