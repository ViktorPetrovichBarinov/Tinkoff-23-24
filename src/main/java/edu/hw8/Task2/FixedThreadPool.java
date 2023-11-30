package edu.hw8.Task2;

import java.util.LinkedList;

public class FixedThreadPool implements ThreadPool {
    private final int threadsNumber;
    private final LinkedList<Runnable> taskQueue;
    private final Thread[] threads;
    private boolean isShotdown;

    public FixedThreadPool(int threadsNumber) {
        this.threadsNumber = threadsNumber;
        taskQueue = new LinkedList<>();
        threads = new Thread[threadsNumber];
        isShotdown = false;
    }


    @Override
    public void start() {
        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new Thread(() -> {
               while (true) {
                   Runnable task;
                   synchronized (taskQueue) {
                       while (taskQueue.isEmpty() && !isShotdown) {
                           try {
                               taskQueue.wait();
                           } catch (InterruptedException e) {
                               Thread.currentThread().interrupt();
                               return;
                           }
                       }

                       if (isShotdown && taskQueue.isEmpty()) {
                           return;
                       }

                       task = taskQueue.poll();
                   }
                   task.run();
               }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (taskQueue) {
            if (!isShotdown) {
                taskQueue.add(runnable);
                taskQueue.notify();
            } else {
                throw new IllegalArgumentException("ThreadPool is shutdown.");
            }
        }
    }

    @Override
    public void close() throws Exception {
        synchronized (taskQueue) {
            isShotdown = true;
            taskQueue.notifyAll();

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static FixedThreadPool create(int threadsNumber) {
        return new FixedThreadPool(threadsNumber);
    }
}
