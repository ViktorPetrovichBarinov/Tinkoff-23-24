package edu.hw8.task2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {
    private final int numberOfThreads;
    private final Queue<Runnable> taskQueue;
    private final Thread[] threads;

    //false, FixedThreadPool открыт
    //true, FixedThreadPool закрыт
    private AtomicBoolean isShutdown;

    public FixedThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        taskQueue = new LinkedList<>();
        threads = new Thread[numberOfThreads];
        isShutdown = new AtomicBoolean(false);
    }

    @Override
    public void start() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(this::runTask);
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isShutdown.get()) {
            throw new IllegalArgumentException("ThreadPool is shut sown");
        }

        synchronized (taskQueue) {
            taskQueue.offer(runnable);
            taskQueue.notify();
        }


    }

    @SuppressWarnings("ReturnCount")
    //Метод начинает выполнение задач из очереди.
    private void runTask() {
        //Бесконечный цикл, который будет прерван, только при закрытии объекта
        while (true) {
            //Хранит текущую задачу.
            Runnable task;

            //Синхронизируемся именно на очереди, чтобы задачи не выполнялись дважды и др.
            synchronized (taskQueue) {
                //Поток засыпает, пока не появится задача или объект не закроется
                while (taskQueue.isEmpty() && !isShutdown.get()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                //Если объект закрыт и очередь пустая, то завершаем выполнение задач для потока
                if (isShutdown.get() && taskQueue.isEmpty()) {
                    return;
                }

                task = taskQueue.poll();
            }

            //Задача получена, выполняем.
            try {
                task.run();
            } catch (Exception exception) {
                throw new RuntimeException();
            }
        }
    }

    @Override
    public void close() throws Exception {
        //Если объект FixedThreadPool открыт
        if (!isShutdown.get()) {
            //Устанавливаем флаг завершения для пула потоков.
            isShutdown.set(true);
            for (Thread thread : threads) {
                thread.join();
            }
        }
    }


}
