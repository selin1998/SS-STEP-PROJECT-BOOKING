//package DAO;
//
//import java.io.*;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class UserDAO implements DAO<User> {
//    String filename;
//    @Override
//    public Optional<User> get(int index) {
//        return getAll().stream().filter(f->f.userId==index).findFirst();
//    }
//
//    @Override
//    public List<User> getAll() {
//        try {
//            return new BufferedReader(new FileReader(new File(filename))).lines()
//                    .map(s -> User.parse(s))
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new RuntimeException("No users were found");
//        }
//    }
//
//
//    @Override
//    public void delete(int index) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
//            getAll().stream()
//                    .filter(f -> f.userId != index)
//                    .forEach(f -> {
//                        try {
//                            bw.write(f.displayUserInfo());
//                            bw.write("\n");
//                        } catch (IOException e) {
//                            throw new RuntimeException("smth went wrong during user creation");
//                        }
//                    });
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException("smth went wrong during user creation");
//        }
//    }
//
//    @Override
//    public void loadData(User user) {
//
//    }
//
//    @Override
//    public void readData(User user) {
//
//    }
//
//    @Override
//    public void saveData(User user) {
//
//    }
//
//    @Override
//    public void delete(User user) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
//            getAll().stream()
//                    .filter(f -> !f.equals(user))
//                    .forEach(f -> {
//                        try {
//                            bw.write(f.displayUserInfo());
//                            bw.write("\n");
//                        } catch (IOException e) {
//                            throw new RuntimeException("smth went wrong during user creation");
//                        }
//                    });
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException("smth went wrong during user creation");
//        }
//    }
//
//    @Override
//    public void create(User user) {
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), true));
//            bw.write(user.displayUserInfo());
//            bw.write("\n");
//            bw.close();
//        } catch (IOException e) {
//            throw new RuntimeException("smth went wrong during user creation");
//        }
//    }
//}
