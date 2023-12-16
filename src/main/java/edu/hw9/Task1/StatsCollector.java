package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatsCollector {
    private final Map<String, List<Double>> data = new ConcurrentHashMap<>();
    private final int numberOfThreads;

    public StatsCollector(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public void push(String metricName, double[] values) {
        data.compute(metricName, (key, existingValues) -> {
            List<Double> list;
            if (existingValues == null) {
                list = new ArrayList<>();
            } else {
                list = existingValues;
            }

            for (int i = 0; i < values.length; i++) {
                list.add(values[i]);
            }
            return list;
        });
    }

    public List<Metric> stats() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(data.size());
        List<Metric> metrics = new ArrayList<>();

        for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
            String name = entry.getKey();
            List<Double> values = entry.getValue();

            executorService.submit(() -> {
                double sum = 0;
                double min = Double.MAX_VALUE;
                double max = Double.MIN_VALUE;

                for (double value : values) {
                    sum += value;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                }

                double average = sum / values.size();

                Metric metric = new Metric(name, sum, average, min, max);
                metrics.add(metric);
                latch.countDown();
            });
        }


        latch.await();


        executorService.shutdown();
        return metrics;
    }
}
