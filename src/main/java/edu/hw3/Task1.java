package edu.hw3;

import org.apache.commons.lang3.StringUtils;

public class Task1 {

    private Task1() {

    }

    public static String encodeWithAtbash(String msg) {
        if (StringUtils.isEmpty(msg)) {
            throw new IllegalArgumentException("Empty message");
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < msg.length(); ++i) {
            if (!isEng(msg.charAt(i))) {
                res.append(msg.charAt(i));
                continue;
            }
            res.append(mirrorChr(msg.charAt(i)));
        }
        return res.toString();
    }

    private static boolean isEng(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && 'Z' >= c);
    }

    private static char mirrorChr(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('z' - c + 'a');
        }
        return (char) ('Z' - c + 'A');
    }
}
