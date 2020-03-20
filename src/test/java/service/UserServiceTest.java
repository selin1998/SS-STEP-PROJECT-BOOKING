package service;

import entity.UserCredential;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService = new UserService("./INFO/TestUser.bin");
    User user1;
    User user2;
    User user3;
    UserCredential userCredential1;
    UserCredential userCredential2;
    UserCredential userCredential3;


    @BeforeEach
    void setUp() {
        userService.clearAll();

        userCredential1 = new UserCredential("a1", "a1");
        user1 = new User(userCredential1, "Anna", "Karenina");
        userCredential2 = new UserCredential("b1", "b1");
        user2 = new User(userCredential2, "Leo", "Matilda");
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
        assertTrue(userService.userExists(userCredential1));
    }

    @Test
    void cancelUser() {
        userService.cancelUser(userCredential2);
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    void saveUser() {
        //before save user3
        assertEquals(2,userService.getAllUsers().size());

        userCredential3 = new UserCredential("c1", "c1");
        user3 = new User(userCredential3, "Sherlock", "Holmes");
        userService.saveUser(user3);
        //after save user3
        assertEquals(3,userService.getAllUsers().size());
    }
}