package edu.hw1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @ParameterizedTest
    @CsvSource(value = {
        "10000, 5",
        "8888, 4",
        "10, 2",
        "-15, 2",
        "0, 1",
        "150000, 6",
        "4666, 4",
        "544, 3"
    }, ignoreLeadingAndTrailingWhitespace = true)
    @DisplayName("Testing func: countDigits")
    public void testCountDigits(int time, int expected) {
        assertThat(Task2.countDigits(time)).isEqualTo(expected);
    }

}
