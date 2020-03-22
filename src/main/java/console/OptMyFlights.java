package console;

import entity.UserCredential;

public class OptMyFlights extends Storage implements Option {


    public OptMyFlights(Database storage) {
        super(storage);
    }

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
        storage.bookings.displayBookingsbyPair(userCredential);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
