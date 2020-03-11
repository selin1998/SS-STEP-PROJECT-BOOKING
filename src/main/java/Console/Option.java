package Console;

import Controller.FlightController;

import java.util.Scanner;

public interface Option {
    final String DASHES = new String(new char[82]).replace("\0", "-");
    FlightController fc= new FlightController("./INFO/flight.bin");
    Scanner sc= new Scanner(System.in);

    int optNumber();
    String text();
    void execution();
    boolean isExit();

}
