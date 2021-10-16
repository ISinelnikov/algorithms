package algorithms.task2.golden;

import algorithms.task2.Function;

import java.util.ArrayList;
import java.util.List;

public class GoldenSectionMethod {
    private static final double MULTIPLIER = (1 + Math.sqrt(5)) / 2;

    public static List<GoldenSectionResult> processFunction(Function function, double a, double b, double eps) {
        List<GoldenSectionResult> result = new ArrayList<>();

        double x1, x2;
        while (true) {
            x1 = b - (b - a) / MULTIPLIER;
            x2 = a + (b - a) / MULTIPLIER;
            if (function.calculate(x1) >= function.calculate(x2)) {
                a = x1;
            } else {
                b = x2;
            }

            result.add(GoldenSectionResult.of(a, b, x1, x2, function.calculate(x1), function.calculate(x2)));

            if (Math.abs(b - a) < eps) {
                break;
            }
        }

        return result;
    }

    private static double difference(double beginInterval, double endInterval) {
        return Math.abs(endInterval - beginInterval);
    }
}
