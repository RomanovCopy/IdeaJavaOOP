package com.romanovcopy.complexNumberCalculator;

import java.util.logging.Logger;

public class LoggingComplexNumberDecorator extends ComplexNumberDecorator {


    public LoggingComplexNumberDecorator(IComplexNumber decoratedNumber) {
        super(decoratedNumber);
    }

    @Override
    public IComplexNumber add(IComplexNumber other) {
        Logger.getLogger("Calculator").info("Performing addition operation");
        return super.add(other);
    }

    @Override
    public IComplexNumber subtract(IComplexNumber other) {
        Logger.getLogger("Calculator").info("Performing subtraction operation");
        return super.subtract(other);
    }

    @Override
    public IComplexNumber multiply(IComplexNumber other) {
        Logger.getLogger("Calculator").info("Performing multiplication operation");
        return super.multiply(other);
    }

    @Override
    public IComplexNumber divide(IComplexNumber other) {
        Logger.getLogger("Calculator").info("Performing division operation");
        return super.divide(other);
    }

}
