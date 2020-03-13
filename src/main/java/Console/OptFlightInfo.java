package Console;

import Controller.FlightController;
import DAO.Flight;
import DAO.Pair;

import java.util.Scanner;

public class OptFlightInfo implements Option {



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
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the flight id to get info:");
        String input=sc.nextLine();
        System.out.println(DASHES);
        System.out.println(String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Date", "Destination", "Airline", "Seats"));
        System.out.println(DASHES);
        fc.displayFlightbyId(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
