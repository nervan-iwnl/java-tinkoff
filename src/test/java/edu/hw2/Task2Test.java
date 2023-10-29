package edu.hw2;

import edu.hw2.Task2.ConnectionException;
import edu.hw2.Task2.DefaultConnectionManager;
import edu.hw2.Task2.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Task2Test {

    @Test
    @DisplayName("Wrong number of maxAttempts")
    public void test0() {
        assertThatThrownBy(() -> new PopularCommandExecutor(new DefaultConnectionManager(), -1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("tryExecute test")
    public void test1() {
        PopularCommandExecutor executor = new PopularCommandExecutor(
            new DefaultConnectionManager(),
            2
        );
        assertThatCode(executor::updatePackages).doesNotThrowAnyException();
    }

}
