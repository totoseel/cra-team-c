package org.example.tradingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
}
