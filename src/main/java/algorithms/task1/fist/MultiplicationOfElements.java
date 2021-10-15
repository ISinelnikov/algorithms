package algorithms.task1.fist;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiplicationOfElements {
    public static long getMultiplicationOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        BigInteger result = getMultiplicationOfElements(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        return endTime - startTime;
    }

    private static BigInteger getMultiplicationOfElements(int[] elements) {
        BigInteger result = BigInteger.ONE;
        for (int element : elements) {
            result = result.multiply(BigInteger.valueOf(element));
        }
        return result;
    }
}
