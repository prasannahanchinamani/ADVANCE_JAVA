package file_handling;

import java.io.*;

public class ReverseFileContent {
    public static void main(String[] args) {
        String inputPath = "source.txt";      // original file
        String outputPath = "reversed.txt";  // reversed file

        reverseFile(inputPath, outputPath);
    }

    private static void reverseFile(String inputPath, String outputPath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        content.reverse();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(content.toString());
            System.out.println("Reversed content written to " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
