package dao;

import entity.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionFlightDAO implements FlightDAO<Flight> {

    private File file;
    private List<Flight> flightsList=new ArrayList();

    public CollectionFlightDAO(String filename) {
        file = new File(filename);

    }


    public Optional<Flight> get(String id) {
        return getAll().stream().filter(x->x.flightId.equalsIgnoreCase(id)).findAny();

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
    }

    @Override
    public List<Flight> getAll() {

        return this.flightsList;
    }


    public void read(){
        try {
            List<Flight> listLoaded = null;
            FileInputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            listLoaded= (ArrayList<Flight>) readed;
            ois.close();
            is.close();
            listLoaded.forEach(this::save);


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Class not found!");

        }

    }

    @Override
    public void delete(String id) {
        flightsList = getAll().stream().filter(f -> !f.flightId.equalsIgnoreCase(id)).collect(Collectors.toList());
     //   write(data);
    }

    @Override
    public void deleteAll(){

        flightsList.clear();
    }

    @Override
    public void save(Flight flight) {

        if(flight!=null){
            if (flightsList.contains(flight)) {

                flightsList.set(flightsList.indexOf(flight), flight);

            } else {

                flightsList.add(flight);

            }
        }

    }

    public void write() {
        try {

            FileOutputStream outputStream=new FileOutputStream(file);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(flightsList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }

    }
}
