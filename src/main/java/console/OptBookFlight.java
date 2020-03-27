package console;

import dao.CollectionBookingDAO;
import entity.Booking;
import entity.UserCredential;
import entity.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptBookFlight extends Storage implements Option  {


    final String DASHES2 = new String(new char[123]).replace("\0", "-");


    HashMap<Integer, String> data;
    List<Booking> bookingList = new ArrayList<>();
    Passenger passenger;
    List<Passenger> passengersList = new ArrayList<>();
    int counter;
    public OptBookFlight(Database storage) {
        super(storage);
    }

    @Override
    public int optNumber() {
        return 3;
    }

    @Override
    public String text() {
        return "SEARCH AND BOOK FOR FLIGHTS";
    }

    @Override
    public void execution(UserCredential userCredential) {

        //SEARCH PART

        console2.printLn("Press Enter in order to fill destination, airline and number of passengers and search for matching flights: ");
        console2.readLn();
        console2.printLn("Origin:");
        String origin = console2.readLn();
        console2.printLn("Destination:");
        String dest = console2.readLn();
        console2.printLn("Day of flight in dd/MM/yyyy format");
        String date = console2.readLn();
        console2.printLn("Number of passengers:");
        int count = console2.readInt();
        console2.readLn();
        console2.printLn("FLIGHTS MATCHING YOUR CRITERIA:");
        console2.printLn(DASHES2);
        console2.printLn(String.format("| %-7s | %-10s | %-16s | %-15s | %-15s | %-30s | %-5s |", "Ord No", "FlightID", "Date", "Origin", "Destination", "Airline", "Seats"));
        console2.printLn(DASHES2);

        if (storage.flights.displayFlightsBy(origin,dest,count)) {

            //BOOKING PART

            console2.printLn("Enter Flight Id of flight you would like to book:");
            String serialNo = console2.readLn();

            String flight = "";

            try {

                flight = storage.flights.getFlightbyId(serialNo);

                String flightId = flight.split("\\|")[1].trim();

                String firstname;
                String lastname;

                for (int i = 1; i <= count; i++) {

                    console2.printf("Passenger %d: ", i);

                    console2.print("Enter the firstname:");
                    firstname = console2.readLn();
                    console2.print("Enter the lastname:");
                    lastname = console2.readLn();
                    passengersList.add(new Passenger(firstname.toUpperCase(), lastname.toUpperCase()));
                }

                counter = storage.bookings.getAll().stream().map(b -> b.idBooking).max((id1, id2) -> id1 - id2).orElse(0);
                List <Passenger> lp=new ArrayList<>(passengersList);
                Booking book = new Booking(++counter,lp, flight, userCredential);
                storage.flights.decreaseSeats(flightId, count);
                storage.bookings.saveBooking(book);
                storage.bookings.displayBookingsbyPair(userCredential);
                passengersList.clear();

            } catch (NullPointerException ex) {
                console2.printLn("No flight with such Flight Id exists!!!");
            }


        }


        else if(storage.flights.displayConnectingFlightsBy(origin,dest,count)){
            console2.printLn("Enter Flight Id-s of flights you would like to book:");
            console2.print("First one:");
            String serialNo1 = console2.readLn();
            console2.print("Second one:");
            String serialNo2 = console2.readLn();

            String flight1 = "";
            String flight2 = "";

            try {

                flight1 = storage.flights.getFlightbyId(serialNo1);

                String flightId1 = flight1.split("\\|")[1].trim();



                flight2 = storage.flights.getFlightbyId(serialNo2);

                String flightId2 = flight2.split("\\|")[1].trim();


                String firstname;
                String lastname;

                for (int i = 1; i <= count; i++) {

                    console2.printf("Passenger %d: ", i);

                    console2.print("Enter the firstname:");
                    firstname = console2.readLn();
                    console2.print("Enter the lastname:");
                    lastname = console2.readLn();
                    passengersList.add(new Passenger(firstname.toUpperCase(), lastname.toUpperCase()));
                }

                counter = storage.bookings.getAll().stream().map(b -> b.idBooking).max((id1, id2) -> id1 - id2).orElse(0);
                List <Passenger> lp=new ArrayList<>(passengersList);

                Booking book = new Booking(++counter,lp, flight1, userCredential);
                storage.flights.decreaseSeats(flightId1, count);
                storage.bookings.saveBooking(book);


                Booking book2 = new Booking(counter,lp, flight2, userCredential);
                storage.flights.decreaseSeats(flightId2, count);
                storage.bookings.saveBooking(book2);


                storage.bookings.displayBookingsbyPair(userCredential);
                passengersList.clear();

            } catch (NullPointerException ex) {
                console2.printLn("No flight with such Flight Id exists!!!");
            }

        }

    }

    @Override
    public boolean isExit() {
        return false;
    }


}
