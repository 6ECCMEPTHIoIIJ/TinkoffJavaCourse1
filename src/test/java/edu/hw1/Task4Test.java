package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    @DisplayName("Проверка строки с четным кол-вом символов")
    public void checkEvenCountCharactersString() {
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g"))
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Проверка строки с нечетным кол-вом символов")
    public void checkOddCountCharactersString() {
        assertThat(Task4.fixString("badce"))
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Проверка пустой строки")
    public void checkEmptyString() {
        assertThat(Task4.fixString(""))
            .isEqualTo("");
    }

    @Test
    @DisplayName("Проверка null строки")
    public void checkNullString() {
        Throwable throwable = assertThrows(
            NullPointerException.class,
            () -> Task4.fixString(null)
        );

        assertNotNull(throwable);
    }
}
