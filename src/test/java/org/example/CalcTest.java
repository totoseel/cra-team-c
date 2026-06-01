package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
