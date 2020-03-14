package DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private DAO_U<User> userDao=new UserDAO("./INFO/TestUser.bin");
     User user1;
     User user2;
     User user3;
     Pair pair1;
    Pair pair2;
    Pair pair3;


    @BeforeEach
     void setUp(){
        userDao.deleteAll();

         pair1=new Pair("a1","a1");
         user1=new User(pair1,"Anna","Karenina");
         pair2=new Pair("b1","b1");
         user2=new User(pair2,"Leo","Matilda");
         pair3=new Pair("c1","c1");
         user3=new User(pair3,"Sherlock","Holmes");
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
        assertEquals("Leo",userDao.get(pair2).get().name);
    }


    @Test
    void delete() {
        userDao.delete(pair1);
        assertEquals(2,userDao.getAll().size());
    }

    @Test
    void save() {
        //before add user4
        assertEquals(3,userDao.getAll().size());

        User user4=new User(new Pair("d1","d1"),"Lily","Rose");
        userDao.save(user4);
        //after add user4
        assertEquals(4,userDao.getAll().size());
    }
}