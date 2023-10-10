package edu.hw1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Task6 {
    private final static int CONST_K = 6174;
    private final static int MAX_FOUR_DIGIT_NUMBER = 9999;
    private final static int MIN_FOUR_DIGIT_NUMBER = 1000;

    private final static int NUM_OF_ONES = 1111;
    private final static int NUM_OF_TWOS = 2222;
    private final static int NUM_OF_TRIPLETS = 3333;
    private final static int NUM_OF_FOURS = 4444;
    private final static int NUM_OF_FIVES = 5555;
    private final static int NUM_OF_SIXES = 6666;
    private final static int NUM_OF_SEVENS = 7777;
    private final static int NUM_OF_EIGHTS = 8888;
    private final static int NUM_OF_NINES = 9999;

    private final static int FOUR_DIGIT_NUMBER_DIGITS_COUNT = 4;

    private final static int DECIMAL_BASE = 10;

    private Task6() {

    }

    private static boolean hasNumberAllDifferentDigits(int num) {
        return num != NUM_OF_ONES
            && num != NUM_OF_TWOS
            && num != NUM_OF_TRIPLETS
            && num != NUM_OF_FOURS
            && num != NUM_OF_FIVES
            && num != NUM_OF_SIXES
            && num != NUM_OF_SEVENS
            && num != NUM_OF_EIGHTS
            && num != NUM_OF_NINES;
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
        if (num <= MIN_FOUR_DIGIT_NUMBER
            || num > MAX_FOUR_DIGIT_NUMBER
            || !hasNumberAllDifferentDigits(num)) {
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
