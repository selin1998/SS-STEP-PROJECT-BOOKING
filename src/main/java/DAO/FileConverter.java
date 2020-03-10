package DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileConverter  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("./INFO/flight.txt");

        BufferedReader reader=new BufferedReader(new FileReader(file));

        File ofile = new File("./INFO/flight.bin");
        FileOutputStream fos = new FileOutputStream(ofile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);



        ArrayList<Flight> flist=new ArrayList<Flight>();

        String line;
        while ((line=reader.readLine())!=null) {
            flist.add(Flight.parse(line));

        }

        oos.writeObject(flist);




}}
