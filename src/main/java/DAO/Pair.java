package DAO;

import java.io.Serializable;
import java.util.Objects;

public class Pair implements Serializable {

  public  String userName;
  public  String password;

    public Pair(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public String toString() {
       return userName.concat(" ").concat(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return userName.equals(pair.userName) &&
                password.equals(pair.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }



}
