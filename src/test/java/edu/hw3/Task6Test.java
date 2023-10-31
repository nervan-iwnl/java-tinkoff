package edu.hw3;

import edu.hw3.Task6.Birge;
import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Task6Test {

    private StockMarket birge;

    @BeforeEach public void init() {
        birge = new Birge();
        birge.add(new Stock("ABOBA", 3000));
        birge.add(new Stock("KEK", 3600));
        birge.add(new Stock("CHEBUREK", 170));
    }

    @Test
    @DisplayName("remove")
    public void test1() {
        birge.remove(new Stock("KEK", 3600));
        assertThat(birge.mostValuableStock())
            .extracting("ticker", "price")
            .containsExactly("ABOBA", 3000d);
    }

    @Test
    @DisplayName("mostValuable")
    public void test2() {
        assertThat(birge.mostValuableStock())
            .extracting("ticker", "price")
            .containsExactly("KEK", 3600d);
    }

    @Test
    @DisplayName("add")
    public void test3() {
        birge.add(new Stock("TEST", 10000));
        assertThat(birge.mostValuableStock())
            .extracting("ticker", "price")
            .containsExactly("TEST", 10000d);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null test")
    public void stock_shouldThrowException_whenStockIsNull(Stock testStock) {
        org.junit.jupiter.api.Assertions.assertAll(
            () -> assertThatThrownBy(() -> birge.remove(testStock)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> birge.add(testStock)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
