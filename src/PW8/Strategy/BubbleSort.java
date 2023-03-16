package PW8.Strategy;

import java.util.Arrays;

public class BubbleSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Соритровка пузырьком");
        System.out.println("Массив до сортировки: " + Arrays.toString(arr));
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }
}
