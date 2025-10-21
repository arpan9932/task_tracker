# 📝 Task Tracker CLI

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.java.com/) 
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-green)](https://spring.io/projects/spring-boot) 
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

A simple **Command-Line Interface (CLI) Task Tracker** built with **Spring Boot**.  
Track tasks with statuses: `todo`, `in-progress`, `done`, stored in a JSON file.

---
Project url:
https://github.com/arpan9932/task_tracker
from https://roadmap.sh/projects/task-tracker
## 📖 Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [CLI Commands](#cli-commands)
- [Task JSON Structure](#task-json-structure)
- [Notes](#notes)
- [Future Improvements](#future-improvements)
---

## ✨ Features

- Add, update, delete tasks  
- Mark tasks as `in-progress` or `done`  
- List all tasks or filter by status  
- JSON storage with automatic creation  
- Tracks creation and update timestamps  
- Handles errors gracefully  

---

## 🛠 Requirements

- Java 17+  
- Maven 3+  
- Spring Boot 3.5.x  

No external libraries beyond Spring Boot and Jackson are required.

---

## 📂 Project Structure

task-tracker/
├─ src/main/java/com/example/task_tracker/
│ ├─ model/ # Task entity
│ ├─ dto/ # TaskDTO for CLI output
│ ├─ service/ # Task business logic
│ ├─ util/ # JSON read/write helper
│ └─ TaskTrackerApplication.java # Main class
├─ tasks.json # JSON storage file (auto-created)
├─ pom.xml
└─ README.md


---

## ⚡ Installation & Setup

1. Clone the repository:

git clone https://github.com/<your-username>/task-tracker.git
cd task-tracker
Build with Maven:
mvn clean package

Run commands via Maven CLI:
mvn spring-boot:run -D"spring-boot.run.arguments=<command> <args>"

## CLI Commands
mvn spring-boot:run -D"spring-boot.run.arguments=add Buy groceries"

Output
Task added successfully (ID: 1)

Update a task
mvn spring-boot:run -D"spring-boot.run.arguments=update 1 Buy groceries and cook dinner"

Delete a task
mvn spring-boot:run -D"spring-boot.run.arguments=delete 1"

Mark a task as in-progress
mvn spring-boot:run -D"spring-boot.run.arguments=mark-in-progress 1"
Mark a task as done
mvn spring-boot:run -D"spring-boot.run.arguments=mark-done 1"
List all tasks
mvn spring-boot:run -D"spring-boot.run.arguments=list"
List tasks by status

Done:
mvn spring-boot:run -D"spring-boot.run.arguments=list done"
Todo:

mvn spring-boot:run -D"spring-boot.run.arguments=list todo"


In-progress:

mvn spring-boot:run -D"spring-boot.run.arguments=list in-progress"

## Task JSON Structure
{
  "id": 1,
  "description": "Buy groceries",
  "status": "todo",
  "createdAt": "2025-10-11T10:55:12.451",
  "updatedAt": "2025-10-11T10:55:12.451"
}

id: Unique identifier

description: Task description

status: todo, in-progress, or done

createdAt: Creation timestamp

updatedAt: Last update timestamp

## ⚠️ Notes

The CLI exits after each command — every command is independent.

Ensure tasks.json is writable.

Java 17+ is required to handle LocalDateTime serialization.

## 📌 Future Improvements

Backup tasks.json automatically to prevent data loss

Convert CLI into a REST API or GUI app

Add priority and due dates for tasks



