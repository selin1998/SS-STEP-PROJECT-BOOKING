import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FlightController fc= new FlightController();
        fc.displayAllFlights();
        System.out.println("-------------");
        fc.displaySearchedFlight("Lisbon","Azul");
        System.out.println("-------------");
        fc.displayFlightbyId(5);
//        DAO <Flight> dao=new FlightDAO("./INFO/flight.bin");
//        System.out.println(dao.getAll());


    }

}
