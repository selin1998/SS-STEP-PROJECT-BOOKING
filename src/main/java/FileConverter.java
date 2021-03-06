import entity.Flight;

import java.io.*;
import java.util.ArrayList;


//  This class is used for converting flight.txt file to flight.bin file.
//  Already converted, so do not use again.


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
            Flight f=new Flight();
            flist.add(f.parse(line));

        }

        oos.writeObject(flist);

        FileInputStream fis = new FileInputStream(ofile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object readed = ois.readObject();
        ArrayList<Flight> data = (ArrayList<Flight>) readed;
        for (Flight datum : data) {
            System.out.println(datum);
        }


          oos.writeObject(flist);




}}
