package Controller;

import DAO.Pair;
import DAO.User;
import Service.UserService;

public class UserController {

    UserService service;

    public UserController(String filename) {

        service = new UserService(filename);
    }


    public void displayAllUsers() {
        service.getAllUsers().stream().forEach(x -> System.out.println(x));
    }

    public User getUserbyPair(Pair pair){
        return service.getUserbyPair(pair);
    }

    public  boolean userExists(Pair pair){
        return service.userExists(pair);
    }

    public void cancelUser(Pair pair) {
        service.cancelUser(pair);
    }

    public void saveUser(User user) {
        service.saveUser(user);
    }

}
