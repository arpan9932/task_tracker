package com.example.task_tracker.service;

import com.example.tasktracker.dto.TaskDTO;
import com.example.task_tracker.exception.TaskNotFoundException;
import com.example.task_tracker.model.Task;
import com.example.task_tracker.util.JsonFileUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class TaskService {

    public Task addTask(String description) {
        List<Task> tasks = JsonFileUtil.readTasks();
        int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;

        Task newTask = new Task();
        newTask.setId(id);
        newTask.setDescription(description);
        newTask.setStatus("todo");
        newTask.setCreatedAt(LocalDateTime.now());
        newTask.setUpdatedAt(LocalDateTime.now());

        tasks.add(newTask);
        JsonFileUtil.writeTasks(tasks);
        return newTask;
    }

    public Task updateTask(int id, String description) {
        List<Task> tasks = JsonFileUtil.readTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setDescription(description);
        task.setUpdatedAt(LocalDateTime.now());
        JsonFileUtil.writeTasks(tasks);
        return task;
    }

    public void deleteTask(int id) {
        List<Task> tasks = JsonFileUtil.readTasks();
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (!removed) throw new TaskNotFoundException(id);
        JsonFileUtil.writeTasks(tasks);
    }

    public Task markStatus(int id, String status) {
        List<Task> tasks = JsonFileUtil.readTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());
        JsonFileUtil.writeTasks(tasks);
        return task;
    }

    public List<Task> listTasks(String filter) {
        List<Task> tasks = JsonFileUtil.readTasks();
        if (filter == null) return tasks;

        return tasks.stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(filter))
                .collect(Collectors.toList());
    }
}
