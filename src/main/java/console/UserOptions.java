package console;

import java.util.ArrayList;
import java.util.List;

public class UserOptions {

    public static List<UserOption> all() {
        return new ArrayList<UserOption>() {{

            add(new OptRegister());
            add(new OptLogin());
            add(new OptOnlineBoard());
            add(new OptFlightInfo());
            add(new OptExit());


        }};
    }
}
