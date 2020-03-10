package DAO;

import Console.InputReader;
import Controller.BookingController;
import Controller.FlightController;
import Service.FlightService;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import DAO.DAO;
import org.graalvm.compiler.lir.LIRInstruction;

public class SearchAndBook {
    InputReader input;

    //LIKE ANOTHER FLIGHTSERVICE

    DAO<Flight> dao = new FlightDAO("./INFO/flight.bin");

    FlightController controllerFlight = new FlightController();
    BookingController bc=new BookingController();
    FlightService service =new FlightService();

//If in FlightService something changes:------>
    public List<String> getAllFlights(){
        return dao.getAll().stream().map(x -> x.toString()).collect(Collectors.toList());

    }


    public List<String> searchFlight(String destination, int numberofPlaces) {
        return dao.getAll().stream()
                .filter(f -> f.destination.equals(destination))
                .filter(f -> Integer.parseInt(f.numberOfFreePlaces) >= numberofPlaces)
                .map(x -> x.toString()).collect(Collectors.toList());
    }


    public boolean bookingFlights(String flightID,String userName, Passenger passenger){  //User user
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the destination: ");
        String destination = in.nextLine();
        System.out.println("Enter the number of places you want: ");
        int numOfPlaces = in.nextInt();
        bc.searchFlightsforBooking(destination, numOfPlaces);


        boolean proceedToBooking = input.getYesOrNo();
        if (proceedToBooking) {
            // get the flight details
            Optional<Flight> optFlight;
            do {
                System.out.println("Enter the flight ID: ");
                optFlight = dao.get(flightID);
            } while (!optFlight.isPresent());
            Flight flight = optFlight.get();
            // get the passenger details and make the bookings
            IntStream.range(1, numOfPlaces + 1).forEach(n -> {
//                String firstName = input.getName("Enter first name of passenger " + n + ": ");
//                String lastName = input.getName("Enter last name of passenger " + n + ": ");
                System.out.println("Enter first name of passenger ");
               String firstName= in.nextLine();
                System.out.println("Enter last name of passenger ");
                String lastName= in.nextLine();
                bc.makeBooking(new Booking(userName,new Passenger(firstName,lastName),flightID));
            });
        }
        return true;

    }


}
