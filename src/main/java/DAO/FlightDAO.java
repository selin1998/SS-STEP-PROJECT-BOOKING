package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {

    private File file;

    public FlightDAO(String filename) {
        file = new File(filename);
    }


    public Optional<Flight> get(String id) {
        return getAll().stream().filter(x->x.flightId.equals(id)).findAny();
    }

    @Override
    public Optional<Flight> get(int index) {
        return get(index);
    }

    @Override
    public List<Flight> getAllBy(Predicate<Flight> p) {
        List<Flight> data=new ArrayList<Flight>();
        for (Flight flight : getAll()) {
            if(p.test(flight)){
                data.add(flight);
            }
        }
        return data;
      //  return getAll().stream().filter(p.test(getAll())).collect(Collectors.toList());
    }

    @Override
    public List<Flight> getAll() {
        try {
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            ArrayList<Flight> data = (ArrayList<Flight>) readed;
            ois.close();
            is.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<Flight>();
        }
    }

    @Override
    public void delete(Flight flight) {
        List<Flight> data = getAll().stream().filter(f -> ! f.equals(flight)).collect(Collectors.toList());
        write(data);
    }

    @Override
    public void save(Flight flight) {
        List<Flight> data = getAll();
        data.add(flight);
        write(data);
    }

    private void write(List<Flight> data) {
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
}
