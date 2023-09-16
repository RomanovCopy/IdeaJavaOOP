package com.romanovcopy.complexNumberCalculator;

public class ComplexNumberFactory {

    public static LoggingComplexNumberDecorator createComplexNumber(double real, double imaginary) {
        return new LoggingComplexNumberDecorator(new ComplexNumber(real, imaginary));
    }

}
