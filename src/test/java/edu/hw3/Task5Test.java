package edu.hw3;

import edu.hw3.Task5.Contact;
import edu.hw3.Task5.Main;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    private static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"},
                "ASC",
                List.of(
                    new Contact("Thomas", "Aquinas"),
                    new Contact("Rene", "Descartes"),
                    new Contact("David", "Hume"),
                    new Contact("John", "Locke")
                )
            ),
            Arguments.of(new String[] {"Paul", "Leonhard", "Carl"}, "DESC",
                List.of(
                    new Contact("Paul"),
                    new Contact("Leonhard"),
                    new Contact("Carl")
                )
            )
        );
    }

    private static Stream<Arguments> test2() {
        return Stream.of(
            Arguments.of((Object) new String[] {"Dmitriy Gavrilov Sergeevich"}),
            Arguments.of((Object) new String[] {"Isaac Asim0v"}),
            Arguments.of((Object) new String[] {"1saac Asimov"})
        );
    }

    @ParameterizedTest
    @MethodSource("test")
    @DisplayName("Basic tests")
    public void test1(
        String[] testPeopleInfo,
        String sortOrder,
        List<Contact> expected
    ) {
        List<Contact> actual = Main.parseContacts(testPeopleInfo, sortOrder);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty test")
    public void test2(String[] testPeopleInfo) {
        List<Contact> actual = Main.parseContacts(testPeopleInfo, "ASC");
        assertThat(actual).isEqualTo(Collections.emptyList());
    }
}
