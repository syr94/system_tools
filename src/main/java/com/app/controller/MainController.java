package com.app.controller;

import com.app.view.MainView;
import com.app.util.TaskFactory;
import com.app.service.TaskService;
import com.app.model.Task;
import com.app.worker.BlockingQueue;
public class MainController {
    private MainView view;
    private TaskService taskService;
    private BlockingQueue queue;

    public MainController(MainView view, TaskService taskService, BlockingQueue queue) {
        this.view = view;
        this.taskService = taskService;
        this.queue = queue;

        view.getAddButton().setOnAction(event -> {
            Task randomTask = taskService.getRandomTask();
            if (randomTask != null) {
                queue.put(TaskFactory.getTask(randomTask));
            }
        });
    }
}
