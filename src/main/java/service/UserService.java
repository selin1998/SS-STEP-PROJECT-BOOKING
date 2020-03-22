package service;

import dao.UserDAO;
import entity.UserCredential;
import entity.User;
import dao.CollectionUserDAO;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    UserDAO<User> daoUser;

    public UserService(String filename) {

        daoUser = new CollectionUserDAO(filename);
    }


    public List<String> getAllUsers() {
        return daoUser.getAll().stream().map(b -> b.toString()).collect(Collectors.toList());
    }


    public User getUserbyPair(UserCredential userCredential) {

        return daoUser.get(userCredential).get();
    }

    public boolean userExists(UserCredential userCredential) {
        return daoUser.get(userCredential).isPresent() ? true : false;
    }

    public void cancelUser(UserCredential userCredential) {
        daoUser.delete(userCredential);
    }

    public void clearAll(){
        daoUser.deleteAll();
    }

    public void saveUser(User user) {
        daoUser.save(user);
    }

    public void read(){
        daoUser.read();
    }
    public void write(){
        daoUser.write();
    }

}
