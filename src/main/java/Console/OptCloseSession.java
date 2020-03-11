package Console;

public class OptCloseSession implements Option{
    @Override
    public int optNumber() {
        return 8;
    }

    @Override
    public String text() {
        return "CLOSE SESSION";
    }

    @Override
    public void execution() {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
