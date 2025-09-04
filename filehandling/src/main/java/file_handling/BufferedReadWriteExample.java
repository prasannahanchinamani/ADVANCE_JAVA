package file_handling;

import java.io.*;

public class BufferedReadWriteExample {

            // Method to write into file
            public static void writeToFile(String path) {
                try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(path))) {
                    bufferWriter.write("Hello, this is written using Buffered Stream.");
                    bufferWriter.newLine();
                    bufferWriter.write("It is faster and supports line operations.");
                    System.out.println(" Data written successfully.");
                } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read from file
    public static void readFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            System.out.println(" File content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(" Data read successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\First.txt";

        // First write
        writeToFile(path);

        // Then read
        readFromFile(path);
    }
}
