package console;

import entity.UserCredential;

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
        console.printLn(String.format("| %-10s | %-10s | %-6s | %-15s | %-28s | %-5s |", "FlightID","Date", "Time", "Destination", "Airline", "Seats"));
        console.printLn(DASHES);
        fc2.displayAllFlights();

    }

    @Override
    public boolean isExitUser() {
        return false;
    }
}
