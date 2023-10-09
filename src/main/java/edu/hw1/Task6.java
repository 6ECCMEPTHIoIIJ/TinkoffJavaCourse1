package edu.hw1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Task6 {
    private final static int CONST_K = 6174;
    private final static int MAX_FOUR_DIGIT_NUMBER = 9999;
    private final static int MIN_FOUR_DIGIT_NUMBER = 1000;

    private final static int FOUR_DIGIT_NUMBER_DIGITS_COUNT = 4;

    private final static int DECIMAL_BASE = 10;

    private Task6() {

    }

    private static boolean hasNumberDifferentDigits(int num) {
        int numCopy = num;
        int firstDigit = num % DECIMAL_BASE;
        numCopy /= DECIMAL_BASE;
        for (int i = num; i > 0; i /= DECIMAL_BASE) {
            int digit = numCopy % DECIMAL_BASE;

            if (digit != firstDigit) {
                return true;
            }
        }

        return false;
    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        int direct = num;
        for (int i = 0; i < FOUR_DIGIT_NUMBER_DIGITS_COUNT; ++i) {
            reversed = reversed * DECIMAL_BASE + direct % DECIMAL_BASE;
            direct /= DECIMAL_BASE;
        }

        return reversed;
    }

    private static int getNextNum(int num) {
        byte[] digits = Integer.valueOf(num).toString().getBytes();
        Arrays.sort(digits);
        int leftNum = Integer.parseInt(new String(digits, StandardCharsets.UTF_8));

        return reverseNumber(leftNum) - leftNum;
    }

    public static int countK(int num) {
        if ((num <= MIN_FOUR_DIGIT_NUMBER || num > MAX_FOUR_DIGIT_NUMBER) && hasNumberDifferentDigits(num)) {
            return -1;
        }

        return countNextK(num, 0);
    }

    private static int countNextK(int num, int count) {
        if (num == CONST_K) {
            return count;
        }

        return countNextK(getNextNum(num), count + 1);
    }
}
