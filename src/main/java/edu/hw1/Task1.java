package edu.hw1;

public class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTE = 60;

    private static final int CORRECT_LENGTH = 5;

    public static Integer minutesToSeconds(String str) {
        if (!isValidTime(str)) {
            return -1;
        }
        var timeArr = str.split(":");
        int minutes = Integer.parseInt(timeArr[0]);
        int seconds = Integer.parseInt(timeArr[1]);
        return SECONDS_IN_MINUTE * minutes + seconds;
    }

    private static Boolean isValidTime(String str) {
        return str != null && str.matches("[0-5][0-9]:[0-5][0-9]") && str.length() == CORRECT_LENGTH;
    }
}
