package edu.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Task4 {
    private Task4() {

    }

    @Contract("null -> fail") public static @NotNull String fixString(String brokenString)
        throws NullPointerException {
        if (brokenString == null) {
            throw new NullPointerException();
        }

        var fixer = new StringBuilder();
        for (int i = 0; i < brokenString.length(); i += 2) {
            if (i + 1 < brokenString.length()) {
                fixer.append(brokenString.charAt(i + 1));
            }

            fixer.append(brokenString.charAt(i));
        }

        return fixer.toString();
    }
}
