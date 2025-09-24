package task_management;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void writeTask(List<Task> list, String path) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), list);
            System.out.println("JSON file created/updated: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> readTask(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                // File not found → return empty list
                return new ArrayList<>();
            }
            return mapper.readValue(file,
                    mapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
