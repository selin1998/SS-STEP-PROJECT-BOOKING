package DAO;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface DAO_B<T> {

    Optional<T> get(int index);
    List<T> getAll();
    boolean create(T t);
    boolean deleteByID (int index);

}
