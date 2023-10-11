package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @ParameterizedTest
    @DisplayName("Проверка на левый сдвиг")
    @MethodSource("leftShiftProviderFactory")
    public void checkLeftShift(@NotNull RotationTestArgs rotation) {
        assertThat(Task7.rotateLeft(rotation.num, rotation.shift))
            .isEqualTo(rotation.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка на правый сдвиг")
    @MethodSource("rightShiftProviderFactory")
    public void checkRightShift(@NotNull RotationTestArgs rotation) {
        assertThat(Task7.rotateRight(rotation.num, rotation.shift))
            .isEqualTo(rotation.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка на левый сдвиг отрицательного числа")
    @MethodSource("negativeNumberShiftProviderFactory")
    public void checkIncorrectLeftShift(@NotNull RotationTestArgs rotation) {
        assertThat(Task7.rotateLeft(rotation.num, rotation.shift))
            .isEqualTo(rotation.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка на правый сдвиг отрицательного числа")
    @MethodSource("negativeNumberShiftProviderFactory")
    public void checkIncorrectRightShift(@NotNull RotationTestArgs rotation) {
        assertThat(Task7.rotateLeft(rotation.num, rotation.shift))
            .isEqualTo(rotation.expected);
    }

    static @NotNull Stream<RotationTestArgs> leftShiftProviderFactory() {
        return Stream.of(
            new RotationTestArgs(8, 1, 1),
            new RotationTestArgs(8, 5, 1),
            new RotationTestArgs(8, 9, 1),
            new RotationTestArgs(8, -1, 4),
            new RotationTestArgs(16, 5, 16),
            new RotationTestArgs(17, 2, 6),
            new RotationTestArgs(17, -2, 12),
            new RotationTestArgs(17, -7, 12),
            new RotationTestArgs(0, -7, 0),
            new RotationTestArgs(7, 0, 7),
            new RotationTestArgs(Integer.MAX_VALUE, 15, Integer.MAX_VALUE)
        );
    }

    static @NotNull Stream<RotationTestArgs> rightShiftProviderFactory() {
        return Stream.of(
            new RotationTestArgs(8, 1, 4),
            new RotationTestArgs(8, 5, 4),
            new RotationTestArgs(8, 9, 4),
            new RotationTestArgs(8, -1, 1),
            new RotationTestArgs(16, 5, 16),
            new RotationTestArgs(17, 2, 12),
            new RotationTestArgs(17, -2, 6),
            new RotationTestArgs(17, -7, 6),
            new RotationTestArgs(0, -7, 0),
            new RotationTestArgs(7, 0, 7),
            new RotationTestArgs(Integer.MAX_VALUE, 2, Integer.MAX_VALUE)
        );
    }

    static @NotNull Stream<RotationTestArgs> negativeNumberShiftProviderFactory() {
        return Stream.of(
            new RotationTestArgs(-5, 1, -1),
            new RotationTestArgs(-1, 5, -1),
            new RotationTestArgs(-1, 0, -1)
        );
    }

    public record RotationTestArgs(int num, int shift, int expected) {
    }
}
