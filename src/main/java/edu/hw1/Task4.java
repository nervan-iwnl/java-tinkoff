package edu.hw1;

public class Task4 {

    private Task4() {
    }

    public static String fixString(String str) {
        if (isInvalid(str)) {
            return "";
        }
        StringBuilder correctStr = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            if (i + 1 < str.length()) {
                correctStr.append(str.charAt(i + 1));
            }
            correctStr.append(str.charAt(i));
        }

        return correctStr.toString();
    }

    private static boolean isInvalid(String str) {
        return (str == null || str.isEmpty());
    }
}
