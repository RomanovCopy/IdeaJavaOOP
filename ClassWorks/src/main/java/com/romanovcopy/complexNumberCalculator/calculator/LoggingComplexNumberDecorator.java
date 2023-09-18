package com.romanovcopy.complexNumberCalculator.calculator;

import com.romanovcopy.complexNumberCalculator.interfaces.IComplexNumber;


public class LoggingComplexNumberDecorator extends ComplexNumberDecorator {


    public LoggingComplexNumberDecorator(IComplexNumber decoratedNumber) {
        super(decoratedNumber);
    }

    @Override
    public IComplexNumber add(IComplexNumber other) {
        logger.info("Performing addition operation");
        return super.add(other);
    }

    @Override
    public IComplexNumber subtract(IComplexNumber other) {
        logger.info("Performing subtraction operation");
        return super.subtract(other);
    }

    @Override
    public IComplexNumber multiply(IComplexNumber other) {
        logger.info("Performing multiplication operation");
        return super.multiply(other);
    }

    @Override
    public IComplexNumber divide(IComplexNumber other) {
        logger.info("Performing division operation");
        return super.divide(other);
    }

}
