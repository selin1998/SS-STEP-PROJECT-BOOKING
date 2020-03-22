package dao;

import entity.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionBookingDAO implements BookingDAO<Booking> {
    private File file;
    private List<Booking> bookingsList = new ArrayList();

    public CollectionBookingDAO(String filename) {
        file = new File(filename);

    }

    @Override
    public Optional<Booking> get(int id) {
        return getAll().stream().filter(x->x.idBooking==id).findAny();
    }



    @Override
    public List<Booking> getAll() {
        return this.bookingsList;

    }

    public void read(){
        try {
            List<Booking> listLoaded = null;
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            listLoaded= (ArrayList<Booking>) readed;
            ois.close();
            is.close();
            listLoaded.forEach(this::save);


        } catch (IOException | ClassNotFoundException e) {

        }

    }

    @Override
    public void delete(int id) {
        bookingsList = getAll().stream().filter(b -> !(b.idBooking == id)).collect(Collectors.toList());
      //  write(listBookings);
    }

    @Override
    public void deleteAll() {

        bookingsList.clear();
    }

    @Override
    public void save(Booking booking) {
        if(booking!=null){
            if (bookingsList.contains(booking)) {

                bookingsList.set(bookingsList.indexOf(booking), booking);

            } else {

                bookingsList.add(booking);

            }
        }

    }




    public void write() {
        try {
            FileOutputStream outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(bookingsList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }
    }



}
