package Console;

import Controller.BookingController;
import Service.BookingService;

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
        System.out.println("Enter the booking id for canceling booking:");
        int id = sc.nextInt();

        int seats= bc.getBookingbyId(id).passenger.size();
        String idFlight=  bc.getBookingbyId(id).flight.split("\\|")[1].trim();
        fc.inreaseSeats(idFlight,seats);
        bc.cancelBooking(id);



    }

    @Override
    public boolean isExit() {
        return false;
    }
}
