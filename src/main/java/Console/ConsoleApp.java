package Console;

import DAO.Pair;

import java.util.*;

public class ConsoleApp {
    List<UserOption> userOptions = UserOptions.all();
    List<Option> options = Options.all();

    Boolean isExit = false;
    Boolean isExitUser = false;

    Optional<Option> opt;
    Optional<UserOption> userOpt;


    public void start() {


        Menu m = new Menu();
        Scanner sc = new Scanner(System.in);
        while (!isExitUser && !isExit) {

            m.printLoginRegister();
            System.out.println("Please, enter option number: ");
           int num;
            try{


                while(!sc.hasNextInt()){
                    String input=sc.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                }
                    num=sc.nextInt();
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
                System.out.println("Enter valid option number!!!");
            }



        }
    }


    public void flightAndBooking(Pair pair) {
        Menu m = new Menu();
        Scanner sc1 = new Scanner(System.in);
        while (!isExit) {
            m.printMenu();

            System.out.println("Please, enter option number: ");
            try{

                while(!sc1.hasNextInt()){
                    String input=sc1.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                }

                int num = sc1.nextInt();
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




