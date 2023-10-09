package edu.hw1;

public final class Task2 {
    private final static int DECIMAL_BASE = 10;

    private Task2() {
    }

    public static int countDigits(int num) {
        int count = 0;
        int absNum = Math.abs(num);
        do {
            ++count;
            absNum /= DECIMAL_BASE;
        } while (absNum > 0);

        return count;
    }
}
