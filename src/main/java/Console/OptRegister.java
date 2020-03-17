package Console;

import DAO.Pair;
import DAO.User;

import java.util.Scanner;

public class OptRegister implements UserOption {


    @Override
    public int userOptNumber() {
        return 2;
    }

    @Override
    public void operation() {

        console.print("Please enter your name:");
        String name=console.readLn();
        console.printLn();
        console.print("Please enter your surname:");
        String surname=console.readLn();
        console.printLn();
        console.print("Please enter a username:");
        String username=console.readLn();
        console.printLn();
        console.print("Please enter a password:");
        String password=console.readLn();
        console.printLn();

        Pair pair= new Pair(username,password);
        if(!uc.userExists(pair)){
            User user= new User(pair,name,surname);
            uc.saveUser(user);
            console.printLn("You are registered, now login please!");
        }

        else{
            console.printLn("User with such credentials already exists!");
        }
    }

    @Override
    public boolean isExitUser() {
        return false;
    }


}
