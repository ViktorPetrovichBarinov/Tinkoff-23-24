package edu.hw1;


public class Task3 {
    private Task3() {
    }

    /**
     * Массив arr1 может быть вложен в массив arr2, если:
     * - min(a1) больше чем min(a2)
     * - max(a1) меньше, чем max(a2)
     *
     * @param arr1  - первый массив
     * @param arr2  - второй массив
     * @return      - true если массив arr1 может быть вложен в arr2 по особым правилам,
     *              - false в обратном случае
     */
    public static boolean isNestable(int[] arr1, int[] arr2) {
        return arrayMin(arr1) > arrayMin(arr2)
                && arrayMax(arr1) < arrayMax(arr2);
    }

    //вспомогательный метод
    //находит минимум в массиве
    private static int arrayMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int elem : arr) {
            min = Integer.min(elem, min);
        }
        return min;
    }

    //вспомогательный метод
    //находит максимум в массиве
    private static int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int elem : arr) {
            max = Integer.max(elem, max);
        }
        return max;
    }
}

