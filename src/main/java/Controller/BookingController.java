package Controller;

import DAO.Booking;
import DAO.Passenger;
import Service.BookingService;
import Service.FlightService;

import java.util.List;

public class BookingController {
    BookingService service;

    public BookingController(String filename) {

        service = new BookingService(filename);
    }

    //  BookingService service = new BookingService();
    FlightController controllerFlight = new FlightController("./INFO/flight.bin");


    public void displayAllBookings() {
        service.getAllBookings().stream().forEach(x -> System.out.println(x));
    }

    public void displayBookinsByID(int id) {
        System.out.println(service.getBookingByID(id));

    }

    public boolean makeBooking(Booking booking) {
        return service.makeBooking(booking);
    }

    public boolean cancelBooking(int id) {
        return service.cancelBooking(id);
    }

    public void saveBooking(Booking booking) {
        service.saveBookings(booking);
    }

    public void searchFlightsforBooking(String destination, String airline, int numberPlaces) {
        controllerFlight.displayFlightsBy(destination, airline, numberPlaces);
    }


    //    public void writeDataFile() {
//        service.saveBookings();
//    }

//    public void readData() {
//        service.loadBookings();
//    }
//    public void searchFl() {
//        service.searchFlights();
//    }
//
//
//    public List<String> searchFlightsforBooking(String destination, String numberPlaces) {
//        return controllerFlight.displaySearchedFlight(destination, numberPlaces);
//    }
//
//
//    public void displayAllFlights() {
//        sab.getAllFlights().stream().forEach(x -> System.out.println(x));
//    }
//
//
//    public boolean isBooked() {
//
//
//        return true;
//    }

}
