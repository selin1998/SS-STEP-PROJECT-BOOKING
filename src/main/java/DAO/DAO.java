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
    void saveData(List<T> t,File file);
    void readData(List<T> t, File file);
    void loadData(List<T> t,File file);




}
