package com.romanovcopy.complexNumberCalculator.calculator;

public class ComplexNumber implements IComplexNumber{

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real=real;
        this.imaginary=imaginary;
    }

    @Override
    public double getReal() {
        return real;
    }
    @Override
    public double getImaginary() {
        return imaginary;
    }

    @Override
    public IComplexNumber add(IComplexNumber other) {
        double realSum = this.real + other.getReal();
        double imaginarySum = this.imaginary + other.getImaginary();
        return new ComplexNumber(realSum, imaginarySum);
    }

    @Override
    public IComplexNumber subtract(IComplexNumber other) {
        double realDiff = this.real - other.getReal();
        double imaginaryDiff = this.imaginary - other.getImaginary();
        return new ComplexNumber(realDiff, imaginaryDiff);
    }

    @Override
    public IComplexNumber multiply(IComplexNumber other) {
        double realProduct = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double imaginaryProduct = this.real * other.getImaginary() + this.imaginary * other.getReal();
        return new ComplexNumber(realProduct, imaginaryProduct);
    }

    @Override
    public IComplexNumber divide(IComplexNumber other) {
        double denominator = Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2);
        double realQuotient = (this.real * other.getReal() + this.imaginary * other.getImaginary()) / denominator;
        double imaginaryQuotient =(this.imaginary * other.getReal() - this.real * other.getImaginary()) / denominator;
        return new ComplexNumber(realQuotient, imaginaryQuotient);
    }

    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }
}
