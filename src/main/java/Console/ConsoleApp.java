package Console;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleApp {
    List<UserOption> userOptions = UserOptions.all();
    List<Option> options = Options.all();
    Boolean isExit=false;
    Boolean isExitUser=false;


    Optional<Option> opt;
    Optional <UserOption> userOpt;

    public void start(){


        Menu m= new Menu();
        Scanner sc=new Scanner(System.in);
        while(!isExitUser){

            m.printLoginRegister();
            System.out.println("Please, enter option number: ");
            int num=sc.nextInt();
            userOpt = userOptions
                    .stream()
                    .filter(command -> command.userOptNumber()==num)
                    .findFirst();

            userOpt.ifPresent(UserOption::operation);
            isExitUser=userOpt.get().isExitUser();




        }}



        public void flightAndBooking(){
            Menu m= new Menu();
            Scanner sc1=new Scanner(System.in);
            while(!isExit){
                m.printMenu();

                System.out.println("Please, enter option number: ");
                int num=sc1.nextInt();
                opt = options
                        .stream()
                        .filter(command -> command.optNumber()==num)
                        .findFirst();

                opt.ifPresent(Option::text);
                opt.ifPresent(Option::execution);
                isExit=opt.get().isExit();
                isExitUser=isExit;


            }
        }


    }




