package com.myapp;

import com.app.model.BlockingQueue;
import com.app.model.TaskFactory;
import com.app.worker.WorkerThread;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationMain extends Application {
    private static final Logger logger = LogManager.getLogger(ApplicationMain.class);
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        logger.info("Starting Application...");
        // Initialize the queue, worker thread, and task factory
        BlockingQueue queue = new BlockingQueue();
        WorkerThread worker = new WorkerThread(queue);
        TaskFactory taskFactory = new TaskFactory();

        // Start the worker thread
        Thread workerThread = new Thread(worker);
        workerThread.start();

        // Generate tasks and add them to the queue
        Runnable task = taskFactory.getTask();
        queue.put(task);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setScene(new Scene(new Label("Hello, world!"), 300, 200));
        primaryStage.show();
        logger.info("Application started successfully");
    }
}

