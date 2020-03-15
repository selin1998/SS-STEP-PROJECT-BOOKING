package Console;

import Controller.BookingController;
import Controller.FlightController;
import Controller.UserController;

public interface UserOption {

    FlightController fc= new FlightController("./INFO/flight.bin");
    BookingController bc=new BookingController("./INFO/booking.bin");
    UserController uc= new UserController("./INFO/user.bin");
    ConsoleApp c=new ConsoleApp();

    int userOptNumber();
    void operation();
    boolean isExitUser();

}
