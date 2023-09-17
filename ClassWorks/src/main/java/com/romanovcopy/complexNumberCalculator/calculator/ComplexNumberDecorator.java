package com.romanovcopy.complexNumberCalculator.calculator;

import com.romanovcopy.complexNumberCalculator.interfaces.IComplexNumber;

import java.util.logging.Logger;

public class ComplexNumberDecorator implements IComplexNumber {

    protected IComplexNumber decoratedNumber;

    public ComplexNumberDecorator(IComplexNumber decoratedNumber) {
        this.decoratedNumber = decoratedNumber;
    }

    @Override
    public double getReal() {
        return decoratedNumber.getReal();
    }
    @Override
    public double getImaginary() {
        return decoratedNumber.getImaginary();
    }

    @Override
    public IComplexNumber add(IComplexNumber other) {
            IComplexNumber result = decoratedNumber.add(other);
            Logger.getLogger("Calculator").info(decoratedNumber + " + " + other + " = " + result);
            return result;
    }

    @Override
    public IComplexNumber subtract(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.subtract(other);
        Logger.getLogger("Calculator").info(decoratedNumber + " - " + other + " = " + result);
        return result;
    }

    @Override
    public IComplexNumber multiply(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.multiply(other);
        Logger.getLogger("Calculator").info(decoratedNumber + " * " + other + " = " + result);
        return result;
    }

    @Override
    public IComplexNumber divide(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.divide(other);
        Logger.getLogger("Calculator").info(decoratedNumber + " / " + other + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return decoratedNumber.toString();
    }
}
