package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalcTest {
    private Calc calc = new Calc();

    @Test
    void test_두_정수의_합() {
        assertThat(calc.getSum(2, 3)).isEqualTo(5);
        assertThat(calc.getSum(-1, 5)).isEqualTo(4);
        assertThat(calc.getSum(0, 0)).isEqualTo(0);
    }
}