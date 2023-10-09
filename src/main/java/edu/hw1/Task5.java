package edu.hw1;

public class Task5 {

    private final static int MIN_TWO_DIGIT_NUMBER = 10;
    private final static int DECIMAL_BASE = 10;

    private Task5() {

    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        for (int direct = num; direct > 0; direct /= DECIMAL_BASE) {
            reversed = reversed * DECIMAL_BASE + direct % DECIMAL_BASE;
        }

        return reversed;
    }

    private static boolean isPalindrome(int num) {
        return num == reverseNumber(num);
    }

    private static int calculateChild(int num) {
        int child = 0;
        int shift = 1;
        int parent = num;
        while (parent > 0) {
            int right = parent % DECIMAL_BASE;
            parent /= DECIMAL_BASE;
            int left = parent % DECIMAL_BASE;
            parent /= DECIMAL_BASE;

            child += (left + right) * shift;
            shift *= DECIMAL_BASE;
        }

        return child;
    }

    public static boolean isPalindromeDescendant(int num) {
        if (isPalindrome(num)) {
            return true;
        }

        int child = calculateChild(num);

        return child >= MIN_TWO_DIGIT_NUMBER
            && isPalindromeDescendant(child);
    }
}
