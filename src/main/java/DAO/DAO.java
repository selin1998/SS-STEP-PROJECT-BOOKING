package DAO;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
    Optional<T> get(int index);
    Optional<T> get(String s);
    List<T> getAllBy(Predicate<T> p);
    List<T> getAll();
    void save(T t);
    void delete (String id);
    void deleteAll();
}
