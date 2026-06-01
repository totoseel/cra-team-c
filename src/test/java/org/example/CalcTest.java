package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalcTest {

    Calc calc;

    @BeforeEach
    void setUp() {
        calc = new Calc();
    }

    @Test
    void test_두_정수의_합() {
        assertThat(calc.getSum(2, 3)).isEqualTo(5);
        assertThat(calc.getSum(-1, 5)).isEqualTo(4);
        assertThat(calc.getSum(0, 0)).isEqualTo(0);
    }

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
        assertThat(calc.getMinus(10, 2))
                .isEqualTo(8);
    }
    @Test
    void getZegopTest() {
        assertThat(36).isEqualTo(calc.getZegop(6));
    }
}
