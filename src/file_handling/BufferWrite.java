package file_handling;

import java.io.*;

public class BufferWrite {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\First.txt";
        try(BufferedWriter bufferWriter=new BufferedWriter(new FileWriter(path))){
            bufferWriter.write("Hello, this is written using Buffered Stream.");
            bufferWriter.newLine();
            bufferWriter.write("It is faster and supports line operations.");
        } catch (IOException e) {
         e.printStackTrace();
        }
    }
}
