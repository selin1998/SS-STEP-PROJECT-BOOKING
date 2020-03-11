package Console;

public class OptCancelBooking implements Option {
    @Override
    public int optNumber() {
        return 5;
    }

    @Override
    public String text() {
        return "CANCEL THE BOOKING";
    }

    @Override
    public void execution() {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
