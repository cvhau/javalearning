package com.cvhau.javalearning.junit.quality;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void destroyCalculator() {
        calculator = null;
    }

    @Test
    void add_Double2Double_ThenCorrect() {
        double firstNumber = 10;
        double secondNumber = 50;
        double expectedResult = 60;
        double result = calculator.add(firstNumber, secondNumber);
        assertEquals(expectedResult, result);
    }

    @Test
    void add_DoubleMaxValue2Double_ArithmeticException() {
        double firstNumber = 1.7976931348623157E308; // Double.MAX_VALUE
        double secondNumber= 10;
        assertThrows(ArithmeticException.class, () -> {
            calculator.add(firstNumber, secondNumber);
        });
    }

    @Test
    void add_Double2DoubleMaxValue_ArithmeticException() {
        double firstNumber = 10;
        double secondNumber= 1.7976931348623157E308; // Double.MAX_VALUE
        assertThrows(ArithmeticException.class, () -> {
            calculator.add(firstNumber, secondNumber);
        });
    }

    @Test
    void add_Double2DoubleCauseOverflowResult_ArithmeticException() {
        double firstNumber = 1.1984620899082105E308; // Double.MAX_VALUE / 1.5
        double secondNumber= 8.988465674311579E307;  // Double.MAX_VALUE / 2
        assertThrows(ArithmeticException.class, () -> {
            double result = calculator.add(firstNumber, secondNumber);
            System.out.println(result);
        });
    }

    @Test
    void add_Double2DoubleCauseUnderflowResult_ArithmeticException() {
        double firstNumber = -1.1984620899082105E308; // Double.MIN_VALUE / 1.5
        double secondNumber= -8.988465674311579E307;  // Double.MIN_VALUE / 2
        assertThrows(ArithmeticException.class, () -> {
            double result = calculator.add(firstNumber, secondNumber);
            System.out.println(result);
        });
    }

    @Test
    void sqrt_PositiveDouble_ThenCorrect() {
        double givenNumber = 2D;
        double expectedResult = 1.414213562D;
        double result = calculator.sqrt(givenNumber);
        assertEquals(expectedResult, result, 0.000000001);
    }

    @Test
    void sqrt_NegativeDouble_IllegalArgumentException() {
        double givenNumber = -2D;

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(givenNumber);
        });
    }

    @Test
    void divide_DoubleByDouble_ThenCorrect() {
        double x = 7D;
        double y = 3D;
        double expectedResult = 2.333333333D;
        double result = calculator.divide(x, y);
        assertEquals(expectedResult, result, 0.000000001);
    }

    @Test
    void divide_DoubleByZero_ArithmeticException() {
        double x = 7D;
        double y = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(x, y);
        });
    }
}