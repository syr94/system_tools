package com.app.worker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkerThread extends Thread {
    private static final Logger logger = LogManager.getLogger(WorkerThread.class);
    private final BlockingQueue queue;

    public WorkerThread(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = queue.get();
            task.run();
        }
    }
}