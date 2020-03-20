package dao;

import entity.UserCredential;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectionUserDAO implements UserDAO<User> {
    String filename;
    List<User> users = new ArrayList<User>();

    public CollectionUserDAO(String filename) {
        this.filename = filename;
    }

    @Override
    public Optional<User> get(UserCredential userCredential) {
        return getAll().stream().filter(x -> x.credential.equals(userCredential)).findAny();
    }

    @Override
    public List<User> getAll() {
        try {
            FileInputStream is = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object readed = ois.readObject();
            ArrayList<User> data = (ArrayList<User>) readed;
            ois.close();
            is.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<User>();
        }
    }

    @Override
    public void delete(UserCredential userCredential) {
        List<User> listUsers = getAll().stream().filter(b -> !(b.credential.equals(userCredential))).collect(Collectors.toList());
        write(listUsers);
    }

    @Override
    public void deleteAll() {
        List<User> data = getAll();
        data.clear();
        write(data);
    }

    @Override
    public void save(User user) {
        List<User> data = getAll();
        data.add(user);
        write(data);
    }


    private void write(List<User> data) {
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException:", e);
        }
    }
}


