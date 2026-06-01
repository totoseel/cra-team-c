package org.example.tradingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KiwerDriverTest {

    @InjectMocks
    KiwerDriver kiwerDriver;

    @Mock
    KiwerAPI kiwerAPI;

    @Test
    void buyTest() {
        String stockCode = "1234";
        int price = 10000;
        int quantity = 200;

        kiwerDriver.buy(stockCode, price, quantity);

        verify(kiwerAPI, times(1)).buy(stockCode, price, quantity);
    }

    @Test
    void sellTest() {
        String stockCode = "1234";
        int price = 10000;
        int quantity = 200;

        kiwerDriver.sell(stockCode, price, quantity);

        verify(kiwerAPI, times(1)).sell(stockCode, price, quantity);
    }
}