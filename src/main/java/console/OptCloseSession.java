package console;

import entity.UserCredential;

public class OptCloseSession extends Storage implements Option {


    public OptCloseSession(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 6;
    }

    @Override
    public String text() {
        return "CLOSE SESSION";
    }

    @Override
    public void execution(UserCredential userCredential) {
        storage.writeData();
        c.start();

    }

    @Override
    public boolean isExit() {
        return true;
    }
}
