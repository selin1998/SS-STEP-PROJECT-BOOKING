package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookingDAO implements DAO_B<Booking> {
    File fileBooking;

    public BookingDAO(String filename) {
        this.fileBooking = new File(filename);
    }

    List<Booking> bookings = new ArrayList<>();
    List<Flight> flights=new ArrayList<>();


    @Override
    public Optional<Booking> get(int bookingID) {
        return bookings.stream().filter(x -> x.idBooking == bookingID).findAny();
    }

    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    public List<Booking> getBookingsbyUser(String username){
        return getAll().stream().filter(b->b.username.equals(username)).collect(Collectors.toList());
    }

    @Override
    public boolean create(Booking booking) {
        if (booking == null) return false;
        if (bookings.contains(booking)) {
            return false;
        } else {
            bookings.add(booking);
            return true;
        }
    }

    @Override
    public boolean deleteByID(int bookingID) {
        if (!get(bookingID).isPresent()) return false;
        return bookings.removeIf(b -> bookingID == b.idBooking);
    }

    public void loadBookingsFromFile() {
        if (fileBooking.exists()) {
            loadData(bookings, fileBooking);
        }
    }

    public void saveBookingstoFile(){
        saveData(bookings,fileBooking);
    }


    public void loadData(List<Booking> bookingList, File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List list = (List) ois.readObject();
            bookingList.addAll(list);
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found there");
        } catch (IOException e) {
            throw new IllegalArgumentException("Something wrong with stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Something gone wrong");
        }

    }


    public void saveData(List<Booking> bookingList, File file) {
        try {
            file.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookingList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found there");
        } catch (IOException e) {
            throw new IllegalArgumentException("Something wrong with stream");
        }
    }



}
