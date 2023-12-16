package DATABASE;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;

public class GymDataBase {
    public static <T> void saveData(ArrayList<T> dataList, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(dataList);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> ArrayList<T> loadData(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<T>)  inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not found. Creating a new list.\n");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
