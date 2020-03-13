package Console;

import DAO.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Options {


    public static List<Option> all() {
        return new ArrayList<Option>() {{
            add(new OptOnlineBoard());
            add(new OptFlightInfo());
            add(new OptBookFlight());
            add(new OptCancelBooking());
            add(new OptCloseSession());
            add(new OptMyFlights());
            add(new OptExit());

        }};
    }
}
