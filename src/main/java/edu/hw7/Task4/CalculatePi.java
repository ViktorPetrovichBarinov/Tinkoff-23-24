package edu.hw7.Task4;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculatePi {

    // Метод генерирует точки внутри квадрата со стороной 2 и левым нижним углом в (0,0)
    // Круг радиуса 1 с центром в (1,1)
    private static final Random RANDOM = new Random();
    private static final Double circleCoordinateX = 1.0;
    private static final Double circleCoordinateY = 1.0;
    private static int calculateNumberPointsInCircle(int numberOfGeneratePoint) {
        int numberOfPointsInCircle = 0;


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

    private final static AtomicInteger numberOfPointsInCircle = new AtomicInteger(0);

    private static int calculateNumberPointsInCircleParallel(int numberOfGeneratePoint, int threadCount) {
        numberOfPointsInCircle.set(0);

        Thread[] threads = new Thread[threadCount];
        int numberOfGeneratePointForOneThread = numberOfGeneratePoint / threadCount;
        for (int i = 0; i < threadCount; i++) {

            if (i == threadCount - 1) {
                numberOfGeneratePointForOneThread = numberOfGeneratePoint - numberOfGeneratePointForOneThread * (threadCount - 1);
            }

            int finalNumberOfGeneratePointForOneThread = numberOfGeneratePointForOneThread;
            threads[i] = new Thread(() -> {
                int pointsForCurrentThread = calculateNumberPointsInCircle(
                    finalNumberOfGeneratePointForOneThread);
                numberOfPointsInCircle.addAndGet(pointsForCurrentThread);
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


        return numberOfPointsInCircle.get();
    }

    public static Double calculatePi (int numberOfGeneratePoint) {
        int numberOfPointsInCircle = calculateNumberPointsInCircle(numberOfGeneratePoint);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * 4;
    }

    public static Double calculatePiInParallel (int numberOfGeneratePoint, int threadsCount) {
        long numberOfPointsInCircle = calculateNumberPointsInCircleParallel(numberOfGeneratePoint, threadsCount);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * 4;
    }

    public static void main(String[] args) {
        long start, end;
        int number1 = 10000000;

        start = System.currentTimeMillis();
        Double pi = calculatePi(number1);
        end = System.currentTimeMillis();
        System.out.println("Number of generate points: " + number1 + "|  pi: " + pi + "|   time: " + (end - start));

        start = System.currentTimeMillis();
        pi = calculatePiInParallel(number1, 4);
        end = System.currentTimeMillis();
        System.out.println("Number of generate points: " + number1 + "|  pi: " + pi + "|   time: " + (end - start));
    }
}
