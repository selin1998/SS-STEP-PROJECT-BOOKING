package Console;

public class Menu {
    
   public static StringBuilder menu= new StringBuilder();
    final static String DASHES = new String(new char[30]).replace("\0", "-");
   static {
        generateMenu();
    }

    public static void generateMenu(){
        menu.append(DASHES);
        menu.append("\nFLIGHT BOOKING APPLICATION\n");
        menu.append(DASHES);
        menu.append("\n1. Online table.\n");
        menu.append("2. Flight information.\n");
        menu.append("3. Flights search and booking.\n");
        menu.append("4. Booking cancelling.\n");
        menu.append("5. My flights.\n");
        menu.append("6. Close session.\n");
        menu.append("7. Exit.\n");
    }

    public void printMenu(){



        System.out.println(menu);

    }







    
}
