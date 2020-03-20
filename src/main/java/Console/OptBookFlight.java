package Console;

import Controller.BookingController;
import Controller.FlightController;
import DAO.Booking;
import DAO.Pair;
import DAO.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OptBookFlight implements Option {



    final String DASHES2 = new String(new char[93]).replace("\0", "-");


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
    public void execution(Pair pair) {

        //SEARCH PART
       // Scanner sc=new Scanner(System.in);
        console2.printLn("Press Enter in order to fill destination, airline and number of passengers and search for matching flights: ");
        console2.readLn();
        console2.printLn("Destination:");
        String dest = console2.readLn();
        console2.printLn("Airline:");
        String airway = console2.readLn();
        console2.printLn("Number of passengers:");
        int count = console2.readInt();
        console2.printLn("FLIGHTS MATCHING YOUR CRITERIA:");
        console2.printLn(DASHES2);
        console2.printLn(String.format("| %-8s | %-10s | %-8s | %-15s | %-28s | %-5s |", "Serial No", "FlightID", "Time", "Destination", "Airline", "Seats"));
        console2.printLn(DASHES2);

        if(fc.displayFlightsBy(dest, airway, count)){

            //BOOKING PART
            console2.printLn("Enter Serial NO of flight you would like to book:");
            int serialNo = console2.readInt();

            String flight="";

            try{

                flight = bc.getFlightForBooking(serialNo, dest, airway, count);
                Booking book1=new Booking(passengersList,flight,pair);
                String flightId = flight.split("\\|")[1].trim();

                String firstname;
                String lastname;

                for (int i = 1; i <=count; i++) {
                    console2.readLn();
                    console2.printf("Passenger %d: ",i);

                    console2.print("Enter the firstname:");
                    firstname=console2.readLn();
                    console2.print("Enter the lastname:");
                    lastname=console2.readLn();
                    passengersList.add(new Passenger(firstname.toUpperCase(),lastname.toUpperCase()));
                }



                fc.decreaseSeats(flightId,count);

                bc.saveBooking(book1);
                bc.displayBookingsbyPair(pair);
                passengersList.clear();

            }

            catch (NullPointerException ex){
                console2.printLn("No flight with such serial number exists!!!");
            }


        }

    }

    @Override
    public boolean isExit() {
        return false;
    }



}
