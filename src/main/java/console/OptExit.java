package console;

import entity.UserCredential;

public class OptExit extends Storage implements UserOption, Option {

    public UserCredential userCredential;

    public OptExit(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 7;
    }

    @Override
    public String text() {
        return "EXIT";
    }

    @Override
    public void execution(UserCredential userCredential) {
        storage.writeData();
        console.printLn("Bye!");
        this.userCredential = userCredential;


    }


    @Override
    public int userOptNumber() {
        return 5;
    }



    @Override
    public void operation() {

        execution(userCredential);


    }

    @Override
    public boolean isExitUser() {
        return true;
    }


    @Override
    public boolean isExit() {
        return true;
    }
}
