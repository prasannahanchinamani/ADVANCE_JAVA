package file_handling;

import java.io.*;

public class BufferOperations {
    public static void createFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("this is content in source file");
            writer.write("need to copy destination file");
            System.out.println(" Data written successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void readFile(String path) {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
                System.out.println("data is succesfully read");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFromStoD(String input, String output) {
        try (BufferedReader reader=new BufferedReader(new FileReader(input));
            BufferedWriter writer=new BufferedWriter(new FileWriter(output))){
            String line;
            while ((line=reader.readLine())!=null){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied from " + input + " to " + output);
        }catch(IOException e){
            System.out.println("Error copying file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\filehandling\\source.txt";
        String destination = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\filehandling\\destination.txt";
        createFile(source);
        readFile(source);
        copyFromStoD(source,destination);
    }
}
