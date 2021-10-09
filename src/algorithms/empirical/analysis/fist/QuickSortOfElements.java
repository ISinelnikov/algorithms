package algorithms.empirical.analysis.fist;

import java.util.Arrays;

public class QuickSortOfElements {
    public static long getQuickSortOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        quickSort(elements, 0, elements.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Result: " + Arrays.toString(elements));
        return endTime - startTime;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int supportingElement = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < supportingElement) {
                i++;
            }

            while (array[j] > supportingElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }
}
