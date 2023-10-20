package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    private static final int CARPERKAR = 6174;
    private static final int SIZE = 4;
    private static final int THOUSAND = 1000;
    private static final int MAX_THOUSAND = 9999;
    private static final int HUNDRED = 100;
    private static final int DECADE = 10;


    @SuppressWarnings("MagicNumber")
    public static int countK(int x) {
        if (isInvalid(x)) {
            return -1;
        }
        if (x == CARPERKAR) {
            return 0;
        }
        int[] digits = getDigits(x);
        Arrays.sort(digits);
        int minN = digits[0] * THOUSAND + digits[1] * HUNDRED + digits[2] * DECADE + digits[3];
        int maxN = digits[3] * THOUSAND + digits[2] * HUNDRED + digits[1] * DECADE + digits[0];
        return 1 + countK(maxN - minN);
    }

    @SuppressWarnings("MagicNumber")
    private static int[] getDigits(int x) {
        var tmp = x;
        int[] arr = new int[SIZE];
        int i = 0;
        while (tmp > 0) {
            arr[i] = tmp % 10;
            tmp /= 10;
            i++;
        }
        return arr;
    }

    private static boolean isInvalid(int x) {
        if (x < THOUSAND || x > MAX_THOUSAND) {
            return true;
        }
        return (x % DECADE == x / THOUSAND) && (x / THOUSAND == ((x % HUNDRED) / DECADE))
            && (x / THOUSAND == ((x / HUNDRED) % DECADE));
    }
}
