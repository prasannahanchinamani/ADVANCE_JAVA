package file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInputToFile {
    public static void count_Words(String path) {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine())!= null) {
                String word[] = line.trim().split(" ");
                if (!line.isBlank()){
                    wordCount+=word.length;
                }
            }
            System.out.println("Total words in file: " + wordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "user_input.txt";  // File where user input will be saved

        // Scanner and FileWriter are automatically closed by try-with-resources
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(path)) {

            System.out.println("Enter text (type 'exit' to finish):");

            while (true) {
                String line = scanner.nextLine(); // Read a line from console
                if (line.equalsIgnoreCase("exit")) {
                    break; // Stop when user types "exit"
                }
                writer.write(line + System.lineSeparator()); // Write line to file
            }

            System.out.println("Data successfully saved to " + path);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        count_Words("user_input.txt");
    }
}
