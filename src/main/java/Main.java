import manager.TaskManager;
import tasks.BasicTask;
import tasks.LimitedTimeTask;
import tasks.RepeatableTask;
import tasks.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.println("Welcome to Task Management System.");
        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("1. add_task");
            System.out.println("2. get_tasks");
            System.out.println("3. update_task");
            System.out.println("4. delete_task");
            System.out.println("5. get_task_details");
            System.out.println("6. exit");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "add_task":
                    System.out.print("Enter task type (LimitedTimeTask, RepeatableTask, BasicTask): ");
                    String taskType = scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();

                    switch (taskType) {
                        case "LimitedTimeTask":
                            System.out.print("Enter deadline (yyyy-MM-dd HH:mm): ");
                            String deadlineStr = scanner.nextLine();
                            LocalDateTime deadline = LocalDateTime.parse(deadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            Task limitedTask = new LimitedTimeTask(taskName, taskDescription, username, deadline);
                            taskManager.addTask(limitedTask);
                            break;
                        case "RepeatableTask":
                            System.out.print("Enter repeat count: ");
                            int repeatCount = Integer.parseInt(scanner.nextLine());
                            System.out.print("Enter repeat interval (yyyy-MM-dd HH:mm): ");
                            String intervalStr = scanner.nextLine();
                            LocalDateTime repeatInterval = LocalDateTime.parse(intervalStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            Task repeatableTask = new RepeatableTask(taskName, taskDescription, username, repeatCount, repeatInterval);
                            taskManager.addTask(repeatableTask);
                            break;
                        case "BasicTask":
                            Task basicTask = new BasicTask(taskName, taskDescription, username);
                            taskManager.addTask(basicTask);
                            break;
                        default:
                            System.out.println("Invalid task type.");
                    }
                    break;

                case "get_tasks":
                    System.out.println("Here are all the tasks:");
                    taskManager.getTasks();
                    break;

                case "update_task":
                    System.out.print("Enter task name to update: ");
                    String updateName = scanner.nextLine();
                    Task taskToUpdate = taskManager.getTask(updateName);

                    if (taskToUpdate == null) {
                        System.out.println("Task does not exist.");
                    } else {
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.println("Enter new taskname");
                        String newTaskName = scanner.nextLine();

                        if (taskToUpdate instanceof LimitedTimeTask) {
                            System.out.print("Enter new deadline (yyyy-MM-dd HH:mm): ");
                            String newDeadlineStr = scanner.nextLine();
                            LocalDateTime newDeadline = LocalDateTime.parse(newDeadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            taskManager.updateTask(updateName, newDescription, newDeadline, 0, null);
                        } else if (taskToUpdate instanceof RepeatableTask) {
                            System.out.print("Enter new repeat interval (yyyy-MM-dd HH:mm): ");
                            String newRepeatIntervalStr = scanner.nextLine();
                            LocalDateTime newRepeatInterval = LocalDateTime.parse(newRepeatIntervalStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                            System.out.println("Enter new repeat count: ");
                            int newRepeatCount = scanner.nextInt();

                            taskManager.updateTask(updateName, newDescription, null, newRepeatCount, newRepeatInterval);
                        } else {
                            taskManager.updateTask(updateName, newDescription, null, 0, null);
                        }
                    }
                    break;

                case "delete_task":
                    System.out.print("Enter task name to delete: ");
                    String deleteName = scanner.nextLine();
                    taskManager.deleteTask(deleteName);
                    break;

                case "get_task_details":
                    System.out.print("Enter task name to get details: ");
                    String detailName = scanner.nextLine();
                    taskManager.getTaskDetails(detailName);
                    break;

                case "exit":
                    System.out.println("Exiting the Task Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}