package edu.hw1;

public class Task7 {
    private Task7() {
    }

    private static int countBits(int num) {
        int count = 0;
        int numCopy = num;
        do {
            ++count;
            numCopy >>= 1;
        } while (numCopy > 0);

        return count;
    }

    private static int rotate(int num, int shift, boolean leftRotation) {
        if (num < 0) {
            return -1;
        }

        if (shift < 0) {
            return rotate(num, -shift, !leftRotation);
        }

        int nBits = countBits(num);
        int clampedShift = shift % nBits;
        return ((1 << nBits) - 1) & ((leftRotation)
            ? ((num << clampedShift) | (num >> (nBits - clampedShift)))
            : ((num >> clampedShift) | (num << (nBits - clampedShift))));
    }

    public static int rotateLeft(int num, int shift) {
        return rotate(num, shift, true);
    }

    public static int rotateRight(int num, int shift) {
        return rotate(num, shift, false);
    }
}
