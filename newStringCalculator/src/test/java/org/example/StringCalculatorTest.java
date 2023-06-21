package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    //Test case When an empty string is passed
    @Test
    void WhenEmptyStringPassedResultShouldBeZero() {
        var calc = new StringCalculator();
        assertEquals(calc.Add(""), 0);
    }

    //Test case When only one number is passed
    @Test
    void SameValueShouldBeReturnForOneNumber() {
        var calc = new StringCalculator();
        assertEquals(calc.Add("1"), 1);
    }

    //Test case When two numbers passed as Input
    @Test
    void SumOfTwoNumbersShouldBeReturnForTwoNumbers() {
        var calc = new StringCalculator();
        assertEquals(calc.Add("1,2"), 3);
    }

    //Test case When unknown values are passed as Input
    @Test
    void SumOfUnknownNumbersShouldBeReturnForUnknownNumbers() {
        var calc = new StringCalculator();
        assertEquals(calc.Add("1,2,3"), 6);
    }

    //Test case When comma and New Line used as delimiter
    @Test
    void SumOfNumbersShouldBeReturnForNumbersGivenWithCommaAndNewLine() {
        var calc = new StringCalculator();
        assertEquals(calc.Add("1\n2,3"), 6);
    }

    //Test case When custom delimiters used in Input
    @Test
    void SumOfNumbersShouldBeReturnForNumbersGivenWithCustomDelimiters() {
        var calc = new StringCalculator();
        assertEquals(calc.Add("//;\n1;2;3"), 6);
    }

    //Test case When New line is prefixed with comma used in Input
    @Test
    void ThrowErrorWhenNewLinePrefixedWithComma() {
        var calc = new StringCalculator();
        Throwable throwable =  assertThrows(Throwable.class, () -> {
            calc.Add("1,\n2");
        });
        assertEquals(NumberFormatException.class, throwable.getClass());
    }

    //Test case for Negative values present in the Input
    @Test
    void ThrowErrorWhenNegativeValuesPresent() {
        var calc = new StringCalculator();
        Throwable throwable =  assertThrows(Throwable.class, () -> {
            calc.Add("-1,2,-3,-4,5");
        });
        assertEquals("Negatives not allowed", throwable.getMessage());
    }

    //Test case for character string is present in the Input
    @Test
    void ThrowErrorWhenCharacterStringIsPresentInTheInput() {
        var calc = new StringCalculator();
        Throwable throwable =  assertThrows(Throwable.class, () -> {
            calc.Add("String");
        });
        assertEquals(NumberFormatException.class , throwable.getClass());
        System.out.println("Series of Character is not allowed");
    }

    //Test case for Decimal values are present in the Input
    @Test
    void ThrowErrorWhenDecimalIsPresentInTheInput() {
        var calc = new StringCalculator();
        Throwable throwable =  assertThrows(Throwable.class, () -> {
            calc.Add("1.20,2,3,4.50");
        });
        assertEquals(NumberFormatException.class , throwable.getClass());
        System.out.println("No decimal values are not allowed in the String");
    }

    //Test case for Long value is given as Input
    @Test
    void ThrowErrorWhenLongValueIsInput() {
        var calc = new StringCalculator();
        Throwable throwable =  assertThrows(Throwable.class, () -> {
            calc.Add("2147483647");
        });
    }

}