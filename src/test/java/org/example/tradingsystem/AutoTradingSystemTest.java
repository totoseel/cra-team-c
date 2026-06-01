package org.example.tradingsystem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class AutoTradingSystemTest {
    @Test
    void selectedDriverWorkingWell() {
        MockStockerBrokerDriver mockDriver = new MockStockerBrokerDriver(10000);
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem(mockDriver);

        autoTradingSystem.login("user", "password");
        autoTradingSystem.buy("123456", 10000, 3);
        autoTradingSystem.sell("123456", 11000, 2);
        int price = autoTradingSystem.getPrice("123456");

        assertThat(mockDriver.getLoginId()).isEqualTo("user");
        assertThat(mockDriver.getLoginPassword()).isEqualTo("password");
        assertThat(price).isEqualTo(10000);
        assertThat(mockDriver.getBuyOrders()).hasSize(1);
        assertThat(mockDriver.getBuyOrders().get(0).getStockCode()).isEqualTo("123456");
        assertThat(mockDriver.getBuyOrders().get(0).getPrice()).isEqualTo(10000);
        assertThat(mockDriver.getBuyOrders().get(0).getQuantity()).isEqualTo(3);

        assertThat(mockDriver.getSellOrders()).hasSize(1);
        assertThat(mockDriver.getSellOrders().get(0).getStockCode()).isEqualTo("123456");
        assertThat(mockDriver.getSellOrders().get(0).getPrice()).isEqualTo(11000);
        assertThat(mockDriver.getSellOrders().get(0).getQuantity()).isEqualTo(2);
    }

    @Test
    void buyingWhenIncreasing() {
        MockStockerBrokerDriver mockDriver = new MockStockerBrokerDriver(10000,11000,12000);
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem(mockDriver);

        autoTradingSystem.buyNiceTiming("005930", 25000);

        assertThat(mockDriver.getPriceCallCount()).isEqualTo(3);
        assertThat(mockDriver.getBuyOrders()).hasSize(1);
        assertThat(mockDriver.getBuyOrders().get(0).getStockCode()).isEqualTo("005930");
        assertThat(mockDriver.getBuyOrders().get(0).getPrice()).isEqualTo(12000);
        assertThat(mockDriver.getBuyOrders().get(0).getQuantity()).isEqualTo(2);
    }

    @Test
    void noBuyingWhenNotIncreasing() {
        MockStockerBrokerDriver mockDriver = new MockStockerBrokerDriver(10000,11000,10000);
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem(mockDriver);

        autoTradingSystem.buyNiceTiming("005930", 25000);

        assertThat(mockDriver.getPriceCallCount()).isEqualTo(3);
        assertThat(mockDriver.getBuyOrders()).isEmpty();
    }

    @Test
    void sellingWhenDecreasing() {
        MockStockerBrokerDriver mockDriver = new MockStockerBrokerDriver(20000,19000,18000);
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem(mockDriver);

        autoTradingSystem.sellNiceTiming("005930", 55000);

        assertThat(mockDriver.getSellOrders()).hasSize(1);
        assertThat(mockDriver.getSellOrders().get(0).getStockCode()).isEqualTo("005930");
        assertThat(mockDriver.getSellOrders().get(0).getPrice()).isEqualTo(18000);
        assertThat(mockDriver.getSellOrders().get(0).getQuantity()).isEqualTo(3);
    }

    @Test
    void noSellingWhenNotDecreasing() {
        MockStockerBrokerDriver mockDriver = new MockStockerBrokerDriver(20000,11000,21000);
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem(mockDriver);

        autoTradingSystem.sellNiceTiming("005930", 55000);

        assertThat(mockDriver.getSellOrders()).isEmpty();
    }

    @Test
    void throwsWhenBrokerIsNotSelected() {
        AutoTradingSystem autoTradingSystem = new AutoTradingSystem();

        assertThatThrownBy(() -> autoTradingSystem.getPrice("005930"))
                .isInstanceOf(IllegalStateException.class);
    }


}