package file_handling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteExample {

    // Method to create file
    public static void createFile(String path) {
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file.");
            e.printStackTrace();
        }
    }

    // Method to write to file
    public static void writeFile(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("Hello, this is the first file created in Java.\n");
            writer.write("I am Prasanna.");
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
            e.printStackTrace();
        }
    }

    // Method to read from file
    public static void readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int i;
            System.out.println("File Content:");
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\nFile read successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }


    // Main method
    public static void main(String[] args) {
        String source = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\source.txt";
        createFile(source);
        writeFile(source);
        readFile(source);
    }
}
