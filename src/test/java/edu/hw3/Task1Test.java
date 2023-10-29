package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.*;

public class Task1Test {

    @ParameterizedTest
    @CsvSource(delimiter = '➞', value = {
        "Hello world!➞Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler➞"
            + "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
    })
    @DisplayName("default tests")
    public void message_shouldReturnEncodedWithAbashMessage(String testMessage, String expected) {
        String actual = Task1.encodeWithAtbash(testMessage);
        assertThat(actual).isEqualTo(expected);
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("null and empty test")
    public void message_shouldThrowException_whenMessageIsNullOrEmpty(String message) {
        assertThatThrownBy(() -> Task1.encodeWithAtbash(message)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("unicode & not Latin symbols test")
    public void message_shouldReturnEncodedWithAbashMessageWhereOnlyAsciiLatinLetterAreEncoded() {
        String testMessage = "Лол кек чебурек!❤\uD83D\uDE0E";
        String actual = Task1.encodeWithAtbash(testMessage);
        assertThat(actual).isEqualTo("Лол кек чебурек!❤\uD83D\uDE0E");
    }
}
