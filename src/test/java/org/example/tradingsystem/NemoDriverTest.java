package org.example.tradingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NemoDriverTest {

    @InjectMocks
    NemoDriver nemoDriver;

    @Mock
    NemoAPI nemoAPI;

    @Test
    void buyTest() {
        String stockCode = "1234";
        int price = 10000;
        int quantity = 200;

        nemoDriver.buy(stockCode, price, quantity);

        verify(nemoAPI, times(1)).purchasingStock(stockCode, price, quantity);
    }

    @Test
    void sellTest() {
        String stockCode = "1234";
        int price = 10000;
        int quantity = 200;

        nemoDriver.sell(stockCode, price, quantity);

        verify(nemoAPI, times(1)).sellingStock(stockCode, price, quantity);
    }
}