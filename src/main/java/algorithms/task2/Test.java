package algorithms.task2;

import algorithms.task2.dichotomy.DichotomyMethod;
import algorithms.task2.dichotomy.DichotomyResult;
import algorithms.task2.exhaustive.ExhaustiveResult;
import algorithms.task2.exhaustive.ExhaustiveSearchMethod;
import algorithms.task2.golden.GoldenSectionMethod;
import algorithms.task2.golden.GoldenSectionResult;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class Test {
    private static final double EPS = 0.001;

    private static double firstFunction(double x) {
        return Math.pow(x, 3);
    }

    private static double secondFunction(double x) {
        return Math.abs(x - 0.2);
    }

    private static double thirdFunction(double x) {
        return x * Math.sin(1 / x);
    }

    public static void main(String[] args) throws IOException {
        //exhaustiveSearchResults();
        //dichotomyResults();
        goldenSectionResults();
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

    private static void dichotomyResults() throws IOException {
        List<DichotomyResult> firstFunctionResults = DichotomyMethod.processFunction(Test::firstFunction, 0., 1., EPS, EPS / 2);
        DichotomyResult firstFunctionDichotomyResult = firstFunctionResults.get(firstFunctionResults.size() - 1);
        double firstFunctionX = (firstFunctionDichotomyResult.getBeginInterval() + firstFunctionDichotomyResult.getEndInterval()) / 2;
        double firstFunctionF = firstFunction(firstFunctionX);
        System.out.println("First function result: x(" + BigDecimal.valueOf(firstFunctionF).toPlainString() + "), f("
                + BigDecimal.valueOf(firstFunctionF).toPlainString() + ")");

        generateFileDichotomyResults("dichotomy-first-function-result.csv", firstFunctionResults);

        List<DichotomyResult> secondFunctionResults = DichotomyMethod.processFunction(Test::secondFunction, 0., 1., EPS, EPS / 2);
        DichotomyResult secondFunctionDichotomyResult = secondFunctionResults.get(secondFunctionResults.size() - 1);
        double secondFunctionX = (secondFunctionDichotomyResult.getBeginInterval() + secondFunctionDichotomyResult.getEndInterval())
                / 2;
        double secondFunctionF = secondFunction(secondFunctionX);
        System.out.println("Second function result: x(" + BigDecimal.valueOf(secondFunctionX).toPlainString() + "), f("
                + BigDecimal.valueOf(secondFunctionF).toPlainString() + ")");

        generateFileDichotomyResults("dichotomy-second-function-result.csv", secondFunctionResults);

        List<DichotomyResult> thirdFunctionResult = DichotomyMethod.processFunction(Test::thirdFunction, 0.01, 1, EPS, EPS - 0.0001);
        DichotomyResult thirdFunctionDichotomyResult = thirdFunctionResult.get(thirdFunctionResult.size() - 1);
        double thirdFunctionX = (thirdFunctionDichotomyResult.getBeginInterval() + thirdFunctionDichotomyResult.getEndInterval()) / 2;
        double thirdFunctionF = thirdFunction(thirdFunctionX);
        System.out.println("Third function result: x(" + BigDecimal.valueOf(thirdFunctionX).toPlainString() + "), f("
                + BigDecimal.valueOf(thirdFunctionF).toPlainString() + ")");

        generateFileDichotomyResults("dichotomy-third-function-result.csv", thirdFunctionResult);
    }

    private static void goldenSectionResults() {
        List<GoldenSectionResult> firstFunctionResults = GoldenSectionMethod.processFunction(Test::firstFunction, 0., 1., EPS);
        firstFunctionResults.forEach(System.out::println);
        //GoldenSectionMethod.processFunction(Test::secondFunction, 0., 1., EPS);
        //GoldenSectionMethod.processFunction(Test::thirdFunction, 0.01, .1, EPS);
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

    private static void generateFileDichotomyResults(String fileName, List<DichotomyResult> results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String title = "<ITERATION>, <INVOKE>, <BEGIN_INTERVAL>, <END_INTERVAL>, <DIFFERENCE>, <X1>, <X2>, <F1>, <F2>\n";
        writer.write(title);

        for (DichotomyResult dichotomyResult : results) {
            writer.write(String.format("%d, %d, %s, %s, %s, %s, %s, %s, %s\n",
                    dichotomyResult.getIteration(),
                    dichotomyResult.getInvoke(),
                    BigDecimal.valueOf(dichotomyResult.getBeginInterval()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getEndInterval()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getDifference()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getX1()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getX2()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getF1()).toPlainString(),
                    BigDecimal.valueOf(dichotomyResult.getF2()).toPlainString()
            ));
        }
        writer.close();
    }
}
