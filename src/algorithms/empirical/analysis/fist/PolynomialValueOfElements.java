package algorithms.empirical.analysis.fist;

import java.math.BigDecimal;
import java.util.Arrays;

public class PolynomialValueOfElements {
    private static final BigDecimal X = BigDecimal.valueOf(1.5);

    public static long getNaivePolynomialValueOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        BigDecimal result = getNaivePolynomialValueOfElementsResult(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        return endTime - startTime;
    }

    public static long getHornerPolynomialValueOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        BigDecimal result = getHornerPolynomialValueOfElementsResult(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        return endTime - startTime;
    }

    private static BigDecimal getNaivePolynomialValueOfElementsResult(int[] elements) {
        if (elements.length == 1) {
            return BigDecimal.valueOf(elements[0]);
        }

        BigDecimal result = BigDecimal.ZERO;
        for (int idx = 1; idx <= elements.length; idx++) {
            result = result.add(X.pow(idx - 1).multiply(BigDecimal.valueOf(elements[idx - 1])));
        }
        return result;
    }

    private static BigDecimal getHornerPolynomialValueOfElementsResult(int[] elements) {
        if (elements.length == 1) {
            return BigDecimal.valueOf(elements[0]);
        }

        BigDecimal result = BigDecimal.ZERO;
        for (int idx = elements.length - 1; idx >= 1; idx--) {
            result = result.add(BigDecimal.valueOf(elements[idx])).multiply(X);
        }
        return result.add(BigDecimal.valueOf(elements[0]));
    }
}
