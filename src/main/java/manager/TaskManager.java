package manager;

import tasks.LimitedTimeTask;
import tasks.RepeatableTask;
import tasks.Task;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private Map<String, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (tasks.containsKey(task.getName())) {
            System.out.println("Task already exists with this name.");
        } else {
            tasks.put(task.getName(), task);
            System.out.println("Task added successfully.");
        }
    }

    public void getTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (String taskName : tasks.keySet()) {
                System.out.println(taskName);
            }
        }
    }

    public Task getTask(String taskName) {
        return tasks.get(taskName);
    }

    public void updateTask(
            String taskName,
            String newDescription,
            LocalDateTime newDeadline,
            int newRepeatCount,
            LocalDateTime newRepeatInterval) {
        Task task = tasks.get(taskName);
        if (task == null) {
            System.out.println("Task does not exist.");
            return;
        }

        task.setDescription(newDescription);
        if (task instanceof LimitedTimeTask) {
            ((LimitedTimeTask) task).setDeadline(newDeadline);
        } else if (task instanceof RepeatableTask) {
            ((RepeatableTask) task).setRepeatCount(newRepeatCount);
            ((RepeatableTask) task).setRepeatInterval(newRepeatInterval);
        }

        System.out.println("Task updated successfully.");
    }

    public void deleteTask(String taskName) {
        Task removedTask = tasks.remove(taskName);
        if (removedTask == null) {
            System.out.println("Task does not exist.");
        } else {
            System.out.println("Task deleted successfully.");
        }
    }

    public void getTaskDetails(String taskName) {
        Task task = tasks.get(taskName);
        if (task == null) {
            System.out.println("Task does not exist.");
        } else {
            System.out.println(task.getDetails());
        }
    }
}
