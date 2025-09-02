package file_handling;

import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\First.txt";

        try (FileReader reader = new FileReader(path)) {
            int i;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
