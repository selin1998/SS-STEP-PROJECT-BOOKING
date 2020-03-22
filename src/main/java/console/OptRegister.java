package console;

import entity.UserCredential;
import entity.User;

public class OptRegister extends Storage implements UserOption {


    public OptRegister(Database storage) {
        super(storage);
    }

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

        UserCredential userCredential = new UserCredential(username,password);
        if(!storage.users.userExists(userCredential)){
            User user= new User(userCredential,name,surname);
            storage.users.saveUser(user);
            console.printLn("You are registered, now login please!");
            storage.users.write();
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
