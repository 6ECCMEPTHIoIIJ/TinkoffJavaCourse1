package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task8 {
    private final static int KNIGHT_LONG_MOVE_DISTANCE = 2;
    private final static int KNIGHT_SHORT_MOVE_DISTANCE = 1;

    private Task8() {

    }

    private static boolean isKnightOverlapped(boolean @NotNull [][] desk, int dX, int dY) {
        int leftShift = Math.max(0, -dX);
        int rightShift = Math.max(0, dX);
        for (int y = 0; y < desk.length - dY; ++y) {
            for (int x = leftShift; x < desk[0].length - rightShift; ++x) {
                if (desk[y][x] && desk[y + dY][x + dX]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean knightBoardCapture(boolean[][] desk)
        throws NullPointerException {
        if (desk == null) {
            throw new NullPointerException();
        }

        return !isKnightOverlapped(desk, -KNIGHT_LONG_MOVE_DISTANCE, KNIGHT_SHORT_MOVE_DISTANCE)
            && !isKnightOverlapped(desk, -KNIGHT_SHORT_MOVE_DISTANCE, KNIGHT_LONG_MOVE_DISTANCE)
            && !isKnightOverlapped(desk, KNIGHT_SHORT_MOVE_DISTANCE, KNIGHT_LONG_MOVE_DISTANCE)
            && !isKnightOverlapped(desk, KNIGHT_LONG_MOVE_DISTANCE, KNIGHT_SHORT_MOVE_DISTANCE);
    }
}
