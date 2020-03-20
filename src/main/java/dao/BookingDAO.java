package dao;

import java.util.List;
import java.util.Optional;

public interface BookingDAO<T> {

    Optional<T> get(int index);
    List<T> getAll();
    void save(T t);
    void delete (int index);
    void deleteAll();


}
