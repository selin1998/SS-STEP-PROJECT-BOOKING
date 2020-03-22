package console;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import entity.UserCredential;
import io.Console;
import io.UnixConsole;

import java.util.Scanner;

public interface Option {

    final String DASHES = new String(new char[93]).replace("\0", "-");
    Console console2 = new UnixConsole(new Scanner(System.in));
    ConsoleApp c = new ConsoleApp();


    int optNumber();

    String text();

    void execution(UserCredential userCredential);


    boolean isExit();

}
