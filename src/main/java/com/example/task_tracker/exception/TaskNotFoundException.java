package com.example.task_tracker.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(int id) {
        super("Task not found with ID: " + id);
    }
}
