package algorithms.task2.golden;

import algorithms.task2.Function;

import java.util.ArrayList;
import java.util.List;

public class GoldenSectionMethod {
    private static final double MULTIPLIER = (1 + Math.sqrt(5)) / 2;

    public static List<GoldenSectionResult> processFunction(Function function, double beginInterval, double endInterval, double eps) {
        List<GoldenSectionResult> result = new ArrayList<>();

        int iteration = 0;
        int invoke = 0;

        double x1, x2;
        do {
            x1 = endInterval - (endInterval - beginInterval) / MULTIPLIER;
            x2 = beginInterval + (endInterval - beginInterval) / MULTIPLIER;
            double f1 = function.calculate(x1);
            double f2 = function.calculate(x2);
            if (f1 >= f2) {
                beginInterval = x1;
            } else {
                endInterval = x2;
            }
            iteration++;
            invoke += 2;

            result.add(GoldenSectionResult.of(iteration, invoke, beginInterval, endInterval, x1, x2, f1, f2));

        } while (!(Math.abs(endInterval - beginInterval) < eps));

        return result;
    }
}
