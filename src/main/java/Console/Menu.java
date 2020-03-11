package Console;

public class Menu {
    
   public StringBuilder menu= new StringBuilder();
    final String DASHES = new String(new char[30]).replace("\0", "-");
    public void printMenu(){
        menu.append(DASHES);
        menu.append("\nFLIGHT BOOKING APPLICATION\n");
        menu.append(DASHES);
        menu.append("\n1. Online table.\n");               //CmdShow
        menu.append("2. Flight information.\n");         //CmdFlightInfo
        menu.append("3. Flights search and booking.\n"); //CmdBookAdd
        menu.append("4. Booking cancelling.\n");         //CmdBookCancel
        menu.append("5. My flights.\n");                 //CmdFlightsMy
        menu.append("6. Close session.\n");              //CmdCloseSession
        menu.append("7. Exit.\n");                       //CmdExit


        System.out.println(menu);
    }







    
}
