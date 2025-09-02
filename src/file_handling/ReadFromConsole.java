package file_handling;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFromConsole {
    public static void main(String[] args) {
        FileOutputStream read = null;
        try {
            read = new FileOutputStream("example.txt");
            int i;
            while ((i = System.in.read()) != -1) {   // read from console
                read.write(i);                      // write into file
            }
            System.out.println(" Data saved to example.txt");
        } catch (
                IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (read != null)
                try {
                    read.close();  // close the file safely
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
        }

    }
}
