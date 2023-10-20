package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        if (isInvalid(shift, n)) {
            return -1;
        }
        var num = Integer.toBinaryString(n).length();
        int currentShift = shift % num;
        return (n << currentShift | n >> (num - currentShift)) & ((1 << num) - 1);
    }

    public static int rotateRight(int n, int shift) {
        if (isInvalid(shift, n)) {
            return -1;
        }
        int numberOfBits = Integer.toBinaryString(n).length();
        int newShift = shift % numberOfBits;
        return (n >> newShift | n << (numberOfBits - newShift)) & ((1 << numberOfBits) - 1);
    }

    private static boolean isInvalid(int shift, int number) {
        return (shift < 0 || number < 0);
    }
}
