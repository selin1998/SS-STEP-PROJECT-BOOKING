package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(int index);
    List<T> getAll();
    void create(T t);
    void delete (T t);
    void delete (int index);
    void saveData(T t);
    void readData(T t);
    void loadData(T t);




}
