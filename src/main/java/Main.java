import console.*;
import controller.BookingController;
import controller.FlightController;
import dao.CollectionFlightDAO;
import dao.FlightDAO;
import entity.Booking;
import entity.Flight;
import entity.UserCredential;
import service.FlightService;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       ConsoleApp app= new ConsoleApp();
       app.start();


    }

}
