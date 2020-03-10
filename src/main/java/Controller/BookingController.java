package Controller;

import Service.BookingService;

public class BookingController {
    BookingService service=new BookingService();

    public void displayAllBookings(){
        service.getAllBookings().stream().forEach(x->System.out.println(x));
    }
    public void writeDataFile(){
        service.saveBookings();
    }
    public void readData(){
        service.loadBookings();
    }
}
