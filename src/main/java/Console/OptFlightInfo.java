package Console;

import Controller.FlightController;
import DAO.Flight;

public class OptFlightInfo implements Option {
    @Override
    public int optNumber() {
        return 2;
    }

    @Override
    public String text() {
        return "SHOW THE FLIGHT INFO";
    }

    @Override
    public void execution() {
        System.out.println("Please enter the flight id to get info:");
        String input=sc.nextLine();
       fc.displayFlightbyId(input);
    }
}
