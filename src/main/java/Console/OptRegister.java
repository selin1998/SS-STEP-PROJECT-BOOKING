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
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name=sc.nextLine();
        System.out.println("Please enter your surname:");
        String surname=sc.nextLine();
        System.out.println("Please enter a username:");
        String username=sc.nextLine();
        System.out.println("Please enter a password:");
        String password=sc.nextLine();

        Pair pair= new Pair(username,password);
        if(!uc.userExists(pair)){
            User user= new User(pair,name,surname);
            uc.saveUser(user);
            System.out.println("You are registered, now login please!");
        }
        else{
            System.out.println("User with such credentials already exists!");
        }
    }

    @Override
    public boolean isExitUser() {
        return false;
    }


}
