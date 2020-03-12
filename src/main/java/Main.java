import Console.*;
import Controller.BookingController;
import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;
import Service.BookingService;
import Service.FlightService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
 //      FlightController fc= new FlightController("./INFO/flight.bin");
//       FlightService service= new FlightService("./INFO/flight.bin");
   //   BookingController bc1=new BookingController("./INFO/booking.bin");

    //  bc1.displayAllBookings();



//        BookingService serviceBooking=new BookingService(".INFO/booking.bin");
//        System.out.println(service.availableSeatsFlight("LH8296"));

        //   fc.displayFlightbyId("LH0100");
      //  fc.displayFlightsBy("Berlin","Lufthansa",5);
       // fc.displayFlightbyId("LH8296");
//        service.decreaseAvailableSeats("SK3616",5);
//
//        fc.displayAllFlights();
//        System.out.println();
//        fc.displayFlightbyId("SK3616");
    //    System.out.println(service.countFlights());
//       HashMap<Integer,String> map= fc.getFlightsBymap("Berlin","Lufthansa",5);
//        System.out.println(map.get(3).split("\\|")[1]);

//        System.out.println("--------");
////       OptOnlineBoard o= new OptOnlineBoard();
////       o.execution();
//        OptFlightInfo of= new OptFlightInfo();
//        of.execution();
   //     Menu m=new Menu();
     //   m.printMenu();
  //      fc.displayAllFlights();
    //   FlightService s= new FlightService();
   //     fc.displayFlightsBy("Munich", "Lufthansa", 90);
//        System.out.println("-------------");
//        System.out.println(fc.displaySearchedFlight("Tunis", "Lufthansa","3"));
//        System.out.println("-------------");
//        fc.displayFlightbyId(5);
////        DAO <Flight> dao=new FlightDAO("./INFO/flight.bin");
////        System.out.println(dao.getAll());
//        System.out.println("-------------");
//        fc.displayFlightsBy("Moscow","Aeroflot");

//        OptOnlineBoard o=new OptOnlineBoard();
//        o.execution();

//        OptBookFlight obf=new OptBookFlight();
//        obf.execution();

       ConsoleApp app= new ConsoleApp();
        app.start();

//
//      BookingService bs=new BookingService("./INFO/booking.bin");
//    //   System.out.println(bs.getAllBookings());
//        System.out.println(bs.getBookingByID(2));


//     FlightDAO dao=new FlightDAO("./INFO/flight.bin");
//       System.out.println(dao.getAllBy(x -> x.destination.equals("Munich")));

    }

}
