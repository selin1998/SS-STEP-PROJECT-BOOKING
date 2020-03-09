package DAO;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(int index);
    List<T> getAll();
    boolean create(T t);
    boolean delete (T t);
    boolean deleteByID (int index);
    void saveData(T t,File file);
    void readData(T t, File file);
    void loadData(T t,File file);




}
