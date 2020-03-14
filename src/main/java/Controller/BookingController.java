package Controller;

import DAO.Booking;

import DAO.DAO;
import DAO.Pair;
import DAO.Passenger;
import Service.BookingService;
import Service.FlightService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class BookingController {
    BookingService service;

    public BookingController(String filename) {

        service = new BookingService(filename);
    }

    FlightController controllerFlight = new FlightController("./INFO/flight.bin");


    public void displayAllBookings() {
        service.getAllBookings().stream().forEach(x -> System.out.println(x));
    }

    public Booking getBookingbyId(int id){
        return service.getBookingByID(id);
    }



    public void cancelBooking(int id) {
        service.cancelBooking(id);
    }

    public void saveBooking(Booking booking) {
        service.saveBookings(booking);
    }

    public void searchFlightsforBooking(String destination, String airline, int numberPlaces) {
        controllerFlight.displayFlightsBy(destination, airline, numberPlaces);
    }

    public void displayBookigsbyPair(Pair pair){
        System.out.println(service.getBookingsByPair(pair));

    }

    public String getBookingbyPairandId(Pair pair, int id){
        return service.getBookingbyPairAndId(pair,id).toString();
    }

    public String getFlightForBooking(int serialNo,String dest,String airway,int count){
        HashMap<Integer, String> data;
        data = controllerFlight.getFlightsBymap(dest,airway,count);
        String flight = data.get(serialNo);
        return flight;
    }



}
