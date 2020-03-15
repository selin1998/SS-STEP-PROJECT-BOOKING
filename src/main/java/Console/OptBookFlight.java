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
        Scanner sc=new Scanner(System.in);
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
        System.out.println("Enter Serial NO of flight you would like to book :");
        int serialNo = sc.nextInt();

            String flight="";

            try{

                flight = bc.getFlightForBooking(serialNo, dest, airway, count);
                Booking book1=new Booking(passengersList,flight,pair);
                String flightId = flight.split("\\|")[1].trim();

                String firstname;
                String lastname;
                Scanner scanner=new Scanner(System.in);

                for (int i = 1; i <=count; i++) {
                    System.out.printf("Passenger %d:\n",i);
                    System.out.println("Enter the firstname:");
                    firstname=scanner.nextLine();
                    System.out.println("Enter the lastname:");
                    lastname=scanner.nextLine();
                    passengersList.add(new Passenger(firstname,lastname));
                }



                fc.decreaseSeats(flightId,count);

                bc.saveBooking(book1);
                bc.displayBookingsbyPair(pair);
                passengersList.clear();

            }

            catch (NullPointerException ex){
                System.out.println("No flight with such serial number exists!!!");
            }




    }

    @Override
    public boolean isExit() {
        return false;
    }



}
