package Console;

import io.Console;
import io.UnixConsole;

import java.util.Scanner;

public class Menu {
    
   public static StringBuilder menu= new StringBuilder();

    public static StringBuilder loginRegister= new StringBuilder();
    final static String DASHES = new String(new char[30]).replace("\0", "-");
   public static Console console = new UnixConsole(new Scanner(System.in));
    static {
        generateMenu();
        loginRegister();
    }

    public static void generateMenu(){
        menu.append(DASHES);
        menu.append("\nFLIGHT BOOKING APPLICATION\n");
        menu.append(DASHES);
        menu.append("\n1. Online table.\n");
        menu.append("2. Flight information.\n");
        menu.append("3. Flights search and booking.\n");
        menu.append("4. Booking cancelling.\n");
        menu.append("5. My flights.\n");
        menu.append("6. Close session.\n");
        menu.append("7. Exit.\n");
    }
    public static void loginRegister(){

       loginRegister.append(DASHES);
       loginRegister.append("\nFLIGHT BOOKING APPLICATION\n");
        loginRegister.append(DASHES);
        loginRegister.append("\nWanna buy one way ticket to the blues?\n");
        loginRegister.append("\n1. Login.\n");
        loginRegister.append("2. Register.\n");
        loginRegister.append("3. Online table.\n");
        loginRegister.append("4. Flight information.\n");
        loginRegister.append("5. Exit.\n");

    }

    public static void printMenu(){



        console.printLn(menu.toString());

    }

    public static void printLoginRegister(){
        console.printLn(loginRegister.toString());
    }







    
}
