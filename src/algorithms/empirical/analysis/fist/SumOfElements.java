package algorithms.empirical.analysis.fist;

import java.math.BigInteger;
import java.util.Arrays;

public class SumOfElements {
    public static long getSumOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        BigInteger result = getSumOfElements(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        return endTime - startTime;
    }

    private static BigInteger getSumOfElements(int[] elements) {
        BigInteger result = BigInteger.ZERO;
        for (int element : elements) {
            result = result.add(BigInteger.valueOf(element));
        }
        return result;
    }
}
