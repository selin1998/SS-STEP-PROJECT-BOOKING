package Console;

import DAO.Pair;
import io.Console;
import io.UnixConsole;

import java.util.*;

public class ConsoleApp {
    List<UserOption> userOptions = UserOptions.all();
    List<Option> options = Options.all();

    Boolean isExit = false;
    Boolean isExitUser = false;

    Optional<Option> opt;
    Optional<UserOption> userOpt;

    Console console = new UnixConsole(new Scanner(System.in));

    public void start() {


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


    public void flightAndBooking(Pair pair) {
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
                opt.get().execution(pair);

                isExit = opt.get().isExit();
            }

            catch (Exception ex){
                System.out.println("Enter valid option number!!!");
            }



        }
    }


}




