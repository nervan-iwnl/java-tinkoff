package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    private Task7Test() {}

    @Test
    @DisplayName("Add null as key test")
    void testNullKey() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7<String>());
        tree.put("aboba", "kekovich");
        tree.put(null, "null");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
