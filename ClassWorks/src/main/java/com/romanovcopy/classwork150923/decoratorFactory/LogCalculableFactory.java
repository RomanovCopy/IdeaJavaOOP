package com.romanovcopy.classwork150923.decoratorFactory;

public class LogCalculableFactory implements ICalculableFactory {

    private Logable logger;

    public LogCalculableFactory(Logable logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(int primaryArg) {
        return new LogCalculator(new Calculator(primaryArg),logger);
    }
}
