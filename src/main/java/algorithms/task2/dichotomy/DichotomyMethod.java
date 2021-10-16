package algorithms.task2.dichotomy;

import algorithms.task2.Function;

import java.util.ArrayList;
import java.util.List;

public class DichotomyMethod {
    public static List<DichotomyResult> processFunction(Function function, double beginInterval, double endInterval, double eps,
            double delta) {
        List<DichotomyResult> result = new ArrayList<>();
        int iteration = 0;
        int invoke = 0;
        do {
            double x1 = (beginInterval + endInterval - delta) / 2;
            double x2 = (beginInterval + endInterval + delta) / 2;

            double f1 = function.calculate(x1);
            double f2 = function.calculate(x2);

            if (f1 <= f2) {
                endInterval = x2;
            } else {
                beginInterval = x1;
            }
            iteration++;
            invoke += 2;

            result.add(
                    DichotomyResult.of(iteration, invoke, beginInterval, endInterval, difference(beginInterval, endInterval), x1, x2, f1, f2));
        } while (difference(beginInterval, endInterval) > eps);
        return result;
    }

    private static double difference(double beginInterval, double endInterval) {
        return (endInterval - beginInterval) / 2;
    }
}
