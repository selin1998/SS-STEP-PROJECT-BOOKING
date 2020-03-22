package console;

import entity.UserCredential;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class OptCancelBooking extends Storage implements Option {


    public OptCancelBooking(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 4;
    }

    @Override
    public String text() {
        return "CANCEL THE BOOKING";
    }

    @Override
    public void execution(UserCredential userCredential) {
        System.out.println("Enter the booking id for canceling booking:");

        try{
            int id = console2.readInt();
            int seats= storage.bookings.getBookingbyPairandId(userCredential,id).passenger.size();
            String idFlight=  storage.bookings.getBookingbyId(id).flight.split("\\|")[1].trim();
            storage.flights.inreaseSeats(idFlight,seats);
            storage.bookings.cancelBooking(id);
        }

        catch(InputMismatchException ex){
            console2.print("Your input is mismatching. Enter a number!!!\n");
        }

        catch (NoSuchElementException ex){
            console2.print("You do not have booking with such ID!!!\n");
        }


    }

    @Override
    public boolean isExit() {
        return false;
    }
}
