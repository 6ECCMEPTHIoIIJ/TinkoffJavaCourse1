package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @ParameterizedTest
    @DisplayName("Проверка четырехзначных чисел, больших 1000, состоящие из неодинаковых цифр")
    @MethodSource("correctNumsProviderFactory")
    public void checkCorrectNumbers(@NotNull NumTestArgs num) {
        assertThat(Task6.countK(num.given))
            .isEqualTo(num.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка нечетырехзначных чисел и четырехзначных чисел, состоящих из одинаковых цифр")
    @MethodSource("incorrectNumsProviderFactory")
    public void checkIncorrectNumbers(@NotNull NumTestArgs num) {
        assertThat(Task6.countK(num.given))
            .isEqualTo(num.expected);
    }

    static @NotNull Stream<NumTestArgs> correctNumsProviderFactory() {
        return Stream.of(
            new NumTestArgs(3524, 3),
            new NumTestArgs(6174, 0),
            new NumTestArgs(5200, 7),
            new NumTestArgs(1100, 4)
        );
    }

    static @NotNull Stream<NumTestArgs> incorrectNumsProviderFactory() {
        return Stream.of(
            new NumTestArgs(1111, -1),
            new NumTestArgs(2222, -1),
            new NumTestArgs(3333, -1),
            new NumTestArgs(4444, -1),
            new NumTestArgs(5555, -1),
            new NumTestArgs(6666, -1),
            new NumTestArgs(7777, -1),
            new NumTestArgs(8888, -1),
            new NumTestArgs(9999, -1),
            new NumTestArgs(1000, -1),
            new NumTestArgs(999, -1),
            new NumTestArgs(10000, -1)
        );
    }

    public record NumTestArgs(int given, int expected) {
    }
}
