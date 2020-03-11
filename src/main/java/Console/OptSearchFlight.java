//package Console;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class OptSearchFlight implements Option {
//    final String DASHES2 = new String(new char[93]).replace("\0", "-");
//    @Override
//    public int optNumber() {
//        return 3;
//    }
//
//    @Override
//    public String text() {
//        return "SEARCH FOR FLIGHTS";
//    }
//
//    @Override
//    public void execution() {
//        System.out.println("Enter destination, airline and number of passengers to search for matching flights: ");
//        System.out.println("Destination:");
//       String dest= sc.nextLine();
//        System.out.println("Airline:");
//       String airway= sc.nextLine();
//        System.out.println("Number of passengers:");
//       int count= sc.nextInt();
//        System.out.println("FLIGHTS MATCHING YOUR CRITERIA:");
//        System.out.println(DASHES2);
//        System.out.println(String.format("| %-8s | %-10s | %-8s | %-15s | %-28s | %-5s |","Serial No", "FlightID", "Date", "Destination", "Airline", "Seats"));
//        System.out.println(DASHES2);
//        fc.displayFlightsBy(dest,airway,count);
//
//    }
//
//    @Override
//    public boolean isExit() {
//        return false;
//    }
//}
