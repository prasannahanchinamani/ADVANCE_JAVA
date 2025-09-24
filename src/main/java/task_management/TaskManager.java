package task_management;

import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private static final String FILE_PATH = "tasks.json";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask(scanner);
                case 5 -> markTaskCompleted();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void markTaskCompleted() {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        System.out.print("Enter Task ID to mark completed: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskId() == id) {
                task.setCompleted(true);
                JsonUtil.writeTask(tasks, FILE_PATH);
                System.out.println("Task marked as completed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found!");
        }
    }

    public static void deleteTask(Scanner scanner) {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        System.out.print("Enter Task ID to delete: ");
        int id = scanner.nextInt();

        boolean removed = tasks.removeIf(task -> task.getTaskId() == id);
        if (removed) {
            JsonUtil.writeTask(tasks, FILE_PATH);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }


    public static void updateTask() {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        System.out.print("Enter Task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Task task : tasks) {
            if (task.getTaskId() == id) {
                System.out.print("Enter new Description: ");
                task.setDescription(scanner.nextLine());
                System.out.print("Enter new Due Date: ");
                task.setDueDate(scanner.nextLine());
                JsonUtil.writeTask(tasks, FILE_PATH);
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public static void viewTasks() {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public  static void addTask() {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        System.out.print("Enter Task ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exists = tasks.stream().anyMatch(t -> t.getTaskId() == id);
        if (exists) {
            System.out.println("Task ID " + id + " already exists!");
            throw  new IllegalArgumentException("Duplicate ID should not add new task");
        }

        System.out.print("Enter Description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = scanner.nextLine();
        System.out.print("Is Task Completed? (yes/no): ");
        String yesno = scanner.nextLine();

        boolean completed = yesno.equalsIgnoreCase("yes");
        tasks.add(new Task(id, desc, dueDate, completed));
        JsonUtil.writeTask(tasks, FILE_PATH);
        System.out.println("Task added successfully.");
    }

    public static int countIds() {
        List<Task> tasks = JsonUtil.readTask(FILE_PATH);
        return tasks.size();
    }

}
