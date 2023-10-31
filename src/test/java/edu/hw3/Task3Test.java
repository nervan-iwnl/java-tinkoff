package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.*;

public class Task3Test {

    private static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2L, "a", 2L)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1L, "and", 2L, "this", 1L)),
            Arguments.of(List.of("код", "код", "код", "bug"), Map.of("код", 3L, "bug", 1L)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2L, 2, 2L))
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    @DisplayName("Basic tests")
    public <T> void test1(List<T> testList, Map<T, Long> expected) {
        Map<T, Long> actual = Task3.getFrequencyDictionary(testList);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty")
    public <T> void test2(List<T> testList) {
        assertThatThrownBy(() -> Task3.getFrequencyDictionary(testList)).isInstanceOf(IllegalArgumentException.class);
    }
}
