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

    @Test
    void SumOfUnknownNumbersShouldBeReturnForUnknownNumbers() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("1,2,3")).isEqualTo(6);
    }

    @Test
    void SumOfNumbersShouldBeReturnForNumbersGivenWithCommaAndNewLine() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void SumOfNumbersShouldBeReturnForNumbersGivenWithCustomDelimiters() {
        var calc = new StringCalculator();
        Assertions.assertThat(calc.Add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void ThrowErrorWhenNegativeValuesPresent() {
        var calc = new StringCalculator();
        Assertions.assertThatThrownBy(() -> calc.Add("-1,2,-3,-4,5")).hasMessageContaining("Negatives not Allowed").hasMessageContaining("-1 -3 -4");
    }
}
