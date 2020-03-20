package console;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import io.Console;
import io.UnixConsole;

import java.util.Scanner;

public interface UserOption {

    FlightController fc2= new FlightController("./INFO/flight.bin");
    BookingController bc2=new BookingController("./INFO/booking.bin");
    UserController uc= new UserController("./INFO/user.bin");
    ConsoleApp c=new ConsoleApp();
    Console console = new UnixConsole(new Scanner(System.in));
    int userOptNumber();
    void operation();
    boolean isExitUser();

}
