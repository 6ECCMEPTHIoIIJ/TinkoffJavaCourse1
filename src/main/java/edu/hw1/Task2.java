package edu.hw1;

public final class Task2 {
    private final static int DECIMAL_PLACE_SHIFT = 10;

    private Task2() {
    }

    public static int countDigits(int num) {
        int count = 0;
        int asbNum = Math.abs(num);
        do {
            ++count;
            asbNum /= DECIMAL_PLACE_SHIFT;
        } while (asbNum > 0);

        return count;
    }
}
