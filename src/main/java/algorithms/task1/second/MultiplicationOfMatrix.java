package algorithms.task1.second;

import java.math.BigInteger;
import java.util.Arrays;

public class MultiplicationOfMatrix {
    public static long getMultiplicationOfMatrixExecutionTime(int size, int[][] firstMatrix, int[][] secondMatrix) {
        System.out.println("First matrix: ");
        for (int[] row : firstMatrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Second matrix: ");
        for (int[] row : secondMatrix) {
            System.out.println(Arrays.toString(row));
        }
        long startTime = System.nanoTime();
        BigInteger[][] result = getMultiplicationOfMatrix(size, firstMatrix, secondMatrix);
        long endTime = System.nanoTime();
        System.out.println("Result: ");
        for (BigInteger[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        return endTime - startTime;
    }

    private static BigInteger[][] getMultiplicationOfMatrix(int size, int[][] firstMatrix, int[][] secondMatrix) {
        BigInteger[][] result = new BigInteger[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = BigInteger.ZERO;
                for (int k = 0; k < size; k++) {
                    result[i][j] = result[i][j].add(
                            BigInteger.valueOf(firstMatrix[i][k]).multiply(BigInteger.valueOf(secondMatrix[k][j]))
                    );
                }
            }
        }
        return result;
    }
}
