package Console;

import java.util.Scanner;

public class ConsoleApp {


    public void start(){

        Boolean isExit=false;
        Menu m= new Menu();
        Scanner sc=new Scanner(System.in);
        while(!isExit){
            m.printMenu();
        }


    }



}
