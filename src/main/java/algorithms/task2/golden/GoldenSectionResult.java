package algorithms.task2.golden;

public class GoldenSectionResult {
    private final int iteration;
    private final int invoke;
    private final double beginInterval;
    private final double endInterval;
    private final double x1;
    private final double x2;
    private final double f1;
    private final double f2;

    public GoldenSectionResult(int iteration, int invoke, double beginInterval, double endInterval,
            double x1, double x2, double f1, double f2) {
        this.iteration = iteration;
        this.invoke = invoke;
        this.beginInterval = beginInterval;
        this.endInterval = endInterval;
        this.x1 = x1;
        this.x2 = x2;
        this.f1 = f1;
        this.f2 = f2;
    }

    public int getIteration() {
        return iteration;
    }

    public int getInvoke() {
        return invoke;
    }

    public double getBeginInterval() {
        return beginInterval;
    }

    public double getEndInterval() {
        return endInterval;
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

    public double getX() {
        return (beginInterval + endInterval) / 2;
    }

    @Override
    public String toString() {
        return "{" +
                "beginInterval=" + beginInterval +
                ", endInterval=" + endInterval +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }

    public static GoldenSectionResult of(int iteration, int invoke, double beginInterval, double endInterval,
            double x1, double x2, double f1, double f2) {
        return new GoldenSectionResult(iteration, invoke, beginInterval, endInterval, x1, x2, f1, f2);
    }
}
