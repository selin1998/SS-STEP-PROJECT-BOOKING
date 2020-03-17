package Console;

import DAO.Pair;

public class OptExit implements UserOption, Option {

    public Pair pair;
    @Override
    public int optNumber() {
        return 7;
    }

    @Override
    public String text() {
        return "EXIT";
    }

    @Override
    public void execution(Pair pair) {
        console.printLn("Bye!");
        this.pair=pair;

    }


    @Override
    public int userOptNumber() {
        return 5;
    }



    @Override
    public void operation() {

        execution( pair);


    }

    @Override
    public boolean isExitUser() {
        return true;
    }


    @Override
    public boolean isExit() {
        return true;
    }
}
