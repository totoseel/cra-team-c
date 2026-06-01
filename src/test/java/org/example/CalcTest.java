package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CalcTest {
    @Test
    void testGetMinus() {
        Calc calc = new Calc();
        assertThat(calc.getMinus(10, 2))
                .isEqualTo(8);
    }
}

