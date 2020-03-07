package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDAO implements DAO<Booking> {
    String filename;

    @Override
    public Optional<Booking> get(int BookingId) {
        return getAll().stream().filter(x -> x.idBooking == BookingId).findFirst();
    }

    @Override
    public List<Booking> getAll() {
        try {
            return new BufferedReader(new FileReader(new File(filename))).lines()
                    .map(s -> Booking.parse(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("No bookings were found");
        }
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void loadData(Booking booking) {

    }

    @Override
    public void readData(Booking booking) {

    }

    @Override
    public void saveData(Booking booking) {

    }

    @Override
    public void delete(Booking booking) {

    }

    @Override
    public void create(Booking booking) {

    }
}
