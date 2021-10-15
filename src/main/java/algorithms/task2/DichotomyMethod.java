package algorithms.task2;

import java.util.ArrayList;
import java.util.List;

public class DichotomyMethod {
    public static List<MethodResult> processFunction(Function function, double beginInterval, double endInterval, double eps,
            double delta) {
        List<MethodResult> result = new ArrayList<>();
        do {
            double x1 = (beginInterval + endInterval - delta) / 2;
            double x2 = (beginInterval + endInterval + delta) / 2;

            double f1 = function.calculate(x1);
            double f2 = function.calculate(x2);

            result.add(MethodResult.of(x1, x2, f1, f2));

            if (f1 <= f2) {
                endInterval = x2;
            } else {
                beginInterval = x1;
            }
        } while (Math.abs(beginInterval - endInterval) > eps);
        return result;
    }
}
