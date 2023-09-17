package com.romanovcopy.complexNumberCalculator.calculator;

public interface IComplexNumber {

    double getReal();
    double getImaginary();
    IComplexNumber add(IComplexNumber other);
    IComplexNumber subtract(IComplexNumber other);
    IComplexNumber multiply(IComplexNumber other);
    IComplexNumber divide(IComplexNumber other);
    String toString();
}
