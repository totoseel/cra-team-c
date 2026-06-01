package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AutoTradingSystemTest {

    private AutoTradingSystem autoTradingSystem;

    @BeforeEach
    void setUp() {
        this.autoTradingSystem = new AutoTradingSystem();
    }
    private static void setSystemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    @Test
    void test_scanner_use() {
        String input = "1";
        setSystemIn(input);
        this.autoTradingSystem = new AutoTradingSystem();
        autoTradingSystem.selectStockBroker();
    }

    @Test
    void test_stock_broker_kiwer() {
        String input = "1";
        setSystemIn(input);
        this.autoTradingSystem = new AutoTradingSystem();
        autoTradingSystem.selectStockBroker();

        assertThat(autoTradingSystem.stockerBrokerDriver)
                .isNotNull()
                .isExactlyInstanceOf(KiwerDriver.class);
    }

    @Test
    void test_stock_broker_nemo() {
        String input = "2";
        setSystemIn(input);
        this.autoTradingSystem = new AutoTradingSystem();
        autoTradingSystem.selectStockBroker();

        assertThat(autoTradingSystem.stockerBrokerDriver)
                .isNotNull()
                .isExactlyInstanceOf(NemoDriver.class);
    }
}