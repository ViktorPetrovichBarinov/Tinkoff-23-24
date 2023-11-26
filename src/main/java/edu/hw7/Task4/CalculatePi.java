package edu.hw7.Task4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculatePi {

    private final static AtomicInteger NUMBER_OF_POINTS_IN_CIRCLE = new AtomicInteger(0);
    private final static Integer MONTE_CARLO_CONST = 4;

    // Метод генерирует точки внутри квадрата со стороной 2 и левым нижним углом в (0,0)
    // Круг радиуса 1 с центром в (1,1)
    private int calculateNumberPointsInCircle(int numberOfGeneratePoint) {
        int numberOfPointsInCircle = 0;
        final Random RANDOM = new Random();
        final Double circleCoordinateX = 1.0;
        final Double circleCoordinateY = 1.0;

        for (int i = 0; i < numberOfGeneratePoint; i++) {
            // Генерируем рандомную точку внутри квадрата
            double randomCoordinateX = RANDOM.nextDouble() * 2.0;
            double randomCoordinateY = RANDOM.nextDouble() * 2.0;
            Double lengthOfCathetX = circleCoordinateX - randomCoordinateX;
            Double lengthOfCathetY = circleCoordinateY - randomCoordinateY;
            // Если длинна до центра меньше радиуса, то точка внутри круга
            if (lengthOfCathetY * lengthOfCathetY + lengthOfCathetX * lengthOfCathetX < 1.0) {
                numberOfPointsInCircle++;
            }
        }
        return numberOfPointsInCircle;
    }

    private int calculateNumberPointsInCircleParallel(int numberOfGeneratePoint, int threadCount) {
        NUMBER_OF_POINTS_IN_CIRCLE.set(0);

        Thread[] threads = new Thread[threadCount];
        int numberOfGeneratePointForOneThread = numberOfGeneratePoint / threadCount;
        for (int i = 0; i < threadCount; i++) {

            if (i == threadCount - 1) {
                numberOfGeneratePointForOneThread =
                    numberOfGeneratePoint - numberOfGeneratePointForOneThread * (threadCount - 1);
            }

            int finalNumberOfGeneratePointForOneThread = numberOfGeneratePointForOneThread;
            threads[i] = new Thread(() -> {
                int pointsForCurrentThread = calculateNumberPointsInCircle(
                    finalNumberOfGeneratePointForOneThread);
                NUMBER_OF_POINTS_IN_CIRCLE.addAndGet(pointsForCurrentThread);
            });
            threads[i].start();
        }

        try {
            for (int i = 0; i < threadCount; i++) {
                threads[i].join();
            }

        } catch (InterruptedException e) {
            System.exit(-1);
        }


        return NUMBER_OF_POINTS_IN_CIRCLE.get();
    }

    public Double calculatePi(int numberOfGeneratePoint) {
        int numberOfPointsInCircle = calculateNumberPointsInCircle(numberOfGeneratePoint);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * MONTE_CARLO_CONST;
    }

    public Double calculatePiInParallel(int numberOfGeneratePoint, int threadsCount) {
        long numberOfPointsInCircle = calculateNumberPointsInCircleParallel(numberOfGeneratePoint, threadsCount);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * MONTE_CARLO_CONST;
    }
}
