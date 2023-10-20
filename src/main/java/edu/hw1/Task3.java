package edu.hw1;

public class Task3 {

    private Task3() {

    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (isInvalidArr(arr1) || isInvalidArr(arr2)) {
            return false;
        }
        var arr1MinMax =  getMinAndMaxOfArray(arr1);
        var arr2MinMax =  getMinAndMaxOfArray(arr2);
        return (arr1MinMax[0] > arr2MinMax[0] && arr1MinMax[1] < arr2MinMax[1]);
    }

    private static boolean isInvalidArr(int[] arr) {
        return (arr == null || arr.length == 0);
    }

    private static int[] getMinAndMaxOfArray(int[] arr) {
        int[] minMaxArr = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int el : arr) {
            minMaxArr[0] = Math.min(minMaxArr[0], el);
            minMaxArr[1] = Math.max(minMaxArr[1], el);
        }
        return minMaxArr;
    }
}
