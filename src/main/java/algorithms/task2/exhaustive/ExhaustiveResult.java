package algorithms.task2.exhaustive;

public class ExhaustiveResult {
    private final int iteration;
    private final double x;
    private final double f;

    private ExhaustiveResult(int iteration, double x, double f) {
        this.iteration = iteration;
        this.x = x;
        this.f = f;
    }

    public int getIteration() {
        return iteration;
    }

    public double getX() {
        return x;
    }

    public double getF() {
        return f;
    }

    @Override
    public String toString() {
        return "{" +
                "iteration=" + iteration +
                ", x=" + x +
                ", f=" + f +
                '}';
    }

    public static ExhaustiveResult of(int iteration, double x, double f) {
        return new ExhaustiveResult(iteration, x, f);
    }
}
