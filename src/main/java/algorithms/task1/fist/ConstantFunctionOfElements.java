package algorithms.task1.fist;

import java.util.Arrays;

public class ConstantFunctionOfElements {
    public static long getConstantFunctionOfElementsExecutionTime(int[] elements) {
        System.out.println("Array: " + Arrays.toString(elements));
        long startTime = System.nanoTime();
        int result = getConstantFunctionOfElementsResult(elements);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        return endTime - startTime;
    }

    private static int getConstantFunctionOfElementsResult(int[] elements) {
        return 1;
    }
}
