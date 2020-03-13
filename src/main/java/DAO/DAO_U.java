package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO_U<T> {


    Optional<T> get(Pair pair);
    List<T> getAll();
    void save(T t);
    void delete (Pair pair);
}
