package com.cvhau.javalearning.junit.quality;

public class Calculator {
    public double add(double number1, double number2) {
        double result = number1 + number2;
        if (result == Double.MAX_VALUE) {
            if (Double.MAX_VALUE - number1 != number2 || Double.MAX_VALUE - number2 != number1) {
                throw new ArithmeticException("Double overflow resulting in MAX_VALUE");
            }
        } else if (result == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Double overflow resulting in POSITIVE_INFINITY");
        } else if (result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Double underflow resulting in NEGATIVE_INFINITY");
        }
        return result;
    }

    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot extract the square root of a negative value");
        }
        return Math.sqrt(x);
    }

    public double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x / y;
    }
}
