//package DAO;
//
//import java.io.*;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class PassengerDAO implements DAO<Passenger> {
//
//
//    String filename;
//    @Override
//    public Passenger get(int index) {
//        return getAll().get(index);
//
//    }
//
//    @Override
//    public List<Passenger> getAll() {
//        try {
//            return new BufferedReader(new FileReader(new File(filename))).lines()
//                    .map(s -> Passenger.parse(s))
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new RuntimeException("No passengers were found");
//        }
//    }
//
//    @Override
//    public void save(Passenger passenger) {
//
//    }
//
//
//
//
//
//    @Override
//    public void delete(Passenger passenger) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
//            getAll().stream()
//                    .filter(f -> !f.equals(passenger))
//                    .forEach(f -> {
//                        try {
//                            bw.write(f.displayPassengerInfo());
//                            bw.write("\n");
//                        } catch (IOException e) {
//                            throw new RuntimeException("smth went wrong during passenger creation");
//                        }
//                    });
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException("smth went wrong during passenger creation");
//        }
//    }
//
//    @Override
//    public void delete(String index) {
//
//    }
//
//    @Override
//    public void saveData(String filePath) {
//
//    }
//
//    @Override
//    public List<Passenger> readData(String filePath) {
//        return null;
//    }
//
//
//}
