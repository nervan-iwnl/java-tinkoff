package edu.hw1;

public class Task2 {

    private Task2() {

    }

    private static final int NUMBER_SYSTEM = 10;

    public static int countDigits(long x) {
        var tmp = Math.abs(x);
        int ans = 1;
        while (tmp >= NUMBER_SYSTEM) {
            ++ans;
            tmp /= NUMBER_SYSTEM;
        }
        return ans;
    }
}
