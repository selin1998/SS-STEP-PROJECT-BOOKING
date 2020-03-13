package Console;

public class OptExit implements Option, UserOption {
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
    public int userOptNumber() {
        return 3;
    }

    @Override
    public void operation() {

        execution();


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
