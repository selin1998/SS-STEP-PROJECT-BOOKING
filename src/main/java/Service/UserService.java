package Service;

import DAO.DAO_U;
import DAO.Pair;
import DAO.User;
import DAO.UserDAO;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    DAO_U<User> daoUser;

    public UserService(String filename) {

        daoUser = new UserDAO(filename);
    }


    public List<String> getAllUsers() {
        return daoUser.getAll().stream().map(b -> b.toString()).collect(Collectors.toList());
    }


    public User getUserbyPair(Pair pair) {

        return daoUser.get(pair).get();
    }

    public boolean userExists(Pair pair) {
        return daoUser.get(pair).isPresent() ? true : false;
    }

    public void cancelUser(Pair pair) {
        daoUser.delete(pair);
    }

    public void clearAll(){
        daoUser.deleteAll();
    }

    public void saveUser(User user) {
        daoUser.save(user);
    }

}
