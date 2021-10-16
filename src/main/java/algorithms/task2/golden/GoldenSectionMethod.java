package algorithms.task2.golden;

import algorithms.task2.Function;

import java.util.ArrayList;
import java.util.List;

public class GoldenSectionMethod {
    private static final double MULTIPLIER = (1 + Math.sqrt(5)) / 2;

    public static List<GoldenSectionResult> processFunction(Function function, double beginInterval, double endInterval, double eps) {
        List<GoldenSectionResult> result = new ArrayList<>();

        double x1, x2;
        do {
            x1 = endInterval - (endInterval - beginInterval) / MULTIPLIER;
            x2 = beginInterval + (endInterval - beginInterval) / MULTIPLIER;
            if (function.calculate(x1) >= function.calculate(x2)) {
                beginInterval = x1;
            } else {
                endInterval = x2;
            }

            result.add(GoldenSectionResult.of(beginInterval, endInterval, x1, x2, function.calculate(x1), function.calculate(x2)));

        } while (!(Math.abs(endInterval - beginInterval) < eps));

        return result;
    }
}
