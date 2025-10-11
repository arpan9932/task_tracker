package com.example.task_tracker.util;

import com.example.task_tracker.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileUtil {
    private static final String FILE_PATH = "tasks.json";

    // ✅ Register JavaTimeModule for LocalDateTime support
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .findAndRegisterModules();

    public static List<Task> readTasks() {
        File file = new File(FILE_PATH);
        try {
            // Create new file if not exists
            if (!file.exists()) {
                file.createNewFile();
                mapper.writeValue(file, new ArrayList<Task>());
            }

            // If file is empty, return empty list
            if (file.length() == 0) {
                return new ArrayList<>();
            }

            return mapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
    }

    public static void writeTasks(List<Task> tasks) {
        File file = new File(FILE_PATH);
        try {
            System.out.println("📁 Writing tasks to: " + file.getAbsolutePath());
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
            System.out.println("✅ Tasks written successfully");
        } catch (IOException e) {
            System.out.println("❌ Error writing to JSON file: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error writing to JSON file", e);
        }
    }
}
