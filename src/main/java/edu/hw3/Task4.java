package edu.hw3;

import java.util.ArrayList;
import org.apache.commons.lang3.tuple.MutablePair;

public class Task4 {
    private static final int MAX_NUMBER = 3999;
    private static final int MIN_NUMBER = 1;

    private static final ArrayList<MutablePair<Integer, String>> NUMS = new ArrayList<MutablePair<Integer, String>>();

    private Task4() {
    }

    public static String convertToRoman(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Number should be >= 1 and <= 3999");
        }
        buildNums();
        StringBuilder str = new StringBuilder();
        int curr = number;
        while (curr > 0) {
            for (var num : NUMS) {
                while (curr >= num.getLeft()) {
                    str.append(num.getRight());
                    curr -= num.getLeft();
                }
            }

        }
        return str.toString();
    }

    @SuppressWarnings("MagicNumber")
    private static void buildNums() {
        NUMS.add(new MutablePair<>(1000, "M"));
        NUMS.add(new MutablePair<>(900, "CM"));
        NUMS.add(new MutablePair<>(500, "D"));
        NUMS.add(new MutablePair<>(400, "CD"));
        NUMS.add(new MutablePair<>(100, "C"));
        NUMS.add(new MutablePair<>(90, "XC"));
        NUMS.add(new MutablePair<>(50, "L"));
        NUMS.add(new MutablePair<>(40, "XL"));
        NUMS.add(new MutablePair<>(10, "X"));
        NUMS.add(new MutablePair<>(9, "IX"));
        NUMS.add(new MutablePair<>(5, "V"));
        NUMS.add(new MutablePair<>(4, "IV"));
        NUMS.add(new MutablePair<>(1, "I"));
    }
}
