package Console;

import Controller.BookingController;
import Controller.FlightController;
import Controller.UserController;

import java.util.Scanner;

public interface Option {
    final String DASHES = new String(new char[82]).replace("\0", "-");
    FlightController fc= new FlightController("./INFO/flight.bin");
   BookingController bc=new BookingController("./INFO/booking.bin");
   UserController uc= new UserController("./INFO/user.bin");
   ConsoleApp console= new ConsoleApp();


    int optNumber();
    String text();
    void execution();
    boolean isExit();

}
