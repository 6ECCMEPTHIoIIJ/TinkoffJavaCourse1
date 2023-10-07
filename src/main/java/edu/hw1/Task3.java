package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] left, int[] right)
        throws NullPointerException, IllegalArgumentException  {
        if (left == null || right == null) {
            throw new NullPointerException();
        }

        if (left.length == 0 || right.length == 0) {
            throw new IllegalArgumentException();
        }

        MinMax leftMinMax = getMinMax(left);
        MinMax rightMinMax = getMinMax(right);

        return leftMinMax.min > rightMinMax.min
            && leftMinMax.max < rightMinMax.max;
    }

    private static MinMax getMinMax(int @NotNull [] a) {
        int min = a[0];
        int max = a[0];
        for (var el : a) {
            if (el < min) {
                min = el;
            } else if (el > max) {
                max = el;
            }
        }

        return new MinMax(min, max);
    }

    private record MinMax(int min, int max) {
    }
}
