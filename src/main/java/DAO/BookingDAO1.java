package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookingDAO1 implements DAO_B<Booking> {
    private File file;
    List<Booking> bookings = new ArrayList<>();

    public BookingDAO1(String filename) {
        file = new File(filename);
    }

    @Override
    public Optional<Booking> get(int id) {
        return getAll().stream().filter(x->x.idBooking==id).findAny();
    }

    @Override
    public List<Booking> getAll() {
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            ArrayList<Booking> data = (ArrayList<Booking>) readed;
            ois.close();
            is.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Booking>();
        }
    }

    @Override
    public boolean delete(int id) {
        if (!get(id).isPresent()) return false;
        bookings.removeIf(b -> id == b.idBooking);
        List<Booking> data=bookings;
        write(data);
        return true;
//        List<Booking> data = getAll().stream().filter(f -> ! f.equals(id)).collect(Collectors.toList());
    }

    @Override
    public void save(Booking booking) {
        List<Booking> data = getAll();
        data.add(booking);
        write(data);
    }

    @Override
    public List<Booking> getAllBy(Predicate<Booking> p) {
        List<Booking> data=new ArrayList<Booking>();
        for (Booking booking : getAll()) {
            if(p.test(booking)){
                data.add(booking);
            }
        }
        return data;
    }

    private void write(List<Booking> data) {
        try {
            FileOutputStream outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }
    }

    public boolean create(Booking booking) {
        if (booking == null) return false;
        if (bookings.contains(booking)) {
            return false;
        } else {
            bookings.add(booking);
            return true;
        }
    }
}
