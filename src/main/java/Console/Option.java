package Console;

import Controller.BookingController;
import Controller.FlightController;
import Controller.UserController;
import DAO.Pair;
import io.Console;
import io.UnixConsole;

import java.util.Scanner;

public interface Option {

    final String DASHES = new String(new char[82]).replace("\0", "-");
    FlightController fc = new FlightController("./INFO/flight.bin");
    BookingController bc = new BookingController("./INFO/booking.bin");
    UserController uc = new UserController("./INFO/user.bin");
    Console console2 = new UnixConsole(new Scanner(System.in));
    ConsoleApp c = new ConsoleApp();


    int optNumber();

    String text();

    void execution(Pair pair);


    boolean isExit();

}
