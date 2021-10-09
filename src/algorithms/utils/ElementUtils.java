package algorithms.utils;

import java.util.Arrays;

public final class ElementUtils {
    private ElementUtils() {
    }

    public static int[] generateRandomArray(int size) {
        int[] result = new int[size];
        for (int idx = 0; idx < size; idx++) {
            result[idx] = RandomUtils.getRandomElement();
        }
        return result;
    }

    public static int[] copyOfArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }
}
