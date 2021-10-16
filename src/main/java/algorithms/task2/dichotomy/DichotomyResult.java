package algorithms.task2.dichotomy;

public class DichotomyResult {
    private final int iteration;
    private final int invoke;
    private final double beginInterval;
    private final double endInterval;
    private final double difference;
    private final double x1;
    private final double x2;
    private final double f1;
    private final double f2;

    public DichotomyResult(int iteration, int invoke, double beginInterval, double endInterval, double difference, double x1,
            double x2, double f1, double f2) {
        this.iteration = iteration;
        this.invoke = invoke;
        this.beginInterval = beginInterval;
        this.endInterval = endInterval;
        this.difference = difference;
        this.x1 = x1;
        this.x2 = x2;
        this.f1 = f1;
        this.f2 = f2;
    }

    public int getIteration() {
        return iteration;
    }

    public int getInvoke() {
        return invoke + 1;
    }

    public double getBeginInterval() {
        return beginInterval;
    }

    public double getEndInterval() {
        return endInterval;
    }

    public double getDifference() {
        return difference;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getF1() {
        return f1;
    }

    public double getF2() {
        return f2;
    }

    @Override
    public String toString() {
        return "{" +
                "beginInterval=" + beginInterval +
                ", endInterval=" + endInterval +
                ", difference=" + difference +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }

    public static DichotomyResult of(int iteration, int invoke, double beginInterval, double endInterval, double difference,
            double x1, double x2, double f1, double f2) {
        return new DichotomyResult(iteration, invoke, beginInterval, endInterval, difference, x1, x2, f1, f2);
    }
}
