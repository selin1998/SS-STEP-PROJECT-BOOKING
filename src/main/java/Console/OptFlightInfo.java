package Console;

import Controller.FlightController;
import DAO.Flight;
import DAO.Pair;

import java.util.Scanner;

public class OptFlightInfo implements Option,UserOption {



    final String DASHES = new String(new char[82]).replace("\0", "-");
    @Override
    public int optNumber() {
        return 2;
    }

    @Override
    public String text() {
        return "SHOW THE FLIGHT INFO";
    }

    @Override
    public void execution(Pair pair) {
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
        console.printLn(String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Time", "Destination", "Airline", "Seats"));
        console.printLn(DASHES);
        fc2.displayFlightbyId(input);
    }

    @Override
    public boolean isExitUser() {
        return false;
    }
}
