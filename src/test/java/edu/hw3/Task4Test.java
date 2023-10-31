package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

public class Task4Test {

    private static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(3999, "MMMCMXCIX"),
            Arguments.of(9, "IX")
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    @DisplayName("Basic tests")
    public void test1(int testNumber, String expected) {
        String actual = Task4.convertToRoman(testNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "4500"
    })
    @DisplayName("Wrong input tests")
    public void test2(int testNumber) {
        assertThatThrownBy(() -> Task4.convertToRoman(testNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
