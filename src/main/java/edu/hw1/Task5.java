package edu.hw1;

public class Task5 {

    private Task5() {
    }

    private static final int NUMBER_SYSTEM = 10;

    public static boolean isPalindromeDescendant(long x) {
        var tmp = x;
        while (tmp > NUMBER_SYSTEM) {
            if (isPalindrome(tmp)) {
                return true;
            }
            tmp = Integer.parseInt(step(tmp));
        }
        return false;
    }

    private static String step(long x) {
        String str = Long.toString(x);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            var sum = 0;
            if (i + 1 < str.length()) {
                sum += Character.getNumericValue(str.charAt(i + 1));
            }
            sum += Character.getNumericValue(str.charAt(i));
            ans.append(sum);
        }
        return ans.toString();
    }

    private static boolean isPalindrome(long x) {
        String str = Long.toString(x);
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
