package file_handling;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public static void main(String[] args) {
        try {
            File file = new File("First.txt");
            if (file.createNewFile())
                System.out.println("File is Created:" + file.getName());
            else
                System.out.println("File already exists.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
