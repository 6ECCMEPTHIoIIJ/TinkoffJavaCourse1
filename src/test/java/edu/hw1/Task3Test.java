package edu.hw1;

import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @ParameterizedTest
    @DisplayName("Проверка массива, который может быть вложен в другой")
    @MethodSource("nestableArrayArgsProviderFactory")
    public void checkNestableArray(@NotNull ArrayTestArgs arrays) {
        assertThat(Task3.isNestable(arrays.left, arrays.right))
            .isEqualTo(arrays.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка массива, который не может быть вложен в другой")
    @MethodSource("nonNestableArrayArgsProviderFactory")
    public void checkNonNestableArray(@NotNull ArrayTestArgs arrays) {
        assertThat(Task3.isNestable(arrays.left, arrays.right))
            .isEqualTo(arrays.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка пустого массива")
    @MethodSource("emptyArrayArgsProviderFactory")
    public void checkEmptyArray(@NotNull ArrayTestArgs arrays) {
        assertThat(Task3.isNestable(arrays.left, arrays.right))
            .isEqualTo(arrays.expected);
    }

    @ParameterizedTest
    @DisplayName("Проверка null массива")
    @MethodSource("nullArrayArgsProviderFactory")
    public void checkNullArray(@NotNull ArrayTestArgs arrays) {
        Throwable throwable = assertThrows(
            NullPointerException.class,
            () -> Task3.isNestable(arrays.left, arrays.right)
        );

        assertNotNull(throwable);
    }

    static @NotNull Stream<ArrayTestArgs> nestableArrayArgsProviderFactory() {
        return Stream.of(
            new ArrayTestArgs(new int[] {1, 2, 3}, new int[] {6, 5, 1, 0, 4, 3, 2}, true),
            new ArrayTestArgs(new int[] {3, 9}, new int[] {-5, 18}, true),
            new ArrayTestArgs(new int[] {1, 4, 3, 2}, new int[] {5, -1}, true),
            new ArrayTestArgs(new int[] {7}, new int[] {6, 8}, true)
        );
    }

    static @NotNull Stream<ArrayTestArgs> nonNestableArrayArgsProviderFactory() {
        return Stream.of(
            new ArrayTestArgs(new int[] {1, 2, 3}, new int[] {6, 5, 4, 3, 2, 1}, false),
            new ArrayTestArgs(new int[] {3, 9}, new int[] {2, 9}, false),
            new ArrayTestArgs(new int[] {3, 9}, new int[] {3, 10}, false),
            new ArrayTestArgs(new int[] {3, 9}, new int[] {10, 11}, false),
            new ArrayTestArgs(new int[] {7}, new int[] {10}, false),
            new ArrayTestArgs(new int[] {9}, new int[] {6}, false),
            new ArrayTestArgs(new int[] {-20}, new int[] {-20}, false),
            new ArrayTestArgs(new int[] {1, 4, 3, 2}, new int[] {4, 1}, false),
            new ArrayTestArgs(new int[] {6, 8}, new int[] {7}, false)
        );
    }

    static @NotNull Stream<ArrayTestArgs> emptyArrayArgsProviderFactory() {
        return Stream.of(
            new ArrayTestArgs(new int[] {}, new int[] {6, 5, 1, 0, 4, 3, 2}, true),
            new ArrayTestArgs(new int[] {3, 9}, new int[] {}, false),
            new ArrayTestArgs(new int[] {}, new int[] {}, true)
        );
    }

    static @NotNull Stream<ArrayTestArgs> nullArrayArgsProviderFactory() {
        return Stream.of(
            new ArrayTestArgs(null, new int[] {6, 5, 1, 0, 4, 3, 2}, null),
            new ArrayTestArgs(new int[] {3, 9}, null, null),
            new ArrayTestArgs(null, null, null)
        );
    }

    public record ArrayTestArgs(int[] left, int[] right, Boolean expected) {
    }
}
