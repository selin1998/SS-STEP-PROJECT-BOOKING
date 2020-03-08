package DAO;

public class Passenger {
    private static int counter = 1;

    int id;
    String firstName;
    String lastName;

    public Passenger(String firstName, String lastName) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Passenger(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String displayPassengerInfo() {
        return String.format("Passenger %d: %s %s", id, firstName.toUpperCase(), lastName.toUpperCase());
    }

}
