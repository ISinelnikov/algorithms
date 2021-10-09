package algorithms.empirical.analysis;

import algorithms.empirical.analysis.fist.BubbleSortOfElements;
import algorithms.empirical.analysis.fist.ConstantFunctionOfElements;
import algorithms.empirical.analysis.fist.MultiplicationOfElements;
import algorithms.empirical.analysis.fist.PolynomialValueOfElements;
import algorithms.empirical.analysis.fist.QuickSortOfElements;
import algorithms.empirical.analysis.fist.SumOfElements;
import algorithms.empirical.analysis.fist.TimsortOfElements;
import algorithms.empirical.analysis.second.MultiplicationOfMatrix;
import algorithms.utils.ElementUtils;
import algorithms.utils.MatrixUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpiricalAnalysisTest {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 2000;
    private static final int MAX_MATRIX_SIZE = 200;

    public static void main(String[] args) throws IOException {
        generateConstantFunctionOfElementsExecutionTime();
        generateSumOfElementsExecutionTime();
        generateMultiplicationOfElementsExecutionTime();
        generateBubbleSortOfElementsExecutionTime();
        generateMultiplicationOfMatrixExecutionTime();
        generateQuickSortOfElementsExecutionTime();
        generateTimSortOfElementsExecutionTime();
        generateNaivePolynomialValueOfElementsExecutionTime();
        generateHornerPolynomialValueOfElementsExecutionTime();
    }

    private static void generateConstantFunctionOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    ConstantFunctionOfElements.getConstantFunctionOfElementsExecutionTime(array),
                    ConstantFunctionOfElements.getConstantFunctionOfElementsExecutionTime(array),
                    ConstantFunctionOfElements.getConstantFunctionOfElementsExecutionTime(array),
                    ConstantFunctionOfElements.getConstantFunctionOfElementsExecutionTime(array),
                    ConstantFunctionOfElements.getConstantFunctionOfElementsExecutionTime(array)
            ));
        }
        generateFileWithResults("constant-function-of-elements-execution-time.csv", executionResults);
    }

    private static void generateNaivePolynomialValueOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    PolynomialValueOfElements.getNaivePolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getNaivePolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getNaivePolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getNaivePolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getNaivePolynomialValueOfElementsExecutionTime(array)
            ));
        }
        generateFileWithResults("naive-polynomial-value-of-elements-execution-time.csv", executionResults);
    }

    private static void generateHornerPolynomialValueOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    PolynomialValueOfElements.getHornerPolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getHornerPolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getHornerPolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getHornerPolynomialValueOfElementsExecutionTime(array),
                    PolynomialValueOfElements.getHornerPolynomialValueOfElementsExecutionTime(array)
            ));
        }
        generateFileWithResults("horner-polynomial-value-of-elements-execution-time.csv", executionResults);
    }

    private static void generateSumOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    SumOfElements.getSumOfElementsExecutionTime(array),
                    SumOfElements.getSumOfElementsExecutionTime(array),
                    SumOfElements.getSumOfElementsExecutionTime(array),
                    SumOfElements.getSumOfElementsExecutionTime(array),
                    SumOfElements.getSumOfElementsExecutionTime(array)
            ));
        }
        generateFileWithResults("sum-of-elements-execution-time.csv", executionResults);
    }

    private static void generateMultiplicationOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    MultiplicationOfElements.getMultiplicationOfElementsExecutionTime(array),
                    MultiplicationOfElements.getMultiplicationOfElementsExecutionTime(array),
                    MultiplicationOfElements.getMultiplicationOfElementsExecutionTime(array),
                    MultiplicationOfElements.getMultiplicationOfElementsExecutionTime(array),
                    MultiplicationOfElements.getMultiplicationOfElementsExecutionTime(array)
            ));
        }
        generateFileWithResults("multiplication-of-elements-execution-time.csv", executionResults);
    }

    private static void generateBubbleSortOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    BubbleSortOfElements.getBubbleSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    BubbleSortOfElements.getBubbleSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    BubbleSortOfElements.getBubbleSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    BubbleSortOfElements.getBubbleSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    BubbleSortOfElements.getBubbleSortOfElementsExecutionTime(ElementUtils.copyOfArray(array))
            ));
        }
        generateFileWithResults("bubble-sort-of-elements-execution-time.csv", executionResults);
    }

    private static void generateQuickSortOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    QuickSortOfElements.getQuickSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    QuickSortOfElements.getQuickSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    QuickSortOfElements.getQuickSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    QuickSortOfElements.getQuickSortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    QuickSortOfElements.getQuickSortOfElementsExecutionTime(ElementUtils.copyOfArray(array))
            ));
        }
        generateFileWithResults("quick-sort-of-elements-execution-time.csv", executionResults);
    }

    private static void generateTimSortOfElementsExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_SIZE; size++) {
            int[] array = ElementUtils.generateRandomArray(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    TimsortOfElements.getTimsortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    TimsortOfElements.getTimsortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    TimsortOfElements.getTimsortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    TimsortOfElements.getTimsortOfElementsExecutionTime(ElementUtils.copyOfArray(array)),
                    TimsortOfElements.getTimsortOfElementsExecutionTime(ElementUtils.copyOfArray(array))
            ));
        }
        generateFileWithResults("tim-sort-of-elements-execution-time.csv", executionResults);
    }

    private static void generateMultiplicationOfMatrixExecutionTime() throws IOException {
        List<ExecutionResult> executionResults = new ArrayList<>();
        for (int size = MIN_SIZE; size <= MAX_MATRIX_SIZE; size++) {
            System.out.println("Iteration: " + size);
            int[][] firstMatrix = MatrixUtils.generateRandomMatrix(size);
            int[][] secondMatrix = MatrixUtils.generateRandomMatrix(size);
            executionResults.add(ExecutionResult.of(
                    size,
                    MultiplicationOfMatrix.getMultiplicationOfMatrixExecutionTime(size, firstMatrix, secondMatrix),
                    MultiplicationOfMatrix.getMultiplicationOfMatrixExecutionTime(size, firstMatrix, secondMatrix),
                    MultiplicationOfMatrix.getMultiplicationOfMatrixExecutionTime(size, firstMatrix, secondMatrix),
                    MultiplicationOfMatrix.getMultiplicationOfMatrixExecutionTime(size, firstMatrix, secondMatrix),
                    MultiplicationOfMatrix.getMultiplicationOfMatrixExecutionTime(size, firstMatrix, secondMatrix)
            ));
        }
        generateFileWithResults("multiplication-of-matrix-execution-time.csv", executionResults);
    }

    private static void generateFileWithResults(String fileName, List<ExecutionResult> executionResults) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String title = "<SIZE>, <EXECUTION_TIME_1>, <EXECUTION_TIME_2>, <EXECUTION_TIME_3>, "
                + "<EXECUTION_TIME_4>, <EXECUTION_TIME_5>, <AVG>\n";
        writer.write(title);

        for (ExecutionResult executionResult: executionResults) {
            writer.write(String.format("%d, %d, %d, %d, %d, %d, %d\n",
                    executionResult.getSizeOfArray(),
                    executionResult.getExecutionTime1(),
                    executionResult.getExecutionTime2(),
                    executionResult.getExecutionTime3(),
                    executionResult.getExecutionTime4(),
                    executionResult.getExecutionTime5(),
                    executionResult.getAvgExecutionTime()
            ));
        };
        writer.close();
    }
}
