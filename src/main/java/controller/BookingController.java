package controller;

import entity.Booking;
import entity.UserCredential;
import service.BookingService;

import java.util.HashMap;
import java.util.List;

public class BookingController {
    BookingService service;

    public BookingController(String filename) {

        service = new BookingService(filename);
    }

    FlightController controllerFlight = new FlightController("./INFO/flight.bin");


    public void displayAllBookings() {
        service.getAllBookings().forEach(System.out::println);
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

    public List<Booking> getAll(){
        return service.getAll();
    }


    public void displayBookingsbyPair(UserCredential userCredential){
        List<Booking> list=service.getBookingsbyPair(userCredential);
        if(list.isEmpty()){
            System.out.println("No bookings were found!!!");
        }
        else{
            list.stream().map(x->x.toString().split("###")[0]).forEach(x-> System.out.println(x));
        }

    }

    public void read(){
        service.read();
    }
    public void write(){
        service.write();
    }
    public Booking getBookingbyPairandId(UserCredential userCredential, int id){
        return service.getBookingbyPairAndId(userCredential,id);
    }

    public String getFlightForBooking(int serialNo,String dest,String airway,int count,String date){
        HashMap<Integer, String> data;
        data = controllerFlight.getFlightsBymap(dest,airway,count,date);
        String flight = data.get(serialNo);
        return flight;
    }



}
