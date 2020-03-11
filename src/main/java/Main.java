import Console.*;
import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;
import Service.FlightService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       FlightController fc= new FlightController("./INFO/flight.bin");
    //   fc.displayFlightbyId("LH0100");
    //    fc.displayFlightsBy("Berlin","Lufthansa",5);
       HashMap<Integer,String> map= fc.getFlightsBymap("Berlin","Lufthansa",5);
        System.out.println(map.get(3).split("\\|")[1]);

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

//        OptSearchFlight osf=new OptSearchFlight();
//        osf.execution();

//        ConsoleApp app= new ConsoleApp();
//        app.start();

//     FlightDAO dao=new FlightDAO("./INFO/flight.bin");
//       System.out.println(dao.getAllBy(x -> x.destination.equals("Munich")));

    }

}
