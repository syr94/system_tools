package com.app.model;


import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockingQueue {
    private Boolean isFirstWait = true;
    private static final Logger logger = LogManager.getLogger(BlockingQueue.class);
    private List<Runnable> tasks = new ArrayList<>();

    public synchronized Runnable get() {
        while (tasks.isEmpty()) {
            try {
                if (isFirstWait) {
                    logger.info("Queue is empty, waiting for a task");
                    isFirstWait = false;
                }
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("Interrupted while waitong for a task: " + e);
            }
        }
        Runnable task = tasks.get(0);
        tasks.remove(task);
        isFirstWait = true;
        return task;
    }

    public synchronized void put(Runnable task) {
        tasks.add(task);
        notify();
        logger.info("Task added to queue");
    }
}
