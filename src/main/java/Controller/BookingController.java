package Controller;

import DAO.Booking;
import DAO.Passenger;
import DAO.SearchAndBook;
import Service.BookingService;

import java.util.List;

public class BookingController {
    BookingService service = new BookingService();
    FlightController controllerFlight = new FlightController();
    SearchAndBook sab = new SearchAndBook();

    public void displayAllBookings() {
        service.getAllBookings().stream().forEach(x -> System.out.println(x));
    }

    public void writeDataFile() {
        service.saveBookings();
    }

    public void readData() {
        service.loadBookings();
    }

    public boolean makeBooking(Booking booking){
        return service.makeBooking(booking);
    }
    //  public void searchFl(){service.searchFlights();}


    //    public List<String > searchFlightsforBooking(String destination,String numberPlaces){
//        return controllerFlight.displaySearchedFlight(destination,numberPlaces);
//    }


    public void displayAllFlights(){
        sab.getAllFlights().stream().forEach(x->System.out.println(x));
    }

    public void searchFlightsforBooking(String destination, int numberPlaces) {
        sab.searchFlight(destination, numberPlaces).stream().forEach(x -> System.out.println(x));
    }

    public boolean isbooked(int flightID, String username, Passenger passenger){
       return sab.bookingFlights(flightID,username,passenger);
    }
}
