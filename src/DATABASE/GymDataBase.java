package DATABASE;
import java.io.Serializable;

import java.io.*;
import java.util.ArrayList;

public class GymDataBase {
    public static void saveData(ArrayList<? extends Serializable> dataList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dataList);
            System.out.println("Data saved successfully to " + fileName);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<? extends Serializable> loadData(String fileName) {
        ArrayList<? extends Serializable> dataList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();

            if (obj instanceof ArrayList) {
                dataList = (ArrayList<? extends Serializable>) obj;
                System.out.println("Data loaded successfully from " + fileName);
            } else {
                System.out.println("Invalid data format in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}

