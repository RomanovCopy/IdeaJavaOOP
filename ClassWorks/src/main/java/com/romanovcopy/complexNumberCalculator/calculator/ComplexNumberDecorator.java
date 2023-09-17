package com.romanovcopy.complexNumberCalculator.calculator;

import com.romanovcopy.complexNumberCalculator.interfaces.IComplexNumber;

import java.util.logging.*;

public class ComplexNumberDecorator implements IComplexNumber {

    protected final Logger logger = Logger.getLogger("Calculator");
    protected FileHandler fileHandler;

    protected IComplexNumber decoratedNumber;

    public ComplexNumberDecorator(IComplexNumber decoratedNumber) {
        this.decoratedNumber = decoratedNumber;
        settingsLogger();
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
            logger.info(decoratedNumber + " + " + other + " = " + result);
            fileHandler.close();
            return result;
    }

    @Override
    public IComplexNumber subtract(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.subtract(other);
        logger.info(decoratedNumber + " - " + other + " = " + result);
        return result;
    }

    @Override
    public IComplexNumber multiply(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.multiply(other);
        logger.info(decoratedNumber + " * " + other + " = " + result);
        return result;
    }

    @Override
    public IComplexNumber divide(IComplexNumber other) {
        IComplexNumber result = decoratedNumber.divide(other);
        logger.info(decoratedNumber + " / " + other + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return decoratedNumber.toString();
    }

    private void settingsLogger(){
        logger.setUseParentHandlers(false);
        try {
            // Указываем путь к файлу логов
            fileHandler = new FileHandler("log.txt");
            logger.addHandler(fileHandler);

            // Устанавливаем уровень логирования
            logger.setLevel(Level.INFO);

            // Создаем форматтер для логов
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
