package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task2Test {

    private static Stream<Arguments> basicTestsInputs() {
        return Stream.of(
            Arguments.of("()()()", new String[] {"()", "()", "()"}),
            Arguments.of("((()))", new String[] {"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"})
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestsInputs")
    @DisplayName("Basic tests for #clusterize")
    public void bracketsLine_shouldReturnListOfBalancedBracketsClusters(String testBracketLine, String[] expected) {
        String[] actual = Task2.clusterize(testBracketLine).toArray(new String[0]);
        assertThat(actual).isEqualTo(expected);
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Null and empty test for #clusterize")
    public void bracketsLine_shouldThrowException_whenBracketsLineIsNullOrEmpty(String testBracketLine) {
        assertThatThrownBy(() -> Task2.clusterize(testBracketLine)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
        "(((()",
        "(())d()"
    })
    @DisplayName("Wrong input test for #clusterize")
    public void bracketsLine_shouldThrowException_whenBracketsLinesIsIncorrect(String testBracketLine) {
        assertThatThrownBy(() -> Task2.clusterize(testBracketLine)).isInstanceOf(IllegalArgumentException.class);
    }
}
