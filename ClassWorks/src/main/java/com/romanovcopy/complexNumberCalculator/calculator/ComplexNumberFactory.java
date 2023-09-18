package com.romanovcopy.complexNumberCalculator.calculator;

import com.romanovcopy.complexNumberCalculator.utils.Logger;

public class ComplexNumberFactory {

    public static final Logger logger=new Logger("log.txt");

    public static LoggingComplexNumberDecorator createComplexNumber(double real, double imaginary) {
        return new LoggingComplexNumberDecorator(new ComplexNumber(real, imaginary));
    }

}
