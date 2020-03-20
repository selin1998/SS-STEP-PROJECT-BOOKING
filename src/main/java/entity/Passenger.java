package entity;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {
    public String name;
    public String lastname;


    public Passenger(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public static Passenger parse(String text) {
        String[] content = text.split("|");
        return new Passenger(
                content[1],
                content[2]
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return name.equals(passenger.name) &&
                lastname.equals(passenger.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }

    public String toString() {
        return String.format("Passenger: %-5s %-5s", name, lastname);

    }
}
