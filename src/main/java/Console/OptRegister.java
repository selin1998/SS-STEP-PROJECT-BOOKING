package Console;

public class OptRegister implements Option {
    @Override
    public int optNumber() {
        return 10;
    }

    @Override
    public String text() {
        return "REGISTER";
    }

    @Override
    public void execution() {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
