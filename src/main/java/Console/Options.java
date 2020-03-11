package Console;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Options {
    public static List<Option> all() {
        return new ArrayList<Option>() {{
            add(new OptOnlineBoard());
            add(new OptFlightInfo());
           // add(new OptSearchFlight());
            add(new OptBookFlight());
            add(new OptCancelBooking());
            add(new OptCloseSession());
            add(new OptLogin());
            add(new OptRegister());
            add(new OptMyFlights());
            add(new OptExit());

        }};
    }
}
