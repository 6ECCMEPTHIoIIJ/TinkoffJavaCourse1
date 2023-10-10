package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @ParameterizedTest
    @DisplayName("Проверка чисел с четным числом разрядов")
    @MethodSource("numbersWithEvenCountOfDigitsArgsProviderFactory")
    public void checkNumbersWithEvenCountOfDigits(@NotNull PalindromeTestArgs palindrome) {
        assertThat(Task5.isPalindromeDescendant(palindrome.given))
            .isEqualTo(palindrome.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка чисел с нечетным числом разрядов")
    @MethodSource("numbersWithOddCountOfDigitsArgsProviderFactory")
    public void checkNumbersWithOddCountOfDigits(@NotNull PalindromeTestArgs palindrome) {
        assertThat(Task5.isPalindromeDescendant(palindrome.given))
            .isEqualTo(palindrome.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка чисел, изначально являющихся палиндромами")
    @MethodSource("initialPalindromesArgsProviderFactory")
    public void checkInitialPalindromes(@NotNull PalindromeTestArgs palindrome) {
        assertThat(Task5.isPalindromeDescendant(palindrome.given))
            .isEqualTo(palindrome.expected);
    }

    static @NotNull Stream<PalindromeTestArgs> numbersWithEvenCountOfDigitsArgsProviderFactory() {
        return Stream.of(
            new PalindromeTestArgs(11211230, true),
            new PalindromeTestArgs(-11211230, true),
            new PalindromeTestArgs(13001120, true),
            new PalindromeTestArgs(23336014, true),
            new PalindromeTestArgs(11122122, false),
            new PalindromeTestArgs(-11122122, false),
            new PalindromeTestArgs(5621, false),
            new PalindromeTestArgs(11, true)
        );
    }

    static @NotNull Stream<PalindromeTestArgs> numbersWithOddCountOfDigitsArgsProviderFactory() {
        return Stream.of(
            new PalindromeTestArgs(533, true),
            new PalindromeTestArgs(-533, true),
            new PalindromeTestArgs(3412, false),
            new PalindromeTestArgs(-3412, false)
        );
    }

    static @NotNull Stream<PalindromeTestArgs> initialPalindromesArgsProviderFactory() {
        return Stream.of(
            new PalindromeTestArgs(121, true),
            new PalindromeTestArgs(12344321, true),
            new PalindromeTestArgs(22, true),
            new PalindromeTestArgs(-5, true),
            new PalindromeTestArgs(0, true)
        );
    }

    public record PalindromeTestArgs(int given, boolean expected) {

    }
}
