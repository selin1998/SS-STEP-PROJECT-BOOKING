import Console.*;
import Controller.BookingController;
import Controller.FlightController;
import DAO.DAO;
import DAO.FlightDAO;
import DAO.Flight;
import Service.BookingService;
import Service.FlightService;
import DAO.Pair;
import DAO.Booking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


       ConsoleApp app= new ConsoleApp();
        app.start();


    }

}
