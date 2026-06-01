package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NemoDriverTest {
    private NemoDriver nemoDriver;
    @BeforeEach
    void setUp() {
        this.nemoDriver = new NemoDriver();
    }

    @Test
    void loginSuccess() {
        String id = "hello";
        String passwd = "qwerty1234";

        boolean result = nemoDriver.login(id, passwd);
        assertThat(result).isTrue();
    }
}
