package com.app.util;

import com.app.model.Task;
import com.app.repository.TaskRepository;
import com.app.service.TaskService;

import java.io.IOException;

public class TaskFactory {
    private static TaskService taskService = TaskService.getInstance();
    public static Runnable getRandomTask() {
        Task task = taskService.getRandomTask();

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task started: " + task.getName());
                // Execute the system command specified in task.getValue()
                try {
                    String command = task.getValue();
                    // If the command requires a directory path, append a random directory
                    if (command.equals("ls") ||
                            command.equals("mkdir") ||
                            command.equals("cp -r") ||
                            command.equals("cp") ||
                            command.equals("rm")) {
                        command += " " + DirectoryTree.getRandomDirectory();
                    }
                    Runtime.getRuntime().exec(command);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Task finished: " + task.getName());
            }
        };
    }

    public static Runnable getTask(Task task) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task started: " + task.getName());
                // Execute the system command specified in task.getValue()
                try {
                    Runtime.getRuntime().exec(task.getValue());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Task finished: " + task.getName());
            }
        };
    }
}