package dao;

import entity.UserCredential;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUserFlightDAOTest {
    private UserDAO<User> userDao=new CollectionUserDAO("./INFO/TestUser.bin");
     User user1;
     User user2;
     User user3;
     UserCredential userCredential1;
    UserCredential userCredential2;
    UserCredential userCredential3;


    @BeforeEach
     void setUp(){
        userDao.deleteAll();

         userCredential1 =new UserCredential("a1","a1");
         user1=new User(userCredential1,"Anna","Karenina");
         userCredential2 =new UserCredential("b1","b1");
         user2=new User(userCredential2,"Leo","Matilda");
         userCredential3 =new UserCredential("c1","c1");
         user3=new User(userCredential3,"Sherlock","Holmes");
         userDao.save(user1);
         userDao.save(user2);
         userDao.save(user3);

     }

    @Test
    void getAll() {
        int countUsers = userDao.getAll().size();
        assertEquals(3,countUsers);
    }

    @Test
    void get() {
        assertEquals("Leo",userDao.get(userCredential2).get().name);
    }


    @Test
    void delete() {
        userDao.delete(userCredential1);
        assertEquals(2,userDao.getAll().size());
    }

    @Test
    void save() {
        //before add user4
        assertEquals(3,userDao.getAll().size());

        User user4=new User(new UserCredential("d1","d1"),"Lily","Rose");
        userDao.save(user4);
        //after add user4
        assertEquals(4,userDao.getAll().size());
    }
}