package org.example.tradingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NemoDriverTest {
    private NemoDriver nemoDriver;
    @BeforeEach
    void setUp() {
        this.nemoDriver = new NemoDriver();
    }
}