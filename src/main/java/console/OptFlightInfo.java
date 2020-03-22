package console;

import entity.UserCredential;

public class OptFlightInfo extends Storage implements Option,UserOption {



    final String DASHES = new String(new char[93]).replace("\0", "-");

    public OptFlightInfo(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 2;
    }

    @Override
    public String text() {
        return "SHOW THE FLIGHT INFO";
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
        return 4;
    }

    @Override
    public void operation() {
        console.printLn("Please enter the flight id to get info:");
        String input=console.readLn();
        console.printLn(DASHES);
        console.printLn(String.format("| %-10s | %-10s | %-6s | %-15s | %-28s | %-5s |", "FlightID","Date", "Time", "Destination", "Airline", "Seats"));
        console.printLn(DASHES);
        storage.flights.displayFlightbyId(input);
    }

    @Override
    public boolean isExitUser() {
        return false;
    }
}
