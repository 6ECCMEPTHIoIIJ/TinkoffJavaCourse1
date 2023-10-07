package edu.hw1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    private static final int MINUTES_PER_SECOND = 60;

    @ParameterizedTest
    @DisplayName("Проверка обычной строки в формате mm:ss")
    @MethodSource("commonTimeArgsProviderFactory")
    public void checkCommonTime(TimeTestArgs time) {
        assertThat(Task1.minutesToSeconds(time.string))
            .isEqualTo(time.value);
    }

    @ParameterizedTest
    @DisplayName("Проверка строки с нулевым временем")
    @MethodSource("zeroTimeArgsProviderFactory")
    public void checkZeroTime(TimeTestArgs time) {
        assertThat(Task1.minutesToSeconds(time.string))
            .isEqualTo(time.value);
    }

    @Test
    @DisplayName("Проверка времени на null")
    public void checkNullTime() {
        Throwable throwable = assertThrows(
            NullPointerException.class,
            () -> Task1.minutesToSeconds(null)
        );

        assertNotNull(throwable);
    }

    @ParameterizedTest
    @DisplayName("Проверка строки с некорректным значением")
    @MethodSource("incorrectValueTimeArgsProviderFactory")
    public void checkIncorrectValueTime(String time) {
        assertThat(Task1.minutesToSeconds(time))
            .isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("Проверка строки с некорректным форматом")
    @MethodSource("incorrectFormatTimeArgsProviderFactory")
    public void checkIncorrectFormatTime(String time) {
        Throwable throwable = assertThrows(
            IllegalArgumentException.class,
            () -> Task1.minutesToSeconds(time)
        );

        assertNotNull(throwable);
    }

    static @NotNull Stream<TimeTestArgs> commonTimeArgsProviderFactory() {
        return Stream.of(
            new TimeTestArgs("12:30", (long) 12 * MINUTES_PER_SECOND + 30),
            new TimeTestArgs("00:49", 49),
            new TimeTestArgs("12341:15", (long) 12341 * MINUTES_PER_SECOND + 15)
        );
    }

    static @NotNull Stream<String> incorrectValueTimeArgsProviderFactory() {
        return Stream.of("00:60", "12:99");
    }

    static @NotNull Stream<TimeTestArgs> zeroTimeArgsProviderFactory() {
        return Stream.of(
            new TimeTestArgs("00:00", 0),
            new TimeTestArgs("0000000000:00", 0),
            new TimeTestArgs("00000000000000000000000:00", 0)
        );
    }

    static @NotNull Stream<String> incorrectFormatTimeArgsProviderFactory() {
        return Stream.of("", ":", "aboba", "abo:ba",
            "-5:23", "12:-1", "-3:66", "0:0", "00:0", "0:00", "00:", ":80", "0:600", "00:-12",
            "12341", "-123124", ":2133:31", "12:43:", "43:12:54",
            "12a30", "12 30", "-12-30", "12:30a", "a12:30", "12:3a0");
    }

    public record TimeTestArgs(String string, long value) {
    }
}
