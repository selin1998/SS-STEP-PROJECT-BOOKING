package Console;

public class OptBookFlight implements Option {
    @Override
    public int optNumber() {
        return 4;
    }

    @Override
    public String text() {
        return "BOOK FLIGHT";
    }

    @Override
    public void execution() {
        System.out.println("Enter Serial NO of flight you would like to book or press 0 to return to main menu:");


    }

    @Override
    public boolean isExit() {
        return false;
    }
}
