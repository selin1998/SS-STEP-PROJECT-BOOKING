package Console;

public class OptExit implements Option {
    @Override
    public int optNumber() {
        return 7;
    }

    @Override
    public String text() {
        return "EXIT";
    }

    @Override
    public void execution() {
        System.out.println("Bye!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
