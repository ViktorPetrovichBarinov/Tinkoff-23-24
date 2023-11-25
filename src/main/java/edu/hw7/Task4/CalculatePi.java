package edu.hw7.Task4;

import java.util.Random;

public class CalculatePi {

    // Метод генерирует точки внутри квадрата со стороной 2 и левым нижним углом в (0,0)
    // Круг радиуса 1 с центром в (1,1)
    private static final Random RANDOM = new Random();
    private static final Double circleCoordinateX = 1.0;
    private static final Double circleCoordinateY = 1.0;
    public static long calculateNumberPointsInCircle(long numberOfGeneratePoint) {
        long numberOfPointsInCircle = 0;


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

    public static long calculateNumberPointsInCircleParallel(long numberOfGeneratePoint, int threadCount) {
        long numberOfPointsInCircle = 0;
        long[] numberOfPointsInCircleForThread = new long[threadCount];


        Thread[] threads = new Thread[threadCount];
        long numberOfGeneratePointForOneThread = numberOfGeneratePoint / threadCount;
        for (int i = 0; i < threadCount; i++) {

            if (i == threadCount - 1) {
                numberOfGeneratePointForOneThread = numberOfGeneratePoint - numberOfGeneratePointForOneThread * (threadCount - 1);
            }

            int finalI = i;
            long finalNumberOfGeneratePointForOneThread = numberOfGeneratePointForOneThread;
            threads[i] = new Thread(() -> {
                numberOfPointsInCircleForThread[finalI] = calculateNumberPointsInCircle(
                    finalNumberOfGeneratePointForOneThread);
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


        for (int i = 0; i < threadCount; i++) {
            numberOfPointsInCircle += numberOfPointsInCircleForThread[i];
        }

        return numberOfPointsInCircle;
    }

    public static Double calculatePi (long numberOfGeneratePoint) {
        long numberOfPointsInCircle = calculateNumberPointsInCircle(numberOfGeneratePoint);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * 4;
    }

    public static Double calculatePiInParallel (long numberOfGeneratePoint, int threadsCount) {
        long numberOfPointsInCircle = calculateNumberPointsInCircleParallel(numberOfGeneratePoint, threadsCount);
        return (double) numberOfPointsInCircle / numberOfGeneratePoint * 4;
    }

    public static void main(String[] args) {
        long start, end;
        long number1 = 1000000;

        start = System.currentTimeMillis();
        Double pi = calculatePi(number1);
        end = System.currentTimeMillis();
        System.out.println("Number of generate points: " + number1 + "|  pi: " + pi + "|   time: " + (end - start));

        start = System.currentTimeMillis();
        pi = calculatePiInParallel(number1, 3);
        end = System.currentTimeMillis();
        System.out.println("Number of generate points: " + number1 + "|  pi: " + pi + "|   time: " + (end - start));
    }
}
