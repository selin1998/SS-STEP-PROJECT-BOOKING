package Console;

import Controller.FlightController;
import DAO.Pair;

import static Console.UserOption.fc2;

public class OptOnlineBoard implements Option,UserOption {



    @Override
    public int optNumber() {
        return 1;
    }

    @Override
    public String text() {
        return "Online-board";
    }

    @Override
    public void execution(Pair pair) {
        System.out.println("ONLINE-BOARD");
        System.out.println(DASHES);
        System.out.println(String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Date", "Destination", "Airline", "Seats"));
        System.out.println(DASHES);
        fc.displayAllFlights();
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

        System.out.println("ONLINE-BOARD");
        System.out.println(DASHES);
        System.out.println(String.format("| %-10s | %-8s | %-15s | %-28s | %-5s |", "FlightID", "Date", "Destination", "Airline", "Seats"));
        System.out.println(DASHES);
        fc2.displayAllFlights();

    }

    @Override
    public boolean isExitUser() {
        return false;
    }
}
