package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    @ParameterizedTest
    @DisplayName("Проверка незахваченной доски")
    @MethodSource("nonCapturedDeskProviderFactory")
    public void checkNonCapturedDesk(DeskTestArgs desk) {
        assertThat(Task8.knightBoardCapture(desk.given))
            .isEqualTo(desk.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка зфхваченной доски")
    @MethodSource("capturedDeskProviderFactory")
    public void checkCapturedDesk(DeskTestArgs desk) {
        assertThat(Task8.knightBoardCapture(desk.given))
            .isEqualTo(desk.expected);
    }

    @Test
    @DisplayName("Проверка null доски")
    public void checkNullDesk() {
        Throwable throwable = assertThrows(
            IllegalArgumentException.class,
            () -> Task8.knightBoardCapture(null)
        );

        assertNotNull(throwable);
    }

    static @NotNull Stream<DeskTestArgs> nonCapturedDeskProviderFactory() {
        return Stream.of(
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, true),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, true, false},
                {false, true, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, true, false, false, false, true, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false}}, true),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, true, false, false, false, true, false, false},
                {false, false, false, false, true, false, true, false},
                {false, true, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, true},
                {false, false, false, false, true, false, false, false}}, true),
            new DeskTestArgs(new boolean[][] {
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true}}, true)
        );
    }

    static @NotNull Stream<DeskTestArgs> capturedDeskProviderFactory() {
        return Stream.of(
            new DeskTestArgs(new boolean[][] {
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {false, false, false, false, true, false, true, false},
                {false, false, true, false, false, true, false, true},
                {true, false, false, false, true, false, true, false},
                {false, false, false, false, false, true, false, true},
                {true, false, false, false, true, false, true, false},
                {false, false, false, true, false, true, false, true}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, true, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, false, true, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, false, false, false, true, false, false},
                {true, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, true, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {true, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, true}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, true}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, true, false, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, true, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false, false},
                {true, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, true, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false}}, false),
            new DeskTestArgs(new boolean[][] {
                {false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}}, false)
        );
    }

    public record DeskTestArgs(boolean[][] given, boolean expected) {
    }
}
