package console;

import entity.UserCredential;

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
    public void execution(UserCredential userCredential) {
        console2.printLn("YOUR BOOKINGS:\n");
        bc.displayBookingsbyPair(userCredential);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
