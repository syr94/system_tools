package com.app.worker;

import com.app.model.BlockingQueue;

public class WorkerThread extends Thread {

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