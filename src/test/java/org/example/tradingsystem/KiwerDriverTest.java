package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KiwerDriverTest {
    private KiwerDriver kiwerDriver;
    @BeforeEach
    void setUp() {
        this.kiwerDriver = new KiwerDriver();
    }

}