package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @ParameterizedTest
    @CsvSource(value = {
        "01:00, 60",
        "00:01, 1",
        "00:00, 0",
        "14:56, 896",
        "10:60, -1",
        "1a:59, -1",
        "a1:34, -1",
        "141:14, -1",
        "14:1, -1",
        "01:11, 71"
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing func: minutesToSeconds")
    public void testMinutesToSeconds(String time, long expected) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(expected);
    }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Testing func: minutesTosSeconds\nparams: empty string")
        public void testMinutesToSecondsEmptyString(String time) {
            assertThat(Task1.minutesToSeconds(time)).isEqualTo(-1);
        }
}
