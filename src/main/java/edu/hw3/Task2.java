package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Task2 {
    private static final String EXCEPTION_STRING = "Can't create cluster";

    private Task2() {
    }

    public static List<String> clusterize(String bracketsLine) {
        if (StringUtils.isBlank(bracketsLine)) {
            throw new IllegalArgumentException("Brackets line is empty");
        }
        List<String> clusters = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < bracketsLine.length(); ++i) {
            if (!isCorrectChar(bracketsLine.charAt(i))) {
                throw new IllegalArgumentException("Message should consist from ( and )");
            }
            curr.append(bracketsLine.charAt(i));
            if (balance < 0) {
                throw new IllegalArgumentException(EXCEPTION_STRING);
            }
            if (bracketsLine.charAt(i) == '(') {
                balance++;
            }
            if (bracketsLine.charAt(i) == ')') {
                balance--;
            }
            if (balance == 0) {
                clusters.add(curr.toString());
                curr = new StringBuilder();
            }
        }
        if (balance > 0) {
            throw new IllegalArgumentException(EXCEPTION_STRING);
        }
        return clusters;
    }

    public static boolean isCorrectChar(char c) {
        return c == '(' || c == ')';
    }
}
