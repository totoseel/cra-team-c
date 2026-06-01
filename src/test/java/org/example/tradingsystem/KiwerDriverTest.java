package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class KiwerDriverTest {

    private KiwerDriver kiwerDriver;
    @BeforeEach
    void setUp() {
        this.kiwerDriver = new KiwerDriver();
    }

    @Test
    void loginSuccess() {
        String id = "hello";
        String passwd = "qwerty1234";

        boolean result = kiwerDriver.login(id, passwd);
        assertThat(result).isTrue();
    }
}
