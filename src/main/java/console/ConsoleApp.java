package console;
import entity.UserCredential;
import io.Console;
import io.UnixConsole;

import java.util.*;

public class ConsoleApp {
    List<UserOption> userOptions ;
    List<Option> options ;

    Boolean isExit = false;
    Boolean isExitUser = false;

    Optional<Option> opt;
    Optional<UserOption> userOpt;

    Console console = new UnixConsole(new Scanner(System.in));

   final Database db=new Database();

    public ConsoleApp() {
        userOptions = UserOptions.all(db);
        options = Options.all(db);
    }

    public void start() {

        db.flights.read();
        db.users.read();
        Menu m = new Menu();
        while (!isExitUser && !isExit) {

            m.printLoginRegister();
            console.printLn("Please, enter option number: ");
           int num;
            try{


                while(!console.hasNextInt()){
                    String input=console.readLnNext();
                    console.print("Enter option in number format:\n");
                }
                    num=console.readInt();
                    userOpt = userOptions
                            .stream()
                            .filter(command -> command.userOptNumber() == num)
                            .findFirst();


                userOpt.ifPresent(UserOption::operation);
                isExitUser = userOpt.get().isExitUser();


                if (num == 1) {
                    break;

                  }

            }

            catch (NoSuchElementException ex){
                console.printLn("Enter valid option number!!!");
            }



        }
    }


    public void flightAndBooking(UserCredential userCredential) {
        db.bookings.read();
        db.flights.read();
        db.users.read();
        Menu m = new Menu();
        while (!isExit) {
            m.printMenu();

            console.printLn("Please, enter option number: ");
            try{

                while(!console.hasNextInt()){
                    String input=console.readLnNext();
                   console.print("Enter option in number format:\n");
                }

                int num = console.readInt();
                opt = options
                        .stream()
                        .filter(command -> command.optNumber() == num)
                        .findFirst();

                opt.ifPresent(Option::text);
                opt.get().execution(userCredential);

                isExit = opt.get().isExit();
            }

            catch (Exception ex){
                System.out.println("Enter valid option number!!!");
            }



        }
    }


}




