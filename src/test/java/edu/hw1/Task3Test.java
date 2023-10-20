package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("First test")
    public void firstTest() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};
        assertThat(Task3.isNestable(arr1, arr2)).isTrue();
    }

    @Test
    @DisplayName("Second Test")
    public void secondTest() {
        int[] arr1 = {3, 1};
        int[] arr2 = {4, 0};
        assertThat(Task3.isNestable(arr1, arr2)).isTrue();
    }

    @Test
    @DisplayName("Third Test")
    public void thirdTest() {
        int[] arr1 = {9, 9, 8};
        int[] arr2 = {8, 9};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }

    @Test
    @DisplayName("Fourth Test")
    public void fourthTest() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3};
        assertThat(Task3.isNestable(arr1, arr2)).isFalse();
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("First Empty Arr")
    public void firstEmpty(int[] emptyArr) {
        int[] arr = {1, 2, 3, 4};
        assertThat(Task3.isNestable(emptyArr, arr)).isFalse();
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("First/Second Empty Arr")
    public void firstAndSecondEmpty(int[] emptyArr) {
        assertThat(Task3.isNestable(emptyArr, emptyArr)).isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Second Empty Arr")
    public void secondEmpty(int[] emptyArr) {
        int[] arr = {1, 2, 3, 4};
        assertThat(Task3.isNestable(emptyArr, arr)).isFalse();
    }
}
