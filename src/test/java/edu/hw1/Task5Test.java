package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @ParameterizedTest
    @CsvSource(value = {
        "11211230, true",
        "13001120, true",
        "23336014, true",
        "11, true",
        "1, false",
        "13, false",
        "112, true"
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing func: fixString")
    public void testFixString(long x, boolean expected) {
        assertThat(Task5.isPalindromeDescendant(x)).isEqualTo(expected);
    }
}

