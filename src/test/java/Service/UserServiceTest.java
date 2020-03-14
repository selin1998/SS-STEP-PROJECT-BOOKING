package Service;

import DAO.DAO_U;
import DAO.Pair;
import DAO.User;
import DAO.UserDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService = new UserService("./INFO/TestUser.bin");
    User user1;
    User user2;
    User user3;
    Pair pair1;
    Pair pair2;
    Pair pair3;


    @BeforeEach
    void setUp() {
        userService.clearAll();

        pair1 = new Pair("a1", "a1");
        user1 = new User(pair1, "Anna", "Karenina");
        pair2 = new Pair("b1", "b1");
        user2 = new User(pair2, "Leo", "Matilda");
        userService.saveUser(user1);
        userService.saveUser(user2);

    }

    @Test
    void getAllUsers() {
        List<String> allUsers = userService.getAllUsers();
        assertTrue(!allUsers.isEmpty());

    }

    @Test
    void userExists() {
        assertTrue(userService.userExists(pair1));
    }

    @Test
    void cancelUser() {
        userService.cancelUser(pair2);
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    void saveUser() {
        //before save user3
        assertEquals(2,userService.getAllUsers().size());

        pair3 = new Pair("c1", "c1");
        user3 = new User(pair3, "Sherlock", "Holmes");
        userService.saveUser(user3);
        //after save user3
        assertEquals(3,userService.getAllUsers().size());
    }
}