package algorithms.utils;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {
    private static final int MIN_ELEMENT = 1;
    private static final int MAX_ELEMENT = 1000;

    private RandomUtils() {
    }

    public static int getRandomElement() {
        return ThreadLocalRandom.current().nextInt(MIN_ELEMENT, MAX_ELEMENT + 1);
    }
}
