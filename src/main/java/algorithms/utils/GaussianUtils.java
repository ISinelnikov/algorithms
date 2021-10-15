package algorithms.utils;

import java.util.Random;

public final class GaussianUtils {
    private GaussianUtils() {
    }

    public static GaussianData[] generateGaussianData(int size) {
        GaussianData[] result = new GaussianData[size];

        Random random = new Random();
        double a = random.nextGaussian();
        double b = random.nextGaussian();

        for (int idx = 0; idx < size; idx++) {
            double x = idx / 100.;
            double y = a * x + b + random.nextGaussian();

            result[idx] = GaussianData.of(a, b, x, y);
        }

        return result;
    }

    public static class GaussianData {
        private final double a;
        private final double b;

        private final double x;
        private final double y;

        private GaussianData(double a, double b, double x, double y) {
            this.a = a;
            this.b = b;
            this.x = x;
            this.y = y;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public static GaussianData of(double a, double b, double x, double y) {
            return new GaussianData(a, b, x, y);
        }
    }
}
