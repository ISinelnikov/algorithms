package algorithms.task2;

public class MethodResult {
    private final double x1;
    private final double x2;
    private final double f1;
    private final double f2;

    public MethodResult(double x1, double x2, double f1, double f2) {
        this.x1 = x1;
        this.x2 = x2;
        this.f1 = f1;
        this.f2 = f2;
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
        return "MethodResult{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", f1=" + f1 +
                ", f2=" + f2 +
                '}';
    }

    public static MethodResult of(double x1, double x2, double f1, double f2) {
        return new MethodResult(x1, x2, f1, f2);
    }
}
