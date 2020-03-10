package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {
    ArrayList<Flight> flightList=new ArrayList<Flight>();



    @Override
    public Flight get(int id) {
        return flightList.get(id);
    }


    @Override
    public List<Flight> getAll() {
       return flightList;
    }

    @Override
    public void delete(String index) {
        try {
            flightList.remove(index);

        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Entered index is out of list length");
        }
    }

    @Override
    public void delete(Flight flight) {
        flightList.remove(flight);

    }


    @Override
    public void save(Flight flight) {
        if (flightList.contains(flight)){
            flightList.set(flightList.indexOf(flight),flight);

        }
        else {
            flightList.add(flight);
        }
        saveData();
    }

    @Override
    public void saveData() {

            try {
                FileOutputStream outputStream=new FileOutputStream("./INFO/flight.bin");
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(flightList);
                objectOutputStream.close();
                outputStream.close();
            }

        catch (Exception ex){
            System.out.println("File not found!");
        }

    }


    @Override
    public ArrayList<Flight> readData() {
        ArrayList<Flight> listLoaded=null ;
        try {
            File file = new File("./INFO/flight.bin");
            FileInputStream inputStream=new FileInputStream( file);
            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
            listLoaded = (ArrayList<Flight>)objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();

        }
        catch (FileNotFoundException ex){
            System.out.println("File not found! filepath wrong");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listLoaded;
    }



}
