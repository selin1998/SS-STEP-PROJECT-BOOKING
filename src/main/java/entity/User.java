package entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    public UserCredential credential;
    public String name;
    public String lastName;


    public User(UserCredential userCredential, String name, String lastName) {
        this.credential = userCredential;
        this.name = name;
        this.lastName = lastName;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return credential.equals(user.credential);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credential);
    }

    public static User parse(String text) {
        String[] content = text.split("|");
        return new User(
                new UserCredential(content[0], content[1]),
                content[2],
                content[3]

        );
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-10s | %-15s |", credential.userName, credential.password, name, lastName);
    }
}
