package com.example.task_tracker.controller;

import com.example.task_tracker.model.Task;
import com.example.task_tracker.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TaskCLIController implements CommandLineRunner {

    private final TaskService taskService;

    public TaskCLIController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            System.out.println("Usage: task-cli <command> [options]");
            return;
        }

        String command = args[0];
        try {
            switch (command) {
                case "add":
                    Task newTask = taskService.addTask(args[1]);
                    System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
                    break;
                case "update":
                    taskService.updateTask(Integer.parseInt(args[1]), args[2]);
                    System.out.println("Task updated successfully.");
                    break;
                case "delete":
                    taskService.deleteTask(Integer.parseInt(args[1]));
                    System.out.println("Task deleted successfully.");
                    break;
                case "mark-in-progress":
                    taskService.markStatus(Integer.parseInt(args[1]), "in-progress");
                    System.out.println("Task marked as in progress.");
                    break;
                case "mark-done":
                    taskService.markStatus(Integer.parseInt(args[1]), "done");
                    System.out.println("Task marked as done.");
                    break;
                case "list":
                    List<Task> tasks = (args.length > 1)
                            ? taskService.listTasks(args[1])
                            : taskService.listTasks(null);
                    tasks.forEach(t -> System.out.println(t.getId() + ": " + t.getDescription() + " [" + t.getStatus() + "]"));
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
