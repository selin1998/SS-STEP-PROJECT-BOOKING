package entity;

import java.io.Serializable;
import java.util.Objects;

public class UserCredential implements Serializable {

  public  String userName;
  public  String password;

    public UserCredential(String userName, String password) {
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
        UserCredential userCredential = (UserCredential) o;
        return userName.equals(userCredential.userName) &&
                password.equals(userCredential.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }



}
