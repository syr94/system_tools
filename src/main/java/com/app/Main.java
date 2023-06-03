package com.myapp;

import com.app.view.MainView;
import com.app.controller.MainController;
import com.app.service.TaskService;
import com.app.worker.BlockingQueue;
import com.app.worker.WorkerThread;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main extends Application {
    private static final Logger logger = LogManager.getLogger(com.myapp.Main.class);
    private TaskService taskService = TaskService.getInstance();
    private BlockingQueue queue = new BlockingQueue();
    private Thread worker = new Thread(new WorkerThread(queue));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting Application...");
        MainView view = new MainView();
        new MainController(view, taskService, queue);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(view.getScene());
        primaryStage.show();

        // Starting the worker thread here
        worker.start();
        logger.info("Application started successfully");
    }
}

