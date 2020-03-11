package Console;

import Controller.FlightController;

import java.util.Scanner;

public interface Option {
    FlightController fc= new FlightController();
    Scanner sc= new Scanner(System.in);
    int optNumber();
    String text();
    void execution();

}
