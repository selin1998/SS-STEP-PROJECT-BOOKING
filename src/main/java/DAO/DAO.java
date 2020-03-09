package DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(String index);
    Optional<T> get(T t);
    List<T> getAll();
    void create(T t);
    void delete (T t);
    void delete (String index);





}
