package algorithms.task1.fist;

import java.util.Arrays;

public class BubbleSortOfElements {
    public static long getBubbleSortOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        bubbleSort(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + Arrays.toString(elements));
        return endTime - startTime;
    }

    public static void bubbleSort(int[] elements) {
        int length = elements.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
}
