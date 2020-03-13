package DAO;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO_B<T> {

    Optional<T> get(int index);
    List<T> getAll();
    void save(T t);
    void delete (int index);

}
