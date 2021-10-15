package algorithms.task2;

public class ExhaustiveSearchMethod {
    public static double processFunction(Function function, double beginInterval, double endInterval, double eps) {
        int k = (int) ((endInterval - beginInterval) / eps);
        System.out.println(k);

        for (int idx = 0; idx <= k; idx++) {
            double x = beginInterval + idx * ((endInterval - beginInterval) / k);
            double f = function.calculate(x);
            System.out.println(x + "  " + f );
        }
        return 0;
    }
}
