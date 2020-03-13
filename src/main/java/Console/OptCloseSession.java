package Console;

public class OptCloseSession implements Option{
    @Override
    public int optNumber() {
        return 6;
    }

    @Override
    public String text() {
        return "CLOSE SESSION";
    }

    @Override
    public void execution() {
        console.start();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
