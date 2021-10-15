package algorithms.utils;

public final class MatrixUtils {
    private MatrixUtils() {
    }

    public static int[][] generateRandomMatrix(int size) {
        int[][] result = new int[size][];
        for (int rowIdx = 0; rowIdx < size; rowIdx++) {
            result[rowIdx] = new int[size];
            for (int cellIdx = 0; cellIdx < size; cellIdx++) {
                result[rowIdx][cellIdx] = RandomUtils.getRandomElement();
            }
        }
        return result;
    }
}
