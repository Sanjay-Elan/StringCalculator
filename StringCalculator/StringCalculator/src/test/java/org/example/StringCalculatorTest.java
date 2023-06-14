package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class StringCalculatorTest {

    @Test
    void WhenEmptyStringPassedResultShouldBeZero() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("")).isEqualTo(0);
    }

    @Test
    void SameValueShouldBeReturnForOneNumber() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("1")).isEqualTo(1);
    }

    @Test
    void SumOfTwoNumbersShouldBeReturnForTwoNumbers() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("1,2")).isEqualTo(3);
    }
}
