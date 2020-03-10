import Controller.BookingController;
import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;
import DAO.Passenger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FlightController fc= new FlightController();
        BookingController bc=new BookingController();

        bc.displayAllFlights();
        System.out.println("-------------");
//        Scanner in=new Scanner(System.in);
//        System.out.println("Enter the destination: ");
//        String destination = in.nextLine();
//        System.out.println("Enter the number of places you want: ");
//        int numOfPlaces = in.nextInt();
//        bc.searchFlightsforBooking(destination, numOfPlaces);
        System.out.println(bc.isbooked());





//        System.out.println(fc.displaySearchedFlight("Tunis", "3"));
//        System.out.println("-------------");
//        fc.displayFlightbyId(5);
////        DAO <Flight> dao=new FlightDAO("./INFO/flight.bin");
////        System.out.println(dao.getAll());
//        System.out.println("-------------");
//        fc.displayFlightsBy("Moscow","Aeroflot");
//
//
//        System.out.println("Flight searched:");
//        bc.searchFl();
    }

}
