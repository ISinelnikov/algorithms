package algorithms.task2;

import algorithms.task2.exhaustive.ExhaustiveResult;
import algorithms.task2.exhaustive.ExhaustiveSearchMethod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Test {
    private static final double EPS = 0.001;

    private static double firstFunction(double x) {
        return x * x * x;
    }

    private static double secondFunction(double x) {
        return Math.abs(x - 0.2);
    }

    private static double thirdFunction(double x) {
        return x * Math.sin(1 / x);
    }

    public static void main(String[] args) throws IOException {
        exhaustiveSearchResults();
    }

    private static void exhaustiveSearchResults() throws IOException {
        List<ExhaustiveResult> exhaustiveSearchFirstFunctionResult = ExhaustiveSearchMethod.processFunction(Test::firstFunction, 0.,
                1., EPS);
        ExhaustiveResult exhaustiveResult = exhaustiveSearchFirstFunctionResult.stream()
                .min(Comparator.comparingDouble(ExhaustiveResult::getF))
                .orElse(null);
        System.out.println("First function result: " + exhaustiveResult);
        generateFileExhaustiveSearchResults("exhaustive-search-first-function-result.csv", exhaustiveSearchFirstFunctionResult);

        List<ExhaustiveResult> exhaustiveSearchSecondFunctionResult = ExhaustiveSearchMethod.processFunction(Test::secondFunction, 0.,
                1., EPS);
        exhaustiveResult = exhaustiveSearchSecondFunctionResult.stream()
                .min(Comparator.comparingDouble(ExhaustiveResult::getF))
                .orElse(null);
        System.out.println("Second function result: " + exhaustiveResult);
        generateFileExhaustiveSearchResults("exhaustive-search-second-function-result.csv", exhaustiveSearchSecondFunctionResult);

        List<ExhaustiveResult> exhaustiveSearchThirdFunctionResult = ExhaustiveSearchMethod.processFunction(Test::thirdFunction, 0.01,
                1., EPS);
        exhaustiveResult = exhaustiveSearchThirdFunctionResult.stream()
                .min(Comparator.comparingDouble(ExhaustiveResult::getF))
                .orElse(null);
        System.out.println("Third function result: " + exhaustiveResult);
        generateFileExhaustiveSearchResults("exhaustive-search-third-function-result.csv", exhaustiveSearchThirdFunctionResult);
    }

    private static void dichotomyResults() {
        DichotomyMethod.processFunction(Test::firstFunction, 0., 1., EPS, 0);
        DichotomyMethod.processFunction(Test::secondFunction, 0., 1., EPS, EPS / 2);
        DichotomyMethod.processFunction(Test::thirdFunction, 0.01, 1, EPS, EPS / 2);
    }

    private static void goldenSectionResults() {
        GoldenSectionMethod.processFunction(Test::firstFunction, 0., 1., EPS);
        GoldenSectionMethod.processFunction(Test::secondFunction, 0., 1., EPS);
        GoldenSectionMethod.processFunction(Test::thirdFunction, 0.01, .1, EPS);
    }

    private static void generateFileExhaustiveSearchResults(String fileName, List<ExhaustiveResult> results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String title = "<ITERATION>, <X>, <F>\n";
        writer.write(title);

        for (ExhaustiveResult exhaustiveResult : results) {
            writer.write(String.format("%d, %s, %s\n",
                    exhaustiveResult.getIteration(),
                    BigDecimal.valueOf(exhaustiveResult.getX()),
                    BigDecimal.valueOf(exhaustiveResult.getF())
            ));
        }
        writer.close();
    }
}
