package task_management_test;

import org.junit.jupiter.api.*;
import task_management.Task;
import task_management.JsonUtil;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {
    private static final String TEST_FILE = "test_tasks.json";

    @BeforeEach
    void cleanFile() {
        new File(TEST_FILE).delete();
    }

    @Test
    void testWriteAndReadTasks() {
        List<Task> tasks = Arrays.asList(
                new Task(1, "Project Assigned", "2025-09-05", false),
                new Task(2, "Submit project", "2025-09-10", false)
        );

        //  Write tasks
        JsonUtil.writeTask(tasks,TEST_FILE);

        // Read tasks back
        List<Task> loadedTasks = JsonUtil.readTask(TEST_FILE);

        assertEquals(2, loadedTasks.size());
        assertEquals("Project Assigned", loadedTasks.get(0).getDescription());
        assertFalse(loadedTasks.get(0).isCompleted());
    }

    @Test
    void testInvalidTaskThrowsException() {
        //  Invalid ID should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(0, "Invalid task", "2025-09-05", false);
        });

        //  Empty description should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(1, "   ", "2025-09-05", false);
        });

        //  Null due date should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(1, "No due date", null, false);
        });
    }
}
