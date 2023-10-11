package edu.hw1;

public final class Task2 {
    private final static int DECIMAL_BASE = 10;

    private Task2() {
    }

    public static int countDigits(int num) {
        if (num < 0) {
            return -1;
        }

        int count = 0;
        int numCopy = num;
        do {
            ++count;
            numCopy /= DECIMAL_BASE;
        } while (numCopy > 0);

        return count;
    }
}
