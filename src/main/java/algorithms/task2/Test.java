package algorithms.task2;

import java.util.List;

public class Test {
    private static final double BEGIN_INTERVAL_VALUE = 0.;
    private static final double END_INTERVAL_VALUE = 1.;
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

    public static void main(String[] args) {
        List<MethodResult> firstFunctionResult = DichotomyMethod.processFunction(Test::firstFunction, BEGIN_INTERVAL_VALUE,
                END_INTERVAL_VALUE, EPS, 0);
        //DichotomyMethod.processFunction(Test::secondFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS, EPS / 2);
        //DichotomyMethod.processFunction(Test::thirdFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS, EPS / 2);

        //System.out.println(firstFunctionResult);

        //ExhaustiveSearchMethod.processFunction(Test::firstFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS);
        List<MethodResult> results = GoldenSectionMethod.processFunction(Test::firstFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE,
                EPS);
        System.out.println(results);

        //ExhaustiveSearchMethod.processFunction(Test::secondFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS);
        //GoldenSectionMethod.processFunction(Test::secondFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS);

        //ExhaustiveSearchMethod.processFunction(Test::thirdFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS);
        //GoldenSectionMethod.processFunction(Test::thirdFunction, BEGIN_INTERVAL_VALUE, END_INTERVAL_VALUE, EPS);
    }
}
