package file_handling;

import java.io.File;
import java.io.FileWriter;

public class FileWrite {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter(new File("First.txt"));//to write data file
           writer.write("Hello, this is the first file created in Java!\n");
           writer.write("Im Prasanna");
           writer.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
