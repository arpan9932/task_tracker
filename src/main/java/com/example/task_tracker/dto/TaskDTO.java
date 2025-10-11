package com.example.tasktracker.dto;

public class TaskDTO {

    private int id;
    private String description;
    private String status; // todo, in-progress, done

    // Default Constructor
    public TaskDTO() {
    }

    // Parameterized Constructor
    public TaskDTO(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() for easy printing in CLI
    @Override
    public String toString() {
        return "TaskDTO {" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
