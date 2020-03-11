package Console;

import java.util.Scanner;

public class InputReader {
    private final Scanner in = new Scanner(System.in);

    public void print(String s){
        System.out.print(s);
    }

    public String readLn() {
        return in.nextLine();
    }

    public String input(String s) {
        print(s);
        return readLn();
    }

    public boolean validateYesOrNo(String input) {
        if (input.length() != 1) return false;
        return input.chars().anyMatch(c -> c == 'Y' || c == 'N');
    }





    public boolean getYesOrNo() {
        String input = "";

        do {
            input = input("Would you like to make a booking(s) now? Y/N: ").trim().toUpperCase();
        } while(!validateYesOrNo(input));

        return input.equals("Y");
    }
}
