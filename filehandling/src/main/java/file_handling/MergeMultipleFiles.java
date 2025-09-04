package file_handling;

import java.io.*;

public class MergeMultipleFiles {
    public static void mergeMultipleFiles(String[] sourceFiles, String merge) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(merge))) {
            for (String source : sourceFiles) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(source));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("merged the all files");
    }

    public static void main(String[] args) {
        // List of source files
        String[] sourceFiles = {
                "file1.txt",
                "file2.txt",
                "file3.txt"
        };
        String mergedFile = "merged.txt";
        mergeMultipleFiles(sourceFiles,mergedFile);
    }
}
