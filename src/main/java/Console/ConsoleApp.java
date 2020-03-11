package Console;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleApp {
    List<Option> options = Options.all();

    public void start(){

        Boolean isExit=false;
        Menu m= new Menu();
        Optional<Option> opt;

        Scanner sc=new Scanner(System.in);
        while(!isExit){
            m.printMenu();
            System.out.println("Please, enter option number: ");
            int num=sc.nextInt();
            opt = options
                    .stream()
                    .filter(command -> command.optNumber()==num)
                    .findFirst();

            opt.ifPresent(Option::text);
            opt.ifPresent(Option::execution);
            isExit=opt.get().isExit();

        }


    }



}
