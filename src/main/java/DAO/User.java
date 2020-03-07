package DAO;

import java.util.Objects;

public class User {


    String username;
    String password;
    String name;
    String lastName;
    int userId;


    public User(int userId,String username, String password, String name, String lastName) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.userId=userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public String displayUserInfo(){
        return String.format("| %-8s |%-12s |%-15s |%-10s |", username,name,lastName,password);

    }

    public static User parse(String text) {
        String[] content = text.split("|");
        return new User(
                Integer.parseInt(content[0]),
                content[1],
                content[2],
                content[3],
                content[4]

        );
    }


}
