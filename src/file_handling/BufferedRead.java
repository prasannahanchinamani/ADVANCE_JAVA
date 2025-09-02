package file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedRead {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\BridgeLabz_Advance\\Advance_java\\First.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
