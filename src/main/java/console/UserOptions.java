package console;

import java.util.ArrayList;
import java.util.List;

public class UserOptions {

    public static List<UserOption> all(Database db) {
        return new ArrayList<UserOption>() {{

            add(new OptRegister(db));
            add(new OptLogin(db));
            add(new OptOnlineBoard(db));
            add(new OptFlightInfo(db));
            add(new OptExit(db));


        }};
    }
}
