package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    private Task7Test() {}

    @Test
    @ValueSource
    @DisplayName("Add null as key test")
    void testAddingNullAsKey() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7<String>());
        tree.put("AAA", "bbb");
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
