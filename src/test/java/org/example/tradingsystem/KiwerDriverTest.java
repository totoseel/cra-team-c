package org.example.tradingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class KiwerDriverTest {
    @Mock
    KiwerAPI kiwerAPI;

    @InjectMocks
    private KiwerDriver kiwerDriver;

    @Test
    void loginSuccess() {
        String id = "hello";
        String passwd = "qwerty1234";

        boolean result = kiwerDriver.login(id, passwd);
        assertThat(result).isTrue();
    }

    @Test
    void invalidLoginInfo() {
        doThrow(IllegalArgumentException.class)
                .when(kiwerAPI)
                .login(anyString(), anyString());

        String id = "invalidUser";
        String passwd = "qwerty1234";

        boolean result = kiwerDriver.login(id, passwd);
        assertThat(result).isFalse();
    }

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

    @Test
    void getPrice() {
        when(kiwerAPI.currentPrice(eq("123")))
                .thenReturn(5300);
        when(kiwerAPI.currentPrice(eq("456")))
                .thenReturn(7000);

        assertThat(kiwerDriver.getPrice("123"))
                .isEqualTo(5300);
        assertThat(kiwerDriver.getPrice("456"))
                .isEqualTo(7000);
    }

    @Test
    void failGetPrice() {
        when(kiwerAPI.currentPrice(anyString()))
                .thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> kiwerDriver.getPrice("123"))
                .isInstanceOf(RuntimeException.class);
    }
}
