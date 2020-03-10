package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(int index);
    List<T> getAll();
    void save(T t);
    void delete (T t);
    void delete (String index);
    void saveData();
    List<T> readData( );





}
