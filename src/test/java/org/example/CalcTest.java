package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

class CalcTest {
    private final Calc calc = new Calc();

    @Test
    void getGopReturnsProduct() {
        assertEquals(12, calc.getGop(3, 4));
    }

    @Test
    void getGopReturnsZeroWhenAnyOperandIsZero() {
        assertEquals(0, calc.getGop(0, 5));
        assertEquals(0, calc.getGop(5, 0));
    }

    @Test
    void getGopReturnsNegativeWhenOnlyOneOperandIsNegative() {
        assertEquals(-12, calc.getGop(-3, 4));
        assertEquals(-12, calc.getGop(3, -4));
    }
  
    @Test
    void testGetMinus() {
        Calc calc = new Calc();
        assertThat(calc.getMinus(10, 2))
                .isEqualTo(8);
    }
}
