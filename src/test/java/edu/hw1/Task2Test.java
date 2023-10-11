package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @ParameterizedTest
    @DisplayName("Проверка неотрицательных чисел")
    @MethodSource("nonNegativeNumbersArgsProviderFactory")
    public void checkNonNegativeNumbers(@NotNull NumberTestArgs num) {
        assertThat(Task2.countDigits(num.given))
            .isEqualTo(num.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка отрицательных чисел")
    @MethodSource("negativeNumbersArgsProviderFactory")
    public void checkNegativeNumbers(@NotNull NumberTestArgs num) {
        assertThat(Task2.countDigits(num.given))
            .isEqualTo(num.expected);
    }

    static @NotNull Stream<NumberTestArgs> nonNegativeNumbersArgsProviderFactory() {
        return Stream.of(
            new NumberTestArgs(5444, 4),
            new NumberTestArgs(12, 2),
            new NumberTestArgs(1234567890, 10),
            new NumberTestArgs(10, 2),
            new NumberTestArgs(100000, 6),
            new NumberTestArgs(Integer.MAX_VALUE, Integer.valueOf(Integer.MAX_VALUE).toString().length()),
            new NumberTestArgs(0, 1),
            new NumberTestArgs(5, 1)
        );
    }

    static @NotNull Stream<NumberTestArgs> negativeNumbersArgsProviderFactory() {
        return Stream.of(
            new NumberTestArgs(-5245, -1),
            new NumberTestArgs(-43, -1),
            new NumberTestArgs(-1234567890, -1),
            new NumberTestArgs(-7, -1)
        );
    }

    public record NumberTestArgs(int given, int expected) {
    }
}
