package dao;

import entity.UserCredential;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionUserDAO implements UserDAO<User> {
   private String filename;
  private  List<User> usersList= new ArrayList<User>();

    public CollectionUserDAO(String filename) {
        this.filename = filename;

    }

    @Override
    public Optional<User> get(UserCredential userCredential) {
        return getAll().stream().filter(x -> x.credential.equals(userCredential)).findAny();
    }

    @Override
    public List<User> getAll() {
        return this.usersList;

    }

    public void read(){
        try {
            List<User> listLoaded = null;
            FileInputStream is = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            listLoaded = (ArrayList<User>) readed;
            ois.close();
            is.close();
            listLoaded.forEach(this::save);



        } catch (IOException | ClassNotFoundException e) {



        }

    }

    @Override
    public void delete(UserCredential userCredential) {
        usersList = getAll().stream().filter(b -> !(b.credential.equals(userCredential))).collect(Collectors.toList());

    }

    @Override
    public void deleteAll() {

        usersList.clear();
    }

    @Override
    public void save(User user) {

        if(user!=null){

            if (usersList.contains(user)) {

                usersList.set(usersList.indexOf(user), user);

            } else {

                usersList.add(user);

            }
        }

    }


    public void write() {
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(usersList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }
    }
}


