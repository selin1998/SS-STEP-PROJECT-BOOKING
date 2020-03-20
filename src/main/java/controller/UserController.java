package controller;

import entity.UserCredential;
import entity.User;
import service.UserService;

public class UserController {

    UserService service;

    public UserController(String filename) {

        service = new UserService(filename);
    }


    public void displayAllUsers() {
        service.getAllUsers().stream().forEach(x -> System.out.println(x));
    }

    public User getUserbyPair(UserCredential userCredential){
        return service.getUserbyPair(userCredential);
    }

    public  boolean userExists(UserCredential userCredential){
        return service.userExists(userCredential);
    }

    public void cancelUser(UserCredential userCredential) {
        service.cancelUser(userCredential);
    }

    public void saveUser(User user) {
        service.saveUser(user);
    }

}
