package console;

import entity.UserCredential;


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
        UserCredential userCredential = new UserCredential(username,password);
        if(uc.userExists(userCredential)){
            ConsoleApp c= new ConsoleApp();
            c.flightAndBooking(new UserCredential(username,password));
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
