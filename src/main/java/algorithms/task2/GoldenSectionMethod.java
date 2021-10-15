package algorithms.task2;

import java.util.ArrayList;
import java.util.List;

public class GoldenSectionMethod {
    private static final double F = (1 + Math.sqrt(5)) / 2;

    public static List<MethodResult> processFunction(Function function, double beginInterval, double endInterval, double eps) {
        List<MethodResult> result = new ArrayList<>();
        do {
            double x1 = endInterval - (endInterval - beginInterval) / F;
            double x2 = beginInterval + (endInterval - beginInterval) / F;
            double f1 = function.calculate(x1);
            double f2 = function.calculate(x2);
            if (f1 <= f2) {
                endInterval = x2;
            } else {
                beginInterval = x1;
            }
            result.add(MethodResult.of(x1, x2, f1, f2));
        } while (Math.abs(endInterval - beginInterval) > eps);

        return result;
    }
}
