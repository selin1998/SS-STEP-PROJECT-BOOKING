package Console;

import Controller.BookingController;

import java.util.Scanner;

public class OptCancelBooking implements Option {
    Scanner sc=new Scanner(System.in);

    @Override
    public int optNumber() {
        return 4;
    }

    @Override
    public String text() {
        return "CANCEL THE BOOKING";
    }

    @Override
    public void execution() {
        System.out.println("Enter the booking id for cancel booking:");
        int id = sc.nextInt();
        bc.cancelBooking(id);

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
