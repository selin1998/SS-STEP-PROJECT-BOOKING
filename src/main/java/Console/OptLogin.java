package Console;

import DAO.Pair;

import java.util.Scanner;



public class OptLogin implements UserOption {



    @Override
    public int userOptNumber() {
        return 1;
    }

    @Override
    public void operation() {


        console.print("Please enter your username:");
        String username=console.readLn();
        console.printLn();
        console.print("Please enter your password:");
        String password=console.readLn();
        Pair pair= new Pair(username,password);
        if(uc.userExists(pair)){
            ConsoleApp c= new ConsoleApp();
            c.flightAndBooking(new Pair(username,password));
            c.isExitUser=true;
        }
        else{
            console.printLn("Wrong username or password!");
            c.start();
        }
    }

    @Override
    public boolean isExitUser() {
        return false;
    }


}
