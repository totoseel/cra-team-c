package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NemoDriverTest {
    @Mock
    NemoAPI nemoAPI;

    @InjectMocks
    private NemoDriver nemoDriver;

    @Test
    void loginSuccess() {
        String id = "hello";
        String passwd = "qwerty1234";

        boolean result = nemoDriver.login(id, passwd);
        assertThat(result).isTrue();
    }

    @Test
    void invalidLoginInfo() {
        doThrow(IllegalArgumentException.class)
                .when(nemoAPI)
                .certification(anyString(), anyString());

        String id = "invalidUser";
        String passwd = "qwerty1234";

        boolean result = nemoDriver.login(id, passwd);
        assertThat(result).isFalse();

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
