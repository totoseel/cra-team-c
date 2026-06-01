package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AutoTradingSystemTest {
    private AutoTradingSystem autoTradingSystem;
    @BeforeEach
    void setUp() {
        this.autoTradingSystem = new AutoTradingSystem();
    }


}