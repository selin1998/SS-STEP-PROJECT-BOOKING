package console;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import io.Console;
import io.UnixConsole;

import java.util.Scanner;

public interface UserOption {


    ConsoleApp c=new ConsoleApp();
    Console console = new UnixConsole(new Scanner(System.in));
    int userOptNumber();
    void operation();
    boolean isExitUser();

}
