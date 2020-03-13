package Console;

import DAO.Pair;

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
    public void execution(Pair pair) {
        console.start();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
