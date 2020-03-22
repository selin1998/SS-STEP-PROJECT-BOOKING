package console;

import java.util.ArrayList;
import java.util.List;

public class Options {


    public static List<Option> all(Database db) {
        return new ArrayList<Option>() {{
            add(new OptOnlineBoard(db));
            add(new OptFlightInfo(db));
            add(new OptBookFlight(db));
            add(new OptCancelBooking(db));
            add(new OptCloseSession(db));
            add(new OptMyFlights(db));
            add(new OptExit(db));

        }};
    }
}
