package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Long> getFrequencyDictionary(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        TreeMap<T, Long> words = new TreeMap<T, Long>();
        for (var s : list) {
            if (!words.containsKey(s)) {
                words.put(s, 1L);
            } else {
                words.put(s, words.get(s) + 1);
            }
        }
        return words;
    }
}
