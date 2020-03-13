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

        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username=sc.nextLine();
        System.out.println("Please enter your password:");
        String password=sc.nextLine();
        Pair pair= new Pair(username,password);
        if(uc.userExists(pair)){
            ConsoleApp c= new ConsoleApp();


                c.flightAndBooking(new Pair(username,password));
              //  c.isExitUser=false;
        }
        else{
            System.out.println("Wrong username or password!");
        }
    }

    @Override
    public boolean isExitUser() {
        return false;
    }


}
