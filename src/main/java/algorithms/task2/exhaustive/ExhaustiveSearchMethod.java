package algorithms.task2.exhaustive;

import algorithms.task2.Function;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearchMethod {
    public static List<ExhaustiveResult> processFunction(Function function, double beginInterval, double endInterval, double eps) {
        List<ExhaustiveResult> result = new ArrayList<>();
        int k = (int) ((endInterval - beginInterval) / eps);
        System.out.println(k);
        for (int idx = 0; idx <= k; idx++) {
            double x = beginInterval + idx * ((endInterval - beginInterval) / k);
            double f = function.calculate(x);
            result.add(ExhaustiveResult.of(idx, x, f));
        }
        return result;
    }
}
