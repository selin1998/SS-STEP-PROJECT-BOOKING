package DAO;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDAO implements DAO<Flight> {
    String filename="./INFO/flight.txt";
    @Override
    public Optional<Flight> get(String id) {
        return getAll().stream().filter(f->f.flightId.equals(id)).findFirst();
    }

    @Override
    public Optional<Flight> get(Flight flight) {
        return getAll().stream().filter(f->f.equals(flight)).findAny();
    }

    @Override
    public List<Flight> getAll() {
        try {
            return new BufferedReader(new FileReader(new File(filename))).lines()
                    .map(s -> Flight.parse(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("No flights were found");
        }
    }

    @Override
    public void delete(String index) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
            getAll().stream()
                    .filter(f -> f.flightId.equals(index))
                    .forEach(f -> {
                        try {
                            bw.write(f.displayFlightInfo());
                            bw.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException("smth went wrong during flight creation");
                        }
                    });
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during flight creation");
        }
    }



    @Override
    public void delete(Flight flight) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
            getAll().stream()
                    .filter(f -> !f.equals(flight))
                    .forEach(f -> {
                        try {
                            bw.write(f.displayFlightInfo());
                            bw.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException("smth went wrong during flight creation");
                        }
                    });
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during flight creation");
        }

    }

    @Override
    public void create(Flight flight) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), true));
            bw.write(flight.displayFlightInfo());
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("smth went wrong during flight creation");
        }
    }
}
