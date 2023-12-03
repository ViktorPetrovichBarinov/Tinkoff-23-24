package edu.hw8.Task2;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntToDoubleFunction;
import static edu.hw8.Task2.Fibonacci.fib;

public class FixedThreadPool implements ThreadPool{
    private final int numberOfThreads;
    private final Queue<Runnable> taskQueue;
    private final Thread[] threads;

    //false, FixedThreadPool открыт
    //true, FixedThreadPool закрыт
    private boolean isShutdown;

    public FixedThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        taskQueue = new LinkedList<>();
        threads = new Thread[numberOfThreads];
        isShutdown = false;
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
        if (isShutdown) {
            throw new IllegalArgumentException("ThreadPool is shut sown");
        }

        synchronized (taskQueue) {
            taskQueue.offer(runnable);
            taskQueue.notify();
        }


    }

    //Метод начинает выполнение задач из очереди.
    private void runTask() {
        //Бесконечный цикл, который будет прерван, только при закрытии объекта
        while(true) {
            //Хранит текущую задачу.
            Runnable task;

            //Синхронизируемся именно на очереди, чтобы задачи не выполнялись дважды и др.
            synchronized (taskQueue) {
                //Поток засыпает, пока не появится задача или объект не закроется
                while (taskQueue.isEmpty() && !isShutdown) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                //Если объект закрыт и очередь пустая, то завершаем выполнение задач для потока
                if (isShutdown && taskQueue.isEmpty()) {
                    return;
                }

                task = taskQueue.poll();
            }

            //Задача получена, выполняем.
            try {
                task.run();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws Exception {
        //Если объект FixedThreadPool открыт
        if(!isShutdown) {
            //Устанавливаем флаг завершения для пула потоков.
            isShutdown = true;
            for (Thread thread : threads) {
                thread.join();
            }
        }
    }


}
