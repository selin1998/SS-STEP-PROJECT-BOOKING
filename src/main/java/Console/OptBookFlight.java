package Console;

import Controller.BookingController;
import Controller.FlightController;
import DAO.Booking;
import DAO.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class OptBookFlight implements Option {
    final String DASHES2 = new String(new char[93]).replace("\0", "-");

    FlightController controllerFlight = new FlightController("./INFO/flight.bin");
    BookingController controllerBooking=new BookingController("./INFO/bookings.bin");
    HashMap<Integer, String> data;
    ArrayList<Booking> bookingList=new ArrayList<>();
    ArrayList<Passenger> passengersList=new ArrayList<>();
    Passenger passenger;

    @Override
    public int optNumber() {
        return 3;
    }

    @Override
    public String text() {
        return "SEARCH AND BOOK FOR FLIGHTS";
    }

    @Override
    public void execution() {
        //SEARCH PART
        System.out.println("Enter destination, airline and number of passengers to search for matching flights: ");
        System.out.println("Destination:");
        String dest = sc.nextLine();
        System.out.println("Airline:");
        String airway = sc.nextLine();
        System.out.println("Number of passengers:");
        int count = sc.nextInt();
        System.out.println("FLIGHTS MATCHING YOUR CRITERIA:");
        System.out.println(DASHES2);
        System.out.println(String.format("| %-8s | %-10s | %-8s | %-15s | %-28s | %-5s |", "Serial No", "FlightID", "Date", "Destination", "Airline", "Seats"));
        System.out.println(DASHES2);
        fc.displayFlightsBy(dest, airway, count);
        //BOOKING PART
        System.out.println("Enter Serial NO of flight you would like to book or press 0 to return to main menu:");
        int serialNo = 2;
        String firstname;
        String lastname;
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the firstname:");
            firstname=sc.nextLine();
//            System.out.println("Enter the lastname:");
//             lastname=sc.nextLine();
            passengersList.add(new Passenger(firstname)); //,lastname
        }
        data = controllerFlight.getFlightsBymap(dest,airway,count);
        String flight = data.get(serialNo);
        Booking book1=new Booking(passengersList,flight);
        controllerBooking.saveBooking(book1);
        controllerBooking.displayAllBookings();
        //bookingList.add(book1);



    }

    @Override
    public boolean isExit() {
        return false;
    }


//    FlightController controllerFlight=new FlightController("./INFO/flight.bin");
//    HashMap<Integer,String> data;
//
//    @Override
//    public int optNumber() {
//        return 4;
//    }
//
//    @Override
//    public String text() {
//        return "BOOK FLIGHT";
//    }
//
//    @Override
//    public void execution() {
////        optSearchFlight.execution();
//        System.out.println("Enter Serial NO of flight you would like to book or press 0 to return to main menu:");
//        int serialNo= sc.nextInt();
//       data=controllerFlight.getFlightsBymap();
//
//
//
//    }
//
//    @Override
//    public boolean isExit() {
//        return false;
//    }

}
