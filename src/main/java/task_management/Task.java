package task_management;

public class Task {
    private int taskId;
    private String description;
    private String dueDate;
    private boolean completed;

    public Task() {
    }  // Default constructor for Jackson

    public Task(int taskId, String description, String dueDate, boolean completed) {
        if (taskId <= 0) {
            throw new IllegalArgumentException("Task ID must be greater than 0");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (dueDate == null || dueDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Due date cannot be null or empty");
        }

        this.taskId = taskId;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public  void setCompleted(boolean completed) {

        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID=" + taskId +
                ", Description='" + description + '\'' +
                ", DueDate='" + dueDate + '\'' +
                ", Completed=" + completed +
                '}';
    }

}
