package console;

import entity.UserCredential;

public class OptCloseSession implements Option {


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
        c.start();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
