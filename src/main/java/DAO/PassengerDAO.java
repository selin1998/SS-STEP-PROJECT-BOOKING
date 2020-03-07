package DAO;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PassengerDAO implements DAO<Passenger> {
    String filename;
    @Override
    public Optional<Passenger> get(int index) {
        return getAll().stream().filter(f->f.pass_ID==index).findFirst();
    }

    @Override
    public List<Passenger> getAll() {
        try {
            return new BufferedReader(new FileReader(new File(filename))).lines()
                    .map(s -> Passenger.parse(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("No passengers were found");
        }
    }

    @Override
    public void delete(int index) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
            getAll().stream()
                    .filter(f -> f.pass_ID != index)
                    .forEach(f -> {
                        try {
                            bw.write(f.displayPassengerInfo());
                            bw.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException("smth went wrong during passenger creation");
                        }
                    });
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during passenger creation");
        }
    }

    @Override
    public void loadData(Passenger passenger) {

    }

    @Override
    public void readData(Passenger passenger) {

    }

    @Override
    public void saveData(Passenger passenger) {

    }

    @Override
    public void delete(Passenger passenger) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
            getAll().stream()
                    .filter(f -> !f.equals(passenger))
                    .forEach(f -> {
                        try {
                            bw.write(f.displayPassengerInfo());
                            bw.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException("smth went wrong during passenger creation");
                        }
                    });
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during passenger creation");
        }
    }

    @Override
    public void create(Passenger passenger) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), true));
            bw.write(passenger.displayPassengerInfo());
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during passenger creation");
        }
    }
}
