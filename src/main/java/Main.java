import Controller.BookingController;

public class Main {
    public static void main(String[] args) {
        BookingController controller=new BookingController();
        controller.readData();
        //controller.writeDataFile();
        controller.displayAllBookings();
    }

}
