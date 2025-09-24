package task_management_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import task_management.JsonUtil;
import task_management.Task;
import task_management.TaskManager;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private static final String TEST_FILE = "tasks.json";

    @BeforeEach
    void cleanFile() {
        new File(TEST_FILE).delete();
        JsonUtil.writeTask(List.of(), TEST_FILE);
    }

    @Test
    @DisplayName("CountIds should return correct number of tasks")
    void testCountIds() {
        assertEquals(0, TaskManager.countIds());

        JsonUtil.writeTask(List.of(
                new Task(1, "Task1", "2025-09-05", false),
                new Task(2, "Task2", "2025-09-06", true)
        ), TEST_FILE);

        assertEquals(2, TaskManager.countIds());
    }
@Test
@DisplayName("Add Task should throw exception for duplicate ID")
public void addNewTasktest() {
    JsonUtil.writeTask(List.of(
            new Task(1, "Task1", "2025-09-05", false)
    ), TEST_FILE);

    String simulatedInput1 = "1\ntask1\n2025-09-06\nyes\n";
    System.setIn(new java.io.ByteArrayInputStream(simulatedInput1.getBytes()));

    String simulatedInput2 = "2\n\n2025-09-06\nyes\n";
    System.setIn(new java.io.ByteArrayInputStream(simulatedInput2.getBytes()));


    assertThrows(IllegalArgumentException.class, TaskManager::addTask);
}
    @Test
    @DisplayName("Update Task should modify task details")
    void testUpdateTask() {
        // Step 1: Create initial task in file
        JsonUtil.writeTask(List.of(
                new Task(1, "Old Task", "2025-09-05", false)
        ), TEST_FILE);
        String simulatedInput = "1\nUpdated Task\n2025-10-01\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        TaskManager.updateTask();

        List<Task> tasks = JsonUtil.readTask(TEST_FILE);
        Task updatedTask = tasks.get(0);

        assertEquals("Updated Task", updatedTask.getDescription());
        assertEquals("2025-10-01", updatedTask.getDueDate());
    }
    @Test
    public void deleteTaskTest() {
        JsonUtil.writeTask(List.of(
                new Task(1, "Task1", "2025-09-05", false),
                new Task(2, "Task2", "2025-09-06", true)
        ), TEST_FILE);

        int before = TaskManager.countIds();

        // Create a Scanner from a string instead of System.in
        Scanner scanner = new Scanner("1\n");

        TaskManager.deleteTask(scanner);

        int after = TaskManager.countIds();
        assertEquals(before - 1, after);

        List<Task> tasks = JsonUtil.readTask(TEST_FILE);
        assertFalse(tasks.stream().anyMatch(t -> t.getTaskId() == 1));
    }


}