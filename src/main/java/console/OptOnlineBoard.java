package console;

import entity.Flight;
import entity.UserCredential;


public class OptOnlineBoard extends Storage implements Option,UserOption {


    public OptOnlineBoard(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 1;
    }

    @Override
    public String text() {
        return "Online-board";
    }

    @Override
    public void execution(UserCredential userCredential) {
        operation();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public int userOptNumber() {
        return 3;
    }

    @Override
    public void operation() {

        console.printLn("ONLINE-BOARD");
        console.printLn(DASHES);
        console.printLn(String.format("| %-10s | %-16s | %-15s | %-15s | %-28s | %-5s |", "FlightID","Departure Time","Origin", "Destination", "Airline", "Seats"));
        console.printLn(DASHES);
        storage.flights.changeDepartureTime();
        storage.flights.displayAllFlights();

    }

    @Override
    public boolean isExitUser() {
        return false;
    }
}
