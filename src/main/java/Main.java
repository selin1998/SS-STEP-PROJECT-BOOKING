import Console.Menu;
import Console.OptFlightInfo;
import Console.OptOnlineBoard;
import Console.OptSearchFlight;
import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;
import Service.FlightService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       FlightController fc= new FlightController();
       fc.displayFlightbyId("LH0100");
        System.out.println("--------");
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

        OptSearchFlight osf=new OptSearchFlight();
        osf.execution();

//     FlightDAO dao=new FlightDAO("./INFO/flight.bin");
//       System.out.println(dao.getAllBy(x -> x.destination.equals("Munich")));

    }

}
