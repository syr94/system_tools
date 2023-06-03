package com.app.service;

import com.app.model.Task;
import com.app.repository.TaskRepository;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class TaskService {

    private static final Logger logger = LogManager.getLogger(TaskService.class);
    private static TaskService instance;
    private TaskRepository taskRepository;

    private TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskService();
        }
        return instance;
    }

    public Task getTaskByName(String name) {
        return taskRepository.getTaskByName(name);
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getRandomTask() {
        List<Task> tasks = getAllTasks();
        if (!tasks.isEmpty()) {
            return tasks.get(new Random().nextInt(tasks.size()));
        }
        return null;
    }
}