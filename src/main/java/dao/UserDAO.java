package dao;

import entity.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserDAO<T> {

    Optional<T> get(UserCredential userCredential);
    List<T> getAll();
    void save(T t);
    void delete (UserCredential userCredential);
    void deleteAll();
    void read();
    void write();
}
