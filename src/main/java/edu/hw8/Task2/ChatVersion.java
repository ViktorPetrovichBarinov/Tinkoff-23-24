package edu.hw8.Task2;

import java.util.LinkedList;
import java.util.Queue;

class FixedThreadPool1 implements ThreadPool {
    private final int numThreads;
    private final Queue<Runnable> taskQueue;
    private final Thread[] threads;
    private boolean isShutdown;

    public FixedThreadPool1(int numThreads) {
        this.numThreads = numThreads;
        this.taskQueue = new LinkedList<>();
        this.threads = new Thread[numThreads];
        this.isShutdown = false;
    }

    @Override
    public void start() {
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(this::runTasks);
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutdown) {
            throw new IllegalStateException("ThreadPool is shut down");
        }

        synchronized (taskQueue) {
            taskQueue.offer(runnable);
            taskQueue.notify(); // Notify one of the waiting threads that a task is available.
        }
    }

    private void runTasks() {
        while (true) {
            Runnable task;
            synchronized (taskQueue) {
                while (taskQueue.isEmpty() && !isShutdown) {
                    try {
                        taskQueue.wait(); // Wait for a task to be added to the queue.
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (isShutdown && taskQueue.isEmpty()) {
                    return;
                }

                task = taskQueue.poll();
            }

            // Execute the task outside the synchronized block to allow for better parallelism.
            try {
                task.run();
            } catch (Exception e) {
                // Handle exceptions thrown by tasks.
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        if (!isShutdown) {
            isShutdown = true;
            for (Thread thread : threads) {
                thread.interrupt(); // Interrupt each thread to exit their runTasks loop.
            }
        }
    }

    // Фабричный метод для создания FixedThreadPool
    public static FixedThreadPool1 create(int numThreads) {
        if (numThreads <= 0) {
            throw new IllegalArgumentException("Number of threads must be greater than zero");
        }
        return new FixedThreadPool1(numThreads);
    }
}
